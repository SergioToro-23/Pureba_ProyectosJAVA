import javax.swing.JOptionPane;

public class Bucle_Acceso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String Clave="juan";
		
		String pass="";
		
		while(Clave.equals(pass)==false) {
			
			pass=JOptionPane.showInputDialog("Introduce contrase�a");
			if (Clave.equals(pass)==false) {
				System.out.println("contrase�a incorrecta");
			}
		}
		System.out.println("Contrase�a correcta");
	}

}