/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.dto;
package net.codejava.entity.Product;


import lombok.Data;
import net.codejava.entity.Product;

/**
 *
 * @author braya
 */
@Data
public class TrianguloDTO {
    private int id;
    private double altura;
    private double base;
    private double area;
    private double perimetro;
    public double area(){
        return altura * base / 2;
    }
    public TrianguloDTO(){
        
    }
    
     public TrianguloDTO(Product area){
        this.id=area.getId();
        this.altura=area.getAltura();
        this.base=area.getBase();
        this.area=area.getArea();
        this.perimetro= area.getPerimetro();
    }
}
