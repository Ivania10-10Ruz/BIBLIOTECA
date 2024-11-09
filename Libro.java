/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaproyecto;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Graciela
 */
public class Libro {
   private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;
    private boolean prestado;
    private List<String> comentarios;
    private List<Integer> calificaciones;

    public Libro(String titulo, String autor, int anioPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.prestado = false;
        this.comentarios = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
  

    public List<String> getComentarios() {
        return comentarios;
    }
    
    public String getGenero() {  
        return genero;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar() {
        this.prestado = true;
    }

    public void devolver() {
        this.prestado = false;
    }

    public void agregarComentario(String comentario) {
        comentarios.add(comentario);
    }

    public void agregarCalificacion(int calificacion) {
        if (calificacion >= 1 && calificacion <= 5) {
            calificaciones.add(calificacion);
        }
    }

    public double obtenerCalificacionPromedio() {
        if (calificaciones.isEmpty()) {
            return 0;
        }
        int suma = 0;
        for (int calificacion : calificaciones) {
            suma += calificacion;
        }
        return (double) suma / calificaciones.size();
    }

    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + anioPublicacion);
        System.out.println("Género: " + genero);
        System.out.println("Disponibilidad: " + (prestado ? "No disponible" : "Disponible"));
        System.out.println("Calificación promedio: " + obtenerCalificacionPromedio());
        System.out.println("Comentarios: " + comentarios);
        System.out.println();
    }

}
