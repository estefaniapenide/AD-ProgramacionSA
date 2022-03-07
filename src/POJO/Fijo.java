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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Estefania
 */
@Entity
@PrimaryKeyJoinColumn(name = "DNI_EMPLEADO")
@Table(name = "EMPLEADOS_FIJOS")
public class Fijo extends Empleado implements Serializable {

    @Column(name = "SALARIO_BASE")
    private int salarioBase;

    @Column(name = "TRIENIOS")
    private int trienios;

    @Column(name = "SUELDO")
    private float sueldo;

    public Fijo() {
        super();
    }

    public Fijo(String dni, String nombre, String telefono, float porcentajeRetencion, int salarioBase, int trienios) {
        super(dni, nombre, telefono, porcentajeRetencion);
        this.salarioBase = salarioBase;
        this.trienios = trienios;
    }

    /**
     * @return the salarioBase
     */
    public int getSalarioBase() {
        return salarioBase;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * @return the trienios
     */
    public int getTrienios() {
        return trienios;
    }

    /**
     * @param trienios the trienios to set
     */
    public void setTrienios(int trienios) {
        this.trienios = trienios;
    }

    /**
     * @return the sueldo
     */
    public float getSueldo() {
        return sueldo;
    }

    @Override
    public void calcularNomina() {
        sueldo = (salarioBase + trienios) - (salarioBase + trienios) * getPorcentajeRetencion();
    }

    @Override
    public String toString() {
        String fijo = "DNI: " + super.getDni() + "\n"
                + "NOMBRE: " + super.getNombre() + "\n"
                + "TELÉFONO: " + super.getTelefono() + "\n"
                + "PORCENTAJE DE RENTENCIÓN: " + super.getPorcentajeRetencion() + "\n"
                + "SALARIO BASE: " + getSalarioBase() + "\n"
                + "TRIENIOS: " + getTrienios() + "\n"
                + "SULEDO: " + getSueldo() + "\n";
        return fijo;
    }

}
