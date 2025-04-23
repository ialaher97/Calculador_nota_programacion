package org.iesvdm.calculador_nota_programacion;

import java.util.Scanner;




public class CalculadorNotaProgramacion {
	
	public static double pedirNota() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca nota");
		String notaSrt = sc.nextLine();
		double nota = Double.parseDouble(notaSrt);
		
		if(nota < 0 || nota >10) {
			throw new Exception("Nota no válida");
		}
		
		
	return nota;	
	}
	
	public static double media(double nota1, double nota2) {
	
		return (nota1+nota2)/2;
		
	}

	
	public static double notaFinal(double media) throws Exception {
		Scanner sc = new Scanner(System.in);
		double notaFinal = 0.0;
		
		if(media<5) {
			//pido recuperación apto o no apto.
			System.out.println("¿Cual ha sido el resultado de la recuperación? apto/no apto");
			String respuesta = sc.next();
			
			if(respuesta.equalsIgnoreCase("apto")) {
				notaFinal = 5;
		}else if(respuesta.equalsIgnoreCase(respuesta)) {
			notaFinal = media;
		}else {
			throw new Exception("Respuesta de recuperación no contemplada: "+respuesta);
		}
	
		}
		
		
		return notaFinal;
	}
}
