/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backpropagation;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author X555LH
 */
public class Simulacion extends javax.swing.JFrame {

    /**
     * Creates new form Simulacion
     */
    DefaultListModel modelolista = new DefaultListModel();
    public Map<Integer, float[][]> Diccionariodepesos = new HashMap<>();
    public Map<Integer, float[]> Diccionariodeumbrales = new HashMap<>();
    public Map<Integer, float[]> Diccionariodesalidasdecapa = new HashMap<>();
    public float[] salidadecapaactual;
    public float[] salidadecapaanterior;
    public float[][] pesos;
    public float[] umbrales;
    public List<String> funcionesdeactivacion = new ArrayList<>();
    public String selected;
    public JTextField Cajasdesalida;
    ArrayList arraydesalidas = new ArrayList();
    JTextField Cajasdeentrada = new JTextField();
    
    public Simulacion() {
        initComponents();
        jList1.setModel(modelolista);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.GRAY);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btnCargar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        btnSimular = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel11.setText("SIMULACIÓN");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel1.setBackground(java.awt.Color.gray);

        jScrollPane1.setViewportView(jList1);

        btnCargar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnCargar.setText("Seleccionar");
        btnCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCargarMouseClicked(evt);
            }
        });
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(java.awt.Color.gray);
        jPanel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel12.setText("# Entradas:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel13.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel13.setText("# Salidas:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel14.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel14.setText("# Capas ocultas");

        jList2.setBackground(java.awt.Color.gray);
        jList2.setForeground(java.awt.SystemColor.controlLtHighlight);
        jScrollPane2.setViewportView(jList2);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel6.setText("Funciones de activación de cada capa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(java.awt.Color.gray);
        jPanel3.setForeground(java.awt.SystemColor.controlLtHighlight);
        jPanel3.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane3.setViewportView(jPanel3);

        jPanel4.setBackground(java.awt.Color.gray);
        jPanel4.setForeground(java.awt.SystemColor.controlLtHighlight);
        jPanel4.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane4.setViewportView(jPanel4);

        btnSimular.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnSimular.setText("Simular");
        btnSimular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimularMouseClicked(evt);
            }
        });
        btnSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel4.setText("Salida");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel5.setText("Patrón de entrada");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel15.setText("Información de la Red");

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("X");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel10.setText("Redes configuradas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3)
                                    .addComponent(btnSimular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(jLabel15)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(129, 129, 129)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(3, 3, 3)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimular)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
        //jPanel3.setBorder(BorderFactory.createTitledBorder("SIMULAR DATOS."));
        try {
            //String currentDir = System.getProperty("user.dir");
            modelolista.removeAllElements();
            String current = new File( "." ).getCanonicalPath();
            File carpetaroot = new File("current").getAbsoluteFile().getParentFile();
            for(File file: carpetaroot.listFiles()){
                String[] registro = file.getName().toString().split(" ");
                if(registro.length > 5){
                    if(registro[3].toString().equals("pesos")){
                        String nombre = "";
                        for (int i = 4; i < registro.length; i++) {
                            if((i + 1) < registro.length)
                                nombre += registro[i] + " ";
                            else
                                nombre += registro[i];
                        }
                        modelolista.addElement(nombre);
                    }
                }
            }            
        } catch (Exception ex) {  }
    }//GEN-LAST:event_formWindowOpened

    private void btnCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarMouseClicked
        selected = jList1.getSelectedValue();
        if(selected != null && selected != ""){
            try {
                CargarConfiguracion(selected);
            } catch (IOException ex) { }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una configuración de red");
        }
    }//GEN-LAST:event_btnCargarMouseClicked

    private void btnSimularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimularMouseClicked
        try{
            float[] entradas = new float[jPanel3.getComponentCount()];
            for (int i = 0; i < jPanel3.getComponentCount(); i++) {
                if (jPanel3.getComponent(i) instanceof JTextField) {
                    JTextField caja = (JTextField)jPanel3.getComponent(i);
                    entradas[i] = Float.parseFloat(caja.getText());
                }
            }
            SimularDatos(entradas);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Debe digitar entradas validas");
        }
    }//GEN-LAST:event_btnSimularMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Simulacion p = new Simulacion();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularActionPerformed
        // TODO add your handling code here:
       jPanel4.removeAll();
        jPanel4.repaint();
    }//GEN-LAST:event_btnSimularActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel4.removeAll();
        jPanel4.repaint();
    }//GEN-LAST:event_btnCargarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Inicial frm = new Inicial();
        frm.show();
        this.hide();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void SimularDatos(float[] entradas){
        CargarDirectorioDePesosYUmbrales();
        
        Diccionariodesalidasdecapa.clear();
        for (int cp = 0; cp <= Integer.parseInt(jLabel3.getText()); cp++) {
            pesos = Diccionariodepesos.get(cp);
            umbrales = Diccionariodeumbrales.get(cp);
            salidadecapaactual = new float[pesos.length];
            if (cp > 0)
                salidadecapaanterior = Diccionariodesalidasdecapa.get(cp-1);
            for (int i = 0; i < pesos.length; i++)
            {
                salidadecapaactual[i] = 0;
                if (cp == 0) 
                {
                    for (int j = 0; j < Integer.parseInt(jLabel1.getText()); j++)
                        salidadecapaactual[i] += entradas[j] * pesos[i][j];
                }else if (cp > 0 && cp < Integer.parseInt(jLabel3.getText())) 
                {
                    for (int j = 0; j < pesos[0].length; j++)
                        salidadecapaactual[i] += salidadecapaanterior[j] * pesos[i][j];
                }else if (cp == Integer.parseInt(jLabel3.getText())) 
                {
                    for (int j = 0; j < pesos[0].length; j++)
                        salidadecapaactual[i] += salidadecapaanterior[j] * pesos[i][j];
                }
                salidadecapaactual[i] -= umbrales[i];
                if (cp != Integer.parseInt(jLabel3.getText())) 
                    salidadecapaactual[i] = getFunciondeActivacion(funcionesdeactivacion.get(cp), salidadecapaactual[i]);
                else 
                {
                    salidadecapaactual[i] = getFunciondeActivacion(funcionesdeactivacion.get(cp), salidadecapaactual[i]);
                    arraydesalidas.add(salidadecapaactual[i]);
                }
            }
            Diccionariodesalidasdecapa.put(cp, salidadecapaactual);
        }
        for (int i = 0; i < arraydesalidas.size(); i++) {
             
            String x = arraydesalidas.get(i).toString();
            //Cajasdesalida.add(arraydesalidas.get(i).toString());
          JLabel label = new JLabel (arraydesalidas.get(i).toString());
          jPanel4.add(label);
          jPanel4.validate(); jPanel4.repaint();


    
        }
    }
    
    public float getFunciondeActivacion(String funcion, float salidaCapa) {
        float res = 0;
        switch (funcion) {
            case "lineal":
                res = salidaCapa;
                break;
            case "bipolar":
                if (salidaCapa >= 0) 
                    res = 1;
                else
                    res = -1;
                break;
            case "sigmoide":
                res = (float) (1 / (1 + Math.pow(Math.E, -salidaCapa)));
                break;
            case "tangenteh":
                res = (float) Math.tanh(salidaCapa);
                break;
            case "seno":
                res = (float) Math.sin(salidaCapa);
                break;
            case "coseno":
                res = (float) Math.cos(salidaCapa);
                break;
            case "gauseana":
                res = (float) Math.pow(Math.E, -Math.pow(salidaCapa, 2));
                break;
        }
        return res;
    }
    
    private void CargarDirectorioDePesosYUmbrales() {
        try 
            {                
                File directoriodepesos = new File("Carpeta de los pesos " + selected);
                File directoriodeumbrales = new File("Carpeta de los umbrales " + selected);
                if (directoriodepesos.exists() && directoriodeumbrales.exists()) {
                    int i = 0;
                    for(File file: directoriodepesos.listFiles()){
                        FileReader fr = new FileReader (file);
                        BufferedReader br = new BufferedReader(fr);
                        List<String> atributos = new ArrayList<>();
                        int columnas = 0;
                        String linea;
                        int fila = 0;
                        while((linea=br.readLine())!=null){
                            columnas = linea.toString().split(" ").length;
                            for (int j = 0; j < linea.toString().split(" ").length; j++) {
                                atributos.add(linea.toString().split(" ")[j]);
                            }
                            fila++;
                        }
                        float[][] matriz = new float[fila][columnas];
                        int item = 0;
                        for (int f = 0; f < fila; f++) {
                            for (int c = 0; c < columnas; c++) {
                                matriz[f][c] = Float.parseFloat(atributos.get(item));
                                item++;
                            }
                        }
                        fr.close();
                        br.close();
                        Diccionariodepesos.put(i, matriz);
                        i++;
                    }
                    
                    int j = 0;
                    for(File file: directoriodeumbrales.listFiles()){
                        FileReader fr = new FileReader (file);
                        BufferedReader br = new BufferedReader(fr);
                        List<String> atributosu = new ArrayList<>();
                        String linea;
                        int fila = 0;
                        while((linea=br.readLine())!=null){
                            for (int f = 0; f < linea.toString().split(" ").length; f++) {
                                atributosu.add(linea.toString().split(" ")[f]);
                                //atributos.add("1");
                            }
                            fila++;
                        }
                        float[] umbral = new float[fila];
                        for (int f = 0; f < fila; f++) {
                            umbral[f] = Float.parseFloat(atributosu.get(f));
                            //umbral[f] = Float.parseFloat("1");
                        }
                        fr.close();
                        br.close();
                        Diccionariodeumbrales.put(j, umbral);
                        j++;
                    }                    
                } else {
                    JOptionPane.showMessageDialog(null, "HA ELIMINADO LOS DIRECTORIOS.\nELIMINE TODAS LAS CARPETAS Y\nVUELVA A ENTRENAR.");
                }
            }
            catch (Exception e) { JOptionPane.showMessageDialog(null, "Ocurrió un error."); }
    }
    
    private void CargarConfiguracion(String seleccionado) throws FileNotFoundException, IOException{
        
        DefaultListModel modelo = new DefaultListModel();
        jLabel1.setText("");
        jLabel2.setText("");
        jLabel3.setText("");
        jList2.setModel(modelo);
        File directoriodeconfiguracion = new File("Configuracion de la red " + seleccionado + "/Configuracion.txt");
        FileReader fr = new FileReader (directoriodeconfiguracion);
        BufferedReader br = new BufferedReader(fr);
        String[] atributos = new String[4];
        String linea;
        int x = 0;
        while((linea=br.readLine())!=null){
            atributos[x] = linea;
            x++;
        }
        jLabel1.setText(atributos[2].toString().split(" ")[1]);
        jLabel2.setText(atributos[3].toString().split(" ")[1]);
        jLabel3.setText(atributos[0].toString().split(" ")[1]);
        for (int i = 1; i < atributos[1].toString().split(" ").length; i++) {
            if(i <= Integer.parseInt(atributos[0].toString().split(" ")[1])){
                modelo.addElement("Capa oculta " + i + ": " + atributos[1].toString().split(" ")[i]);
                funcionesdeactivacion.add(atributos[1].toString().split(" ")[i]);
            } else {
                modelo.addElement("Capa de salida: " + atributos[1].toString().split(" ")[i]);
                funcionesdeactivacion.add(atributos[1].toString().split(" ")[i]);
            }            
        }
        fr.close();
        br.close();
        CargarCajasDeTexto(Integer.parseInt(jLabel1.getText().toString()), Integer.parseInt(jLabel2.getText().toString()));
    }
    
    public void CargarCajasDeTexto(int entradas, int salidas){
        for (int i = 0; i < Integer.parseInt(jLabel1.getText()); i++) {
            JTextField cajasdeentrada = new JTextField();
            cajasdeentrada.setSize(2000, 200);
            Cajasdeentrada = cajasdeentrada;
            jPanel3.add(cajasdeentrada);
            jPanel3.updateUI();
        }
        /*
        for (int i = 0; i < Integer.parseInt(jLabel2.getText()); i++) {
            JTextField cajasdesalida = new JTextField();
            cajasdesalida.setSize(200, 20);
            
            Cajasdesalida = cajasdesalida;
            
            jPanel4.add(cajasdesalida);
            jPanel4.updateUI();
        }
        //cajasdeentrada.setSize(200, 30);   */   
        
         for (int i = 0; i < Integer.parseInt(jLabel2.getText()); i++) {
           
          double x = Double.parseDouble(arraydesalidas.get(i).toString());
          double y = Math.abs(Math.round(x));
          JLabel label = new JLabel (Double.toString(y));
          jPanel4.add(label);
          jPanel4.validate(); jPanel4.repaint();
            jPanel4.updateUI();
        }
    }
    
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
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnSimular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

}
