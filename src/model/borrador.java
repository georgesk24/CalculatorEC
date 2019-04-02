/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author de
 */
public class borrador {
 
/*        
        boolean condicion = false;
        int contador_filas = 0, i , j ;
         
         for(j=0; j<matriz[0].length-1; j++){

             for(i=contador_filas; i<matriz.length; i++){
                
                if(condicion == true){
                    
                    if(!matriz[i][j].equals("0")){
                        
                        Fraccion f = getFraccion(matriz[i][j]);
                        f = f.multiplicar(new Fraccion(-1, 1));

                        for(int k=0; k<matriz[0].length; k++){
                            
                            Fraccion val1 = getFraccion(matriz[j][k]);
                            Fraccion val2 = getFraccion(matriz[i][k]);

                            matriz[i][k]=f.multiplicar(val1).sumar(val2).toString();
                        }

                    }

                }
                    
                 if(i==j){

                     if(matriz[i][j].equals("0") && i != matriz.length-1){ 
                         
                        int columna = j;
                        int fila=i+1;
                        while(matriz[fila][columna].equals("0")){
                            fila++;
                            if(fila==matriz.length){
                                break;
                            }
                        }                         
                        
                        if(fila < matriz.length){
                            matriz = intercambiar_fila(i, fila, matriz);
                        }

                     }
                     
                    // se verifica si el numero es diferente de cero para multiplicar el numero por su inverso
                     if(!matriz[i][j].equals("0") ){ 

                            if(!matriz[i][j].equals("1")){
                                matriz = fraccion_inversa_borrador(matriz, i, j);
                            }
                            condicion = true;
                           
                    }else{

                         condicion = false;
              
                    }
                     
                                        
                 }
                 

            }
             
             contador_filas++;
             condicion = false;
         
         }

    
   public  String [][] fraccion_inversa_borrador(String [][]matriz ,  int fila, int columna ){
            
        Fraccion f = getFraccion(matriz[fila][columna]);
        f = f.inversa(f);
                       
        for(int k=0; k<matriz[0].length; k++){
            
            if(!matriz[fila][k].equals("0")){
                
                Fraccion data = getFraccion(matriz[fila][k]);
                
                Fraccion result =  f.multiplicar(data);
                
                matriz[fila][k]=result.toString();
            }
            
      }

        return matriz;
    }
    
    
    
    */         


    
    
    
}
