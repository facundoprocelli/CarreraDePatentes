package org.example;
import org.example.Conectar.ConexionBD;
import org.example.Module.Jugador;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ConexionBD conexionBD = new ConexionBD();
        ArrayList<Jugador> jugadors = new ArrayList<>();
        Jugador jugador = new Jugador(3,"Agustin","*******", 0);
        try {
        conexionBD.conectarBD();
        //conexionBD.cargarDato(jugador);
            jugadors = conexionBD.pedirDatos();
            conexionBD.editarDato(1, "AG669ER");
            System.out.println(jugadors);
            jugadors.clear();
           jugadors =  conexionBD.pedirDatos();
            conexionBD.desconaectarBD();

            System.out.println(jugadors);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}