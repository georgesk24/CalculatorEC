/*
* Controlador de la vista perteneciente al PanelRestarMatrices
* en esta clase interactuamos con los elementos de nuestra vista (componentes, eventos, operaciones)
*/
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Fraccion;
import model.ModelRestarMatrices;
import view.PanelRestarMatrices;

/**
 *
 * @author SOFTWARE GALAXIA
 */
public class ControllerRestarMatrices extends Controller implements ActionListener, KeyListener{
    
    /*Creamos un objeto de tipo PanelSumarMatrices (nuestra vista)*/
    PanelRestarMatrices view;
        
    ModelRestarMatrices model;
    
    /*agregamos los respectivos eventos a utilizar*/
    public final void events(){
        view.JcDimensionFila.addActionListener(this);
        view.JcDimensionColumna.addActionListener(this);
        view.btnCalcular.addActionListener(this);
        view.btnLimpiar.addActionListener(this);
    }    
    
    public ControllerRestarMatrices(PanelRestarMatrices view){
        
        this.view=view;
        
        model = new ModelRestarMatrices();
        
        addTextField(view.JmatrizA,  0, 0, true, view.panelAreaOperaciones, true);
        addSeparator(view.separator, 0, view.JmatrizA.length, view.panelAreaOperaciones, view.JmatrizA[0].length+1);
        addTextField(view.JmatrizB,  0, view.JmatrizA.length+1, true, view.panelAreaOperaciones, true );        
        
        addLabel(new JLabel("Matriz A = "), 0, 0, view.panelAreaOperaciones, view.JmatrizA.length);
        addLabel(new JLabel("Matriz B = "), 0, view.JmatrizA.length+1, view.panelAreaOperaciones, view.JmatrizA.length);                
     
        addTextField(view.JmatrizC, 0, 0, true, view.panelAreaResultado, false);
        addLabel(new JLabel("Matriz C = "), 0, 0, view.panelAreaResultado, view.JmatrizC.length);
        
        addEvents(view.JmatrizA);
        addEvents(view.JmatrizB);
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
        if(evt.equals(view.JcDimensionFila) || evt.equals(view.JcDimensionColumna)){
            
            /*obtenemos los item seleccionados del JcDimensionFila y JcDimensionColumna los cuales
            haran referencia a las filas y columnas que llevara el arreglo bidimensional de JTextField*/
            
            int longitudFila = Integer.parseInt(view.JcDimensionFila.getSelectedItem().toString());
            int longitudColumna = Integer.parseInt(view.JcDimensionColumna.getSelectedItem().toString());
            
            /*inicializamos los arreglos bidimensionales con sus nuevas dimensiones (filas y columnas) */
            view.JmatrizA = new JTextField[longitudFila][longitudColumna];
            view.JmatrizB = new JTextField[longitudFila][longitudColumna];   
            view.JmatrizC = new JTextField[longitudFila][longitudColumna];               
            
            /*removemos los componentes que estan agregados actualmente en los respectivos JPanel
            panelAreaOperaciones y panelAreaResultado */
            view.panelAreaOperaciones.removeAll();
            view.panelAreaResultado.removeAll();
            view.panelAreaResultado.setVisible(false);
            /*llamamos los metodos addTextField, addSeparator y addLabel para agregar los nuevos componentes
            en los respectivos JPanel*/
            
            addTextField(view.JmatrizA, 0, 0, true, view.panelAreaOperaciones, true);
            addSeparator(view.separator, 0, longitudFila, view.panelAreaOperaciones, view.JmatrizA[0].length+1);
            addTextField(view.JmatrizB,  0, longitudFila+1, true, view.panelAreaOperaciones, true );  
            addLabel(new JLabel("Matriz A = "), 0, 0, view.panelAreaOperaciones, view.JmatrizA.length);
            addLabel(new JLabel("Matriz B = "), 0, longitudFila+1, view.panelAreaOperaciones, view.JmatrizA.length);            

            addTextField(view.JmatrizC, 0, 0, true, view.panelAreaResultado, false);
            addLabel(new JLabel("Matriz C = "), 0, 0, view.panelAreaResultado, view.JmatrizC.length);

            addEvents(view.JmatrizA);
            addEvents(view.JmatrizB);       
            
            /*actualizamos los respectivos JPanel haciendo uso del metodo updateUI de esta manera se efectuaran
            los cambios en nuestra ventana */
         
            view.panelAreaOperaciones.updateUI();   
            view.panelAreaResultado.updateUI();
    
        }else if(evt.equals(view.btnCalcular)){
 
            String [][] Ma, Mb;
            
            Ma = convertirArreglo(view.JmatrizA);                        
            Mb = convertirArreglo(view.JmatrizB);
            
            if(!model.isEmptyArray(Ma) && !model.isEmptyArray(Mb)){

                if(model.validateData(Ma)==true && model.validateData(Mb)==true){

                    String Mc [][] = model.restar(Ma, Mb);
                    for (int i = 0; i < view.JmatrizC.length; i++) {
                        for (int j = 0; j < view.JmatrizC[0].length; j++) {
                            view.JmatrizC[i][j].setText(Mc[i][j]);
                        }
                    }

                    view.panelAreaResultado.setVisible(true);            

                }else{
                    JOptionPane.showMessageDialog(null, "Formato no permitido, Posibles Errores\n "
                                                        +"1- Ha ingresado una fracción de la forma N/0 (el denominador debe ser distinto de 0) \n"+
                                                         "2- Ha ingresado letras o caracteres no permitidos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Opción valida", JOptionPane.ERROR_MESSAGE);
            }
            
        }else if(evt.equals(view.btnLimpiar)){
            
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea limpiar los campos?");
            
            if(confirmar==JOptionPane.YES_OPTION){

                limpiarCampos(view.JmatrizA);
                limpiarCampos(view.JmatrizB);
                limpiarCampos(view.JmatrizC);
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
                    validarCampo(view.JmatrizA[i][j], c, ke, model);
                }
            }
        }
        
        for (int i = 0; i < view.JmatrizB.length; i++) {
            for (int j = 0; j < view.JmatrizB[0].length; j++) {
                if(evt.equals(view.JmatrizB[i][j])){
                    validarCampo(view.JmatrizB[i][j], c, ke, model);
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
