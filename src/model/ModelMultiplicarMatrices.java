/*
 */
package model;

/**
 *
 * @author SOFTWARE GALAXIA TV
 */
public class ModelMultiplicarMatrices extends Model{
    
    public Fraccion getFraccion(String dato){
        return new Fraccion().toFraccion(dato);
    }
        
    public String [][] multiplicar(String matrizA[][], String matrizB[][]){
        
        String matrizC[][]=new String[matrizA.length][matrizB[0].length];
    
        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC[0].length; j++) {
                
                matrizC[i][j] = "0/1";

                for (int k = 0; k < matrizA[0].length; k++) {
        
                    Fraccion f1 = getFraccion(matrizA[i][k]);
                    Fraccion f2 = getFraccion(matrizB[k][j]);    
                    
                    Fraccion aux = f1.multiplicar(f2);
                    
                    matrizC[i][j] = getFraccion(matrizC[i][j]).sumar(aux).toString();
                    
                }
            }
        }
        
                
        return matrizC;
    }
    
    
}
