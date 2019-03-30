/*
 *clase ControllerMultiplicarMatrices la cual sera la clase controlador de nuestra vista
 *este sera nuestro puente de comunicacion entre la vista y el modelo
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.ModelMultiplicarMatrices;
import view.PanelMultiplicarMatrices;

/**
 *
 * @author SOFTWARE GALAXIA TV
 */
public class ControllerMultiplicarMatrices extends Controller implements ActionListener, KeyListener{
    
    //Creamos un objeto de nuestra vista PanelMultiplicarMatrices
    PanelMultiplicarMatrices view;

    //Creamos un objeto de tipo ModelMultiplicarMatrices la cual sera nuestro modelo
    ModelMultiplicarMatrices model;
    
    /*Agregamos los respectivos eventos, trabajaremos con eventos de tipo Action y Key Listener*/
    public final void events(){
        view.btnGenerarMatriz.addActionListener(this);
        view.btnCalcular.addActionListener(this);
        view.btnLimpiar.addActionListener(this);
    }
    
    /*Metodo constructor de la clase*/
    public ControllerMultiplicarMatrices(PanelMultiplicarMatrices view) {
        this.view = view;
        model = new ModelMultiplicarMatrices();
        events();
    }

    /*asignamos los eventos de teclado a los campos de texto generados*/
    public final void addEvents(JTextField [][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j].addKeyListener(this);
            }
        }
    }    
    
    /*Metodos abstractos en los cuales controlaremos los respectivos eventos que se ejecuten*/
    @Override    
    public void actionPerformed(ActionEvent ae) {
        
        Object evt = ae.getSource();
        
        /*Condicional que se accionara cuando oprimamos el boton generar matriz*/
        if(evt.equals(view.btnGenerarMatriz)){
            
            /*Obtenemos la Columna de la matriz A y la fila de la Matriz B*/
            int columnaMA = Integer.parseInt(view.JcDimensionColumnaMatrizA.getSelectedItem().toString());
            int filaMB = Integer.parseInt(view.JcDimensionFilaMatrizB.getSelectedItem().toString());
            
            /*validamos que se cumpla la condicion en la que el numero de columnas de A debe ser 
            igual al numero de filas de B*/
            if(columnaMA==filaMB){
                
                /*obtenemos los respectivos valores seleccionados en los JComboBox*/
                int longitudFilaMA = Integer.parseInt(view.JcDimensionFilaMatrizA.getSelectedItem().toString());
                int longitudColumnaMA = Integer.parseInt(view.JcDimensionColumnaMatrizA.getSelectedItem().toString());
                int longitudFilaMB = Integer.parseInt(view.JcDimensionColumnaMatrizB.getSelectedItem().toString());
                int longitudColumnaMB = Integer.parseInt(view.JcDimensionColumnaMatrizB.getSelectedItem().toString());
            
                int gridWidthSeparator = (longitudColumnaMA>=longitudColumnaMB) ? longitudColumnaMA : longitudColumnaMB; 
                
                /*Inicializamos el arrayBidimiensional de JTextField*/
                view.JmatrizA = new JTextField[longitudFilaMA][longitudColumnaMA];
                view.JmatrizB = new JTextField[longitudFilaMB][longitudColumnaMB];   
                view.JmatrizC = new JTextField[longitudFilaMA][longitudColumnaMB];               
                
                /*removemos los componentes actuales de los JPanel*/
                view.panelAreaOperaciones.removeAll();
                view.panelAreaResultado.removeAll();
                
                view.panelAreaResultado.setVisible(false);
                
                /*generamos los componentes*/
                addTextField(view.JmatrizA, 0, 0, true, view.panelAreaOperaciones, true);
                addSeparator(view.separator, 0, longitudFilaMA, view.panelAreaOperaciones, gridWidthSeparator+1);
                addTextField(view.JmatrizB,  0, longitudFilaMA+1, true, view.panelAreaOperaciones, true );  
                addLabel(new JLabel("Matriz A = "), 0, 0, view.panelAreaOperaciones, view.JmatrizA.length);
                addLabel(new JLabel("Matriz B = "), 0, longitudFilaMA+1, view.panelAreaOperaciones, view.JmatrizB.length);            

                addTextField(view.JmatrizC, 0, 0, true, view.panelAreaResultado, false);
                addLabel(new JLabel("Matriz C = "), 0, 0, view.panelAreaResultado, view.JmatrizC.length);

                addEvents(view.JmatrizA);
                addEvents(view.JmatrizB);        
                
                /*actualizamos los respectivos JPanel haciendo uso del metodo updateUI de esta manera se efectuaran
                los cambios en nuestra ventana */

                view.panelAreaOperaciones.updateUI();   
                view.panelAreaResultado.updateUI();
                
                
                
            }else{
                JOptionPane.showMessageDialog(null, "El numero de columnas de la matriz A\ndebe ser igual al número de filas de la matriz B", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }else if(evt.equals(view.btnCalcular)){
 
            String [][] Ma, Mb;
            
            Ma = convertirArreglo(view.JmatrizA);                        
            Mb = convertirArreglo(view.JmatrizB);
            
            if(!model.isEmptyArray(Ma) && !model.isEmptyArray(Mb)){

                if(model.validateData(Ma)==true && model.validateData(Mb)==true){

                    String Mc [][] = model.multiplicar(Ma, Mb);
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
            }
            
        }else if(evt.equals(view.btnLimpiar)){
            
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea limpiar los campos?");
            
            if(confirmar==JOptionPane.YES_OPTION){
                
                view.panelAreaOperaciones.removeAll();
                view.panelAreaResultado.removeAll();
                
                /*agregamos el icono por defecto que se visualiza inicialmente en el JPanel */
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/algebra-lineal.png"));
                
                addLabel(new JLabel(icon), 0, 0, view.panelAreaOperaciones, 1);
                
                view.panelAreaResultado.setVisible(false);
                
                view.panelAreaOperaciones.updateUI();
                view.panelAreaResultado.updateUI();
                
            }
            
        }
        
        

    }

    /*eventos de teclado*/
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
