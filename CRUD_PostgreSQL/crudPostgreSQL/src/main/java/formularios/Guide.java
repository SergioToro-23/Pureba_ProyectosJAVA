
package formularios;

import java.sql.Connection;
import ConexionPSQL.ConexionPSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  




public class Guide extends javax.swing.JFrame {

    //atributos, primero hago un objeto de la clase conexionPSQL
    ConexionPSQL cc= new ConexionPSQL();
    //luego hago voy al metodo de conexion y obtengo el objeto correspondiente
    Connection con=cc.Conexion();
    
    //constructor
    public Guide() {
        initComponents();
               
        //aparezca el jframe en el centro de la pantalla
        this.setLocationRelativeTo(null);
        //fondo del jframe?
        this.getContentPane().setBackground(getBackground());
        //llama funcion
        mostrardatos();
        
    }
    
    public void limpiarCajas(){
    
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");    
    }
    
    public void mostrardatos(){
    
        //titulos tablas
        String[] titulos={"ID ","Nombre","Celular","Cumpleaños"};
        //Numero columnas
        String[] registros=new String[5];
        //objeto para modificar la tabla
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        //sentencia SQL consulte datos tabla alumnos
        String SQL="SELECT * FROM contacts";
        
        
        try {
            
            //objeto statement creado del objeto conexion
            Statement st=con.createStatement();
            //ejecuta la consulta
            ResultSet rs=st.executeQuery(SQL);
            
            while(rs.next()){
            //registros se van pasando a las filas
            registros[0]=rs.getString("id");
            registros[1]=rs.getString("Name");
            registros[2]=rs.getString("phone");
            registros[3]=rs.getString("birth");
            //añade los registros al objeto modelo que es una matriz
            modelo.addRow(registros);
            }
            //se le envia la matriz a la tabla los registros con el objeto modelo
            jTable1.setModel(modelo);

            //JOptionPane.showMessageDialog(null,"Consulta realizada con exito");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error al mostrar datos: "+e.getMessage());
        }
        
        
    }
    
    public void insertardatos(){
        
        try {
            //instrucción
              String SQL=("INSERT INTO contacts (id,\"Name\",phone,birth) VALUES (?,?,?,?)");
              //prepara el objeto a partir del objeto con
              PreparedStatement pst=con.prepareStatement(SQL);              
              //obtiene lo que haya en el frame
              pst.setInt(1, Integer.parseInt(jTextField2.getText()));
              pst.setString(2, jTextField3.getText());
              pst.setLong(3, Long.parseLong(jTextField4.getText()));//porque esoso numeros son largos
              
              String sDate1=jTextField5.getText();  //obtiene el string de la caja de texto
              java.util.Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);     //obtiene objeto tipo fecha util(java nativo) del string de arriba
              java.sql.Date sDate = new java.sql.Date(date1.getTime());//convierte el objeto a fecha sql
              pst.setDate(4, sDate);//lo asigna a la base de datos
              
              pst.execute();
                            
              JOptionPane.showMessageDialog(null,"ingreso realizado con exito");
        } catch (Exception e) {            
            JOptionPane.showMessageDialog(null,"Error insertando datos: "+e.getMessage());
        }
              
    }
    
    public void eliminardatos(){
       //obtiene la fila a eliminar
        int filaSeleccionada=jTable1.getSelectedRow();        
        try {            
            //instrucción para con set hacer referencia a las columnas que se van a editar y con where que lo haga cuando el id sea el id seleccionado
            String SQL=("DELETE FROM contacts WHERE id="+jTable1.getValueAt(filaSeleccionada, 0));
            // objeto statement
            Statement st=con.createStatement(); 
            //ejecuta la instruccion y guarda n
            int n=st.executeUpdate(SQL);            
            if(n>=0){            
                JOptionPane.showMessageDialog(null,"Eliminacion exitosa"); //si n returna con valor es porque si elimino
            }
            
        } catch (Exception e) {            
            JOptionPane.showMessageDialog(null,"Error Eliminando datos: "+e.getMessage());
        }
        
        
    }
    
    public void actualizardatos(){
        try{
              //instrucción para con set hacer referencia a las columnas que se van a editar y con where que lo haga cuando el id sea el id seleccionado
              String SQL=(" UPDATE contacts SET \"Name\"=?,phone=?,birth=? WHERE id=?");
              //obtiene la fila seleccionada
              int fila_Seleccionado=jTable1.getSelectedRow();
              //guarda en string el id del seleccionado
              String dao=(String)jTable1.getValueAt(fila_Seleccionado, 0);
              int var=Integer.parseInt(dao);
              //objeto consulta              
              PreparedStatement pst=con.prepareStatement(SQL);      
              //obtiene lo que haya en el frame y envia primero el name luego phone y luego birth            
              pst.setString(1, jTextField3.getText());              
              pst.setLong(2, Long.parseLong(jTextField4.getText()));//porque esoso numeros son largos    
              
              String sDate1=jTextField5.getText();  //obtiene el string de la caja de texto
              java.util.Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);     //obtiene objeto tipo fecha util(java nativo) del string de arriba
              java.sql.Date sDate = new java.sql.Date(date1.getTime());//convierte el objeto a fecha sql
              pst.setDate(3, sDate);//lo asigna a la base de datos   
              
              //se envia la variable del id seleccionado, en el orden en que la sentencia SQL de arriba fue escrita
              pst.setInt(4, var);
              pst.execute();
              
              JOptionPane.showMessageDialog(null,"Registro Editado Exitoso");
              
              
          } catch(Exception e){
          
              JOptionPane.showMessageDialog(null,"Error de Edicion: "+e.getMessage());                
          
          }
    
    }
    
    public void buscardatos(String valor){
        
        //titulos tablas
        String[] titulos={"ID ","Nombre","Celular","Cumpleaños"};
        //Numero columnas
        String[] registros=new String[5];
        //objeto para modificar la tabla
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        //sentencia SQL consulte datos tabla contacts buscando por el nombre(ilike es case-insensitive)
        String SQL="SELECT * FROM contacts WHERE \"Name\" ILIKE '%"+valor+"%'";
        
        try {
            
            //objeto statement creado del objeto conexion
            Statement st=con.createStatement();
            //ejecuta la consulta
            ResultSet rs=st.executeQuery(SQL);
            
            while(rs.next()){
            //registros se van pasando a las filas
            registros[0]=rs.getString("id");
            registros[1]=rs.getString("Name");
            registros[2]=rs.getString("phone");
            registros[3]=rs.getString("birth");
            //añade los registros al objeto modelo que es una matriz
            modelo.addRow(registros);
            }
            //se le envia la matriz a la tabla los registros con el objeto modelo
            jTable1.setModel(modelo);

            //JOptionPane.showMessageDialog(null,"Consulta realizada con exito");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Error al mostrar datos: "+e.getMessage());
        }
        
        
    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));

        jLabel2.setText("ID");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Phone");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel5.setText("BirthDate");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Buscar");

        jTextField1.setText(" ");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       limpiarCajas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        insertardatos();
        limpiarCajas();
        mostrardatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //cuando se selecciona algo de la tabla
        //guardar el punto seleccionado
        int fiaSeleccionada=jTable1.rowAtPoint(evt.getPoint());
        //enviar la info a las cajas de texto
        jTextField2.setText(jTable1.getValueAt(fiaSeleccionada, 0).toString());
        jTextField3.setText(jTable1.getValueAt(fiaSeleccionada, 1).toString());
        jTextField4.setText(jTable1.getValueAt(fiaSeleccionada, 2).toString());
        jTextField5.setText(jTable1.getValueAt(fiaSeleccionada, 3).toString()); 
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        eliminardatos();
        limpiarCajas();
         mostrardatos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        actualizardatos();
        limpiarCajas();
        mostrardatos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       buscardatos(jTextField1.getText());
    }//GEN-LAST:event_jTextField1KeyReleased

    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Guide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Guide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Guide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Guide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Guide().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
