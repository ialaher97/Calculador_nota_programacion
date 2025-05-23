package org.iesvdm.calculador_nota_programacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadorNotaProgramacionTest {
	private final PrintStream standardOut = System.out;

	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	void provideInput(String data) {
		ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}

	@Test
	public void pedirNota(Scanner sc) throws Exception {
		provideInput("6.5");

		double nota = CalculadorNotaProgramacion.pedirNota(sc);

		Assert.assertEquals(6.5, nota, 0.01);
	}

	@Test(expected = Exception.class)
	public void pedirNotaFueraRango(Scanner sc) throws Exception {
		provideInput("11");

		double nota = CalculadorNotaProgramacion.pedirNota(sc);

		Assert.assertEquals(6.5, nota, 0.01);
	}

	@Test
	public void pedirNotaFueraRangoTryCatch(Scanner sc) throws Exception {
		provideInput("11");

		try {
			double nota = CalculadorNotaProgramacion.pedirNota(sc);
		} catch (Exception e) {
			Assert.assertEquals("Nota no válida", e.getMessage());
		}
	}

	@Test
	public void pedirNotaFueraRangoTryCatch1(Scanner sc) throws Exception {
		provideInput("abc");

		try {
			double nota = CalculadorNotaProgramacion.pedirNota(sc);
		} catch (NumberFormatException e) {
			Assert.assertEquals("For input string: \"abc\"", e.getMessage());
		}
	}

	@Test
	public void mediaTest(Scanner sc) throws Exception {

		provideInput("6");
		double nota1 = CalculadorNotaProgramacion.pedirNota(sc);
		provideInput("4");
		double nota2 = CalculadorNotaProgramacion.pedirNota(sc);

		Assert.assertEquals(6.0, nota1, 0.01);
		Assert.assertEquals(4.0, nota2, 0.01);

		double media = CalculadorNotaProgramacion.media(nota1, nota2);

		Assert.assertEquals(5.0, media, 0.01);

	}

	@Test
	public void aptoTest(Scanner sc) throws Exception {

		provideInput("6");
		double nota1 = CalculadorNotaProgramacion.pedirNota(sc);
		provideInput("3");
		double nota2 = CalculadorNotaProgramacion.pedirNota(sc);

		Assert.assertEquals(6.0, nota1, 0.01);
		Assert.assertEquals(3.0, nota2, 0.01);

		double media = CalculadorNotaProgramacion.media(nota1, nota2);

		Assert.assertEquals(4.5, media, 0.01);

		provideInput("Apto");
		double notaFinal = CalculadorNotaProgramacion.notaFinal(media,sc);

		Assert.assertEquals(5.0, notaFinal, 0.01);
	}

	@Test
	public void mainTest() throws Exception {
		provideInput("6\n3\napto\n");
		CalculadorNotaProgramacion.main();
		

	}

}
