/*
 */
package controller;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.PanelGaussJordan;

/**
 *
 * @author de
 */
public class ControllerGaussJordan extends Controller implements ActionListener, KeyListener{
    
    PanelGaussJordan view;
    
    
    /*agregamos los respectivos eventos a utilizar*/
    public final void events(){
        view.JcVariables.addActionListener(this);
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
    
    public final void addLabels(){

        int patron=0;
        for(int i=0; i<view.JmatrizA.length; i++){
            for(int j=0; j<view.JmatrizA.length; j++){
                addLabel(new JLabel("X"+(j+1)), j+2+patron, i, view.panelAreaOperaciones, 1); 
                
                if(j==view.JmatrizA.length-1){
                    addLabel(new JLabel("="), j+3+patron, i, view.panelAreaOperaciones, 1);                  
                }else{
                    addLabel(new JLabel("+"), j+3+patron, i, view.panelAreaOperaciones, 1);  
                }
                
                patron=patron+2;
            }
            patron=0;
        }
    
    }
    
    
    public final void addTextField(JTextField [] textField, JPanel panel, boolean editable){
        
        /*Indices para recorrer el arreglo bidimensional*/
        int i;
        
        /*Creamos un objeto de tipo GridBagConstrains para distribuir las posiciones en las cuales 
        se ubicaran los componentes (JTextField) */
        GridBagConstraints config = new GridBagConstraints();
        
        /*Iniciamos ciclo anidado (for)
          el cual recorrera cada posicion(filas y columnas) del arreglo bidimensional
        */
        
        for(i=0; i<textField.length; i++){

            // inicializamos el objeto JTextField
            textField[i] = new JTextField(1);

            /*Agregamos los componentes teniendo en cuenta los siguientes parametros                 
            */
            config.gridx = 1;
            config.gridy = i;
            config.gridwidth = 1;
            config.gridheight = 1;  
            config.ipadx = 80;
            config.ipady  = 10;
            config.weightx=1.0;
            config.fill = GridBagConstraints.CENTER;
            config.anchor = GridBagConstraints.NORTHWEST;   
            config.insets = new Insets(0, 0, 0, 12);
            panel.add(textField[i], config);    

            textField[i].setEditable(editable);

        }
        

    }        
    
    public ControllerGaussJordan(PanelGaussJordan view){
        
        this.view=view;

        addTextField(view.JmatrizA, 0, 0, true, view.panelAreaOperaciones, true, 2);               
        addLabel(new JLabel("Matriz A = "), 0, 0, view.panelAreaOperaciones, view.JmatrizA.length);
        
        addLabels();
        
        addTextField(view.JmatrizResultado, view.panelAreaResultado, true);
        
        for (int i = 0; i < view.JmatrizResultado.length; i++) {
            addLabel(new JLabel("X"+(i+1)+" = "), 0, i, view.panelAreaResultado, 1);        
        }
        
        addEvents(view.JmatrizA);
        events();
        
              
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object evt = ae.getSource();
        
        if(evt.equals(view.JcVariables)){
                        
            int longitud = Integer.parseInt(view.JcVariables.getSelectedItem().toString());
            
            /*inicializamos los arreglos bidimensionales con sus nuevas dimensiones (filas y columnas) */
            view.JmatrizA = new JTextField[longitud][longitud+1];
            view.JmatrizResultado = new JTextField[longitud];
            
            /*removemos los componentes que estan agregados actualmente en los respectivos JPanel
            panelAreaOperaciones y panelAreaResultado */
            view.panelAreaOperaciones.removeAll();
            view.panelAreaResultado.removeAll();
            view.panelAreaResultado.setVisible(false);
            /*llamamos los metodos addTextField, addSeparator y addLabel para agregar los nuevos componentes
            en los respectivos JPanel*/
            
            addTextField(view.JmatrizA, 0, 0, true, view.panelAreaOperaciones, true,2);
            addLabel(new JLabel("Matriz A = "), 0, 0, view.panelAreaOperaciones, view.JmatrizA.length);

            addLabels();

            addTextField(view.JmatrizResultado, view.panelAreaResultado, true);

            for (int i = 0; i < view.JmatrizResultado.length; i++) {
                addLabel(new JLabel("X"+(i+1)+" = "), 0, i, view.panelAreaResultado, 1);        
            }

            
            /*actualizamos los respectivos JPanel haciendo uso del metodo updateUI de esta manera se efectuaran
            los cambios en nuestra ventana */
            
            view.panelAreaOperaciones.updateUI();   
            view.panelAreaResultado.updateUI();

            addEvents(view.JmatrizA);
            
        }else if(evt.equals(view.btnCalcular)){
            /*
            String [][] Ma, Mb;
            
            Ma = convertirArreglo(view.JmatrizA);                        
            
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
