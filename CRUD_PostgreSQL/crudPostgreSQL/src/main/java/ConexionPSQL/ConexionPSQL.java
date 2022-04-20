
package ConexionPSQL;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionPSQL {

    
        //objeto tipo connection
    Connection conectar=null;
    
    //constructor de la clase(retorna objeto conexion)
    public Connection Conexion(){
    
        //almacena la ruta
        String BD = "jdbc:postgresql://localhost:5432/PostgresIn10";
        //el usuario de postgres por defecto
        String usuario="postgres";
        String contra="1234";
        
        try {
            //pbjeto de tipo conection
             conectar = DriverManager.getConnection(BD,usuario,contra);
            JOptionPane.showMessageDialog(null,"Base de datos conectada");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al conectar"+e.getMessage());
        }
        
        return conectar;
    
    }
    
    public static void main(String[] args) {
        
    }
}
