import java.util.Scanner;

public class Bucle_adivinar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//variables
		int numero=0;
		int NoIntentos=0;		
		//objeto para recibir datos de caja de comandos
		Scanner entrada=new Scanner(System.in);
		//genera numero aleatorio entero de 0 a 100
		int random=(int)(Math.random()*100);
		//System.out.print("el numero es "+random+"\n");
		//System.out.printf("el numero es %1.2f \n",(Math.random()*100));
		
		//bucle indeterminado do while que ejecuta almenos una vez

		do {		
		System.out.println("Ingresa un numero");
		numero=entrada.nextInt();
		NoIntentos++;
		if (numero<random) {
			System.out.println("es mas grande");
		 }else if(numero>random){
			 System.out.println("es mas peque�o");
		 }		
		}while (numero!=random);
		System.out.println("bien, con "+NoIntentos+" intentos");
		
		/*
		while (numero!=random) {		
		System.out.println("Ingresa un numero");
		numero=entrada.nextInt();
		NoIntentos++;
		if (numero<random) {
			System.out.println("es mas grande");
		 }else if(numero>random){
			 System.out.println("es mas peque�o");
		 }		
		}
		System.out.println("bien, con "+NoIntentos+" intentos");
		*/
	}

}
