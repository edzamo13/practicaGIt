/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.empresa.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ezamora
 */
@Entity
@Table(name = "cliente", catalog = "todo1", schema = "")
@XmlRootElement
@NamedQueries({
   // @NamedQuery(name = Cliente.OBTENER_CLIENTECEDULA, query = "SELECT c FROM Cliente c ")
   })
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //  public static final String OBTENER_CLIENTECEDULA = "Producto.OBTENER_PRODUCTO";
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Column(name = "cli_nombre")
    private Integer cliNombre;
    @Size(max = 45)
    @Column(name = "cli_apellido")
    private String cliApellido;
    @Size(max = 45)
    @Column(name = "cli_direccion")
    private String cliDireccion;
    @Size(max = 45)
    @Column(name = "cli_fechaNacimiento")
    private String clifechaNacimiento;
    @Size(max = 45)
    @Column(name = "cli_telefono")
    private String cliTelefono;
    @Size(max = 45)
    @Column(name = "cli_email")
    private String cliEmail;
    @Column(name = "cli_departamento")
    private Integer cliDepartamento;
    @Column(name = "cli_cedula")
    @Getter
    @Setter
    private String cliCedula;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private List<Factura> facturaList;

    public Cliente() {
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(Integer cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliApellido() {
        return cliApellido;
    }

    public void setCliApellido(String cliApellido) {
        this.cliApellido = cliApellido;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getClifechaNacimiento() {
        return clifechaNacimiento;
    }

    public void setClifechaNacimiento(String clifechaNacimiento) {
        this.clifechaNacimiento = clifechaNacimiento;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public Integer getCliDepartamento() {
        return cliDepartamento;
    }

    public void setCliDepartamento(Integer cliDepartamento) {
        this.cliDepartamento = cliDepartamento;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.empresa.modelo.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
