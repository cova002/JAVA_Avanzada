package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author braya
 */
public class Area {
    private double base;
    private double altura;
    private double resultado;
    private double resultado2;
           
    public Area(String base1, String altura1){
        this.setBase(Double.parseDouble(base1));
        this.setAltura(Double.parseDouble(altura1));
       
    }

    public void calcularArea(){
        double a=this.getBase()*this.getAltura()/2;
        this.setResultado(a);
    }
    public void calcularPerimetro(){
        double p=this.getBase()*3;
        this.setResultado2(p);
    }
    public void setBase(double base) {
         this.base= base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase() {
       return base;
    }

    public double getAltura() {
        return altura;
    }

    public void setResultado(double resultado) {
       this.resultado = resultado;
    }
    public double getResultado(){
        return resultado;
    }
    public double getResultado2(){
            return resultado2;
        }

    public void setResultado2(double resultado2) {
        this.resultado2 = resultado2;}
}
