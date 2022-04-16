import java.util.Date;
import java.util.GregorianCalendar;

public class POO_Static_ydemas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Empleado trabajador1=new Empleado("Paco");		
		Empleado trabajador2=new Empleado("Ana");
		Empleado trabajador3=new Empleado("sara");
		
		trabajador1.cambiaSeccion("RRHH");
		
		
		System.out.println(trabajador1.getter_datos()+"\n"+
				trabajador2.getter_datos()+"\n"+
				trabajador3.getter_datos());
		
		// llamar a un metodo estatico
		System.out.println(Empleado.getter_id()); 
		
		
		
		
	}

}

class Empleado{
	
	//constructor
	public Empleado(String nom) {
		nombre = nom;
		seccion = "administracion";
		Id=IDSiguiente;
		//cada que crea un objeto incrementa el valor de idsiguiente
		IDSiguiente++;
	}
	
	
	//getters
	public String getter_datos() {		
		return "El nombre es "+nombre+ " y la seccion es " +seccion+" y el id es "+Id;
		}
	//Setter
	public void cambiaSeccion(String seccion) {	
			
		this.seccion=seccion;
			}
	// getter
	public static String getter_id(){
		
		return "El Id siguiente es : "+IDSiguiente;
	}
	
	
	private final String nombre;
	private String seccion;
	private int Id=0;//una variable compartida entre todos los objetos
	private static int IDSiguiente=1;
	
	
}