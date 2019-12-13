import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ReglasTest {
	
	
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
