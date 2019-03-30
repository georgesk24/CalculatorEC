package view;

import controller.ControllerVistaPrincipal;

/**
 *
 * @author Software Galaxia TV
 * 
 * Clase de nuestro proyecto, esta sera nuestra vista principal dicha clase hereda de la clase JFrame
 * aqui se cargara la vista inicial que se mostrara al ejecutar la aplicación
 */
public class vistaPrincipal extends javax.swing.JFrame {
    
    /*Llamamos al objeto de la clase ControllerVistaPrincipal (el controlador de la vista)*/
    ControllerVistaPrincipal controller;
    
    public vistaPrincipal() {

        initComponents();        
        this.setLocationRelativeTo(null);
        
        /*inializamos el objeto de tipo ControllerVistaPrincipal, le pasamos como parametro nuestra vista*/
        controller = new ControllerVistaPrincipal(this);
                
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

        barraDesplazamientoMenuPrincipal = new javax.swing.JScrollPane();
        panelMenuPrincipal = new javax.swing.JPanel();
        lbTitleMenu = new javax.swing.JLabel();
        btnSumar = new javax.swing.JButton();
        btnRestar = new javax.swing.JButton();
        btnMultiplicar = new javax.swing.JButton();
        btnDeterminante = new javax.swing.JButton();
        btnGaussJordan = new javax.swing.JButton();
        lbSubTitle = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        panelOperaciones = new javax.swing.JPanel();
        barraDesplazamientoPanelOperaciones = new javax.swing.JScrollPane();
        panelInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        itemAyuda = new javax.swing.JMenu();
        itemAcercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barraDesplazamientoMenuPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        barraDesplazamientoMenuPrincipal.setAutoscrolls(true);
        barraDesplazamientoMenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelMenuPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelMenuPrincipal.setPreferredSize(new java.awt.Dimension(290, 542));
        panelMenuPrincipal.setLayout(new java.awt.GridBagLayout());

        lbTitleMenu.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        lbTitleMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleMenu.setText("Menú");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        panelMenuPrincipal.add(lbTitleMenu, gridBagConstraints);

        btnSumar.setBackground(new java.awt.Color(123, 202, 225));
        btnSumar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSumar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        btnSumar.setText("Suma");
        btnSumar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSumar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSumar.setIconTextGap(14);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        panelMenuPrincipal.add(btnSumar, gridBagConstraints);

        btnRestar.setBackground(new java.awt.Color(123, 202, 225));
        btnRestar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnRestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/substract.png"))); // NOI18N
        btnRestar.setText("Resta");
        btnRestar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRestar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnRestar.setIconTextGap(14);
        btnRestar.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        panelMenuPrincipal.add(btnRestar, gridBagConstraints);

        btnMultiplicar.setBackground(new java.awt.Color(123, 202, 225));
        btnMultiplicar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnMultiplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/multiplication.png"))); // NOI18N
        btnMultiplicar.setText("Multiplicación");
        btnMultiplicar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMultiplicar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnMultiplicar.setIconTextGap(14);
        btnMultiplicar.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        panelMenuPrincipal.add(btnMultiplicar, gridBagConstraints);

        btnDeterminante.setBackground(new java.awt.Color(123, 202, 225));
        btnDeterminante.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDeterminante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/determinante.png"))); // NOI18N
        btnDeterminante.setText("Determinante");
        btnDeterminante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeterminante.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDeterminante.setIconTextGap(14);
        btnDeterminante.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        panelMenuPrincipal.add(btnDeterminante, gridBagConstraints);

        btnGaussJordan.setBackground(new java.awt.Color(123, 202, 225));
        btnGaussJordan.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnGaussJordan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gauss_jordan.png"))); // NOI18N
        btnGaussJordan.setText("Gauss Jordan");
        btnGaussJordan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGaussJordan.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnGaussJordan.setIconTextGap(14);
        btnGaussJordan.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        panelMenuPrincipal.add(btnGaussJordan, gridBagConstraints);

        lbSubTitle.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lbSubTitle.setText("(Operaciones Con Matrices)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        panelMenuPrincipal.add(lbSubTitle, gridBagConstraints);

        btnSalir.setBackground(new java.awt.Color(255, 83, 83));
        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSalir.setIconTextGap(14);
        btnSalir.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        panelMenuPrincipal.add(btnSalir, gridBagConstraints);

        btnInicio.setBackground(new java.awt.Color(121, 121, 255));
        btnInicio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnInicio.setIconTextGap(14);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 20;
        panelMenuPrincipal.add(btnInicio, gridBagConstraints);

        barraDesplazamientoMenuPrincipal.setViewportView(panelMenuPrincipal);

        getContentPane().add(barraDesplazamientoMenuPrincipal, java.awt.BorderLayout.LINE_START);

        panelOperaciones.setBackground(new java.awt.Color(255, 255, 255));
        panelOperaciones.setLayout(new java.awt.GridBagLayout());

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));
        panelInicio.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/portada.png"))); // NOI18N
        panelInicio.add(jLabel1, new java.awt.GridBagConstraints());

        barraDesplazamientoPanelOperaciones.setViewportView(panelInicio);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelOperaciones.add(barraDesplazamientoPanelOperaciones, gridBagConstraints);

        getContentPane().add(panelOperaciones, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorderPainted(false);

        itemAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png"))); // NOI18N
        itemAyuda.setText("Ayuda");
        itemAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        itemAyuda.setIconTextGap(14);
        jMenuBar1.add(itemAyuda);

        itemAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N
        itemAcercaDe.setText("Acerca De");
        itemAcercaDe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        itemAcercaDe.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        itemAcercaDe.setIconTextGap(14);
        jMenuBar1.add(itemAcercaDe);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 941, 629);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane barraDesplazamientoMenuPrincipal;
    public javax.swing.JScrollPane barraDesplazamientoPanelOperaciones;
    public javax.swing.JButton btnDeterminante;
    public javax.swing.JButton btnGaussJordan;
    public javax.swing.JButton btnInicio;
    public javax.swing.JButton btnMultiplicar;
    public javax.swing.JButton btnRestar;
    public javax.swing.JButton btnSalir;
    public javax.swing.JButton btnSumar;
    public javax.swing.JMenu itemAcercaDe;
    public javax.swing.JMenu itemAyuda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbSubTitle;
    private javax.swing.JLabel lbTitleMenu;
    public javax.swing.JPanel panelInicio;
    public javax.swing.JPanel panelMenuPrincipal;
    public javax.swing.JPanel panelOperaciones;
    // End of variables declaration//GEN-END:variables
}
