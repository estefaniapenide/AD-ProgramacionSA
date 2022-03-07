/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Estefania
 */
@Entity
@Table(name="EMPLEADOS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Empleado implements Serializable{
    
    @Id
    @Column(name="DNI",unique=true,nullable=false)
    private String dni;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="TELEFONO")
    private String telefono;
    
    @Column(name="PORCENTAJE_RETENCION")
    private float porcentajeRetencion;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CIF_EMPRESA")
    private Empresa empresa;


    public Empleado() {

    }

    public Empleado(String dni, String nombre, String telefono, float porcentajeRetencion) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.porcentajeRetencion = porcentajeRetencion;
    }


    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the porcentajeRetencion
     */
    public float getPorcentajeRetencion() {
        return porcentajeRetencion;
    }

    /**
     * @param porcentajeRetencion the porcentajeRetencion to set
     */
    public void setPorcentajeRetencion(float porcentajeRetencion) {
        this.porcentajeRetencion = porcentajeRetencion;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void calcularNomina() {}

}
