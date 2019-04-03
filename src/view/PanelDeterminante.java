/*

 */
package view;

import controller.ControllerDeterminanteMatrices;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author SOFTWARE GALAXIA
 */
public class PanelDeterminante extends javax.swing.JPanel {

    /*Creamos tres arreglos bidimensionales de tipo JTextField los cuales haran referencia
    a las matrices que trabajaremos */    
    public JTextField [][] JmatrizA, JmatrizARes, JmatrizDetA; 
    public JPanel panelDeterminante;
    
    ControllerDeterminanteMatrices controller;
    
    public PanelDeterminante() {
        
        initComponents();
        
        panelAreaResultado.setVisible(false);
        
        /*Asignamos dimensiones a los arreglos */
        JmatrizA = new JTextField[2][2];
        JmatrizARes = new JTextField[2][2];
        JmatrizDetA= new JTextField[2][2];        
                
        panelDeterminante = new JPanel();
        panelDeterminante.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelDeterminante.setOpaque(false);
        
        controller = new ControllerDeterminanteMatrices(this);
        
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
        jLabel2 = new javax.swing.JLabel();
        JcOrdenDeterminante = new javax.swing.JComboBox<>();
        panelAreaOperaciones = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCalcular = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        panelAreaResultado = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        lbTitle.setText("Determinante De Una Matriz");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        add(lbTitle, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Orden: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 10);
        add(jLabel2, gridBagConstraints);

        JcOrdenDeterminante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2x2", "3x3", "4x4", "5x5", "6x6", "7x7", "8x8" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(JcOrdenDeterminante, gridBagConstraints);

        panelAreaOperaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos De Entrada", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        panelAreaOperaciones.setOpaque(false);
        panelAreaOperaciones.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(panelAreaOperaciones, gridBagConstraints);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnCalcular.setBackground(new java.awt.Color(255, 83, 83));
        btnCalcular.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calcular-suma.png"))); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCalcular.setIconTextGap(14);
        btnCalcular.setPreferredSize(new java.awt.Dimension(227, 67));
        jPanel2.add(btnCalcular);

        btnLimpiar.setBackground(new java.awt.Color(123, 167, 225));
        btnLimpiar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clean.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnLimpiar.setIconTextGap(14);
        btnLimpiar.setPreferredSize(new java.awt.Dimension(227, 67));
        jPanel2.add(btnLimpiar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        add(jPanel2, gridBagConstraints);

        panelAreaResultado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        panelAreaResultado.setOpaque(false);
        panelAreaResultado.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        add(panelAreaResultado, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> JcOrdenDeterminante;
    public javax.swing.JButton btnCalcular;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbTitle;
    public javax.swing.JPanel panelAreaOperaciones;
    public javax.swing.JPanel panelAreaResultado;
    // End of variables declaration//GEN-END:variables
}
