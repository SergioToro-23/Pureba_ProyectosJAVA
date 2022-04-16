import java.util.*;

public class Evalua_edad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Introduce tu edad");
		
		int edad=entrada.nextInt();
		
		if(edad<40) {
			System.out.println("es mayor de edad");	
		}
		else if(edad<60) {
			System.out.println("eres ya cuarenton");
		}
		else {
			System.out.println("es menor de edad");
		}
		
	}

}
