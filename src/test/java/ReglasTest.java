import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class ReglasTest {
	@Test
	public void validarPatronTest() {
		String patron1 = "[0-9]";
		String patron2 = "[a-z]";
		String patron3 = "[A-Z]";
		String patron4 = "[0-9][a-z]";
		String patron5 = "[0-5][a-z]";
		String patron6 = "0-9";
		
		Reglas misReglas1 = new Reglas();
		Reglas misReglas2 = new Reglas();
		Reglas misReglas3 = new Reglas();
		Reglas misReglas4 = new Reglas();
		Reglas misReglas5 = new Reglas();
		Reglas misReglas6 = new Reglas();
		
		ArrayList<String> resultado;
		
		resultado = misReglas1.validarPatron(patron1);
		assertEquals(resultado.size(), 1);
		
		resultado = misReglas2.validarPatron(patron2);
		assertEquals(resultado.size(), 1);
		
		resultado = misReglas3.validarPatron(patron3);
		assertEquals(resultado.size(), 1);
		
		resultado = misReglas4.validarPatron(patron4);
		assertEquals(resultado.size(), 2);
		
		resultado = misReglas5.validarPatron(patron5);
		assertEquals(resultado.size(), 0);
		
		resultado = misReglas6.validarPatron(patron6);
		assertEquals(resultado.size(), 0);

	}
	
	@Test
	public void validNumeroTest() {
		Reglas misReglas1 = new Reglas();
		
		String caracter1 = "2";
		String caracter2 = "a";
		boolean resultado;
		
		resultado = misReglas1.validNumero(caracter1);
		assertTrue(resultado);
		
		resultado = misReglas1.validNumero(caracter2);
		assertFalse(resultado);
	}

	@Test
	public void validMinusculaTest() {
		Reglas misReglas1 = new Reglas();
		
		String caracter1 = "2";
		String caracter2 = "a";
		boolean resultado;
		
		resultado = misReglas1.validMinuscula(caracter2);
		assertTrue(resultado);
		
		resultado = misReglas1.validMinuscula(caracter1);
		assertFalse(resultado);
	}
	
	@Test
	public void validMayusculaTest() {
		Reglas misReglas1 = new Reglas();
		
		String caracter1 = "A";
		String caracter2 = "a";
		boolean resultado;
		
		resultado = misReglas1.validMayuscula(caracter1);
		assertTrue(resultado);
		
		resultado = misReglas1.validMayuscula(caracter2);
		assertFalse(resultado);
	}
}
