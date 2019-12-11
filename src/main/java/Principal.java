import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String patronIntroducido = "";
		String cadenaIntroducida = "";
		int respuestaValidacion = 0;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Expresiones regulares permitidas: [0-9], [a-z], [A-Z] ");
		System.out.println("Introduzca la expresión regular que desea utilizar: ");
		patronIntroducido = reader.next();
		
		Regex miRegex = new Regex(patronIntroducido);
		
		System.out.println("Introduzca la cadena que desea evaluar:");
		cadenaIntroducida = reader.next();
		
		respuestaValidacion = miRegex.validar(cadenaIntroducida);
		
		switch (respuestaValidacion) { 
			case -1:
				System.out.println("El patrón introducido no es válido");
				break;
			case 1:
				System.out.println("Cadena correcta para la expresión regular introducida");
				break;
			case 0:
				System.out.println("Cadena incorrecta para la expresión regular utilizada");
				break;
		}
			
		reader.close();
		
	}

}
