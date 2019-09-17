/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import Huffman.*;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 *
 * @author adine
 */
public class Trabalho2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
        Scanner input = new Scanner(System.in);
        
      // ABRINDO O ARQUIVO texto.txt
     
       String texto = "";
       try{
           FileReader arq = new FileReader("texto.txt");
           BufferedReader lerArq = new BufferedReader(arq);
           String linha = lerArq.readLine();
           while(linha!=null){
           texto = texto + linha;
           linha = lerArq.readLine();
          
       }
          arq.close();
       } catch(IOException e){
            System.err.printf("Erro na abertura do arquivo %s.\n", e.getMessage());
    }
       // TEXTO LIDO NO ARQUIVO 
       System.out.println(texto);
       
       // REALIZANDO A CRIPTOGRAFIA DE CESAR
       System.out.println("Digite o numero de rotações para Criptografia de Cesar:");
       int n;
       n = input.nextInt();
       String textoCesar = Cesar.Codificacao(texto, n);
       
       // IMPRIMINDO O RESULTADO DA CODIFICAÇÃO DE CÉSAR
       System.out.println("CODIFICAÇÃO DE CÉSAR: "+ textoCesar);
       
       // CODIFICAÇÃO DE HUFFMAN SOBRE O TEXTO CIFRADO
       
       
       
      Huffman.HuffmanCode huf = new Huffman.HuffmanCode(textoCesar);
      System.out.println("RESULTADO DA CODIFICAÇÃO DE HUFFMAN: ");
      huf.HuffmanResult();
      
      System.out.println("CODIFIÇÃO DE HUFFMAN: ");
      System.out.println(huf.HuffmanCodificado());
      
      // SALVANDO O NO ARQUIVO TEXTO1 A CODIFICACAO DE HUFFMAN
      
      try{
      FileWriter arq = new FileWriter("texto1.txt");
      PrintWriter gravarArq = new PrintWriter(arq);
      gravarArq.printf(huf.HuffmanCodificado());
      
      arq.close();
      }catch(IOException e){
          System.err.printf("Erro em salvar o arquivo %s.\n",e.getMessage());
      }
      
      
      
      // LEITURA DO ARQUIVO TEXTO1 
      String texto1="";
           try{
           FileReader arq = new FileReader("texto1.txt");
           BufferedReader lerArq = new BufferedReader(arq);
           String linha = lerArq.readLine();
           while(linha!=null){
           texto1 = texto1 + linha;
           linha = lerArq.readLine();
          
       }
          arq.close();
       } catch(IOException e){
            System.err.printf("Erro na abertura do arquivo %s.\n", e.getMessage());
    }
      
    
      
      // DECODIFICAÇÃO DE HUFFMAN
      System.out.println("DECODIFICAÇÃO DE HUFFMAN:");
      System.out.println(huf.HuffmanDecodificado(texto1));
      System.out.println("DECOFICAÇÃO DE CESAR");
      System.out.println(Cesar.Decodificacao(huf.HuffmanDecodifcado(), n));
   
      
      
       
}
    
    
}
