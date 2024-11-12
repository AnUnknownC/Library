package Biblioteca.Modelos;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Biblioteca {

    private int contador;
    private String nombre;
    private boolean estaAbierta;
    private ArrayList<Libro> libros;
    private ArrayList<Material> materiales;
    private Servicios servicios;

    public Biblioteca(String nombre) {
        this.contador = 0;
        this.nombre = nombre;
        this.estaAbierta = false;
        this.libros = new ArrayList<Libro>();
        this.materiales = new ArrayList<Material>();
        this.servicios = new Servicios();
    }

    public String getNombre(){
        return nombre;
    }

    public boolean isEstaAbierta() {
        return estaAbierta;
    }

    public void setEstaAbierta(boolean estaAbierta) {
        this.estaAbierta = estaAbierta;
    }

    public int getCantidadLibros() {
        return libros.size();
    }

    public ArrayList<Libro> getLibros() {return libros;}

    public ArrayList<Material> getMateriales() {return materiales;}

    public Servicios getServicios() {return servicios;}

    // Método para adicionar libros
    public void adicionarLibro(String titulo, String lenguaje, String genero, String autor, String editorial, int anioDePublicacion,int cantidadAdicionar) {
        for (int i = 0; i < cantidadAdicionar; i++) {
            contador++;
            Libro libro = new Libro(titulo,lenguaje,genero,autor,editorial, anioDePublicacion);
            libro.setId(contador); // Asignar ID al nuevo materiales
            libros.add(libro);
        }

    }

    //Metodo para eliminar libros
    public void eliminarLibro(Libro libro) {
        libros = libros.stream()
                .filter(busqueda -> busqueda.getId() != libro.getId())
                .collect(Collectors.toCollection(ArrayList::new));;
    }

    public void adicionarMaterial(String titulo, String lenguaje, String autor, String editorial, int anioDePublicacion,int cantidadAdicionar) {
        for (int i = 0; i < cantidadAdicionar; i++) {
            contador++;
            Material material = new Material(titulo,lenguaje,autor,editorial, anioDePublicacion);
            material.setId(contador); // Asignar ID al nuevo materiales
            materiales.add(material);
        };} // Método para adicionar materiales

    public void eliminarMaterial(Material material) {
        this.materiales.remove(material);
    } //Metodo para eliminar Materiales

    public ArrayList<Libro> buscarLibrosPorGenero(String generoBuscado) {
        ArrayList<Libro> librosPorGenero = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getGenero().equalsIgnoreCase(generoBuscado)) {
                librosPorGenero.add(libro);
            }
        }
        return librosPorGenero;
    }

    // Buscar Libros por autor

    public ArrayList<Libro> buscaPorAutorLibro (String NombreAutor){
        return libros.stream()
                .filter(libro -> libro.getAutor().equalsIgnoreCase(NombreAutor))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Material> buscaPorAutorMaterial (String autorBuscado){
        ArrayList<Material> materialPorAutor = new ArrayList<>();
        for (Material i: materiales){
            if (i instanceof Libro libro && libro.getAutor().equalsIgnoreCase(autorBuscado)) {
                materialPorAutor.add(libro);
            }
        }
        return materialPorAutor;
    }

    // Buscar Libro por Titulo

    public ArrayList<Libro> buscaPorTituloLibro(String TituloDelLibro){
        return libros.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(TituloDelLibro))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int cantidadTotalMaterial(String titulo, ArrayList<Material> listaMaterial){
        return listaMaterial.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toCollection(ArrayList::new)).toArray().length;
    }

    public int cantidadTotalLibro(String titulo) {
        return libros.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toCollection(ArrayList::new)).toArray().length;
    }

    public int cantidadDisponibleMaterial(String titulo){
        return materiales.stream()
                .filter(material -> material.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toCollection(ArrayList::new)).toArray().length - servicios.getLibrosYMaterialPrestados().stream()
                .filter(material -> material.getTitulo().equalsIgnoreCase(titulo)).collect(Collectors.toCollection(ArrayList::new)).toArray().length;
    }

    public int cantidadDisponibleLibro(String titulo){
        return libros.stream().filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo)).collect(Collectors.toCollection(ArrayList::new)).toArray().length -
                servicios.getLibrosYMaterialPrestados().stream().filter(material -> material.getTitulo().equalsIgnoreCase(titulo)).collect(Collectors.toCollection(ArrayList::new)).toArray().length;
    }

    public ArrayList<Material> buscaPorTituloMaterial(String TituloDelMaterial){
        return materiales.stream()
                .filter(material -> material.getTitulo().equalsIgnoreCase(TituloDelMaterial))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // buscar la localizacion del libro

    public String buscarLocalizacionLibro (Libro libroBuscado){
        return libros.stream()
                .filter(libro -> libro.getTitulo().equals(libroBuscado.getTitulo()))
                .map(libro -> libro.getLocalizacion())
                .findFirst().get();
    }

    public String buscarLocalizacionMaterial (Material materialBuscado){
        return materiales.stream()
                .filter(materia -> materia.getTitulo().equals(materialBuscado.getTitulo()))
                .map(libro -> libro.getLocalizacion())
                .findFirst().get();
    }

    public void agregarActividad(Evento actividad) {
        servicios.agregarActividad(actividad);
    } // Método para agregar actividades

    public void quitarActividad(Evento actividad) {
        servicios.quitarActividad(actividad);
    } // Método para quitar actividades

    public void verActividad(){
        ArrayList<Evento> actividades = servicios.getActividades();
        if (actividades.isEmpty()){
            System.out.println("No hay actividades reservadas por el momento.");
        } else {
            for(Evento actividad: actividades)
                System.out.println("Actividad: " + actividad.getTema() + " el " + actividad.getFecha());
        }

    } // Método para ver actividades (intentare hacer otro con un string formateado, pero por ahora usemos este sencillo)

    /*
     * Charlas
     */

    public void agregarCharla(Evento charla) {
        servicios.agregarCharla(charla);
    } // Método para agregar charlas

    public void quitarCharla(Evento charla) {
        servicios.quitarCharla(charla);
    } // Método para quitar charlas

    public void verCharla(){
        ArrayList<Evento> charlas = servicios.getCharlas();
        if (charlas.isEmpty()){
            System.out.println("No hay charlas reservadas por el momento.");
        } else {
            for(Evento charla: charlas)
                System.out.println("Charla: " + charla.getTema() + " el " + charla.getFecha());
        }

    } //Método para ver charlas


}

