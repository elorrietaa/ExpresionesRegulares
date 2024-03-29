import java.util.ArrayList;

public class Reglas {
	
	public ArrayList<String> validarPatron(String expresion) {
		ArrayList<String> validadores = new ArrayList<String>();
		final String validadorNumeros = "[0-9]";
		final String validadorMayusculas = "[A-Z]";
		final String validadorMinusculas= "[a-z]";
		
		if (expresion.length() % 5 == 0) {		
			// Dividir el patron en validadores individuales
			for (int i=0;i<expresion.length();i=i+5) {
				String p = expresion.substring(i, i+5);
			// Comparar los validadores si están definidos
				if (!p.equals(validadorNumeros) && !p.equals(validadorMayusculas) && !p.equals(validadorMinusculas)) {
					validadores.clear();
					return validadores;
				} else {
					validadores.add(p);
				}
			}
		}
		
		return validadores;
	}

	public boolean validNumero(String caracter) {
		boolean resultado = false;
		String[] digito = {"0","1","2","3","4","5","6","7","8","9"}; //Array de dígitos
		
		for (int f=0;f<digito.length;f++) {  //Comparamos el que nos llega y con nuestro array
			if(caracter.equals(digito[f])) {
				resultado = true;
				break;
			}
		}
		
		return resultado;
	}
	
	public boolean validMinuscula(String caracter) {
		
		char [] caracteres = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'á','é','í','ó','ú'};
		boolean respuesta = false;
		char c = caracter.charAt(0);
		
		for(int i=0; i<caracteres.length;i++) {
			if(caracteres[i] == c) {
				respuesta=true;
				break;
			}
		}
		
		return respuesta;
		
	}
	
	public boolean validMayuscula(String caracter) {
		boolean resultado = false;
		char c = caracter.charAt(0);
		char[] letras = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z','Á','É','Í','Ó','Ú','Ñ','Ü'};
		
		for (char x: letras) {
			if (x == c) {
				resultado = true;
				break;
			}
		}
		
		return resultado;
	}
}
