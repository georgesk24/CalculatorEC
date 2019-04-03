/*
 *Clase ControllerDeterminanteMatrices.java, donde realizaremos la operaciones para obtener la determinante
 * de una matriz aplicando una serie de metodos para lograr este resultado, igualmente esta clase 
 * es el controlador por lo tanto interactuaremos con los metodos del modelo (ModelDeterminanteMatrices.java) 
 * y los componentes de nuestra vista
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import model.Model;
import model.ModelDeterminanteMatrices;
import view.PanelDeterminante;

/**
 *
 * @author SOFTWARE GALAXIA TV  
 */
public class ControllerDeterminanteMatrices extends Controller implements ActionListener, KeyListener{
    
    /*Objeto de la vista*/
    PanelDeterminante view;
    
    
    /*agregamos los respectivos eventos a utilizar*/
    public final void events(){
        view.JcOrdenDeterminante.addActionListener(this);
        view.btnCalcular.addActionListener(this);
        view.btnLimpiar.addActionListener(this);
    }

    public final void addEvents(JTextField [][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j].addKeyListener(this);
            }
        }
    }        
    
    /*Metodo constructor de la clase*/
    public ControllerDeterminanteMatrices(PanelDeterminante view) {
        this.view = view;
        
        /*agregamos nuevos componentes a nuestra vista (JTextField, JLabel)*/        
        addTextField(view.JmatrizA,  0, 0, true, view.panelAreaOperaciones, true);               
        addLabel(new JLabel("Matriz A = "), 0, 0, view.panelAreaOperaciones, view.JmatrizA.length);
        
        addTextField(view.JmatrizARes, 0, 0, true, view.panelAreaResultado, false);
        addLabel(new JLabel("A="), 0, 0, view.panelAreaResultado, view.JmatrizARes.length);
        
        /*agregamos los eventos de teclado para los campos de texto generados*/
        addEvents(view.JmatrizA);
        events();
        
    }
    
    /*metodo el cual generara una nueva serie de componentes dinamicos a la vista eliminando los 
    ya existentes*/
    public void resetearComponentes(){

        /*obtenemos los item seleccionados del JcDimensionFila y JcDimensionColumna los cuales
        haran referencia a las filas y columnas que llevara el arreglo bidimensional de JTextField*/

        int longitud = view.JcOrdenDeterminante.getSelectedIndex()+2;

        /*inicializamos los arreglos bidimensionales con sus nuevas dimensiones (filas y columnas) */
        view.JmatrizA = new JTextField[longitud][longitud];
        view.JmatrizARes = new JTextField[longitud][longitud];
        view.JmatrizDetA = new JTextField[longitud][longitud];  


        /*removemos los componentes que estan agregados actualmente en los respectivos JPanel
        panelAreaOperaciones, panelAreaResultado y panelDeterminante */
        view.panelAreaOperaciones.removeAll();
        view.panelAreaResultado.removeAll();
        view.panelDeterminante.removeAll();
        view.panelAreaResultado.setVisible(false);
        
        /*llamamos los metodos addTextField, y addLabel para agregar los nuevos componentes
        en el panelAreaResultado*/

        addTextField(view.JmatrizA, 0, 0, true, view.panelAreaOperaciones, true);
        addLabel(new JLabel("Matriz A = "), 0, 0, view.panelAreaOperaciones, view.JmatrizA.length);

        addTextField(view.JmatrizARes, 0, 0, true, view.panelAreaResultado, false);
        addLabel(new JLabel("A="), 0, 0, view.panelAreaResultado, view.JmatrizARes.length);

        /*actualizamos los respectivos JPanel haciendo uso del metodo updateUI de esta manera se efectuaran
        los cambios en nuestra ventana */

        view.panelAreaOperaciones.updateUI();   
        view.panelAreaResultado.updateUI();
        view.panelDeterminante.updateUI();

        addEvents(view.JmatrizA);
        
    }
    
    /*Eventos*/
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object evt = ae.getSource();
        
        /*se accionara cuando se seleccione un item del JCombobox*/
        if(evt.equals(view.JcOrdenDeterminante)){
            
            resetearComponentes();
            
        }else if(evt.equals(view.btnCalcular)){
                        
            String [][] Ma;
            
            /*pasamos los datos que estan en los JTextField a un array tipo String*/
            Ma = convertirArreglo(view.JmatrizA);       
            /*llamamos al modelo y le pasamos como parametro el array*/
            ModelDeterminanteMatrices model = new ModelDeterminanteMatrices(Ma);
            
            /*verificamos si el array esta vacio*/
            if(!model.isEmptyArray(Ma)){
                
                /*validamos si el formato de los valores del array(matriz) es correcto*/
                if(model.validateData(Ma)==true){
                                         
                    String determinante= model.getDeterminante().toString();
                    
                    if(!determinante.equals("0")){
                      
                        view.panelDeterminante.removeAll();
                        view.panelDeterminante.updateUI();
                        
                        addSeparator(new JSeparator(), 0, view.JmatrizARes.length, view.panelAreaResultado, view.JmatrizARes[0].length+1);        

                        addTextField(view.JmatrizDetA, 0, view.JmatrizDetA.length+1, true, view.panelAreaResultado, false);
                        addLabel(new JLabel("="), 0, view.JmatrizDetA.length+1, view.panelAreaResultado, view.JmatrizDetA.length);
                        
                        String MdetA [][] = model.getMatriz();
                        for (int i = 0; i < view.JmatrizDetA.length; i++) {
                            for (int j = 0; j < view.JmatrizDetA[0].length; j++) {
                                view.JmatrizDetA[i][j].setText(MdetA[i][j]);
                            }
                        }   
                        
                        addSeparator(new JSeparator(),  0, view.JmatrizARes.length+view.JmatrizDetA.length+1, view.panelAreaResultado, view.JmatrizDetA[0].length+1);                                
                        
                        addComponent(view.panelDeterminante, 0, view.JmatrizARes.length+view.JmatrizDetA.length+2, view.panelAreaResultado, view.JmatrizDetA[0].length+1);
                        
                        view.panelDeterminante.add(new JLabel("<html><body><h1>Det|A|=</h1></body>"));                        
                        for (int i = 0; i < view.JmatrizDetA.length; i++) {
                            for (int j = 0; j < view.JmatrizDetA[0].length; j++) {
                                if(i==j){
                                    String textHtml = "<html><body><h1>("+view.JmatrizDetA[i][j].getText()+")</h1></body></html>";
                                    view.panelDeterminante.add(new JLabel(textHtml));
                                }
                            }
                        }   
                        
                        if(model.getIntercambio().toString().equals("-1")){
                            view.panelDeterminante.add(new JLabel("<html><body><h1>("+model.getIntercambio().toString()+")</h1></body>"));                                                    
                        }
                        
                        view.panelDeterminante.add(new JLabel("<html><body><h1>=</h1></body>"));                        
                        view.panelDeterminante.add(new JLabel("<html><body><h1>"+determinante+"</h1></body>"));                        

                        
                    }else{
                        
                        view.panelAreaResultado.removeAll();
                        view.panelDeterminante.removeAll();
                        view.panelAreaResultado.updateUI();
                        view.panelDeterminante.updateUI();
                        addTextField(view.JmatrizARes, 0, 0, true, view.panelAreaResultado, false);
                        addLabel(new JLabel("A="), 0, 0, view.panelAreaResultado, view.JmatrizARes.length);
                        addSeparator(new JSeparator(),  0, view.JmatrizARes.length+view.JmatrizDetA.length+1, view.panelAreaResultado, view.JmatrizDetA[0].length+1);                                                        
                        addComponent(view.panelDeterminante, 0, view.JmatrizARes.length+view.JmatrizDetA.length+2, view.panelAreaResultado, view.JmatrizDetA[0].length+1);                        
                        view.panelDeterminante.add(new JLabel("<html><body><h1>Det|A|=0</h1></body>"));                        
                        
                    }
 
                    for (int i = 0; i < view.JmatrizA.length; i++) {
                        for (int j = 0; j < view.JmatrizA[0].length; j++) {
                            view.JmatrizARes[i][j].setText(view.JmatrizA[i][j].getText());
                        }
                    }                                            
                   
                    view.panelAreaResultado.setVisible(true);            

                }else{
                    JOptionPane.showMessageDialog(null, "Formato no permitido\nVerifique sus datos e intente nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Opción valida", JOptionPane.ERROR_MESSAGE);
            }
            
        }else if(evt.equals(view.btnLimpiar)){
            
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea limpiar los campos?");
            
            if(confirmar==JOptionPane.YES_OPTION){

                resetearComponentes();
                view.panelAreaResultado.setVisible(false);

            }
            
        }
        
        
        

    }

    @Override
    public void keyTyped(KeyEvent ke) {

        Object evt = ke.getSource();
        
        char c = ke.getKeyChar();
        
        for (int i = 0; i < view.JmatrizA.length; i++) {
            for (int j = 0; j < view.JmatrizA[0].length; j++) {
                if(evt.equals(view.JmatrizA[i][j])){
                    validarCampo(view.JmatrizA[i][j], c, ke, new Model());
                }
            }
        }        
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    
    
    
}
