/*
 * Clase Model, la cual tendra metodos generales que seran utilizados en varias clases del paquete modelo 
 * Principalmente se agregaran metodos para realizar validaciones 
 */
package model;

import java.awt.event.KeyEvent;

/**
 *
 * @author SOFTWARE GALAXIA
 */
public class Model {
    
    /*Validamos que el dato ingresado por teclado sea igual a un numero*/
    public boolean validarDato(KeyEvent e){
        char key = e.getKeyChar();
        return Character.isDigit(key) || key == '/';    
    }    
    
    public boolean isFraccionOrNumberValue(String dato){
        return new Fraccion().isFraccionOrNumberValue(dato);
    }
    
    public boolean isEmptyArray(String [][] array){
        int cont=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j].length()!=0 && validarEspacio(array[i][j])!=true){
                    cont++;
                }
            }
        }
        
        return cont!=Math.pow(array[0].length, 2);
        
    }
    
    public boolean validarEspacio(String dato){
        
        int i=0;
        
        while(dato.charAt(i)==' '){
            i++;
            if(i==dato.length()){
                break;
            }
        }
        
        return i==dato.length();
        
    }
    
    public boolean validateData(String [][] matriz){
        boolean condicion=false;
        int cont=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(isFraccionOrNumberValue(matriz[i][j])==true){
                    cont++;
                }
            }
        }
        if(cont==(matriz[0].length*matriz[0].length)){
            condicion=true;
        }
        return condicion;
    }

    
    
}
