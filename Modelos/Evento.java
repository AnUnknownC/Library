package Biblioteca.Modelos;

import java.util.ArrayList;
import java.util.Date;

public class Evento {
    private ArrayList<String> invitados;
    private String fecha;
    private String tema;
    private String descripcion;

    public Evento(ArrayList<String> invitados, String fecha, String tema, String descripcion) {
        this.invitados = invitados;
        this.fecha = fecha;
        this.tema = tema;
        this.descripcion = descripcion;
    }

    public ArrayList<String> getInvitados() {
        return invitados;
    }

    public void setInvitados(ArrayList<String> invitados) {
        this.invitados = invitados;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
