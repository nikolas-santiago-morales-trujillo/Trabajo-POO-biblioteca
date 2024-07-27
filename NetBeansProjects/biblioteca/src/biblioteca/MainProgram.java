/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    agregarLibro(biblioteca, scanner);
                    break;
                case 2:
                    listarLibros(biblioteca);
                    break;
                case 3:
                    buscarLibroPorTitulo(biblioteca, scanner);
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        
        System.out.println("¡Hasta luego!");
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Agregar libro");
        System.out.println("2. Listar libros");
        System.out.println("3. Buscar libro por título");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el año de publicación del libro: ");
        int anio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después del número

        Libro libro = new Libro(titulo, autor, anio);
        biblioteca.agregarLibro(libro);
        System.out.println("Libro agregado correctamente a la biblioteca.");
    }

    private static void listarLibros(Biblioteca biblioteca) {
        List<Libro> libros = biblioteca.obtenerLibros();
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("\nListado de libros en la biblioteca:");
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    private static void buscarLibroPorTitulo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título o parte del título a buscar: ");
        String busqueda = scanner.nextLine();
        List<Libro> resultados = biblioteca.buscarPorTitulo(busqueda);

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
        } else {
            System.out.println("\nResultados de la búsqueda:");
            for (Libro libro : resultados) {
                System.out.println(libro);
            }
        }
    }
}

class Libro {
    private String titulo;
    private String autor;
    private int anio;

    public Libro(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio=" + anio +
                '}';
    }
}

class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> obtenerLibros() {
        return libros;
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }
}
    