import javax.swing.JOptionPane;

public class Bucle_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		for (int i=0;i<20;i+=2) {
		//for (int i=10;i>0;i--) {
		//for (int i=0;i<10;i++) {
			System.out.println("hola como estas "+i);
			
		}
		*/
		
		String correo=JOptionPane.showInputDialog("Introduce tu email");
		int arroba=0;
		boolean punto=false;
		
		for (int i=0;i<correo.length();i++) {
		if(correo.charAt(i)=='@') {
			arroba++;			
		}
		if(correo.charAt(i)=='.') {
			 punto=true;			
		} 

		
	}
		if(arroba==1 && punto==true) {
			System.out.println("es correcto el mail");
		}else {
			System.out.println("mal el correo");
		}	
	}

}
