/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Estefania
 */
@Entity
@Table(name = "EMPRESAS")
@NamedQueries({
   @NamedQuery(name="empleadosEmpresa", query="select empleados from Empresa where cif=:cif"),
    @NamedQuery(name="productosEmpresa", query="select productos from Empresa where cif=:cif"),
   @NamedQuery(name="empresas", query="from Empresa")
})
public class Empresa implements Serializable {

    @Id
    @Column(name = "CIF", unique = true, nullable = false)
    private String cif;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "TELEFONO")
    private String telefono;

    @OneToMany(mappedBy = "empresa")
    private Set<Producto> productos;

    @OneToMany(mappedBy = "empresa")
    private Set<Empleado> empleados;

    public Empresa() {

    }

    public Empresa(String cif) {
        this.cif = cif;
    }

    public Empresa(String cif, String nombre, String direccion, String telefono) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * @return the cif
     */
    public String getCif() {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(String cif) {
        this.cif = cif;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

//    /**
//     * @return the productos
//     */
//    public Set<Producto> getProductos() {
//        return productos;
//    }
//
//    /**
//     * @param productos the productos to set
//     */
//    public void setProductos(Set<Producto> productos) {
//        this.productos = productos;
//    }
    /**
     * @return the empleados
     */
    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        String empresa = "CIF: " + getCif() + "\n"
                + "NOMBRE: " + getNombre() + "\n"
                + "DIRECCIÓN: " + getDireccion() + "\n"
                + "TELÉFONO: " + getTelefono() + "\n";
        return empresa;
    }
}
