import static org.junit.Assert.*;

import org.junit.Test;

public class RegexTest {

	@Test
	public void validarPatronTest() {
		String patron1 = "[0-9]";
		String patron2 = "[a-z]";
		String patron3 = "[A-Z]";
		String patron4 = "[0-9][a-z]";
		String patron5 = "[0-5][a-z]";
		String patron6 = "0-9";
		
		Regex miRegex1 = new Regex(patron1);
		Regex miRegex2 = new Regex(patron2);
		Regex miRegex3 = new Regex(patron3);
		Regex miRegex4 = new Regex(patron4);
		Regex miRegex5 = new Regex(patron5);
		Regex miRegex6 = new Regex(patron6);
		
		boolean resultado;
		
		resultado = miRegex1.validarPatron(patron1);
		assertTrue(resultado);
		
		resultado = miRegex2.validarPatron(patron2);
		assertTrue(resultado);
		
		resultado = miRegex3.validarPatron(patron3);
		assertTrue(resultado);
		
		resultado = miRegex4.validarPatron(patron4);
		assertTrue(resultado);
		
		resultado = miRegex5.validarPatron(patron5);
		assertFalse(resultado);

		resultado = miRegex6.validarPatron(patron6);
		assertFalse(resultado);
	}
	
	@Test
	public void validNumeroTest() {
		String patron1 = "[0-9]";
		Regex miRegex1 = new Regex(patron1);
		
		String caracter1 = "2";
		String caracter2 = "a";
		boolean resultado;
		
		resultado = miRegex1.validNumero(caracter1);
		assertTrue(resultado);
		
		resultado = miRegex1.validNumero(caracter2);
		assertFalse(resultado);
	}
	
	@Test
	public void validMinusculaTest() {
		String patron1 = "[a-z]";
		Regex miRegex1 = new Regex(patron1);
		
		String caracter1 = "2";
		String caracter2 = "a";
		boolean resultado;
		
		resultado = miRegex1.validMinuscula(caracter2);
		assertTrue(resultado);
		
		resultado = miRegex1.validMinuscula(caracter1);
		assertFalse(resultado);
	}
	
	@Test
	public void validMayusculaTest() {
		String patron1 = "[A-Z]";
		Regex miRegex1 = new Regex(patron1);
		
		String caracter1 = "A";
		String caracter2 = "a";
		boolean resultado;
		
		resultado = miRegex1.validMayuscula(caracter1);
		assertTrue(resultado);
		
		resultado = miRegex1.validMayuscula(caracter2);
		assertFalse(resultado);
	}

}