/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;
import java.util.*;


/**
 *
 * @author adine
 */
public class HuffmanCode {
    
     int[] charFreqs;
    HuffmanTree tree;
    String texto;
    public static int[] Frequencia(String texto)
    {
        int[] charFreqs = new int[256];
        for(char c : texto.toCharArray()){
            charFreqs[c]++;
        }
        return charFreqs;
        
    }
  
    public HuffmanCode(String texto) {
        charFreqs = Frequencia(texto);
        tree = buildTree(charFreqs);
        this.texto = texto;
        
    }
    
    
    
    
    public void HuffmanResult(){
        
        System.out.println("TABELA DE CÓDIGOS: ");
        System.out.println("SÍMBOLOS\tQUANTIDADE:\tHUFFMAN CÓDIGO: ");
        printCodes(tree,new StringBuffer());
        
        
    }
    public String HuffmanCodificado(){
        
        String encode = encode(tree,texto);
        return encode;     
    }
    
    public String HuffmanDecodifcado()
    {
        
        String encode = encode(tree,texto);
        return decode(tree,encode);
    }
    public String HuffmanDecodificado(String encode)
    {
        return decode(tree,encode);
    }
    
    public static HuffmanTree buildTree(int[] charFreqs){
        // Cria uma Fila de Prioridade
        // A fila será criado pela ordem de frequência da letra no texto
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        // Criar as folhas da Árvore para cada letra
        for(int i=0;i<charFreqs.length;i++){
            
            if(charFreqs[i] > 0){
            trees.offer(new HuffmanLeaf(charFreqs[i],(char)i)); // Inser os elementos, nó folha, na fila de prioridade
            }
        }
        // Percorre todos os elementos da fila
        // Criando a ávore binária de baixo para cima
        while(trees.size() > 1) {
            // Pega os dois nós com menor frequência
            HuffmanTree a = trees.poll(); // poll - Retorna o próximo nó da Fila ou NULL 
            HuffmanTree b = trees.poll();
            
            // Criar os nós da árvore binária
            trees.offer(new HuffmanNode(a,b));   
        }
        
        // Retorna o primeiro nó da árvore
        return trees.poll();
        
    }
    
    public static String encode(HuffmanTree tree, String encode){
        assert tree !=null;
        
        String encodeText="";
        
        for(char c : encode.toCharArray()){
            encodeText +=(getCodes(tree,new StringBuffer(),c));
        }
        return encodeText;
        
    }
    
    public static String getCodes(HuffmanTree tree, StringBuffer prefix, char w){
        assert tree !=null;
        
        if(tree instanceof HuffmanLeaf){
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
            
            // Retorna o texto compactado da letra
            if(leaf.value == w) {
                return prefix.toString();
            }
            
            }else if(tree instanceof HuffmanNode){
                HuffmanNode node = (HuffmanNode)tree;
                // Percorre a esquerda
                
                prefix.append('0');
                String left = getCodes(node.left,prefix,w);
                prefix.deleteCharAt(prefix.length()-1);
                
                // Percorre a direita
                prefix.append('1');
                String right = getCodes(node.right,prefix,w);
                prefix.deleteCharAt(prefix.length()-1);
                
                if(left == null) return right; 
                else return left;
                
                
            }
            return null;
        }
     
    
    public static String decode(HuffmanTree tree, String encode){
        assert tree !=null;
        
        String decodeText="";
        
        HuffmanNode node = (HuffmanNode)tree;
        for(char code : encode.toCharArray()){
            if(code=='0') { // Quando for igual a 0 é o lado esquerdo
                if(node.left instanceof HuffmanLeaf){
                    decodeText += ((HuffmanLeaf)node.left).value; // Retorna o valor do nó folha, pelo lado esquerdo;
                    node = (HuffmanNode)tree; // Retorna a raiz da árvore
                    
                }else{
                    node = (HuffmanNode) node.left; // Continua percorrendo a árvore pelo lado esquerdo
                    
                }
            }else if(code == '1') { // Quando for igual a 1 é o lado Direito
                if(node.right instanceof HuffmanLeaf){
                    decodeText += ((HuffmanLeaf)node.right).value; // Retorna o valor do nó folha pelo Lado direito
                    node = (HuffmanNode)tree; // Retorna para a raiz da árvore
                    
                }else{
                    node = (HuffmanNode) node.right; // Continua percorrendo a árvore pelo lado Direto
                }
            }    
        }
        return decodeText; // Retorna o texto Decodificado
        
      }
    
    
    public static void printCodes(HuffmanTree tree, StringBuffer prefix){
        assert tree != null;
        
        if(tree instanceof HuffmanLeaf){
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
            
            // Imprime na tela a lista
            
            System.out.println(leaf.value+ "\t\t"+leaf.frequency+"\t\t\t"+prefix);
            
            
            
        }else if( tree instanceof HuffmanNode){
            HuffmanNode node = (HuffmanNode)tree;
            
            // traverse left
            prefix.append('0');
            printCodes(node.left,prefix);
            prefix.deleteCharAt(prefix.length()-1);
            
            // traverse right
            
            prefix.append('1');
            printCodes(node.right,prefix);
            prefix.deleteCharAt(prefix.length()-1);
               
        }    
    }
        
       
    
    
}
