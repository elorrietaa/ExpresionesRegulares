import java.util.ArrayList;

public class Regex {
	private Reglas misReglas;
	private String patron;
	private final String validadorNumeros = "[0-9]";
	private final String validadorMayusculas = "[A-Z]";
	private final String validadorMinusculas= "[a-z]";
	private ArrayList<String> validadores;
	
	public Regex(String patron) {
		this.patron = patron;
		this.misReglas = new Reglas();
	}
	
	public int validar(String cadena) {
		int resultado = 0;
		
		// Verficar que los patrones est�n definidos
		validadores = misReglas.validarPatron(patron);
		if (validadores.size() > 0) {
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
							} else {
								resultado = 0;
							}
							break;
						case validadorMayusculas:
							if (misReglas.validMayuscula(caracteres[i])) {
								resultado = 1;
							} else {
								resultado = 0;
							}
							break;
						case validadorMinusculas:
							if (misReglas.validMinuscula(caracteres[i])) {
								resultado = 1;
							} else {
								resultado = 0;
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
	
	
	
}
