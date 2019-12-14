/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_forms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.text.SimpleDateFormat;
import pack_class.Cotizacion;
import java.awt.*;
import java.awt.print.*;
/**
 *
 * @author Mariano PC
 */
public class frmCotizacion extends javax.swing.JFrame implements Printable{

    DefaultTableModel modeloTrabajador =  new DefaultTableModel();
    DefaultTableModel modeloProducto = new DefaultTableModel();
    DefaultTableModel modeloCotizacion = new DefaultTableModel();
    private int fila;
   
     private void columnasTablaTrabajador(){
            modeloTrabajador.addColumn("CODIGO");
            modeloTrabajador.addColumn("NOMBRE");
            modeloTrabajador.addColumn("APELLDIO");
            
            tblBusquedaTra.setModel(modeloTrabajador);
   }
   
   private void columnasTablaCotizacion(){
       modeloCotizacion.addColumn("MATERIAL");
       modeloCotizacion.addColumn("CANTIDAD");
       modeloCotizacion.addColumn("PRECIO UNI.");
       modeloCotizacion.addColumn("TOTAL");
       tblCotizacion.setModel(modeloCotizacion);
   }
     public final void leerBuscarTrabajador(){
        try{
            File archivo = new File("src\\ficheros\\trabajador.txt");
            if(archivo.exists()){
                FileReader reader = new FileReader(archivo);
                BufferedReader br = new BufferedReader(reader);
                
                String linea;
                while((linea = br.readLine())!=null){
                    StringTokenizer st = new StringTokenizer(linea,";");
                    String cod = st.nextToken().trim();
                    String nom = st.nextToken().trim();
                    String ape = st.nextToken().trim();
                   
                    
                    
                    
                    Object[] obj = new Object[]{
                        cod, nom, ape
                    };
                    modeloTrabajador.addRow(obj);
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
    
    private void columnasTablaProducto(){
        modeloProducto.addColumn("CODIGO");
            modeloProducto.addColumn("MATERIAL");
            modeloProducto.addColumn("CANTIDAD");
             modeloProducto.addColumn("PRECIO");
            
            tblProductoBusqueda.setModel(modeloProducto);
    }
    
         public final void leerBuscarProducto(){
        try{
            File archivo = new File("src\\ficheros\\Repuestos.txt");
            if(archivo.exists()){
                FileReader reader = new FileReader(archivo);
                BufferedReader br = new BufferedReader(reader);
                
                String linea;
                while((linea = br.readLine())!=null){
                    StringTokenizer st = new StringTokenizer(linea,";");
                    String cod = st.nextToken().trim();
                    String mat = st.nextToken().trim();
                    String sto = st.nextToken().trim();
                    String pre = st.nextToken().trim();
                   
                    
                    Object[] obj = new Object[]{
                        cod, mat,sto, pre
                    };
                    modeloProducto.addRow(obj);
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
        

      /*  private void Subtotal(){
             double a = 0;
            for (int i=0; i<tblCotizacion.getRowCount(); i++)
            {
               
                a = a+Double.parseDouble((String) tblCotizacion.getValueAt(i,3));
                  
            }
         lblSubtotal.setText(String.valueOf(a));
        }*/
        /* public double suma(){
             int contar= tblCotizacion.getRowCount();
             double suma=0;
             for(int i =0;i<contar;i++){
             suma=suma+Double.parseDouble(tblCotizacion.getValueAt(i, 3).toString());
             
         }
             return suma;
             
         }*/
    public frmCotizacion() {
        initComponents();
        columnasTablaTrabajador();
        leerBuscarTrabajador();
        columnasTablaProducto();
        leerBuscarProducto();
        columnasTablaCotizacion();
        this.setLocationRelativeTo(null);
       
    }

      private double redondear(double num){
        return Math.rint(num*100)/100;
    }
        private void calTotal(){
        double S = 0,igv,tot;
        for(int i=0;i<tblCotizacion.getRowCount();i++){
            S=S+Double.parseDouble(tblCotizacion.getValueAt(i,3).toString());
        }
        S=redondear(S);
        lblSubtotal.setText(String.valueOf(S));
        igv=0.18*S;
        igv=redondear(igv);
        tot=S*1.18;
        tot=redondear(tot);
        lblIGV.setText(String.valueOf(igv));
        lblTotalCot.setText(String.valueOf(tot));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlImpresion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtAtencion = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtCliNom = new javax.swing.JLabel();
        txtCliDirec = new javax.swing.JLabel();
        txtCLiPais = new javax.swing.JLabel();
        txtCliTelef = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCotizacion = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblIGV = new javax.swing.JLabel();
        lblTotalCot = new javax.swing.JLabel();
        txtCliNom1 = new javax.swing.JLabel();
        txtCliDirec1 = new javax.swing.JLabel();
        txtCLiPais1 = new javax.swing.JLabel();
        txtCliTelef1 = new javax.swing.JLabel();
        dtcCotizFecha = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBusquedaTra = new javax.swing.JTable();
        txtBusTraCodigo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnBusquedaTraCodigo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnTrabajadorGrabar = new javax.swing.JButton();
        lblCodigoTra = new javax.swing.JLabel();
        lblNombreTra = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCliNombre = new javax.swing.JTextField();
        txtCliApellido = new javax.swing.JTextField();
        txtCliDni = new javax.swing.JTextField();
        txtCliTelefono = new javax.swing.JTextField();
        txtCliDirección = new javax.swing.JTextField();
        txtCliPais = new javax.swing.JTextField();
        txtCliDistrito = new javax.swing.JTextField();
        txtCliProvincia = new javax.swing.JTextField();
        btnClienteGrabar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtProBusqueda = new javax.swing.JTextField();
        btnProBusqueda = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductoBusqueda = new javax.swing.JTable();
        btnProGrabar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtProductoCantidad = new javax.swing.JTextField();
        btnEliminarPro = new javax.swing.JButton();
        lblMatProducto = new javax.swing.JLabel();
        lblCodProducto = new javax.swing.JLabel();
        lblPreProducto = new javax.swing.JLabel();
        btnGrabarFecha = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(6);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(244, 19, 78, 0);

        pnlImpresion.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("     COTIZACIÓN");

        jLabel3.setText("     FECHA");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Captura.png"))); // NOI18N

        jLabel5.setText("RUC:");

        jLabel6.setText("Dirección:");

        jLabel7.setText("Telefono:");

        jLabel8.setText("Atención:");

        jLabel25.setText("20519033233");

        jLabel26.setText("Av. Cristobal de Peralta N. N°968 Urb. San Idelfonso");

        jLabel27.setText("6179999  -  6119393");

        txtAtencion.setText("Nombre del Trabajador");

        jLabel28.setBackground(new java.awt.Color(51, 153, 255));
        jLabel28.setText(" CLIENTE");
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtCliNom.setText("Nombre:");

        txtCliDirec.setText("Dirección:");

        txtCLiPais.setText("Pais:");

        txtCliTelef.setText("Telefono:");

        tblCotizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCotizacion.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tblCotizacion);
        tblCotizacion.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel30.setText("SUBTOTAL:");

        jLabel31.setText("IGV:");

        jLabel32.setText("TOTAL:");

        javax.swing.GroupLayout pnlImpresionLayout = new javax.swing.GroupLayout(pnlImpresion);
        pnlImpresion.setLayout(pnlImpresionLayout);
        pnlImpresionLayout.setHorizontalGroup(
            pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImpresionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(pnlImpresionLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAtencion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlImpresionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalCot, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                        .addGap(21, 21, 21))
                    .addGroup(pnlImpresionLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlImpresionLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlImpresionLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))
                    .addGroup(pnlImpresionLayout.createSequentialGroup()
                        .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlImpresionLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlImpresionLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlImpresionLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlImpresionLayout.createSequentialGroup()
                                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCliTelef, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCLiPais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCliNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCliDirec, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCLiPais1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCliDirec1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCliTelef1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCliNom1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlImpresionLayout.setVerticalGroup(
            pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImpresionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlImpresionLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliNom, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliNom1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliDirec1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCLiPais, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCLiPais1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliTelef, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliTelef1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lblIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lblTotalCot, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );

        getContentPane().add(pnlImpresion);
        pnlImpresion.setBounds(930, 50, 520, 650);

        dtcCotizFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtcCotizFechaKeyTyped(evt);
            }
        });
        getContentPane().add(dtcCotizFecha);
        dtcCotizFecha.setBounds(280, 10, 170, 30);

        jLabel9.setText("Fecha:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(240, 10, 50, 20);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Selecionar Trabajador:"));

        tblBusquedaTra.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBusquedaTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBusquedaTraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBusquedaTra);

        txtBusTraCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusTraCodigoKeyTyped(evt);
            }
        });

        jLabel10.setText("Ingresar codigo:");

        btnBusquedaTraCodigo.setBackground(new java.awt.Color(0, 153, 255));
        btnBusquedaTraCodigo.setText("Buscar");
        btnBusquedaTraCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaTraCodigoActionPerformed(evt);
            }
        });

        jLabel11.setText("Codigo:");

        jLabel12.setText("Nombre:");

        btnTrabajadorGrabar.setBackground(new java.awt.Color(255, 102, 0));
        btnTrabajadorGrabar.setText("Grabar");
        btnTrabajadorGrabar.setBorder(null);
        btnTrabajadorGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrabajadorGrabarActionPerformed(evt);
            }
        });

        lblCodigoTra.setBackground(new java.awt.Color(255, 255, 255));
        lblCodigoTra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNombreTra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombreTra, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                    .addComponent(lblCodigoTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtBusTraCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBusquedaTraCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnTrabajadorGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusTraCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btnBusquedaTraCodigo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(lblCodigoTra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreTra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTrabajadorGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(30, 40, 340, 300);

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registro de Cliente"));

        jLabel13.setText("Nombre:");

        jLabel14.setText("Apellido:");

        jLabel15.setText("DNI:");

        jLabel16.setText("Teléfono:");

        jLabel17.setText("Dirección:");

        jLabel18.setText("Pais:");

        jLabel19.setText("Distrito:");

        jLabel20.setText("Provincia:");

        txtCliNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCliNombreKeyTyped(evt);
            }
        });

        txtCliApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCliApellidoKeyTyped(evt);
            }
        });

        txtCliDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCliDniKeyTyped(evt);
            }
        });

        txtCliTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCliTelefonoKeyTyped(evt);
            }
        });

        txtCliPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliPaisActionPerformed(evt);
            }
        });
        txtCliPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCliPaisKeyTyped(evt);
            }
        });

        txtCliDistrito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCliDistritoKeyTyped(evt);
            }
        });

        txtCliProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCliProvinciaKeyTyped(evt);
            }
        });

        btnClienteGrabar.setBackground(new java.awt.Color(255, 102, 0));
        btnClienteGrabar.setText("Grabar");
        btnClienteGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteGrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCliDni)
                                .addComponent(txtCliApellido)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(txtCliNombre))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addGap(34, 34, 34)
                            .addComponent(txtCliPais))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCliDirección))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addGap(18, 18, 18)
                            .addComponent(txtCliDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCliProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCliTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClienteGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCliNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCliApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtCliDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCliTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtCliDirección, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCliPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(txtCliDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClienteGrabar)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(400, 50, 350, 300);

        btncancelar.setText("CANCELAR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btncancelar);
        btncancelar.setBounds(1300, 710, 110, 23);

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setText("IMPRIMIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IMPRIMIR(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(940, 710, 150, 23);

        jPanel4.setBackground(new java.awt.Color(0, 255, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Productos:"));

        jLabel21.setText("Ingrese Nombre:");

        txtProBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProBusquedaKeyTyped(evt);
            }
        });

        btnProBusqueda.setBackground(new java.awt.Color(0, 153, 255));
        btnProBusqueda.setText("Buscar");
        btnProBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProBusquedaActionPerformed(evt);
            }
        });

        tblProductoBusqueda.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProductoBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoBusquedaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProductoBusqueda);

        btnProGrabar.setBackground(new java.awt.Color(255, 102, 0));
        btnProGrabar.setText("Grabar");
        btnProGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProGrabarActionPerformed(evt);
            }
        });

        jLabel22.setText("Codigo:");

        jLabel23.setText("Material:");

        jLabel24.setText("Precio:");

        jLabel29.setText("Cantidad:");

        txtProductoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoCantidadKeyTyped(evt);
            }
        });

        btnEliminarPro.setBackground(new java.awt.Color(255, 255, 204));
        btnEliminarPro.setText("ELIMINAR");
        btnEliminarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProActionPerformed(evt);
            }
        });

        lblMatProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCodProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblPreProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(btnProBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(lblCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtProductoCantidad)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(btnProGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                                                    .addComponent(btnEliminarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(83, 83, 83)))
                                            .addComponent(lblPreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblMatProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtProBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProBusqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblCodProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(lblMatProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(txtProductoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProGrabar)
                    .addComponent(btnEliminarPro))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(30, 350, 710, 340);

        btnGrabarFecha.setBackground(new java.awt.Color(255, 102, 0));
        btnGrabarFecha.setText("Grabar");
        btnGrabarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarFechaActionPerformed(evt);
            }
        });
        getContentPane().add(btnGrabarFecha);
        btnGrabarFecha.setBounds(470, 10, 80, 23);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GAAAAA.jpg"))); // NOI18N
        jLabel33.setText("jLabel33");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(-10, -16, 1620, 860);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCliPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliPaisActionPerformed

    private void tblBusquedaTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBusquedaTraMouseClicked
        int TraFila_seleccionada = tblBusquedaTra.getSelectedRow();
        lblCodigoTra.setText(tblBusquedaTra.getValueAt(TraFila_seleccionada, 0).toString());
        lblNombreTra.setText(tblBusquedaTra.getValueAt(TraFila_seleccionada, 1).toString());
        fila=TraFila_seleccionada;
    }//GEN-LAST:event_tblBusquedaTraMouseClicked

    private void btnBusquedaTraCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaTraCodigoActionPerformed
TableRowSorter tr = new TableRowSorter(modeloTrabajador);
        tblBusquedaTra.setRowSorter(tr);
        String filtro = txtBusTraCodigo.getText().trim();
        tr.setRowFilter(RowFilter.regexFilter(filtro, 0));
    }//GEN-LAST:event_btnBusquedaTraCodigoActionPerformed

    private void tblProductoBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoBusquedaMouseClicked
       int ProFila_seleccionada = tblProductoBusqueda.getSelectedRow();
        lblCodProducto.setText(tblProductoBusqueda.getValueAt(ProFila_seleccionada, 0).toString());
       lblMatProducto.setText(tblProductoBusqueda.getValueAt(ProFila_seleccionada, 1).toString());
        lblPreProducto.setText(tblProductoBusqueda.getValueAt(ProFila_seleccionada, 3).toString());
        fila=ProFila_seleccionada;
    }//GEN-LAST:event_tblProductoBusquedaMouseClicked

    private void btnProBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProBusquedaActionPerformed
       TableRowSorter tr = new TableRowSorter(modeloProducto);
        tblProductoBusqueda.setRowSorter(tr);
        String filtro = txtProBusqueda.getText().trim();
        tr.setRowFilter(RowFilter.regexFilter(filtro, 1));
    }//GEN-LAST:event_btnProBusquedaActionPerformed

    private void btnTrabajadorGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrabajadorGrabarActionPerformed

txtAtencion.setText(lblNombreTra.getText());
    }//GEN-LAST:event_btnTrabajadorGrabarActionPerformed

    private void btnClienteGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteGrabarActionPerformed
txtCliNom1.setText(txtCliNombre.getText());
txtCliDirec1.setText(txtCliDirección.getText());
txtCLiPais1.setText(txtCliPais.getText());
txtCliTelef1.setText(txtCliTelefono.getText());
    }//GEN-LAST:event_btnClienteGrabarActionPerformed

    private void btnGrabarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarFechaActionPerformed
SimpleDateFormat dFormat= new SimpleDateFormat("dd-MM-yyyy");
        String date=dFormat.format(dtcCotizFecha.getDate());
        lblFecha.setText(date);
    }//GEN-LAST:event_btnGrabarFechaActionPerformed

    private void btnProGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProGrabarActionPerformed

        Cotizacion obj = new Cotizacion();
        
obj.setCot_material(lblMatProducto.getText());
obj.setCot_precio(Double.parseDouble(lblPreProducto.getText()));
obj.setCot_cantidad(Integer.parseInt(txtProductoCantidad.getText()));


Object[] fila =new Object[4];
fila[0]=obj.getCot_material();
fila[1]=obj.getCot_cantidad();
fila[2]=obj.getCot_precio();
fila[3]=redondear(obj.PrecioxCatidad());
modeloCotizacion.addRow(fila);
calTotal();
    }//GEN-LAST:event_btnProGrabarActionPerformed

    private void IMPRIMIR(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IMPRIMIR
  try
  {
      //objeto para renderizar en formato 2D
      PrinterJob gap = PrinterJob.getPrinterJob();
      gap.setPrintable(this);
      boolean top = gap.printDialog();
      if(top)
      {
          gap.print();
      }
      
      
  }
  catch(PrinterException pex)
  {
   JOptionPane.showMessageDialog(null,"Error de Programa","Error\n"+pex,JOptionPane.INFORMATION_MESSAGE);
  }
    }//GEN-LAST:event_IMPRIMIR

    private void btnEliminarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProActionPerformed
modeloCotizacion=(DefaultTableModel)this.tblCotizacion.getModel();
modeloCotizacion.removeRow(this.tblCotizacion.getSelectedRow());
fila--;     
    }//GEN-LAST:event_btnEliminarProActionPerformed

    private void txtBusTraCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusTraCodigoKeyTyped
        char buscarCodigoTra = evt.getKeyChar();
        if(buscarCodigoTra<'0' || buscarCodigoTra>'9') evt.consume();
    }//GEN-LAST:event_txtBusTraCodigoKeyTyped

    private void txtCliDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliDniKeyTyped
char dniCliente = evt.getKeyChar();
if(dniCliente<'0' || dniCliente>'9') evt.consume();
    }//GEN-LAST:event_txtCliDniKeyTyped

    private void txtCliTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliTelefonoKeyTyped
        char telfonoCliente = evt.getKeyChar();
if(telfonoCliente<'0' || telfonoCliente>'9') evt.consume();
    }//GEN-LAST:event_txtCliTelefonoKeyTyped

    private void txtCliNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliNombreKeyTyped
char nombreCliente = evt.getKeyChar();
if((nombreCliente<'a' || nombreCliente>'z') && (nombreCliente<'A' || nombreCliente>'Z')) evt.consume();
    }//GEN-LAST:event_txtCliNombreKeyTyped

    private void txtCliApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliApellidoKeyTyped
     char apCliente = evt.getKeyChar();
if((apCliente<'a' || apCliente>'z') && (apCliente<'A' || apCliente>'Z')) evt.consume();
    }//GEN-LAST:event_txtCliApellidoKeyTyped

    private void txtCliPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliPaisKeyTyped
     char psCliente = evt.getKeyChar();
if((psCliente<'a' || psCliente>'z') && (psCliente<'A' || psCliente>'Z')) evt.consume();
    }//GEN-LAST:event_txtCliPaisKeyTyped

    private void txtCliDistritoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliDistritoKeyTyped
       char dtCliente = evt.getKeyChar();
if((dtCliente<'a' || dtCliente>'z') && (dtCliente<'A' || dtCliente>'Z')) evt.consume();
    }//GEN-LAST:event_txtCliDistritoKeyTyped

    private void txtCliProvinciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliProvinciaKeyTyped
       char pvCliente = evt.getKeyChar();
if((pvCliente<'a' || pvCliente>'z') && (pvCliente<'A' || pvCliente>'Z')) evt.consume();
    }//GEN-LAST:event_txtCliProvinciaKeyTyped

    private void txtProBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProBusquedaKeyTyped
       char codPro = evt.getKeyChar();
if((codPro<'a' || codPro>'z') && (codPro<'A' || codPro>'Z')) evt.consume();
    }//GEN-LAST:event_txtProBusquedaKeyTyped

    private void txtProductoCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoCantidadKeyTyped
                char canPro = evt.getKeyChar();
if(canPro<'0' || canPro>'9') evt.consume();
    }//GEN-LAST:event_txtProductoCantidadKeyTyped

    private void dtcCotizFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtcCotizFechaKeyTyped
 char fecha = evt.getKeyChar();
if((fecha<'0' || fecha>'9') && (fecha=='/')) evt.consume();
    }//GEN-LAST:event_dtcCotizFechaKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        frmMenu p = new frmMenu();
        p.setVisible(true);
        
    }//GEN-LAST:event_formWindowClosing

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        
        lblFecha.setText(null);
        txtAtencion.setText(null);
        txtCliNom1.setText(null);
        txtCliDirec1.setText(null);
        txtCLiPais1.setText(null);
        txtCliTelef1.setText(null);
        int fila=tblCotizacion.getRowCount();
        for(int i = fila-1;i>=0;i--){
            modeloCotizacion.removeRow(i);
        }
        lblSubtotal.setText(null);
        lblIGV.setText(null);
        lblTotalCot.setText(null);
        
        lblCodigoTra.setText(null);
        lblNombreTra.setText(null);
        txtBusTraCodigo.setText(null);
        
        lblCodProducto.setText(null);
        lblMatProducto.setText(null);
        lblPreProducto.setText(null);
        txtProductoCantidad.setText(null);
        txtProBusqueda.setText(null);
        
        dtcCotizFecha.setCalendar(null);
        
        txtCliNombre.setText(null);
        txtCliApellido.setText(null);
        txtCliDni.setText(null);
        txtCliTelefono.setText(null);
        txtCliDirección.setText(null);
        txtCliPais.setText(null);
        txtCliDistrito.setText(null);
        txtCliProvincia.setText(null);
        
        txtBusTraCodigo.requestFocus();
        
        
        
    }//GEN-LAST:event_btncancelarActionPerformed

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
            java.util.logging.Logger.getLogger(frmCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmCotizacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusquedaTraCodigo;
    private javax.swing.JButton btnClienteGrabar;
    private javax.swing.JButton btnEliminarPro;
    private javax.swing.JButton btnGrabarFecha;
    private javax.swing.JButton btnProBusqueda;
    private javax.swing.JButton btnProGrabar;
    private javax.swing.JButton btnTrabajadorGrabar;
    private javax.swing.JButton btncancelar;
    private com.toedter.calendar.JDateChooser dtcCotizFecha;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCodProducto;
    private javax.swing.JLabel lblCodigoTra;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIGV;
    private javax.swing.JLabel lblMatProducto;
    private javax.swing.JLabel lblNombreTra;
    private javax.swing.JLabel lblPreProducto;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotalCot;
    private javax.swing.JPanel pnlImpresion;
    private javax.swing.JTable tblBusquedaTra;
    private javax.swing.JTable tblCotizacion;
    private javax.swing.JTable tblProductoBusqueda;
    private javax.swing.JLabel txtAtencion;
    private javax.swing.JTextField txtBusTraCodigo;
    private javax.swing.JLabel txtCLiPais;
    private javax.swing.JLabel txtCLiPais1;
    private javax.swing.JTextField txtCliApellido;
    private javax.swing.JLabel txtCliDirec;
    private javax.swing.JLabel txtCliDirec1;
    private javax.swing.JTextField txtCliDirección;
    private javax.swing.JTextField txtCliDistrito;
    private javax.swing.JTextField txtCliDni;
    private javax.swing.JLabel txtCliNom;
    private javax.swing.JLabel txtCliNom1;
    private javax.swing.JTextField txtCliNombre;
    private javax.swing.JTextField txtCliPais;
    private javax.swing.JTextField txtCliProvincia;
    private javax.swing.JLabel txtCliTelef;
    private javax.swing.JLabel txtCliTelef1;
    private javax.swing.JTextField txtCliTelefono;
    private javax.swing.JTextField txtProBusqueda;
    private javax.swing.JTextField txtProductoCantidad;
    // End of variables declaration//GEN-END:variables

    private String DataFormat(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int print(Graphics graf, PageFormat pagfor, int index) throws PrinterException
    {
        if(index>0)
                {
                    return NO_SUCH_PAGE;
                }
        Graphics2D hub= (Graphics2D) graf;
        hub.translate(pagfor.getImageableX()+30,pagfor.getImageableY()+30);
        hub.scale(1.0, 1.0);
        
        pnlImpresion.printAll(graf);
        return PAGE_EXISTS;
        
    }

   
        
    
}
