/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Estefania
 */
@Entity
@PrimaryKeyJoinColumn(name = "DNI_EMPLEADO")
@Table(name = "EMPLEADOS_TEMPORALES")
public class Temporal extends Empleado implements Serializable {

    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;

    @Column(name = "FECHA_FIN")
    private Date fechaFin;

    @Column(name = "PAGO_DIA")
    private float pagoDia;

    @Column(name = "SUPLEMENTO")
    private float suplemento;

    @Column(name = "SULEDO")
    private float sueldo;

    @OneToMany(mappedBy = "dniEmpleado")
    private Set<Venta> ventas;

    public Temporal() {
        super();
    }

    public Temporal(String dni, String nombre, String telefono, float porcentajeRetencion, Date fechaInicio, Date fechaFin, float pagoDia) {
        super(dni, nombre, telefono, porcentajeRetencion);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pagoDia = pagoDia;

    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the pagoDia
     */
    public float getPagoDia() {
        return pagoDia;
    }

    /**
     * @param pagoDia the pagoDia to set
     */
    public void setPagoDia(float pagoDia) {
        this.pagoDia = pagoDia;
    }

    /**
     * @return the sueldo
     */
    public float getSueldo() {
        return sueldo;
    }

//    /**
//     * @return the ventas
//     */
//    public Set<Venta> getVentas() {
//        return ventas;
//    }
//
//    /**
//     * @param ventas the ventas to set
//     */
//    public void setVentas(Set<Venta> ventas) {
//        this.ventas = ventas;
//    }
    /**
     * @return the suplemento
     */
    public float getSuplemento() {
        return suplemento;
    }

    /**
     * @param suplemento the suplemento to set
     */
    public void setSuplemento(float suplemento) {
        this.suplemento = suplemento;
    }

    @Override
    public void calcularNomina() {//Ver bien lo de la fecha, pero creo que así funciona
        sueldo = pagoDia * ((fechaFin.getTime() - fechaInicio.getTime()) / (1000 * 60 * 60 * 24)) - pagoDia * ((fechaFin.getTime() - fechaInicio.getTime()) / (1000 * 60 * 60 * 24)) * getPorcentajeRetencion() + getSuplemento();
    }

    @Override
    public String toString() {
        String temporal = "DNI: " + super.getDni() + "\n"
                + "NOMBRE: " + super.getNombre() + "\n"
                + "TELÉFONO: " + super.getTelefono() + "\n"
                + "PORCENTAJE DE RENTENCIÓN: " + super.getPorcentajeRetencion() + "\n"
                + "FECHA DE INICIO: " + getFechaInicio() + "\n"
                + "FECHA DE FIN: " + getFechaFin() + "\n"
                + "PAGO DÍA: " + getPagoDia() + "\n"
                + "SUPLEMENTO: " + getSuplemento() + "\n"
                + "SUELDO: " + getSueldo() + "\n";
        return temporal;
    }

}
