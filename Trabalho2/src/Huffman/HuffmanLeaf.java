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
public class HuffmanLeaf extends HuffmanTree {
    public final char value; // A letra é atribuída a um nó folha
    
    public HuffmanLeaf(int freq, char val){
        super(freq);
        value = val; 
    }
}
