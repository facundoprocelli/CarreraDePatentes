package org.example.Module;

public class Jugador {

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
        this.id_usuario = -1; //todo: Hay que hacer el id autoincremental
        this.nombre = nombre;
        this.patente = "AA000AA";
        this.dias_primero = 0;
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

    public void setPatente(String patente) {
        this.patente = patente;
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
}
