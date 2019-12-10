import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String patronIntroducido = "";
		String cadenaIntroducida = "";
		boolean respuestaValidacion = false;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Expresiones regulares permitidas: [0-9], [a-z], [A-Z] ");
		System.out.println("Introduzca la expresi�n regular que desea utilizar: ");
		patronIntroducido = reader.next();
		
		Regex miRegex = new Regex(patronIntroducido);
		
		System.out.println("Introduzca la cadena que desea evaluar:");
		cadenaIntroducida = reader.next();
		
		respuestaValidacion = miRegex.validar(cadenaIntroducida);
		
		if(respuestaValidacion) {
			System.out.println("Cadena correcta para la expresi�n regular introducida");
		}
		else {
			System.out.println("Cadena incorrecta para la expresi�n regular utilizada");
		}
			
		
		
	}

}
