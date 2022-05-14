/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author braya
 */
@Entity
@Table(name = "imc3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imc.findAll", query = "SELECT i FROM Imc i"),
    @NamedQuery(name = "Imc.findById", query = "SELECT i FROM Imc i WHERE i.id = :id"),
    @NamedQuery(name = "Imc.findByNombreuser", query = "SELECT i FROM Imc i WHERE i.nombreuser = :nombreuser"),
    @NamedQuery(name = "Imc.findByEstatura", query = "SELECT i FROM Imc i WHERE i.estatura = :estatura"),
    @NamedQuery(name = "Imc.findByPeso", query = "SELECT i FROM Imc i WHERE i.peso = :peso"),
    @NamedQuery(name = "Imc.findByImc", query = "SELECT i FROM Imc i WHERE i.imc = :imc"),
    @NamedQuery(name = "Imc.findByFecha", query = "SELECT i FROM Imc i WHERE i.fecha = :fecha")})
public class Imc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombreuser")
    private String nombreuser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatura")
    private double estatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private double peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "imc")
    private double imc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fecha")
    private String fecha;

    public Imc() {
    }

    public Imc(Integer id) {
        this.id = id;
    }

    public Imc(Integer id, String nombreuser, double estatura, double peso, double imc, String fecha) {
        this.id = id;
        this.nombreuser = nombreuser;
        this.estatura = estatura;
        this.peso = peso;
        this.imc = imc;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreuser() {
        return nombreuser;
    }

    public void setNombreuser(String nombreuser) {
        this.nombreuser = nombreuser;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof Imc)) {
            return false;
        }
        Imc other = (Imc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.codejava.entity.Imc[ id=" + id + " ]";
    }
    
}
