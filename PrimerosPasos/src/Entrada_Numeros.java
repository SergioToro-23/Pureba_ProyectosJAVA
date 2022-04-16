import javax.swing.JOptionPane;

public class Entrada_Numeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double x=10000.0;
		
		//pone todos los decimales
		//System.out.println(x/3);
		
		//imprime dos decimales
		System.out.printf("%1.2f",x/3);
		
		String num1=JOptionPane.showInputDialog("Introduce un numero");
		
		//lo convierte de string a double
		double num2=Double.parseDouble(num1);
		
		System.out.print("la raiz de "+ num2 + " es");
		System.out.printf("%1.2f",Math.sqrt(num2));
				

	}

}
