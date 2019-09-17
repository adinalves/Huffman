/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;

/**
 *
 * @author adine
 */
abstract public class HuffmanTree implements Comparable<HuffmanTree> {
    public final int frequency; // Frequência da árvore
    
    public HuffmanTree(int freq){
        frequency = freq;
    }
    
    // Compara a frequência - Implementação da Interface Comparable para a ordenação da fila
    
    public int compareTo(HuffmanTree tree){
        return frequency - tree.frequency;
    }
    
    
}
