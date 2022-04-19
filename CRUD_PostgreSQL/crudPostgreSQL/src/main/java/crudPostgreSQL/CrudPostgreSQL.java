
package crudPostgreSQL;

import java.sql.*;
import javax.swing.JOptionPane;

public class CrudPostgreSQL {

    public static void main(String[] args) {
        //almacena la ruta
        String BD = "jdbc:postgresql://localhost:5432/bdprueba";
        //el usuario de postgres por defecto
        String usuario="postgres";
        String contra="1234";
        
        try {
            //pbjeto de tipo conection
            Connection conectar = DriverManager.getConnection(BD,usuario,contra);
            JOptionPane.showMessageDialog(null,"Base de datos conectada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al conectar"+e.getMessage());
        }
    }
}
