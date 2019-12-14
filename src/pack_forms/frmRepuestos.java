package pack_forms;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pack_class.Repuestos;
public class frmRepuestos extends javax.swing.JFrame {

//    //Fecha y Hora
//    Calendar fecha_actual= new GregorianCalendar();
    //Tabla de Producto
    
    //Variables globales
    DefaultTableModel modelo = new DefaultTableModel();
    
    private void ListarTablaRepuestos(){
        modelo.addColumn("CODIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("STOCK");
        modelo.addColumn("PRECIO");
        /*modelo.addColumn("DESCUENTO");
        modelo.addColumn("IMPORTE");
        modelo.addColumn("IGV");
        modelo.addColumn("SUBTOTAL");
        modelo.addColumn("TOTAL");*/
        
        tblRepuestos.setModel(modelo);
    }
    
    public void leerrepuestos(){
        try{
            File archivo = new File("src\\ficheros\\repuestos.txt");
            if(archivo.exists()){
                FileReader reader = new FileReader(archivo);
                BufferedReader br = new BufferedReader(reader);
                
                String linea;
                while((linea = br.readLine())!=null){
                    StringTokenizer st = new StringTokenizer(linea,";");
                    
                    String cod = st.nextToken().trim();
                    String nom = st.nextToken().trim();
                    String sto = st.nextToken().trim();
                    String pre = st.nextToken().trim();
                    
                    Object[] obj = new Object[]{
                        cod, nom, sto, pre
                    };
                    modelo.addRow(obj);
                }
                //liberar recursos
                br.close();
            }
            else{
                JOptionPane.showMessageDialog(null, 
                        "No se encuentra la ruta del archivo");
            }
            
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,
                "Error Leer Fichero:\n"+ ex.getMessage());
        }
    }
    
    
    public frmRepuestos() {
        initComponents();
        ListarTablaRepuestos();	
        
        leerrepuestos();
        this.setMinimumSize(new Dimension(850,550));
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
	
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRepuestos = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        fondito = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(6);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Codigo: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 40, 74, 24);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setText("Nombre: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 80, 82, 24);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setText("Stock:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 120, 60, 24);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setText("Precio:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 40, 70, 24);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1636, 40, 0, 0);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1605, 74, 0, 0);

        btncancelar.setBackground(new java.awt.Color(204, 255, 204));
        btncancelar.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btncancelar);
        btncancelar.setBounds(660, 140, 140, 40);

        txtPrecio.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        getContentPane().add(txtPrecio);
        txtPrecio.setBounds(480, 40, 160, 36);

        btnEliminar.setBackground(new java.awt.Color(204, 255, 204));
        btnEliminar.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(660, 100, 140, 40);

        btnModificar.setBackground(new java.awt.Color(204, 255, 204));
        btnModificar.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar);
        btnModificar.setBounds(660, 60, 140, 40);

        btnGrabar.setBackground(new java.awt.Color(204, 255, 204));
        btnGrabar.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGrabar);
        btnGrabar.setBounds(660, 20, 140, 40);

        txtCodigo.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        getContentPane().add(txtCodigo);
        txtCodigo.setBounds(140, 40, 260, 36);

        txtStock.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });
        getContentPane().add(txtStock);
        txtStock.setBounds(140, 120, 260, 36);

        tblRepuestos.setBackground(new java.awt.Color(255, 255, 204));
        tblRepuestos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblRepuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRepuestos.setShowHorizontalLines(true);
        tblRepuestos.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tblRepuestos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 190, 790, 240);

        txtNombre.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        getContentPane().add(txtNombre);
        txtNombre.setBounds(140, 80, 430, 36);

        fondito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GAAAAA.jpg"))); // NOI18N
        getContentPane().add(fondito);
        fondito.setBounds(0, 0, 1000, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed

        //AGREGAR AL FICHERO
        try{
            FileWriter fw;
            PrintWriter pw;
            
            fw = new FileWriter("src\\ficheros\\Repuestos.txt", true);
            pw = new PrintWriter(fw);
            
            //CREAMOS EL OBJETO
            //AGREGAR A LA TABLA
        Repuestos obj = new Repuestos();
        obj.setcodigo(txtCodigo.getText());
        obj.setnombre(txtNombre.getText());
        obj.setStock(Integer.parseInt(txtStock.getText()));
        obj.setPrecio(Double.parseDouble(txtPrecio.getText()));
        
        //Agregar filas a la tabla
        Object[] fila = new Object[4];
        fila[0] = obj.getcodigo();
        fila[1] = obj.getnombre();
        fila[2] = obj.getStock();
        fila[3] = obj.getPrecio();
        
        modelo.addRow(fila);
        
        //enviar archivos al fichero
            pw.println(obj.getcodigo() + "  ;  " +
                       obj.getnombre()+ "  ;  " +
                       obj.getStock()+ "  ;  " +
                       obj.getPrecio());
            
            pw.close();
            
            //enviar mensaje de exito
            JOptionPane.showMessageDialog(null, "Se registro correctamente.");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro de fichero:" + ex.getMessage());
        }
        
        //LIMPIAR LAS CASILLAS
        txtCodigo.setText(null);
        txtNombre.setText(null);
        txtStock.setText(null);
        txtPrecio.setText(null);
        
        txtCodigo.requestFocus();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String []datos=new String[8];
        datos[0]=txtCodigo.getText();
        datos[1]=txtStock.getText();
        //datos[2]=txtDescuento.getText();
        datos[3]=txtStock.getText();
        datos[4]=txtPrecio.getText();
        for(int i=0; i < tblRepuestos.getColumnCount();i++)
        {
            modelo.setValueAt(datos[i],filas, i);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila_seleccionada=tblRepuestos.getSelectedRow();
        if(fila_seleccionada>=0){
            modelo.removeRow(fila_seleccionada);
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favo, seleccione una fila.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
        frmMenu p = new frmMenu();
        p.setVisible(true);
        
       // this.setVisible(false);
        
    }//GEN-LAST:event_formWindowClosing

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        
        txtCodigo.setText(null);
        txtPrecio.setText(null);
        txtNombre.setText(null);
        txtStock.setText(null);
        
        txtCodigo.requestFocus();
        
        
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
        char telfonoCliente = evt.getKeyChar();
        if(telfonoCliente<'0' || telfonoCliente>'9') evt.consume();
        
        
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        // TODO add your handling code here:
       char telfonoCliente = evt.getKeyChar();
       if(telfonoCliente<'0' || telfonoCliente>'9') evt.consume();
    }//GEN-LAST:event_txtStockKeyTyped
int filas;
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
            java.util.logging.Logger.getLogger(frmRepuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRepuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRepuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRepuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRepuestos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JLabel fondito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRepuestos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
