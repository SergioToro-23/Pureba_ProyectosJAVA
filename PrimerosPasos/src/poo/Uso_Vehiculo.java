package poo;

import javax.swing.*;

public class Uso_Vehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
/*
		//INSTANCIAR UNA CLASE. EJEMPLAR DE CLASE 
		Coche micoche=new Coche();
		 
		micoche.setter_color(JOptionPane.showInputDialog("introdusca el color:"));	
		micoche.setter_configuraAsientos(JOptionPane.showInputDialog("�Quiere asientos de cuero?"));
		micoche.setter_climatizador(JOptionPane.showInputDialog("�Quiere climatizador?"));
		micoche.setter_peso_total();
		
		System.out.println(micoche.getter_datos());
		System.out.println(micoche.getter_color());
		System.out.println(micoche.getter_asientos());
		System.out.println(micoche.getter_climatizador());
		System.out.println(micoche.getter_peso_total());
		System.out.println("El precio final del coche es "+micoche.getter_precio()+"pesos");
*/
		
		Coche micoche1=new Coche();
		micoche1.setter_color(JOptionPane.showInputDialog("introdusca el color:"));
		
		//llamo al constructor de furgoneta con sus parametros extras
		Furgoneta mifurgo1=new Furgoneta(2,1);
		mifurgo1.setter_color(JOptionPane.showInputDialog("introdusca el color:"));
		mifurgo1.setter_configuraAsientos("si");
		mifurgo1.setter_climatizador("si");
		
		System.out.println(micoche1.getter_datos()+" "+micoche1.getter_color());
		
		System.out.println(mifurgo1.getter_datos()+" "+mifurgo1.getter_datosFurgo());
	} 

}
