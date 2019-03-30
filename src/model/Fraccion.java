
package model;

public class Fraccion {

    private int numerador;
    private int denominador;

    
    public Fraccion(){
        this.numerador=0;
        this.denominador=0;
    }
    
    /*Metodo constructor de la clase, recibe dos parametros (numerador, denominador)*/
    public Fraccion(int numerador, int denominador) {
      if (denominador != 0) {
        this.numerador = numerador;
        this.denominador = denominador;
      }
    }    
    
    /*Metodos get y set */
    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
    
   /*Operaciones Basicas: SUMA, RESTA, MULTIPLICACION Y DIVISION*/
    public Fraccion sumar(Fraccion f){
        return new Fraccion(f.getNumerador() * getDenominador() + f.getDenominador() * getNumerador(), f.getDenominador() * getDenominador());
    }    

    public Fraccion restar(Fraccion f) {  
        return new Fraccion((getNumerador() * f.getDenominador()) - (getDenominador() * f.getNumerador()), f.getDenominador() * getDenominador());    
    }
       
    public Fraccion multiplicar(Fraccion f) {
        return new Fraccion(f.getNumerador() * getNumerador() , f.getDenominador() * getDenominador());
    }

    public Fraccion dividir(Fraccion f) {
        return new Fraccion(getNumerador() * f.getDenominador(), f.getNumerador() * getDenominador());        
    }    
    
        
    /*Metodos para simplificar la Fraccion resultante */
    private int mcd(Fraccion f){

        int aux_num , aux_den, mcd ;
        int num = f.getNumerador();
        int den = f.getDenominador();

        if(num != 0){

          if(num < 0){
               num = -1*num;
          }
          if(den < 0){
            den = -1*den;
          }

          if(num > den){
            aux_num = num;
            aux_den = den;
          }else{
            aux_num = den;
            aux_den = num;
          }

          mcd = aux_den;
          while(aux_den != 0){
            mcd = aux_den;
            aux_den = aux_num % aux_den;
            aux_num = mcd;
          }

        }else{
            mcd = 1;
        }
        return mcd;

   }

    private Fraccion simplificar(Fraccion f) {

        int num = mcd(f);
        f.setNumerador(f.getNumerador() / num);
        f.setDenominador(f.getDenominador() / num);
        if(f.getNumerador()<0 && f.getDenominador()<0){
            f.setNumerador(-1 * f.getNumerador());
            f.setDenominador(-1 * f.getDenominador());
        }else if(f.getNumerador() > -1 && f.getDenominador() < 0){
            f.setNumerador(-1 * f.getNumerador());
            f.setDenominador(-1 * f.getDenominador());
        }       
        
        return f;
     }
    
    
    public double toDecimal(){
        return (double) this.getNumerador() / (double) this.getDenominador();
    }


    public Fraccion toFraccion(double decimal){
    
        Fraccion newFraccion;
        String partInt = getPartInt(String.valueOf(decimal), '.');
        String partDecimal = getPartDecimal(String.valueOf(decimal), '.');
        
        int n = Integer.parseInt(partInt);
        int d = Integer.parseInt(partDecimal);   
        int factorMultiplicador = factorMultiplicador(partDecimal.length());
        
        if(n==0){
            newFraccion = new Fraccion(d, factorMultiplicador);
        }else{
            Fraccion f1 = new Fraccion(n, 1);
            Fraccion f2 = new Fraccion(d, factorMultiplicador);
            newFraccion = f1.sumar(f2);
        }
        
        return newFraccion;
    
    }

    
    public Fraccion toFraccion(String cadena){
    
        Fraccion newFraccion;
        String partNumerador = getPartInt(cadena, '/');
        String partDenominador = getPartDecimal(cadena, '/');
        
        if(partDenominador!=null){
            newFraccion = new Fraccion(Integer.parseInt(partNumerador), Integer.parseInt(partDenominador));
        }else{
            newFraccion = new Fraccion(Integer.parseInt(partNumerador), 1);
        }
        
        return newFraccion;
    
    }
    
    
    public boolean isFraccionOrNumberValue(String data){

        boolean condicion=true;
        
        int count = countSlash(data);
        
        if(count>0){
            
            if(count == 1){
                
                String partNumerador = getPartInt(data, '/');
                String partDenominador = getPartDecimal(data, '/');

                if(partDenominador!=null){
                    try{
                        
                        Integer.parseInt(partNumerador);
                        int den = Integer.parseInt(partDenominador);                
                        if(den==0){
                            condicion=false;
                        }
                        
                    }catch(NumberFormatException ex){
                        condicion=false;
                    }
                }else{

                    try{
                        Integer.parseInt(partNumerador);
                        condicion=true;
                    }catch(NumberFormatException ex){
                        condicion=false;
                    }

                }
                                
            }else{
                condicion=false;
            }
            
            
        }else{
            
            try{
                Integer.parseInt(data);
            }catch(NumberFormatException ex){
                condicion=false;
            }
            
        }
        
        
        
        return condicion;
    }
    
    private String getPartInt(String val, char character){
        int i = getCharacter(val, character);
        return val.substring(0, i);
    }
    
    private String getPartDecimal(String val, char character){
        int i=getCharacter(val, character);
        return (i<val.length()) ? val.substring(i+1, val.length()) : null;        
    }
    
    private int getCharacter(String val, char character){
        int i=0;
        while(val.charAt(i)!=character){
            i++;
            if(i==val.length()){
                break;
            }
        }
        return i;
    }

    
    private int factorMultiplicador(int longitud){

        String factorMultiplicador="1";

         for(int i=0; i<longitud; i++){  
             factorMultiplicador=factorMultiplicador+"0";
         }

         return Integer.parseInt(factorMultiplicador);

    }
    
    
    public int countSlash(String data){
        int count=0;
        for (int i = 0; i < data.length(); i++) {
            if(data.charAt(i)=='/'){
                count++;
            }
        }
        return count;
    }
    
    
    /*Funcion toString para devolver el resultado obtenido de las operaciones*/
    @Override
    public String toString(){
      
        if(this.getDenominador()!=0){
            simplificar(this);
            if(this.getDenominador()==1){
                return String.valueOf(getNumerador());
            }else{
                return getNumerador()+ "/" + getDenominador();                
            }        
        }else{
            return "El denominador debe ser distinto de 0";
        }

            
    }   

    

    
}
