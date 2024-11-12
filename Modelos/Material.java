package Biblioteca.Modelos;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Material {

    private int id;
    private String titulo;
    private String lenguaje;
    private String autor;
    private String editorial;
    private int anioDePublicacion;
    private String localizacion;
    private boolean enPrestamo;
    private Ejemplar ejemplar;

    public Material(String nombre, String lenguaje, String autor, String editorial,
                    int anioDePublicacion){
        this.titulo = nombre;
        this.lenguaje = lenguaje;
        this.autor = autor;
        this.editorial = editorial;
        this.anioDePublicacion = anioDePublicacion;
        this.localizacion = "Biblioteca";
        this.enPrestamo = false;
        this.ejemplar = new Ejemplar();
    }

    public Integer getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioDePublicacion() {
        return anioDePublicacion;
    }

    public void setAnioDePublicacion(int anioDePublicacion) {
        this.anioDePublicacion = anioDePublicacion;
    }

    public boolean isEnPrestamo() {return enPrestamo;}

    public void setEnPrestamo(boolean enPrestamo) {this.enPrestamo = enPrestamo;}

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Ejemplar getEjemplar() {return ejemplar;}


}
