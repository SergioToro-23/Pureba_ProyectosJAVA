import javax.swing.JOptionPane;

public class Bucle_Acceso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String Clave="juan";
		
		String pass="";
		
		while(Clave.equals(pass)==false) {
			
			pass=JOptionPane.showInputDialog("Introduce contraseņa");
			if (Clave.equals(pass)==false) {
				System.out.println("contraseņa incorrecta");
			}
		}
		System.out.println("Contraseņa correcta");
	}

}
