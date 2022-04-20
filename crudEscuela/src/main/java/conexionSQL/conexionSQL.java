
package conexionSQL;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexionSQL {

        //objeto tipo connection
    Connection conectar=null;
    
    public Connection conexion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/escuela","root","");
                       
            JOptionPane.showMessageDialog(null,"Conexion Exitosa");
            
        } catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error de conexion: "+e.getMessage());
                }
        
        return conectar;
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
