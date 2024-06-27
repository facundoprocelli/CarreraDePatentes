package org.example.Conectar;

import org.example.Module.Jugador;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ConexionBD {

    private static String url = "jdbc:mysql://127.0.0.1:3306/carreradepatentes";
    private static String contrasena = "";
    private static String usuario = "root";
    private static Connection connection;

    private static Process apacheProcess;
    private static Process mysqlProcess;


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

    public static ArrayList<Jugador> pedirDatosJugadores() throws SQLException {

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

    public static String pedirDatoEspecificoJugadores(String columna) throws SQLException {

        String dato = "No hay datos";
        PreparedStatement state = connection.prepareStatement("SELECT MAX(" + columna + ") AS mayor_dato FROM usuarios");
        ResultSet resultSet = state.executeQuery();

        if(resultSet.next()){
            dato = resultSet.getString("mayor_dato");
        }

        resultSet.close();
        return dato;
    }

    public static String pedirDatoUltimoJugadorIngresadoABD(String columna) throws SQLException {
        String dato = "No hay datos";
        PreparedStatement state = connection.prepareStatement("SELECT " + columna + " FROM usuarios ORDER BY id_usuario DESC LIMIT 1");
        ResultSet resultSet = state.executeQuery();

        if(resultSet.next()){
            dato = resultSet.getString(columna);
        }

        resultSet.close();
        return dato;

    }

    public static LocalDate pedirUltimaFechaRegistrada() throws SQLException {
        //Ejecuto una petición SQL
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM fechas");
        LocalDate ultimaFecha = null;
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            ultimaFecha = resultSet.getDate(1).toLocalDate();
            while (resultSet.next()) {
                ultimaFecha = compararFechas(ultimaFecha, resultSet.getDate(1).toLocalDate());
            }
        }

        return ultimaFecha;
    }

    private static LocalDate compararFechas(LocalDate fechaMasActual, LocalDate fechaBD) {

        LocalDate ultima = fechaMasActual;
        if (fechaMasActual != null) {
            if (fechaBD.isAfter(fechaMasActual)) {
                ultima = fechaBD;
            }
        }

        return ultima;
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

    public static void cargarDato(LocalDate date) throws SQLException {

        //Prompt de carga de dato
        PreparedStatement statement = connection.prepareStatement("INSERT INTO fechas (fecha) VALUES (?)");

        statement.setDate(1, Date.valueOf(date));

        statement.execute();
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

    public static void editarDato(String nombre, int dias_primero) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("UPDATE usuarios SET dias_primero = ? WHERE nombre = ?");

        //Modifico los datos
        statement.setInt(1, dias_primero);
        statement.setString(2, nombre);

        //Ejecuto la modificación
        statement.executeUpdate();
        statement.close();
    }


    public static void iniciarServidores() {
        String apacheStart = "D:\\XAMPP\\apache_start.bat";
        String mysqlStart = "D:\\XAMPP\\mysql_start.bat";

        try {
            // Iniciar Apache
            ProcessBuilder apacheProcessBuilder = new ProcessBuilder(apacheStart);
            apacheProcess = apacheProcessBuilder.start();
            System.out.println("Apache iniciado.");

            // Iniciar MySQL
            ProcessBuilder mysqlProcessBuilder = new ProcessBuilder(mysqlStart);
            mysqlProcess = mysqlProcessBuilder.start();
            System.out.println("MySQL iniciado.");
            Thread.sleep(5000);

        } catch ( IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
