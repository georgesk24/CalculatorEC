/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
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
    
    PanelDeterminante view;
    
    
    /*agregamos los respectivos eventos a utilizar*/
    public final void events(){
        view.JcOrdenDeterminante.addActionListener(this);
        view.btnCalcular.addActionListener(this);
        view.btnLimpiar.addActionListener(this);
    }
            
    
    public ControllerDeterminanteMatrices(PanelDeterminante view) {
        this.view = view;
        
        /*agregamos nuevos componentes a nuestra vista (JTextField, JSeparator, JLabel)*/        
        addTextField(view.JmatrizA,  0, 0, true, view.panelAreaOperaciones, true);               
        addLabel(new JLabel("Matriz A = "), 0, 0, view.panelAreaOperaciones, view.JmatrizA.length);
        
        addTextField(view.JmatrizARes, 0, 0, true, view.panelAreaResultado, false);
        addLabel(new JLabel("A="), 0, 0, view.panelAreaResultado, view.JmatrizARes.length);
        
        
        addEvents(view.JmatrizA);
        events();
        
    }

    public final void addEvents(JTextField [][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j].addKeyListener(this);
            }
        }
    }    
    
    public void resetearComponentes(){

        /*obtenemos los item seleccionados del JcDimensionFila y JcDimensionColumna los cuales
        haran referencia a las filas y columnas que llevara el arreglo bidimensional de JTextField*/

        int longitud = view.JcOrdenDeterminante.getSelectedIndex()+2;

        /*inicializamos los arreglos bidimensionales con sus nuevas dimensiones (filas y columnas) */
        view.JmatrizA = new JTextField[longitud][longitud];
        view.JmatrizARes = new JTextField[longitud][longitud];
        view.JmatrizDetA = new JTextField[longitud][longitud];  


        /*removemos los componentes que estan agregados actualmente en los respectivos JPanel
        panelAreaOperaciones y panelAreaResultado */
        view.panelAreaOperaciones.removeAll();
        view.panelAreaResultado.removeAll();
        view.panelDeterminante.removeAll();
        view.panelAreaResultado.setVisible(false);
        /*llamamos los metodos addTextField, addSeparator y addLabel para agregar los nuevos componentes
        en los respectivos JPanel*/

        addTextField(view.JmatrizA, 0, 0, true, view.panelAreaOperaciones, true);
        addLabel(new JLabel("Matriz A = "), 0, 0, view.panelAreaOperaciones, view.JmatrizA.length);

        addTextField(view.JmatrizARes, 0, 0, true, view.panelAreaResultado, false);
        addLabel(new JLabel("A="), 0, 0, view.panelAreaResultado, view.JmatrizARes.length);

        /*actualizamos los respectivos JPanel haciendo uso del metodo updateUI de esta manera se efectuaran
        los cambios en nuestra ventana */

        addEvents(view.JmatrizA);

        view.panelAreaOperaciones.updateUI();   
        view.panelAreaResultado.updateUI();
        view.panelDeterminante.updateUI();
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object evt = ae.getSource();
        
        /*se accionara cuando se seleccione un item del JCombobox*/
        if(evt.equals(view.JcOrdenDeterminante)){
            
            resetearComponentes();
            
        }else if(evt.equals(view.btnCalcular)){
                        
            String [][] Ma;
            
            Ma = convertirArreglo(view.JmatrizA);       
            ModelDeterminanteMatrices model = new ModelDeterminanteMatrices(Ma);

            if(!model.isEmptyArray(Ma)){

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
