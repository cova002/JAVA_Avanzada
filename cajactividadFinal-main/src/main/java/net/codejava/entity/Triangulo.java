/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author braya
 */
@Entity
@Table(name = "triangulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Triangulo.findAll", query = "SELECT t FROM Triangulo t"),
    @NamedQuery(name = "Triangulo.findById", query = "SELECT t FROM Triangulo t WHERE t.id = :id"),
    @NamedQuery(name = "Triangulo.findByBase", query = "SELECT t FROM Triangulo t WHERE t.base = :base"),
    @NamedQuery(name = "Triangulo.findByAltura", query = "SELECT t FROM Triangulo t WHERE t.altura = :altura"),
    @NamedQuery(name = "Triangulo.findByArea", query = "SELECT t FROM Triangulo t WHERE t.area = :area"),
    @NamedQuery(name = "Triangulo.findByPerimetro", query = "SELECT t FROM Triangulo t WHERE t.perimetro = :perimetro")})
public class Triangulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "base")
    private double base;
    @Basic(optional = false)
    @NotNull
    @Column(name = "altura")
    private double altura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area")
    private double area;
    @Basic(optional = false)
    @NotNull
    @Column(name = "perimetro")
    private double perimetro;

    public Triangulo() {
    }

    public Triangulo(Integer id) {
        this.id = id;
    }

    public Triangulo(Integer id, double base, double altura, double area, double perimetro) {
        this.id = id;
        this.base = base;
        this.altura = altura;
        this.area = area;
        this.perimetro = perimetro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Triangulo)) {
            return false;
        }
        Triangulo other = (Triangulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.codejava.entity.Triangulo[ id=" + id + " ]";
    }
    
}
