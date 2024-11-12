package Biblioteca.Modelos;

public class Libro extends Material {

    private String genero;

    public Libro(String nombre, String lenguaje, String genero, String autor, String editorial,
                 int anioDePublicacion) {
        super(nombre, lenguaje, autor, editorial, anioDePublicacion);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIsbn(String isbn){
        return isbn;
    }

}
