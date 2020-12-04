
package Backpropagation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public final class Backpropagation extends javax.swing.JFrame implements NewInterface{
    
    DefaultListModel modelolista = new DefaultListModel();
    DefaultCategoryDataset dataset = null;
    ChartPanel panel = null;
    JButton n = new JButton();
    private final Procesoneuronal proceso;
    int i = 0;
    int j = 0;
    
    public Backpropagation() {    
        initComponents();
        this.proceso = new Procesoneuronal(this, jButton3);
        this.setLocationRelativeTo(null);
        jButton4.setVisible(false);
        jtfIteraciones.setText("1");
        jtfErrormaximopermitido.setText("0.001");
        jtfRatadeaprendizaje.setText("0.1");
        jList2.setModel(modelolista);
        Graficas();
        this.getContentPane().setBackground(Color.GRAY);
    }
    
        
    public void Graficas(){
        Graficaerror(new ArrayList());
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }
    
    @Override
    public void Graficaerror(ArrayList Array){
        float [][]errordeiteracion = new float[Array.size()][1]; 
        int pos = 0;
        for (int k = 0; k < Array.size(); k++) {
            for (int l = 0; l < 1; l++) {
                errordeiteracion[k][l] = (float) Array.get(pos);
                pos++;
            }
        } 
        if(dataset == null){
            dataset = new DefaultCategoryDataset();
        }     
        for (int k = 0; k < 1; k++) {
            for (int l = 0; l < Array.size(); l++) {
                dataset.addValue(errordeiteracion[l][k], "Error iteración" , "" + l);
            }
        }
        JFreeChart marco = ChartFactory.createLineChart(
                        null,
                        null,
                        null,
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        false,
                        false
                );
        if(panel == null){
            panel = new ChartPanel(marco);
        }
        panel.setBounds(jPanel1.getBounds());
        jPanel1.removeAll();
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(panel);
        jPanel1.validate();
    }
    
    @Override
    public void Graficarsalidasdeseadas(float [][]Matrizdedatos){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int _j = 0; _j < proceso.salidas; _j++) {
            for (int _i = 0; _i < Matrizdedatos.length; _i++) {
                dataset.addValue(Matrizdedatos[_i][proceso.entradas + _j], "Salida " + (_j+1), "" + _i);
            }
        }
        JFreeChart marco = ChartFactory.createLineChart(
                        null,
                        null,
                        null,
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        false,
                        false
                );
        ChartPanel panel = new ChartPanel(marco);
        panel.setBounds(jPanel5.getBounds());
        jPanel5.removeAll();
        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel5.add(panel);
        jPanel5.validate();
    }
    @Override
    public void Graficarsalidasdesimulacion(ArrayList _array){
        float [][]salidasdelasimulacion = new float[proceso.patrones][proceso.salidas]; 
        int pos = 0;
        for (int k = 0; k < proceso.patrones; k++) {
            for (int l = 0; l < proceso.salidas; l++) {
                salidasdelasimulacion[k][l] = (float) _array.get(pos);
                pos++;
            }
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();     
        for (int k = 0; k < proceso.salidas; k++) {
            for (int l = 0; l < proceso.patrones; l++) {
                dataset.addValue(salidasdelasimulacion[l][k], "Salida" + (k+1), "" + l);
            }
        }
        JFreeChart marco = ChartFactory.createLineChart(
                        null,
                        null,
                        null,
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        false,
                        false
                );
        ChartPanel panel = new ChartPanel(marco);
        panel.setBounds(jPanel6.getBounds());
        jPanel6.removeAll();
        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel6.add(panel);
        jPanel6.validate();
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jspCapasocultas = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfIteraciones = new javax.swing.JTextField();
        jtfErrormaximopermitido = new javax.swing.JTextField();
        jtfRatadeaprendizaje = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        s0 = new javax.swing.JLabel();
        s1 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();
        s3 = new javax.swing.JLabel();
        s4 = new javax.swing.JLabel();
        s5 = new javax.swing.JLabel();
        s6 = new javax.swing.JLabel();
        s7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblPatrones = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSalidas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEntradas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        btnSimular = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(java.awt.Color.gray);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Error de iteracion.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12), java.awt.SystemColor.controlLtHighlight)); // NOI18N
        jPanel1.setForeground(java.awt.SystemColor.controlLtHighlight);
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel1.setMinimumSize(new java.awt.Dimension(2, 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(2, 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(java.awt.Color.gray);
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setText("Inicializar Pesos y Umbrales");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lineal", "bipolar", "tangenteh", "seno", "coseno", "gauseana", "sigmoide" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel8.setText("Función de activación de la salida:");

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton4.setText("Ver datos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel10.setText("Número de capas ocultas:");

        jspCapasocultas.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jspCapasocultas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        jspCapasocultas.setEnabled(false);
        jspCapasocultas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jspCapasocultasStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel12.setText("Configuración de la Red");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel4.setText("No. Iteraciones:");

        jtfIteraciones.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jtfIteraciones.setEnabled(false);
        jtfIteraciones.setName(""); // NOI18N
        jtfIteraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIteracionesActionPerformed(evt);
            }
        });
        jtfIteraciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfIteracionesKeyPressed(evt);
            }
        });

        jtfErrormaximopermitido.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jtfErrormaximopermitido.setEnabled(false);

        jtfRatadeaprendizaje.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jtfRatadeaprendizaje.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel6.setText("Rata de aprendizaje:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel5.setText("Error maximo permitido:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jspCapasocultas, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(45, 45, 45)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfErrormaximopermitido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfRatadeaprendizaje, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jspCapasocultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtfIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfErrormaximopermitido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfRatadeaprendizaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(49, 49, 49))
        );

        jPanel5.setBackground(java.awt.Color.gray);
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salidas deseadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12), java.awt.SystemColor.controlLtHighlight)); // NOI18N
        jPanel5.setForeground(java.awt.SystemColor.controlLtHighlight);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(java.awt.Color.gray);
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salidas obtenidas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12), java.awt.SystemColor.controlLtHighlight)); // NOI18N
        jPanel6.setForeground(java.awt.SystemColor.controlLtHighlight);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel11.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel11.setText("ENTRENAMIENTO DE LA RED");

        jButton7.setBackground(new java.awt.Color(255, 0, 0));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("X");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton3.setLabel("Entrenar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton1.setText("Cargar Datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblPatrones.setForeground(java.awt.SystemColor.controlLtHighlight);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel3.setText("# Patrones:");

        lblSalidas.setForeground(java.awt.SystemColor.controlLtHighlight);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel2.setText("# Salidas:");

        lblEntradas.setForeground(java.awt.SystemColor.controlLtHighlight);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.controlLtHighlight);
        jLabel1.setText("# Entradas:");

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnSimular.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnSimular.setText("Simular Red");
        btnSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularActionPerformed(evt);
            }
        });

        jPanel7.setBackground(java.awt.Color.gray);
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Error por Iteración", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12), java.awt.SystemColor.controlLtHighlight)); // NOI18N
        jPanel7.setForeground(java.awt.SystemColor.controlLtHighlight);

        jList2.setBackground(java.awt.Color.gray);
        jList2.setForeground(java.awt.SystemColor.controlLtHighlight);
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPatrones, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(s0)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(s1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(s2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(s3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(s4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(s5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(s6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(s7)))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(387, 387, 387)
                        .addComponent(jButton7)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(s0)
                            .addComponent(s1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s2)
                    .addComponent(s3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s4)
                    .addComponent(s5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(s6)
                            .addComponent(s7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSimular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEntradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPatrones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSalidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel6.getAccessibleContext().setAccessibleName("Salida de la simulación de los datos normalizad");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfIteracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIteracionesActionPerformed
    }//GEN-LAST:event_jtfIteracionesActionPerformed

    private void jtfIteracionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIteracionesKeyPressed
        if (" ".equals(jtfIteraciones.getText())){
            System.out.println("fffffffff");
        }
    }//GEN-LAST:event_jtfIteracionesKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularActionPerformed
        Simulacion obj = new Simulacion();
        obj.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimularActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int filas = proceso.patrones;
        int col = proceso.entradas + proceso.salidas;
        String vector[] = new String[filas];
        DefaultTableModel modelo = new DefaultTableModel();
        DefaultTableModel modelo2 = new DefaultTableModel();
        for (int c = 0; c < col; c++) {
            if (c < proceso.entradas) {
                modelo.addColumn("Xr");
                modelo2.addColumn("Xr");
            }else{
                modelo.addColumn("Yr");
                modelo2.addColumn("Yr");
            }
        }
        for (int c = 0; c < filas; c++) {
            vector[c] = "";
        }
        for (int f = 0; f < filas; f++) {
            modelo.addRow(vector);
            modelo2.addRow(vector);
        }
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < col; c++) {
                modelo.setValueAt(proceso.matrizdedatos[f][c], f, c);
                if (c < proceso.entradas) {
                    modelo2.setValueAt(proceso.matrizdedatos[f][c] * proceso.Mayent[c], f, c);
                }else{
                    modelo2.setValueAt(proceso.matrizdedatos[f][c] * proceso.Maysal[c-proceso.entradas], f, c);
                }
            }
        }
        Tabladedatos obj = new Tabladedatos(modelo, modelo2);
        obj.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Backpropagation p = new Backpropagation();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jspCapasocultasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jspCapasocultasStateChanged
        if (Integer.parseInt(jspCapasocultas.getValue().toString()) <= 0) {
            DefaultTableModel _mod = new DefaultTableModel();
            jTable3.setModel(_mod);
            jButton2.setEnabled(false);
        }else{
            DefaultTableModel _mod = new DefaultTableModel();
            JComboBox cbxActivacion = new JComboBox();
            cbxActivacion.addItem("sigmoide");
            cbxActivacion.addItem("gauseana");
            cbxActivacion.addItem("seno");
            cbxActivacion.addItem("coseno");
            cbxActivacion.addItem("tangenteh");
            _mod.addColumn("Capa");
            _mod.addColumn("Neuronas");
            _mod.addColumn("Activación");
            for (int _i = 0; _i < Integer.parseInt(jspCapasocultas.getValue().toString()); _i++) {
                String[] _agg = {(_i+1)+"", "", ""};
                jTable3.setModel(_mod);
                _mod.addRow(_agg);
                jTable3.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(cbxActivacion));
            }
            jButton2.setEnabled(true);
        }
    }//GEN-LAST:event_jspCapasocultasStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        proceso.numerodeiteraciones = Integer.parseInt(jtfIteraciones.getText());
        proceso.errormaximopermitido = Float.parseFloat(jtfErrormaximopermitido.getText());
        proceso.ratadeaprendizaje = Float.parseFloat(jtfRatadeaprendizaje.getText());
        proceso.numerodecapasocultas = Integer.parseInt(jspCapasocultas.getValue().toString());
        proceso.Tabla = jTable3;
        proceso.Funsalida = jComboBox2.getSelectedItem().toString();
        Thread hilo = new Thread(proceso);
        hilo.start();

        DefaultTableModel modelo = new DefaultTableModel();
        String vector[] = new String[proceso.patrones];
        int x = 1;
        for (int c = 0; c < proceso.entradas; c++) {
            modelo.addColumn("X" + x);
            x++;
        }
        x=1;
        for (int s = 0; s < proceso.salidas; s++) {
            modelo.addColumn("Y" + x);
            x++;
        }
        for (int c = 0; c < proceso.patrones; c++) {
            vector[c] = "";
        }
        for (int f = 0; f < proceso.patrones; f++) {
            modelo.addRow(vector);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser dialog = new JFileChooser();
        FileReader fr;
        BufferedReader br;
        try{
            int resultado = dialog.showOpenDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File Archivo = dialog.getSelectedFile();
                fr = new FileReader(Archivo.toString());
                br = new BufferedReader(fr);
                String linea;
                while((linea=br.readLine())!=null){
                    proceso.registros.add(linea);
                }
                proceso.registros.forEach((String registro) -> {
                    String[] reg = registro.split(" ");
                    for (String reg1 : reg) {
                        if (reg1.toUpperCase().equals("X")) {
                            proceso.entradas++;
                        }
                        if (reg1.toUpperCase().equals("YD")) {
                            proceso.salidas++;
                        }
                    }
                    proceso.patrones++;
                });
                proceso.registros.remove(0);
                proceso.matrizdedatos = new float[proceso.patrones][proceso.entradas + proceso.salidas];
                proceso.registros.forEach((String registro) -> {
                    j = 0;
                    String[] reg = registro.split(" ");
                    for (String reg1 : reg) {
                        proceso.matrizdedatos[i][j] = Float.parseFloat(reg1);
                        j++;
                    }
                    i++;
                });
                //Normalización...
                proceso.Mayent = new float[proceso.entradas];
                proceso.Maysal = new float[proceso.salidas];
                for (int _i = 0; _i < proceso.entradas + proceso.salidas; _i++) {
                    float Mayent = -1000;
                    float Maysal = -1000;
                    for (int _j = 0; _j < proceso.patrones; _j++) {
                        if (_i < proceso.entradas) {
                            if (Mayent < proceso.matrizdedatos[_j][_i])
                            Mayent = proceso.matrizdedatos[_j][_i];
                        }else{
                            if (Maysal < proceso.matrizdedatos[_j][_i]) {
                                Maysal = proceso.matrizdedatos[_j][_i];
                            }
                        }
                    }
                    if (_i < proceso.entradas)
                    proceso.Mayent[_i] = Mayent;
                    else
                    proceso.Maysal[_i - proceso.entradas] = Maysal;
                }
                for (int _i = 0; _i < proceso.entradas + proceso.salidas; _i++) {
                    for (int _j = 0; _j < proceso.patrones; _j++) {
                        if (_i < proceso.entradas) {
                            proceso.matrizdedatos[_j][_i] /= proceso.Mayent[_i];
                        }else{
                            proceso.matrizdedatos[_j][_i] /= proceso.Maysal[_i - proceso.entradas];
                        }
                    }
                }
                //Fin de la normalización
                lblEntradas.setText(Integer.toString(proceso.entradas));
                lblSalidas.setText(Integer.toString(proceso.salidas));
                lblPatrones.setText(Integer.toString(proceso.patrones));
                jspCapasocultas.setEnabled(true);
                jButton4.setVisible(true);
                JOptionPane.showMessageDialog(null, "Carga exitosa");
                proceso.ni.Graficarsalidasdeseadas(proceso.matrizdedatos);
            }
        }catch(HeadlessException | IOException e){

        }
        //jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    @SuppressWarnings("empty-statement")
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
         jPanel1.removeAll();
        jPanel1.repaint();
         jPanel6.removeAll();
        jPanel6.repaint();
        modelolista.removeAllElements();
        Random rnd = new Random();
        int capasocultas = Integer.parseInt(jspCapasocultas.getValue().toString());
        //Llenando pesos y umbrales...
        for (int capa = 0; capa <= capasocultas; capa++) {
            if (capa == 0) {
                proceso.umbrales = new float[Integer.parseInt(jTable3.getValueAt(capa, 1).toString())];
                proceso.pesos = new float[Integer.parseInt(jTable3.getValueAt(capa, 1).toString())][proceso.entradas];
                proceso.Diccionariodeumbrales.put(capa, proceso.umbrales);
                proceso.Diccionariodepesos.put(capa, proceso.pesos);
            }else if (capa > 0 && capa < capasocultas) {
                proceso.umbrales = new float[Integer.parseInt(jTable3.getValueAt(capa, 1).toString())];
                proceso.pesos = new float[Integer.parseInt(jTable3.getValueAt(capa, 1).toString())][Integer.parseInt(jTable3.getValueAt(capa-1, 1).toString())];
                proceso.Diccionariodeumbrales.put(capa, proceso.umbrales);
                proceso.Diccionariodepesos.put(capa, proceso.pesos);
            }else if (capa == capasocultas) {
                proceso.umbrales = new float[proceso.salidas];
                proceso.pesos = new float[proceso.salidas][Integer.parseInt(jTable3.getValueAt(capa-1, 1).toString())];
                proceso.Diccionariodeumbrales.put(capa, proceso.umbrales);
                proceso.Diccionariodepesos.put(capa, proceso.pesos);
            }
        }
        proceso.Diccionariodepesos.entrySet().forEach((Map.Entry<Integer, float[][]> obj) -> {
            for (int _i = 0; _i < obj.getValue().length; _i++) {
                for (int _j = 0; _j < obj.getValue()[0].length; _j++) {
                    double val = rnd.nextDouble() * 1 - (-1) + (-1);
                    obj.getValue()[_i][_j] = Float.parseFloat(String.valueOf(val));
                }
            }
        });
        proceso.Diccionariodeumbrales.entrySet().forEach((Map.Entry<Integer, float[]> obj) -> {
            for (int _i = 0; _i < obj.getValue().length; _i++) {
                double val = rnd.nextDouble() * 1 - (-1) + (-1);
                obj.getValue()[_i] = Float.parseFloat(String.valueOf(val));
            }
        });
        JOptionPane.showMessageDialog(null, "Pesos y umbrales inicializados.");
        //proceso.ni.Graficarsalidasdeseadas(proceso.matrizdedatos);
        jtfIteraciones.setEnabled(true);
        jtfErrormaximopermitido.setEnabled(true);
        jtfRatadeaprendizaje.setEnabled(true);
        jButton3.setEnabled(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Inicial frm = new Inicial();
        frm.show();
        this.hide();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Backpropagation().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimular;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList2;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JSpinner jspCapasocultas;
    private javax.swing.JTextField jtfErrormaximopermitido;
    private javax.swing.JTextField jtfIteraciones;
    private javax.swing.JTextField jtfRatadeaprendizaje;
    private javax.swing.JLabel lblEntradas;
    private javax.swing.JLabel lblPatrones;
    private javax.swing.JLabel lblSalidas;
    private javax.swing.JLabel s0;
    private javax.swing.JLabel s1;
    private javax.swing.JLabel s2;
    private javax.swing.JLabel s3;
    private javax.swing.JLabel s4;
    private javax.swing.JLabel s5;
    private javax.swing.JLabel s6;
    private javax.swing.JLabel s7;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Rellenarlistadeerrores(ArrayList _array) {
        try{
            modelolista.removeAllElements();
            for (int i = 0; i < _array.size(); i++) {
                modelolista.addElement("[" + (i+1) + "]" + _array.get(i));
                jList2.setSelectedIndex(modelolista.size()-1);
            }
        }catch(Exception e){}
    }

}