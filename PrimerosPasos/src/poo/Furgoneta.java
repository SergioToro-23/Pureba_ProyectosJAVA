package poo;


//clase coche(superclase,clase padre)----->clase furgoneta(subclase,clase hija)
public class Furgoneta extends Coche{

	//atributos de solo furgoneta, los demas ya los tiene
	private int capacidad_carga;
	private int plazas_extra;
	
	//constructor
	public Furgoneta(int plazas_extra, int capacidad_carga) {
		
		super();//llamar al constructor de  la clase padre		
		this.capacidad_carga=capacidad_carga;
		this.plazas_extra=plazas_extra;
	}
	
	//Getter
	public String getter_datosFurgo() {
		return "La capacidad de carga es: "+capacidad_carga+" Y las plazas extra son: "+plazas_extra;
	}
	
	
	
}
