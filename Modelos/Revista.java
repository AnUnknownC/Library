package Biblioteca.Modelos;

public class Revista extends Material {

    private int diaDePublicacion;
    private int mesDePublicacion;

    public Revista(String nombre, String lenguaje, String genero, String autor, String editorial, int anioDePublicacion,
                   int diaDePublicacion, int mesDePublicacion) {
        super(nombre, lenguaje, genero, autor, anioDePublicacion);
        this.diaDePublicacion = diaDePublicacion;
        this.mesDePublicacion = mesDePublicacion;
    }
    public int getDiaDePublicacion() {
        return diaDePublicacion;
    }
    public void setDiaDePublicacion(int diaDePublicacion) {
        this.diaDePublicacion = diaDePublicacion;
    }
    public int getMesDePublicacion() {
        return mesDePublicacion;
    }
    public void setMesDePublicacion(int mesDePublicacion) {
        this.mesDePublicacion = mesDePublicacion;
    }

}
