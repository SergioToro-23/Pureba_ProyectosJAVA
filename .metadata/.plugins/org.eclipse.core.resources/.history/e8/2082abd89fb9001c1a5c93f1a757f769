package poo;

import java.util.*;

public class UnicoFichero_Empleado {

	public static void main(String[] args) {
		//para acceder y modificar los objetos(metodo largo)
		
		/*
		Empleado empleado1=new Empleado("Paco Gomez",85000,1990,12,17);
		Empleado empleado2=new Empleado("Ana lopez",95000,1995,06,02);
		Empleado empleado3=new Empleado("Maria Martin",105000,2002,03,15);
		//se usa el metodo para subirles el sueldo
		empleado1.setter_subeSueldo(5);
		empleado2.setter_subeSueldo(5);
		empleado3.setter_subeSueldo(5);
		
		System.out.println("Nombre: "+empleado1.getter_nombre()+" Sueldo "+empleado1.getter_sueldo()+
				" Fecha de alta: "+empleado1.getter_fecha());
		System.out.println("Nombre: "+empleado2.getter_nombre()+" Sueldo "+empleado2.getter_sueldo()+
				" Fecha de alta: "+empleado2.getter_fecha());
		System.out.println("Nombre: "+empleado3.getter_nombre()+" Sueldo "+empleado3.getter_sueldo()+
				" Fecha de alta: "+empleado3.getter_fecha());
		*/
		
		// lo mismo pero mejor metodo
		// array de empleados(oobjetos)
		Empleado[] misEmpleados=new Empleado[4];
		misEmpleados[0]=new Empleado("Paco Gomez",85000,1990,12,17);
		misEmpleados[1]=new Empleado("Ana lopez",95000,1995,06,02);
		misEmpleados[2]=new Empleado("Maria Martin",105000,2002,03,15);
		misEmpleados[3]=new Empleado("sergio mendez");//usando sobrecarga de constructores 
		
		// for each para recorrer el array(un objeto i que recorra los objetos de misEmpleados)
		for (Empleado i:misEmpleados) {
			i.setter_subeSueldo(5);			
		}
		/* for normal
		for (int i=0;i<misEmpleados.length;i++) {
			misEmpleados[i].setter_subeSueldo(5);			
		}*/
		
		
		
		// for each 
		for (Empleado e:misEmpleados) {
			System.out.println("Nombre: "+e.getter_nombre()+" Sueldo "+e.getter_sueldo()+
					" Fecha de alta: "+e.getter_fecha());	
		}/* for normal
		for (int i=0;i<3;i++) {
			System.out.println("Nombre: "+misEmpleados[i].getter_nombre()+" Sueldo "+misEmpleados[i].getter_sueldo()+
					" Fecha de alta: "+misEmpleados[i].getter_fecha());			
		}*/
		
		
	}

}

class Empleado{
	
	//Constructor
	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		nombre = nom;
		sueldo = sue;
		//uso de clase gregorian calendar
		GregorianCalendar calendario=new GregorianCalendar(agno, mes-1,dia);
		altaContrato = calendario.getTime();
		
	}
	// Otro Constructor(sobre carga)
	public Empleado(String nom) {
		// este this llama al constructor que coincide con los parametros que esta enviando, para construir el objeto
		this(nom,3000,2000,01,01);
	} 
	
	
	
	
	//getters
	public String getter_nombre() {		
		return nombre;
	}
	public double getter_sueldo() {		
		return sueldo;
		}
	public Date getter_fecha() {		
		return altaContrato;
	}
	
	
	
	//Setter
		public void setter_subeSueldo(double porcentaje) {		
			// se setea el aumento de sueldo
			double aumento=sueldo*porcentaje/100;
			sueldo+=aumento;
		}
	
	
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	
	
}

//clase que hereda todo de empleado
class Jefatura extends Empleado {
	
	public Jefatura(String nom, double sue, int agno, int mes, int dia) {
		
		super(nom,sue,agno,mes,dia);//llama al constructor de empleado y se le deben pasar los parametros 
	}
	//Setter de incentivo
	public void setter_incentivo(double b) {		
		incentivo=b;
	}
	//Este Getter esta reemplazando al de la clase padre, y pone el sueldo
	public double getter_sueldo() {		
		double sueldoJefe=super.getter_sueldo();// aqui con el super se le especifica que vaya al getter del padre o si no iria a si mismo
		return sueldoJefe + incentivo;
	}
	
	
	private double incentivo;
	
}

