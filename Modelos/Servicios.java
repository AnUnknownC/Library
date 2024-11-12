package Biblioteca.Modelos;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Servicios {

    private ArrayList<Material> librosYMaterialPrestados;
    private ArrayList<Evento> charlas;
    private ArrayList<Evento> actividades;

    public Servicios(){
        this.actividades = new ArrayList<>();
        this.charlas = new ArrayList<>();
        this.librosYMaterialPrestados = new ArrayList<>();
    }

    public ArrayList<Material> getLibrosYMaterialPrestados() {return librosYMaterialPrestados;}

    public ArrayList<Evento> getCharlas() {
        return charlas;
    }

    public ArrayList<Evento> getActividades() {
        return actividades;
    }

    public boolean agregarCharla(Evento evento){
        return charlas.add(evento);
    }

    public boolean quitarCharla(Evento evento){
        return charlas.remove(evento);
    }

    public boolean agregarActividad(Evento evento){return actividades.add(evento);}

    public boolean quitarActividad(Evento evento){return actividades.remove(evento);}

    public void prestamoLibro(String titulo, ArrayList<Libro> listaLibros, String coordenadas){
        try{
            Libro libroDisponible = listaLibros.stream()
                    .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                    .filter(libro -> !libro.isEnPrestamo())
                    .findFirst().get();
            libroDisponible.setEnPrestamo(true);
            libroDisponible.setLocalizacion(coordenadas);
            librosYMaterialPrestados.add(libroDisponible);
        }catch (NoSuchElementException exception){
            System.out.println("Libro no disponible");
        }
    }

    public void prestamoMaterial(String titulo, ArrayList<Material> listaMaterial, String coordenadas){
        try{
            Material libroDisponible = listaMaterial.stream()
                    .filter(material -> material.getTitulo().equalsIgnoreCase(titulo))
                    .filter(material -> !material.isEnPrestamo())
                    .findFirst().get();
            libroDisponible.setEnPrestamo(true);
            libroDisponible.setLocalizacion(coordenadas);
            librosYMaterialPrestados.add(libroDisponible);
        }catch (NoSuchElementException exception){
            System.out.println("Material no disponible");
        }
    }

    public boolean enPrestamo(int id){
        return librosYMaterialPrestados.stream()
                .anyMatch(libro -> libro.getId().equals(id));
    }

    public void devolucionEnCarro(int id){
        try{
            Material material = librosYMaterialPrestados.stream()
                    .filter(libro -> libro.getId().equals(id))
                    .findFirst().get();
            librosYMaterialPrestados = librosYMaterialPrestados.stream()
                    .filter(libro -> libro.getId() != id)
                    .collect(Collectors.toCollection(ArrayList::new));
            material.setEnPrestamo(false);
            material.setLocalizacion("Biblioteca");
        }catch (NoSuchElementException exception){
            System.out.println("No se ha prestado ese libro");
        }
    }

    public void devolucionPunto(int id, String puntoDeRecogida){
        try {
            Material material = librosYMaterialPrestados.stream()
                    .filter(libro -> libro.getId().equals(id))
                    .findFirst().get();
            material.setLocalizacion(puntoDeRecogida);
        }catch (NoSuchElementException exception){
            System.out.println("No se ha prestado ese libro");
        }
    }
}

