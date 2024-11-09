/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaproyecto;
import java.util.Scanner;
/**
 *
 */
public class Proyecto_Ivania {
  public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
      try (Scanner scanner = new Scanner(System.in)) {
          int opcion;
          
          do {
              System.out.println("1. Agregar libro");
              System.out.println("2. Buscar libro");
              System.out.println("3. Prestar libro");
              System.out.println("4. Devolver libro");
              System.out.println("5. Mostrar libros disponibles");
              System.out.println("6. Agregar comentario a un libro");
              System.out.println("7. Generar estadísticas de géneros");
              System.out.println("8. Salir");
              System.out.print("Seleccione una opción: ");
              opcion = scanner.nextInt();
              scanner.nextLine();  
              
              switch (opcion) {
                  case 1 -> {
                      System.out.print("Título: ");
                      String titulo = scanner.nextLine();
                      System.out.print("Autor: ");
                      String autor = scanner.nextLine();
                      System.out.print("Año de publicación: ");
                      int anio = scanner.nextInt();
                      scanner.nextLine();  // Limpiar el buffer
                      System.out.print("Género: ");
                      String genero = scanner.nextLine();
                      biblioteca.agregarLibro(new Libro(titulo, autor, anio, genero));
                  }
                  case 2 -> {
                      System.out.print("Ingrese el título del libro (deje vacío si no lo desea buscar): ");
                      String tituloBuscar = scanner.nextLine();
                      System.out.print("Ingrese el autor del libro (deje vacío si no lo desea buscar): ");
                      String autorBuscar = scanner.nextLine();
                      biblioteca.buscarLibro(tituloBuscar, autorBuscar);
                  }
                  case 3 -> {
                      System.out.print("Ingrese el título del libro a prestar: ");
                      String tituloPrestar = scanner.nextLine();
                      biblioteca.prestarLibro(tituloPrestar);
                  }
                  case 4 -> {
                      System.out.print("Ingrese el título del libro a devolver: ");
                      String tituloDevolver = scanner.nextLine();
                      biblioteca.devolverLibro(tituloDevolver);
                  }
                  case 5 -> biblioteca.mostrarLibrosDisponibles();
                  case 6 -> {
                    System.out.print("Ingrese el título del libro para agregar un comentario: ");
                    String tituloComentario = scanner.nextLine();
                    System.out.print("Ingrese su comentario: ");
                    String comentario = scanner.nextLine();

   
                    for (Libro libro : biblioteca.getLibros()) { 
                        if (libro.getTitulo().equalsIgnoreCase(tituloComentario)) {
                            libro.agregarComentario(comentario);
                            System.out.println("Comentario agregado a '" + tituloComentario + "'.");
                            break;
                        }
                    }
                }
                  case 7 -> biblioteca.generarEstadisticasGeneros();
                  case 8 -> System.out.println("Saliendo del programa.");
                  default -> System.out.println("Opción no válida. Intente de nuevo.");
              }
          } while (opcion != 7);
      }
    }  
}
