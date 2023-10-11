package ar.com.java_desafios;

import java.util.Scanner;

public class Desafio_Uno {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de alumnos a procesar: ");
        int cantidadAlumnos = scanner.nextInt();

        String[] nombres = new String[cantidadAlumnos];
        String[] apellidos = new String[cantidadAlumnos];
        int[] numExamenes = new int[cantidadAlumnos];
        double[] notas = new double[cantidadAlumnos];

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese los datos del alumno " + (i + 1));
            System.out.print("Nombre: ");
            nombres[i] = scanner.next();
            System.out.print("Apellido: ");
            apellidos[i] = scanner.next();
            numExamenes[i] = obtenerNumeroExamenes(scanner);

            double sumaNotas = 0;
            for (int j = 0; j < numExamenes[i]; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                double nota = scanner.nextDouble();
                sumaNotas += nota;
            }
            notas[i] = sumaNotas / numExamenes[i];
        }

        // Encuentra la calificación más alta y la más baja
        double maxCalificacion = obtenerCalificacionMaxima(notas);
        double minCalificacion = obtenerCalificacionMinima(notas);

        System.out.println("Alumno/s con la calificación más alta:");
        mostrarAlumnosConCalificacion(nombres, apellidos, notas, maxCalificacion);

        System.out.println("Alumno/s con la calificación más baja:");
        mostrarAlumnosConCalificacion(nombres, apellidos, notas, minCalificacion);

        System.out.println("Alumnos que promocionan:");
        mostrarAlumnosQuePromocionan(nombres, apellidos, notas);

        System.out.println("Alumnos que deben recursar:");
        mostrarAlumnosQueDebenRecursar(nombres, apellidos, notas);
    }

    // Función para obtener el número de exámenes con manejo de excepciones
	private static int obtenerNumeroExamenes(Scanner scanner) {
	    int numExamenes = 0; // Asigna un valor predeterminado
	    boolean entradaValida = false;

	    while (!entradaValida) {
	        try {
	            System.out.print("Número de exámenes: ");
	            numExamenes = scanner.nextInt();
	            entradaValida = true;
	        } catch (java.util.InputMismatchException e) {
	            System.out.println("Entrada inválida. Debes ingresar un número entero.");
	            scanner.next();  // Limpiar el búfer del scanner
	        }
	    }

	    return numExamenes;
	}

    // Función para obtener la calificación máxima
    private static double obtenerCalificacionMaxima(double[] notas) {
        double maxCalificacion = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > maxCalificacion) {
                maxCalificacion = notas[i];
            }
        }
        return maxCalificacion;
    }

    // Función para obtener la calificación mínima
    private static double obtenerCalificacionMinima(double[] notas) {
        double minCalificacion = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < minCalificacion) {
                minCalificacion = notas[i];
            }
        }
        return minCalificacion;
    }

    // Función para mostrar alumnos con una calificación dada
    private static void mostrarAlumnosConCalificacion(String[] nombres, String[] apellidos, double[] notas, double calificacion) {
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] == calificacion) {
                System.out.println(nombres[i] + " " + apellidos[i]);
            }
        }
    }

    // Función para mostrar alumnos que promocionan (calificación >= 7)
    private static void mostrarAlumnosQuePromocionan(String[] nombres, String[] apellidos, double[] notas) {
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 7) {
                System.out.println(nombres[i] + " " + apellidos[i]);
            }
        }
    }

    // Función para mostrar alumnos que deben recursar (calificación < 7)
    private static void mostrarAlumnosQueDebenRecursar(String[] nombres, String[] apellidos, double[] notas) {
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 7) {
                System.out.println(nombres[i] + " " + apellidos[i]);
            }
        }
    }

}
