package poo;

public class Coche {

	//Atributos y con private se hace uso del encapsulamiento
	//solo se pueden modificar desde esta clase
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int peso_plataforma;
	
	private String color;
	private int peso_total;
	private boolean asientos_cuero, climatizador;
	
	 //Constructor
	public Coche() {
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		peso_plataforma=500;
	}
	
	
	
	//metodo getter(no modifica solo retorna)
	public String getter_datos() {
		
		return "la paltaforma del vehiculo tiene"
				+ruedas+" ruedas. Mide " + largo/1000+" "
				+ "metros con un ancho de "+ancho+"cm y"
		        + " un peso de "+ peso_plataforma+" kg";
	}	
	 //setter(no devuleve, solo modifica)
	public void setter_color(String color_coche) {
		color = color_coche;
	}
	//getter
	public String getter_color() {
		
		return "el color del coche es " + color;
	}
		
	 //setter
	public void setter_configuraAsientos(String asientos_cuero) {

		if(asientos_cuero.equalsIgnoreCase("si")) {
			this.asientos_cuero=true;
		}else {
			this.asientos_cuero=false;
		}
	}
	//getter
	public String getter_asientos() {
		if(asientos_cuero==true) {
			return "el coche tiene asientos de cuero";
		}else {
			return "el coche NO tiene asientos de cuero";
		}
	}
	
	
	 //setter
		public void setter_climatizador(String climatizador) {

			if(climatizador.equalsIgnoreCase("si")) {
				this.climatizador=true;
			}else {
				this.climatizador=false;
			}
		}
		//getter
		public String getter_climatizador() {
			if(climatizador==true) {
				return "el coche tiene climatizador";
			}else {
				return "el coche NO tiene climatizador";
			}
		}
	
	
		 //setter
		public void setter_peso_total() {
			int peso_carroceria=500;
			peso_total=peso_carroceria+peso_plataforma;
		if (asientos_cuero==true) {
			peso_total=peso_total+50;
		}
		if (climatizador==true) {
			peso_total=peso_total+20;
		}
		}
		//getter
		public String getter_peso_total() {
			return "el coche un peso de "+peso_total;
			}
		
		
		//getter 
		public int getter_precio() {
			int precio_final=10000;
			if(asientos_cuero==true) {
				precio_final+=2000;
			}
			if (climatizador==true) {
				precio_final+=1500;
			}
			
			return precio_final;
			}
		
		
	
}
