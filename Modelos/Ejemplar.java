package Biblioteca.Modelos;

import java.util.ArrayList;
import java.util.Date;

public class Ejemplar {
    private boolean disponible;
    private Integer cantidadActual = 0;
    private Integer cantidadCompleta = 0;

    public Ejemplar() {
        this.disponible = true;
        this.cantidadActual += 0;
        this.cantidadCompleta += 0;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Integer getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Integer cantidadActual) {
        this.cantidadActual += cantidadActual;
    }

    public Integer getCantidadCompleta() {
        return cantidadCompleta;
    }

    public void setCantidadCompleta(Integer cantidadCompleta) {
        this.cantidadCompleta += cantidadCompleta;
    }
}
