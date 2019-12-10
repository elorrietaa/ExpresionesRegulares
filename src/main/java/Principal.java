
public class Principal {

	public static void main(String[] args) {
		Regex miRegex = new Regex("[0-9][a-z]");

		miRegex.validar("1a");
	}

}
