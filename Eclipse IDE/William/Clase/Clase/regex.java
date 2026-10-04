package Clase.Clase;

public class regex {

	public static void main(String[] args) {
		String p = "a pepo";
		System.out.println(p.matches(".*[k].*"));
		System.out.println(p.matches(".*"));
	}
}
