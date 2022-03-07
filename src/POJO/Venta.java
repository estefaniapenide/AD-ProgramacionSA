/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "VENTAS")
public class Venta implements Serializable {

    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "CODIGO_ARTICULO")
    private Producto codigoArticulo;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DNI_EMPLEADO")
    private Empleado dniEmpleado;

    @Id
    @Column(name = "FECHA_VENTA")
    private Date fechaVenta;

    @Id
    @Column(name = "HORA")
    private Time hora;

    @Column(name = "NUMERO_UNIDADES")
    private int numeroUnidades;

    @Column(name = "IMPORTE")
    private float importe;

    public Venta() {

    }

    public Venta(Producto codigoArticulo, Empleado dniEmpleado, Date fechaVenta, Time hora, int numeroUnidades, float importe) {
        this.codigoArticulo = codigoArticulo;
        this.dniEmpleado = dniEmpleado;
        this.fechaVenta = fechaVenta;
        this.hora = hora;
        this.numeroUnidades = numeroUnidades;
        this.importe = importe;
    }

    /**
     * @return the fechaVenta
     */
    public Date getFechaVenta() {
        return fechaVenta;
    }

    /**
     * @param fechaVenta the fechaVenta to set
     */
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * @return the hora
     */
    public Time getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     * @return the codigoArticulo
     */
    public Producto getCodigoArticulo() {
        return codigoArticulo;
    }

    /**
     * @param codigoArticulo the codigoArticulo to set
     */
    public void setCodigoArticulo(Producto codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    /**
     * @return the numeroUnidades
     */
    public int getNumeroUnidades() {
        return numeroUnidades;
    }

    /**
     * @param numeroUnidades the numeroUnidades to set
     */
    public void setNumeroUnidades(int numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    /**
     * @return the importe
     */
    public float getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(float importe) {
        this.importe = importe;
    }

}
