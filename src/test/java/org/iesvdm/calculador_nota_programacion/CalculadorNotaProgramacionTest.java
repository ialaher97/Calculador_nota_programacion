package org.iesvdm.calculador_nota_programacion;


import java.io.ByteArrayInputStream;

import org.junit.Assert;
import org.junit.Test;

public class CalculadorNotaProgramacionTest {
	
	void provideInput(String data) {
	    ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
	    System.setIn(testIn);
	}
	
	@Test
	public void pedirNota() throws Exception {
		provideInput("6.5");
		
		double nota = CalculadorNotaProgramacion.pedirNota();
		
		Assert.assertEquals(6.5, nota,0.01);
	}
	
	@Test (expected = Exception.class)
	public void pedirNotaFueraRango() throws Exception {
		provideInput("11");
		
		double nota = CalculadorNotaProgramacion.pedirNota();
		
		Assert.assertEquals(6.5, nota,0.01);
	}
	
	@Test
	public void pedirNotaFueraRangoTryCatch() throws Exception {
		provideInput("11");
		
		try {
		double nota = CalculadorNotaProgramacion.pedirNota();
		}catch(Exception e){
		Assert.assertEquals("Nota no válida",e.getMessage());
		}
		}
	
	@Test
	public void pedirNotaFueraRangoTryCatch1() throws Exception {
		provideInput("abc");
		
		try {
		double nota = CalculadorNotaProgramacion.pedirNota();
		}catch(NumberFormatException e){
		Assert.assertEquals("For input string: \"abc\"", e.getMessage());
		}
		}

}
