import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class RegexTest {

	@Test
	public void validarTest() {
		String patron1 = "[0-9]";
		String patron2 = "[a-z]";
		String patron3 = "[A-Z]";
		String patron4 = "[0-9][a-z]";
		String patron5 = "[0-5][a-z]";
		
		ArrayList<String> arrayPatron1 = new ArrayList<String>();
		arrayPatron1.add("[0-9]");
		ArrayList<String> arrayPatron2 = new ArrayList<String>();
		arrayPatron1.add("[a-z]");
		ArrayList<String> arrayPatron3 = new ArrayList<String>();
		arrayPatron1.add("[A-Z]");
		ArrayList<String> arrayPatron4 = new ArrayList<String>();
		arrayPatron1.add("[0-9][a-z]");
		
		ArrayList<String> arrayPatron5 = new ArrayList<String>();
		
		Regex miRegex1 = new Regex(patron1);
		Regex miRegex2 = new Regex(patron2);
		Regex miRegex3 = new Regex(patron3);
		Regex miRegex4 = new Regex(patron4);
		Regex miRegex5 = new Regex(patron5);
		
		String numOk = "1";
		String numNok = "a";
		String mayOk = "A";
		String mayNok = "a";
		String minOk = "a";
		String minNok = "A";
		
		Reglas reglasMock = mock(Reglas.class);
		when(reglasMock.validNumero(numOk)).thenReturn(true);
		when(reglasMock.validNumero(numNok)).thenReturn(false);
		when(reglasMock.validNumero(mayOk)).thenReturn(true);
		when(reglasMock.validNumero(mayNok)).thenReturn(false);
		when(reglasMock.validNumero(minOk)).thenReturn(true);
		when(reglasMock.validNumero(minNok)).thenReturn(false);
		when(reglasMock.validarPatron(patron1)).thenReturn(arrayPatron1);
		when(reglasMock.validarPatron(patron2)).thenReturn(arrayPatron2);
		when(reglasMock.validarPatron(patron3)).thenReturn(arrayPatron3);
		when(reglasMock.validarPatron(patron4)).thenReturn(arrayPatron4);
		when(reglasMock.validarPatron(patron5)).thenReturn(arrayPatron5);
		
		assertEquals(miRegex1.validar(numOk), 1);
		assertEquals(miRegex1.validar(numNok), 0);
		
		assertEquals(miRegex2.validar(minOk), 1);
		assertEquals(miRegex2.validar(minNok), 0);
		
		assertEquals(miRegex3.validar(mayOk), 1);
		assertEquals(miRegex3.validar(mayNok), 0);
		
		assertEquals(miRegex4.validar(numOk + minOk), 1);
		assertEquals(miRegex4.validar(numOk + minNok), 0);
		
		assertEquals(miRegex5.validar(numOk + minOk), -1);
		assertEquals(miRegex5.validar(numOk + minOk), -1);
		
		assertEquals(miRegex1.validar(numOk + minOk), 0);
	}

}
