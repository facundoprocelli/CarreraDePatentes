package org.example.Module;

import org.example.Conectar.ConexionBD;

import java.sql.SQLException;
import java.util.ArrayList;

public class Jugador implements Comparable {

    private int id_usuario;
    private String nombre;
    private String patente;
    private int dias_primero;

    public Jugador(int id_usuario, String nombre, String patente, int dias_primero) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.patente = patente;
        this.dias_primero = dias_primero;
    }

    public Jugador(String nombre) {
        this.id_usuario = proximoID();
        this.nombre = nombre;
        this.patente = "AA000AA";
        this.dias_primero = 0;
    }
    public Jugador(String nombre, String patente, int dias_primero){
        this.nombre = nombre;
        this.patente = patente;
        this.dias_primero = dias_primero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDias_primero() {
        return dias_primero;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getPatente() {
        return patente;
    }

    public  void setDias_primero(int dias_primero) {
        this.dias_primero = dias_primero;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    private int proximoID() {

        ArrayList<Jugador> jugadores = bajarArrayListDeJugadoresdeDB();
        return buscarIdMayor(jugadores) + 1;
    }

    public static ArrayList<Jugador> bajarArrayListDeJugadoresdeDB() {
        ConexionBD conexionBD = new ConexionBD();
        ArrayList<Jugador> jugadores;
        try {
            conexionBD.conectarBD();
            jugadores = conexionBD.pedirDatosJugadores();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return jugadores;
    }

    private int buscarIdMayor(ArrayList<Jugador> jugadores) {
        int id = 0;
        for (Jugador j : jugadores) {
            if (j.getId_usuario() > id) {
                id = j.getId_usuario();
            }
        }
        return id;
    }


    @Override
    public String toString() {
        return "Jugador{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", patente='" + patente + '\'' +
                ", dias_primero=" + dias_primero +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        boolean rta = false;

        if (object instanceof Jugador u) {
            if (id_usuario == u.getId_usuario()) {
                rta = true;
            }
        }
        return rta;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public int compareTo(Object o) {
        int rta = -2;
        if (o instanceof Jugador j) {
            rta = this.patente.compareTo(j.getPatente());
        }
        return rta;
    }

}
