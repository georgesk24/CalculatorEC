/*

 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author SOFTWARE GALAXIA TV
 */
public class ModelDeterminanteMatrices extends Model{
 
    private Fraccion intercambio;

    public ModelDeterminanteMatrices(){
        intercambio = new Fraccion(1, 1);
    }
    
    public Fraccion getFraccion(String dato){
        return new Fraccion().toFraccion(dato);
    }
    
    public Fraccion getFactorMultiplicador(String val1, String val2){       
        return getFraccion(val1).dividir(getFraccion(val2));
    } 
        
    public String [][] metodoDeGauss(String matriz[][]){

        for (int k = 0; k < matriz.length - 1; k++){

            for (int i = k + 1; i < matriz.length; i++){                

                /*verificamos si estamos posicionados en la diagonal princiapl*/
                if(k==i-1){

                    /*validamos si el valor de la diagonal principal es igual a 0*/
                    if(getFraccion(matriz[i-1][k]).toString().equals("0")){ 

                        /*evaluamos la fila/columna que sea diferente de 0*/
                        int fila = evaluarCelda(i, k, matriz);

                        /*verificamos que el valor de fila sea menor que la longitud de filas de la matriz*/
                        if(fila < matriz.length){

                            /*llamamos al metodo intercambiar fila
                            le pasamos como parametro la fila actual mas el valor de la fila en el cual
                            el valor es distinto de 0*/
                            matriz = intercambiarFila(i-1, fila, matriz);

                            /*una de las propiedades de los determinantes dice que al intercambiar 
                            una fila o columna cambiamos de signo para no alterar el resultado de la determinante
                            por lo tanto almacenamos este valor en esta variable(intercambio)*/
                            intercambio=intercambio.multiplicar(getFraccion("-1/1"));
                        }
                    }                   
                }  

                /*Inicio de las operaciones de renglon*/
                /*obtenemos el factor multiplicador*/
                Fraccion factorMultiplciador = getFactorMultiplicador(matriz[i][k], matriz[k][k]);               
                /*realizamos las operaciones de renglon
                filaAModificar = -factor * filaMultiplicadora + filaAModificar*/
                for (int j = k; j < matriz.length; j++){
                    matriz[i][j] = new Fraccion(-1, 1).multiplicar(factorMultiplciador).multiplicar(getFraccion(matriz[k][j] )).sumar(getFraccion(matriz[i][j])).toString();
                }                

            }        
        }
            
        return matriz;
    }
    
    public Fraccion getDeterminante(String matriz[][]){

        Fraccion determinante=new Fraccion(1, 1);
        
        if(evaluarPropiedades(matriz)){
            
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
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
        
    public String [][] intercambiarFila(int fila1, int fila2, String [][] matriz){

         int j;
         String aux;

         for(j=0; j<matriz[0].length; j++){

             aux = matriz[fila1][j];
             matriz[fila1][j] = matriz[fila2][j];
             matriz[fila2][j] = aux;

         }

         return matriz;
    }
    
    public int evaluarCelda(int i, int k, String matriz[][]){

        int columna = k;
        int fila=i;
        while(matriz[fila][columna].equals("0")){
            fila++;
            if(fila==matriz.length){
                break;
            }
        }                         
        return fila;
    
    }
        
    public boolean evaluarPropiedades(String matriz[][]){
        
        int fila=0, columna=0, i=0;
        boolean condicion = true;
        while(i<matriz[0].length){
            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz[0].length; k++) {
                    if(getFraccion(matriz[j][k]).toString().equals("0")){
                        columna++;
                    }
                }
                if(getFraccion(matriz[j][i]).toString().equals("0")){
                    fila++;
                }
                if(columna==matriz[0].length){
                    condicion=false;
                    break;
                }
                columna=0;
            }
            if(fila==matriz.length){
                condicion=false;
                break;
            }
            fila=0;           
            i++;
        }
        return condicion;
    }
    
    
    
    
    
    
}
