/*
 * Vista PanelRestarMatrices, interfaz grafica en la cual el usuario podra hacer operaciones
 * para calcular la resta entre una matriz A y B.
 */
package view;

import controller.ControllerRestarMatrices;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author SOFTWARE GALAXIA TV
 */
public class PanelRestarMatrices extends javax.swing.JPanel {
    
    /*Creamos tres arreglos bidimensionales de tipo JTextField los cuales haran referencia
    a las matrices que trabajaremos */    
    public JTextField [][] JmatrizA, JmatrizB, JmatrizC; 
    public JSeparator separator;

    // llamamos nuestro objeto controlador    
    ControllerRestarMatrices controller;
    
    public PanelRestarMatrices() {
        initComponents();
        
        panelAreaResultado.setVisible(false);

        /*Asignamos dimensiones a los arreglos */
        JmatrizA = new JTextField[2][2];
        JmatrizB= new JTextField[2][2];        
        JmatrizC = new JTextField[2][2]; 
        
        separator = new JSeparator();

        
        controller = new ControllerRestarMatrices(this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbTitle = new javax.swing.JLabel();
        lbNumeroFilas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JcDimensionFila = new javax.swing.JComboBox<>();
        JcDimensionColumna = new javax.swing.JComboBox<>();
        lbFormula = new javax.swing.JLabel();
        panelAreaOperaciones = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnCalcular = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        panelAreaResultado = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        lbTitle.setText("Resta De Matrices");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        add(lbTitle, gridBagConstraints);

        lbNumeroFilas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbNumeroFilas.setText("Número De Filas: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 10);
        add(lbNumeroFilas, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Número De Columnas: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 10);
        add(jLabel1, gridBagConstraints);

        JcDimensionFila.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "7", "8" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(JcDimensionFila, gridBagConstraints);

        JcDimensionColumna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "7", "8" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        add(JcDimensionColumna, gridBagConstraints);

        lbFormula.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lbFormula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFormula.setText("Matriz C = A - B");
        lbFormula.setFocusable(false);
        lbFormula.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(lbFormula, gridBagConstraints);

        panelAreaOperaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos De Entrada", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        panelAreaOperaciones.setOpaque(false);
        panelAreaOperaciones.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(panelAreaOperaciones, gridBagConstraints);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnCalcular.setBackground(new java.awt.Color(255, 83, 83));
        btnCalcular.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calcular-suma.png"))); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcular.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCalcular.setIconTextGap(14);
        btnCalcular.setPreferredSize(new java.awt.Dimension(227, 67));
        jPanel1.add(btnCalcular);

        btnLimpiar.setBackground(new java.awt.Color(123, 167, 225));
        btnLimpiar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clean.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnLimpiar.setIconTextGap(14);
        btnLimpiar.setPreferredSize(new java.awt.Dimension(227, 67));
        jPanel1.add(btnLimpiar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        add(jPanel1, gridBagConstraints);

        panelAreaResultado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        panelAreaResultado.setOpaque(false);
        panelAreaResultado.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        add(panelAreaResultado, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> JcDimensionColumna;
    public javax.swing.JComboBox<String> JcDimensionFila;
    public javax.swing.JButton btnCalcular;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFormula;
    private javax.swing.JLabel lbNumeroFilas;
    private javax.swing.JLabel lbTitle;
    public javax.swing.JPanel panelAreaOperaciones;
    public javax.swing.JPanel panelAreaResultado;
    // End of variables declaration//GEN-END:variables
}