/*
 * Clase Controller en la cual se crearan metodo generales que seran utilizados en todas las clases 
 * del paquete controlador
 */
package controller;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.Model;

/**
 *
 * @author SOFTWARE GALAXIA TV
 */
public class Controller {
    
    
    /*Creamos un metodo tipo void para agregar los respectivos JTextField al JPanel
    Primer parametro = Array bidimensional tipo JTextField
    Segundo parametro = posicion de inicio en el eje de las x (Estamos trabajando con GridBagLayout) 
    Tercer parametro = posicion de inicio en el eje de las y
    Cuarto parametro = variable tipo boolean en la cual determinamos si la celda tendra un tamaño standar o distinto
    quinto parametro = JPanel panel en el cual agregaremos los nuevos componentes 
    */
    public final void addTextField(JTextField [][] textField, int x, int y, boolean weight, JPanel panel, boolean editable){
        
        /*Indices para recorrer el arreglo bidimensional*/
        int i,j;
        
        /*Creamos un objeto de tipo GridBagConstrains para distribuir las posiciones en las cuales 
        se ubicaran los componentes (JTextField) */
        GridBagConstraints config = new GridBagConstraints();
        
        /*Iniciamos ciclo anidado (for)
          el cual recorrera cada posicion(filas y columnas) del arreglo bidimensional
        */
        
        for(i=0; i<textField.length; i++){

            for(j=0; j<textField[i].length; j++){
               
               // inicializamos el objeto JTextField
               textField[i][j] = new JTextField(1);
               
               /*Agregamos los componentes teniendo en cuenta los siguientes parametros                 
               */
               config.gridx = x+j+1;
               config.gridy = y+i;
               config.gridwidth = 1;
               config.gridheight = 1;  
               config.ipadx = 60;
               config.ipady  = 10;
               if(weight==true && j==textField[0].length-1){
                   config.weightx=1.0;               
               }else{
                   config.weightx=0.0;
               }
               config.fill = GridBagConstraints.CENTER;
               config.anchor = GridBagConstraints.NORTHWEST;   
               config.insets = new Insets(0, 0, 0, 12);
               panel.add(textField[i][j], config);    
               
               textField[i][j].setEditable(editable);
               
            }

        }
        

    }
    
    /*Agregamos una etiqueta de texto a un JPanel este metodo contiene tres parametros
    JLabel = etiqueta de texto la cual desea agregar
    int x = posicion que llevara de manera horizontal 
    int y = posicion que ocupara de manera vertical
    JPanel panel = panel al cual se desea agregar la etiqueta
    */
    public final void addLabel(JLabel label, int x, int y, JPanel panel, int gridHeight){
        
        GridBagConstraints config = new GridBagConstraints();

        label.setFont(new Font("Arial", Font.PLAIN, 18));
        
        config.gridx = x;
        config.gridy = y;
        config.gridwidth = 1;
        config.gridheight = gridHeight;  
        config.fill = GridBagConstraints.CENTER;
        config.anchor = GridBagConstraints.CENTER;            
        config.insets = new Insets(0, 0, 0, 20);                
        panel.add(label, config);    

    
    }
    
    /*Agregamos un componente JSeparator para dividir ciertos bloques de nuestra interfaz 
    por ejemplo separar la matriz A de la matriz B*/
    public final void addSeparator(JSeparator separator, int x, int y, JPanel panel, int gridWidth){
    
        GridBagConstraints config = new GridBagConstraints();

        separator.setOrientation(SwingConstants.HORIZONTAL);
        
        config.gridx = x;
        config.gridy = y;
        config.gridwidth = gridWidth;
        config.gridheight=1;
        config.fill = GridBagConstraints.HORIZONTAL;
        config.anchor = GridBagConstraints.CENTER;            
        config.insets = new Insets(25, 10, 25, 10);        
        panel.add(separator, config);    
        
        
    }
    
    public String [][] convertirArreglo(JTextField [][] field){
        
        String newArray[][] = new String[field.length][field[0].length];
        
        for (int i = 0; i < newArray.length; i++) {
            for(int j=0; j<newArray[0].length; j++){
                newArray[i][j]=field[i][j].getText();
            }
        }
        
        return newArray;
    }
    
    
    public void limpiarCampos(JTextField [][] array){
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j].setText("");
            }
        }
    
    }
    
    
    public void validarCampo(JTextField field, char c, KeyEvent ke, Model model){
        
        String cadena = field.getText();

        if(c=='-'){

            if(cadena.length()>0){

                if(cadena.charAt(0)!='-'){
                    field.setText("-"+cadena);
                }

            }else{
                field.setText("-");
            }
            ke.consume();

        }else if(model.validarDato(ke)!=true){
            ke.consume();
        }

    }    
    
}
