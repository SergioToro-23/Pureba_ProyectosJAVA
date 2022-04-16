
public class Manipula_Cadenas2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String fraseejemplo = "Curso Java. Manipulación de cadenas. Clase String II. Vídeo 12";
		
		String frasecorta = fraseejemplo.substring(6,10)+"python";
		
		System.out.println(frasecorta);
		
		String alumno1, alumno2;
		
		alumno1="David";
		alumno2="David";
		
		System.out.println(alumno1.equals(alumno2));
		System.out.println(alumno1.equalsIgnoreCase(alumno2));
	}

}
