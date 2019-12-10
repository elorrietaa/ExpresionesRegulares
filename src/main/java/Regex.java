import java.util.ArrayList;

public class Regex {
	private String patron;
	private final String validadorNumeros = "[0-9]";
	private final String validadorMayusculas = "[A-Z]";
	private final String validadorMinusculas= "[a-z]";
	private ArrayList<String> validadores = new ArrayList<String>();
	
	public Regex(String patron) {
		this.patron = patron;
	}
	
	public boolean validar(String cadena) {
		boolean resultado = false;
		
		// Verficar que los patrones est�n definidos
		if (validarPatron(patron)) {
			// Separa la cadena de entrada en caracteres sueltos
			String[] caracteres = cadena.split("");
			
			// Verificar que la loongitud de la cadena es igual a la de los patrones introducidos
			if (caracteres.length == validadores.size()) {
				// Verificar cada caracter con su patron
				for (int i=0;i<caracteres.length;i++) {
					switch(validadores.get(i)) {
						case validadorNumeros:
							if (validNumero(caracteres[i])) {
								resultado = true;
							}
							break;
						case validadorMayusculas:
							if (validMayuscula(caracteres[i])) {
								resultado = true;
							}
							break;
						case validadorMinusculas:
							if (validMinuscula(caracteres[i])) {
								resultado = true;
							}
							break;
					}
				}
			}
		}
		
		return resultado;
	}
	
	private boolean validarPatron(String expresion) {
		int bloques = expresion.length() / 5;
		boolean resultado = false; 
		
		// Dividir el patron en validadores individuales
		for (int i=0;i<patron.length();i=i+5) {
			validadores.add(patron.substring(i, i+5));
		}
		// Comparar los validadores si están definidos
		for (String p: validadores) {
			if (p.equals(validadorNumeros) || p.equals(validadorMayusculas) || p.equals(validadorMinusculas)) {
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	private boolean validNumero(String caracter) {
		boolean resultado = false;
		String digito[] = {"0","1","2","3","4","5","6","7","8","9"}; //Array de dígitos
		
		for (int f=0; f<digito.length; f++)  //Comparamos el que nos llega y con nuestro array
			if(caracter.equals(digito[f])) resultado = true;
		
		return resultado;
	}
	
	private boolean validMinuscula(String caraceter) {
		return false;
		
	}
	
	private boolean validMayuscula(String caracter) {
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
