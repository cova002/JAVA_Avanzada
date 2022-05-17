/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author braya
 */
public class triangulo {
    
    public int Area(int bas, int alt){
        
        int baseChida = (bas * alt) / 2;
        
        return baseChida;
    }
    
    
    public int Perimetro(int l1, int l2, int l3){
        
        int perimetroChido = (l1 + l2 + l3);
        
        return perimetroChido;
    }
    
}
