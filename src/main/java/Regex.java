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
		
		// Verficar que los patrones están definidos
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
	
	private boolean validNumero(String caraceter) {
		return false;
		
	}
	
	private boolean validMinuscula(String caraceter) {
		return false;
		
	}
	
	private boolean validMayuscula(String caraceter) {
		return false;
		
	}
}
