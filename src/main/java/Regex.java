import java.util.ArrayList;

public class Regex {
	private Reglas misReglas;
	private String patron;
	private final String validadorNumeros = "[0-9]";
	private final String validadorMayusculas = "[A-Z]";
	private final String validadorMinusculas= "[a-z]";
	private ArrayList<String> validadores = new ArrayList<String>();
	
	public Regex(String patron) {
		this.patron = patron;
		this.misReglas = new Reglas();
	}
	
	public int validar(String cadena) {
		int resultado = 0;
		
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
							if (misReglas.validNumero(caracteres[i])) {
								resultado = 1;
							}
							break;
						case validadorMayusculas:
							if (misReglas.validMayuscula(caracteres[i])) {
								resultado = 1;
							}
							break;
						case validadorMinusculas:
							if (misReglas.validMinuscula(caracteres[i])) {
								resultado = 1;
							}
							break;
					}
				}
			}
		} else {
			resultado = -1;
		}
		
		return resultado;
	}
	
	public boolean validarPatron(String expresion) {
		boolean resultado = true;
		
		if (expresion.length() % 5 == 0) {			
			// Dividir el patron en validadores individuales
			for (int i=0;i<patron.length();i=i+5) {
				validadores.add(patron.substring(i, i+5));
			}
			// Comparar los validadores si están definidos
			for (String p: validadores) {
				if (!p.equals(validadorNumeros) && !p.equals(validadorMayusculas) && !p.equals(validadorMinusculas)) {
					resultado = false;
				}
			}
		} else {
			resultado = false;
		}
		
		return resultado;
	}
	
}
