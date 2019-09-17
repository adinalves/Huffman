/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import java.util.Scanner;

/**
 *
 * @author adine
 */
public class Cesar {
    
    
  
        
        public static String Codificacao(String frase , int n)
        {
        
            
        //frase = frase.toLowerCase();
        char[] codigo = frase.toCharArray();
        for(int i=0;i<codigo.length;i++){
            
            
                if(((int)'a'<= (int)codigo[i] && (int)codigo[i] <=(int)'z')){
                    
                    codigo[i] = (char) ((n+(int)codigo[i]-(int)'a')%(int)('z'-'a'+1)+(int)'a');  
                    
                }
                 if(((int)'A'<= (int)codigo[i] && (int)codigo[i] <=(int)'Z')){
                    
                    codigo[i] = (char) ((n+(int)codigo[i]-(int)'A')%(int)('Z'-'A'+1)+(int)'A');  
                    
                }
                
        }
        
       String codificada = new String(codigo);
      // codificada = codificada.toUpperCase();
       return codificada;
        }
       
      
       
       public static String Decodificacao(String codificada, int n)
       {
       //codificada = codificada.toLowerCase();
       char[] decofica = codificada.toCharArray();
       for(int i=0;i<decofica.length;i++){
                if(((int)'a'<= (int)decofica[i] && (int)decofica[i] <=(int)'z')){
                    decofica[i] = (char) ((((n%26+1)*26-n%26)+(int)decofica[i]-(int)'a')%(int)('z'-'a'+1)+(int)'a');
                  
                }
                 if(((int)'A'<= (int)decofica[i] && (int)decofica[i] <=(int)'Z')){
                    decofica[i] = (char) ((((n%26+1)*26-n%26)+(int)decofica[i]-(int)'A')%(int)('Z'-'A'+1)+(int)'A');
                  
                }
        }
        String decodificada = new String (decofica);
        return decodificada;
       
       }
    
    
}
