/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaproyecto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Graciela
 */
public class Biblioteca {
    List<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro.getTitulo());
    }
    
    public List<Libro> getLibros() {
        return libros;
    }

    public void buscarLibro(String titulo, String autor) {
        System.out.println("Resultados de búsqueda:");
    boolean encontrado = false;
    for (Libro libro : libros) {
        boolean tituloCoincide = (titulo == null || titulo.isEmpty() || libro.getTitulo().equalsIgnoreCase(titulo));
        boolean autorCoincide = (autor == null || autor.isEmpty() || libro.getAutor().equalsIgnoreCase(autor));
        
        if (tituloCoincide && autorCoincide) {
            libro.mostrarInformacion(); // Muestra la información del libro
            encontrado = true;
            if (libro.isPrestado()) {
                System.out.println("El libro '" + libro.getTitulo() + "' está prestado.");
            } else {
                System.out.println("El libro '" + libro.getTitulo() + "' está disponible.");
            }
        }
    }
    if (!encontrado) {
        System.out.println("No se encontró ningún libro con el título '" + titulo + "' y el autor '" + autor + "'.");
    }
    }

    public void prestarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (!libro.isPrestado()) {
                    libro.prestar();
                    System.out.println("Libro prestado: " + titulo);
                } else {
                    System.out.println("El libro '" + titulo + "' ya está prestado.");
                }
                return;
            }
        }
        System.out.println("No se encontró el libro: " + titulo);
    }

    public void devolverLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.isPrestado()) {
                    libro.devolver();
                    System.out.println("Libro devuelto: " + titulo);
                } else {
                    System.out.println("El libro '" + titulo + "' no está prestado.");
                }
                return;
            }
        }
        System.out.println("No se encontró el libro: " + titulo);
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("Libros disponibles:");
    boolean hayDisponibles = false;
    for (Libro libro : libros) {
        if (!libro.isPrestado()) { 
            libro.mostrarInformacion(); 
            hayDisponibles = true; 
        }
    }
    if (!hayDisponibles) { 
        System.out.println("No hay libros disponibles en la biblioteca.");
    }
    }

    public void generarEstadisticasGeneros() {
        Map<String, Integer> estadisticas = new HashMap<>();
        for (Libro libro : libros) {
            estadisticas.put(libro.getGenero(), estadisticas.getOrDefault(libro.getGenero(), 0) + 1);
        }

        System.out.println("Estadísticas de géneros:");
        for (Map.Entry<String, Integer> entry : estadisticas.entrySet()) {
            System.out.println("Género: " + entry.getKey() + ", Cantidad: " + entry.getValue());
        }
    }

}
