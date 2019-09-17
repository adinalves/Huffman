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
public class HuffmanNode extends HuffmanTree{
    public final HuffmanTree left, right ; // sub -árvores 

    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency+r.frequency); 
        left = l;
        right = r;
        
    }
    
    
    
}
