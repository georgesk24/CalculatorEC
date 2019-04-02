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
import javax.swing.JTextField;
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
     
        addTextField(view.JmatrizB, 0, 0, true, view.panelAreaResultado, false);
        addLabel(new JLabel("Det|A|= "), 0, 0, view.panelAreaResultado, view.JmatrizB.length);

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
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object evt = ae.getSource();
        
        /*se accionara cuando se seleccione un item del JCombobox*/
        if(evt.equals(view.JcOrdenDeterminante)){
            
            /*obtenemos los item seleccionados del JcDimensionFila y JcDimensionColumna los cuales
            haran referencia a las filas y columnas que llevara el arreglo bidimensional de JTextField*/
            
            int longitud = view.JcOrdenDeterminante.getSelectedIndex()+2;
            
            /*inicializamos los arreglos bidimensionales con sus nuevas dimensiones (filas y columnas) */
            view.JmatrizA = new JTextField[longitud][longitud];
            view.JmatrizB = new JTextField[longitud][longitud];               
            
            /*removemos los componentes que estan agregados actualmente en los respectivos JPanel
            panelAreaOperaciones y panelAreaResultado */
            view.panelAreaOperaciones.removeAll();
            view.panelAreaResultado.removeAll();
            view.panelAreaResultado.setVisible(false);
            /*llamamos los metodos addTextField, addSeparator y addLabel para agregar los nuevos componentes
            en los respectivos JPanel*/
            
            addTextField(view.JmatrizA, 0, 0, true, view.panelAreaOperaciones, true);
            addLabel(new JLabel("Matriz A = "), 0, 0, view.panelAreaOperaciones, view.JmatrizA.length);

            addTextField(view.JmatrizB, 0, 0, true, view.panelAreaResultado, false);
            addLabel(new JLabel("Det|A|= "), 0, 0, view.panelAreaResultado, view.JmatrizB.length);

            /*actualizamos los respectivos JPanel haciendo uso del metodo updateUI de esta manera se efectuaran
            los cambios en nuestra ventana */

            addEvents(view.JmatrizA);
            addEvents(view.JmatrizB);            
            
            view.panelAreaOperaciones.updateUI();   
            view.panelAreaResultado.updateUI();
    
        }else if(evt.equals(view.btnCalcular)){
            /*
            String [][] Ma, Mb;
            
            Ma = convertirArreglo(view.JmatrizA);                        
            Mb = convertirArreglo(view.JmatrizB);
            
            if(!model.isEmptyArray(Ma) && !model.isEmptyArray(Mb)){

                if(model.validateData(Ma)==true && model.validateData(Mb)==true){

                    String Mc [][] = model.sumar(Ma, Mb);
                    for (int i = 0; i < view.JmatrizC.length; i++) {
                        for (int j = 0; j < view.JmatrizC[0].length; j++) {
                            view.JmatrizC[i][j].setText(Mc[i][j]);
                        }
                    }

                    view.panelAreaResultado.setVisible(true);            

                }else{
                    JOptionPane.showMessageDialog(null, "Formato no permitido\nVerifique sus datos e intente nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Opción valida", JOptionPane.ERROR_MESSAGE);
            }*/
            
        }else if(evt.equals(view.btnLimpiar)){
            
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea limpiar los campos?");
            
            if(confirmar==JOptionPane.YES_OPTION){

                limpiarCampos(view.JmatrizA);
                limpiarCampos(view.JmatrizB);
                view.panelAreaResultado.setVisible(false);

            }
            
        }
        
        
        

    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    
    
    
}
