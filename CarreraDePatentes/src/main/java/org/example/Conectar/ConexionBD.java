package org.example.Conectar;

import org.example.Module.Jugador;

import java.sql.*;
import java.util.ArrayList;

public class ConexionBD {

    private static String url = "jdbc:mysql://127.0.0.1:3306/carreradepatentes";
    private  static String contrasena = "";
    private  static String usuario = "root";
    private static Connection connection;


    public ConexionBD() {
    }

    public static void conectarBD() {

        try {
            //Creo una conexion con la base de datos
            connection = DriverManager.getConnection(url, usuario, contrasena);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void desconaectarBD() throws SQLException {

        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public  static ArrayList<Jugador> pedirDatos() throws SQLException {

        ArrayList<Jugador> jugadores = new ArrayList<>();

        //Ejecuto una petición SQL
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios");
        ResultSet resultSet = statement.executeQuery();


        //procesar los resultados
        while (resultSet.next()) {
            Jugador jugador = new Jugador(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4));
            jugadores.add(jugador);
        }


        resultSet.close();
        return jugadores;
    }


    public static void cargarDato(Jugador jugador) throws SQLException {

        //Prompt de carga de dato
        PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios(id_usuario, nombre, patente, dias_primero) VALUES (?,?,?,?)");

        //cargo los datos al statement
        statement.setInt(1, jugador.getId_usuario());
        statement.setString(2, jugador.getNombre());
        statement.setString(3, jugador.getPatente());
        statement.setInt(4, jugador.getDias_primero());

        //Ejecuta la consulata de insercion
        statement.executeUpdate();

        //Cierra la consulta
        statement.close();

    }

    public static void editarDato(String nombre, String patente) throws SQLException {

        //Prompt actualización de datos
        PreparedStatement statement = connection.prepareStatement("UPDATE usuarios SET patente = ? WHERE nombre = ?");

        //Modifico los datos
        statement.setString(1, patente);
        statement.setString(2, nombre);

        //Ejecuto la modificación
        statement.executeUpdate();

        statement.close();

    }
}
