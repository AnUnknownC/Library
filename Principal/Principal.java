package Biblioteca.Principal;

import Biblioteca.Modelos.Evento;
import Biblioteca.Modelos.Libro;
import Biblioteca.Modelos.Biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        Biblioteca inventario = new Biblioteca("LOCK");
        inventario.adicionarLibro("Jujutsukaisen", "Ingles", "Shonen", "GegeAkutami", "Shonen Jump", 2020, 6);
        inventario.adicionarLibro("a", "Ingles", "Shonen", "GegeAkutami", "Shonen Jump", 2021, 2);
        inventario.adicionarLibro("Jujutsukaisen", "Ingles", "Shonen", "GegeAkutami", "Shonen Jump", 2021, 1);

        pruebaCharlasyActividades(inventario);

        //Prueba encontrar por titulo
        ArrayList<Libro> encontrado = inventario.buscaPorTituloLibro("a");
        if(encontrado.isEmpty()){
            System.out.println("No se encontro el libro");
        }
        encontrado.stream().forEach(libro -> System.out.println("Titulo: "+libro.getTitulo()+" - Id: "+libro.getId()+" - En Prestamo: "+libro.isEnPrestamo()+" - Localizacion: "+libro.getLocalizacion()));

        //Prueba cantidad disponible de un titulo
        System.out.println("Cantidad disponible Jujutsu no Kaisen: "+inventario.cantidadDisponibleLibro("JujutsuKaisen"));

        //Prueba de prestamo de libros
        inventario.getServicios().prestamoLibro("JujutsuKaisen", inventario.getLibros(), "X");
        inventario.getServicios().prestamoLibro("JujutsuKaisen", inventario.getLibros(), "X");
        System.out.println("Cantidad disponible Jujutsu no Kaisen: "+inventario.cantidadDisponibleLibro("JujutsuKaisen"));

        System.out.println("--------");
        encontrado.stream().forEach(libro -> System.out.println("Titulo: "+libro.getTitulo()+" - Id: "+libro.getId()+" - En Prestamo: "+libro.isEnPrestamo()+" - Localizacion: "+libro.getLocalizacion()));

        //Prueba devolucion de libros
        System.out.println("--------");
        inventario.getServicios().devolucionEnCarro(2);
        encontrado.stream().forEach(libro -> System.out.println("Titulo: "+libro.getTitulo()+" - Id: "+libro.getId()+" - En Prestamo: "+libro.isEnPrestamo()+" - Localizacion: "+libro.getLocalizacion()));
        //Prueba devolucion en sede
        System.out.println("--------");
        inventario.getServicios().devolucionPunto(1, "Sede A");
        encontrado.stream().forEach(libro -> System.out.println("Titulo: "+libro.getTitulo()+" - Id: "+libro.getId()+" - En Prestamo: "+libro.isEnPrestamo()+" - Localizacion: "+libro.getLocalizacion()));
    }

    private static void pruebaCharlasyActividades(Biblioteca inventario) {

        Evento actividad1 = new Evento(new ArrayList<>(Arrays.asList("Profesores")), "20-12-2024", "Ecosistemas", "Conscientizacion ambiente");
        Evento actividad2 = new Evento(new ArrayList<>(Arrays.asList("Facultad invitada")), "20-12-2024", "Comunidad", "Conscientizacion ambiente");
        Evento charla1 = new Evento(new ArrayList<>(Arrays.asList("Alfred McGuffin")), "20-12-2024", "Fisica en la vida", "La fisica como punto de partida para un mundo mejor");
        Evento charla2 = new Evento(new ArrayList<>(Arrays.asList("Alfred McGuffin")), "20-12-2024", "Test", "La fisica como punto de partida para un mundo mejor");

        inventario.agregarActividad(actividad1);
        inventario.agregarActividad(actividad2);
        inventario.agregarCharla(charla1);
        inventario.agregarCharla(charla2);

        inventario.verCharla();
        inventario.verActividad();

        inventario.quitarActividad(actividad2);
        inventario.quitarCharla(charla1);
        System.out.println("Actividades actualizadas");
        inventario.verActividad();
        System.out.println("Charlas actualizadas");
        inventario.verCharla();
    }
}
