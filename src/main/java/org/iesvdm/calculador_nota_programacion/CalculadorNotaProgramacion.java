package org.iesvdm.calculador_nota_programacion;

import java.util.Scanner;

public class CalculadorNotaProgramacion {
	public static void main() throws Exception {
		
		Scanner sc = new Scanner(System.in);

		double nota1 = pedirNota(sc);
		double nota2 = pedirNota(sc);

		double media = media(nota1, nota2);

		double notaFinal = notaFinal(media,sc);
		System.out.println(notaFinal);

	}

	public static double pedirNota(Scanner sc) throws Exception {
		System.out.println("Introduzca nota");
		String notaSrt = sc.next();
		double nota = Double.parseDouble(notaSrt);

		if (nota < 0 || nota > 10) {
			throw new Exception("Nota no válida");
		}

		return nota;
	}

	public static double media(double nota1, double nota2) {

		return (nota1 + nota2) / 2;

	}

	public static double notaFinal(double media, Scanner sc) throws Exception {
		double notaFinal = 0.0;

		if (media < 5) {
			// pido recuperación apto o no apto.
			System.out.println("¿Cual ha sido el resultado de la recuperación? apto/no apto");
			String respuesta = sc.nextLine();

			if (respuesta.equalsIgnoreCase("apto")) {
				notaFinal = 5;
			} else if (respuesta.equalsIgnoreCase("no apto")) {
				notaFinal = media;
			} else {
				throw new Exception("Respuesta de recuperación no contemplada: " + respuesta);
			}

		}

		return notaFinal;
	}

}
