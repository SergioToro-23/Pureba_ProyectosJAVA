import java.util.Scanner;

public class Entrada_ejemplo1 {

	public static void main(String[] args) {
		// Usando Scanner

		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Introduce tu nombre, por favor");
		//este comando hace que espere a un texto
		String nombre_usuario=entrada.nextLine();
		
		System.out.println("Introduce la edad, por favor");
		
		int edad=entrada.nextInt();
		
		System.out.println("Hola " + nombre_usuario + " El año que viene tendrás " +(edad+1)+ " años" );
	}

}
