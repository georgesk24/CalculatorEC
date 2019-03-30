/*
 */
package model;

/**
 *
 * @author SOFTWARE GALAXIA
 */
public class ModelRestarMatrices extends Model{
    
    public Fraccion getFraccion(String dato){
        return new Fraccion().toFraccion(dato);
    }
        
    public String [][] restar(String matrizA[][], String matrizB[][]){
        
        String matrizC[][]=new String[matrizA.length][matrizA[0].length];
    
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                
                Fraccion f1 = getFraccion(matrizA[i][j]);
                Fraccion f2 = getFraccion(matrizB[i][j]);    
                                
                matrizC[i][j] = f1.restar(f2).toString();
                
            }
        }
        
        return matrizC;
    }
    
    
}
