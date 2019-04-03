/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author SOFTWARE GALAXIA TV
 */
public class ModelDeterminanteMatrices extends Model{

    private Fraccion intercambio;    
    private String [][] matriz;

    private Fraccion getFraccion(String dato){
        return new Fraccion().toFraccion(dato);
    }
    
    public Fraccion getIntercambio() {
        return intercambio;
    }

    public void setIntercambio(Fraccion intercambio) {
        this.intercambio = intercambio;
    }
    
    
    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }    

    public ModelDeterminanteMatrices(String[][] matriz) {
        this.matriz = matriz;
        intercambio = new Fraccion(1, 1);
    }

    public Fraccion getDeterminante(){

        Fraccion determinante=new Fraccion(1, 1);
        
        if(evaluarPropiedades()){
            
            this.setMatriz(metodoDeGauss()); 
            
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if(i==j){
                        determinante = determinante.multiplicar(getFraccion(matriz[i][j]));
                    }
                }
            }
            
            determinante = determinante.multiplicar(intercambio);
            
        }else{
            determinante = new Fraccion(0, 1);
        }
        return determinante;
    }
    

    private String[][] metodoDeGauss(){

        String [][] newMatriz = this.getMatriz();
        
        for (int k = 0; k < newMatriz[0].length - 1; k++){

            for (int i = k + 1; i < newMatriz.length; i++){                

                /*verificamos si estamos posicionados en la diagonal princiapl*/
                if(k==i-1){

                    /*validamos si el valor de la diagonal principal es igual a 0*/
                    if(getFraccion(newMatriz[i-1][k]).toString().equals("0")){ 

                        /*evaluamos la fila/columna que sea diferente de 0*/
                        int fila = evaluarCelda(i, k);

                        /*verificamos que el valor de fila sea menor que la longitud de filas de la matriz*/
                        if(fila < newMatriz.length){

                            /*llamamos al metodo intercambiar fila
                            le pasamos como parametro la fila actual mas el valor de la fila en el cual
                            el valor es distinto de 0*/
                            newMatriz = intercambiarFila(i-1, fila);

                            /*una de las propiedades de los determinantes dice que al intercambiar 
                            una fila o columna cambiamos de signo para no alterar el resultado de la determinante
                            por lo tanto almacenamos este valor en esta variable(intercambio)*/
                            this.setIntercambio(this.getIntercambio().multiplicar(getFraccion("-1/1")));
                        }
                    }                   
                }  

                /*Inicio de las operaciones de renglon*/
                /*obtenemos el factor multiplicador*/
                Fraccion factorMultiplciador = getFactorMultiplicador(newMatriz[i][k], newMatriz[k][k]);               
                /*realizamos las operaciones de renglon
                filaAModificar = -factor * filaMultiplicadora + filaAModificar*/
                for (int j = k; j < newMatriz.length; j++){
                    newMatriz[i][j] = new Fraccion(-1, 1).multiplicar(factorMultiplciador).multiplicar(getFraccion(newMatriz[k][j] )).sumar(getFraccion(newMatriz[i][j])).toString();
                }                

            }        
        }
            
        return newMatriz;
    }
        
    private boolean evaluarPropiedades(){
        
        int fila=0, columna=0, i=0;
        boolean condicion = true;
        while(i<this.getMatriz()[0].length){
            for (int j = 0; j < this.getMatriz().length; j++) {
                for (int k = 0; k < this.getMatriz()[0].length; k++) {
                    if(getFraccion(this.getMatriz()[j][k]).toString().equals("0")){
                        columna++;
                    }
                }
                if(getFraccion(this.getMatriz()[j][i]).toString().equals("0")){
                    fila++;
                }
                if(columna==this.getMatriz()[0].length){
                    condicion=false;
                    break;
                }
                columna=0;
            }
            if(fila==this.getMatriz().length){
                condicion=false;
                break;
            }
            fila=0;           
            i++;
        }
        return condicion;
    }
       
    private Fraccion getFactorMultiplicador(String val1, String val2){       
        return getFraccion(val1).dividir(getFraccion(val2));
    } 
        
    private String [][] intercambiarFila(int fila1, int fila2){

         int j;
         String aux;
         String newMatriz[][] = this.getMatriz();
         for(j=0; j<this.getMatriz()[0].length; j++){

             aux = newMatriz[fila1][j];
             newMatriz[fila1][j] = newMatriz[fila2][j];
             newMatriz[fila2][j] = aux;

         }

         return newMatriz;
    }
    
    private int evaluarCelda(int i, int k){

        int columna = k;
        int fila=i;        
        while(this.getMatriz()[fila][columna].equals("0")){
            fila++;
            if(fila==this.getMatriz().length){
                break;
            }
        }                         
        return fila;
    
    }
        
     
    
    
}
