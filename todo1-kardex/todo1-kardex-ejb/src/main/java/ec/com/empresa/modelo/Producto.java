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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ezamora
 */
@Entity
@Table(name = "producto", catalog = "todo1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Producto.OBTENER_PRODUCTO, query = "SELECT p FROM Producto p WHERE p.idtipoproducto.idtipoproducto=:idtipoproducto")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String OBTENER_PRODUCTO = "Producto.OBTENER_PRODUCTO";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Size(max = 45)
    @Column(name = "pr_nombre")
    private String prNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pr_precio")
    private Double prPrecio;
    @Column(name = "pr_stock")
    private Integer prStock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproducto")
    private List<DetalleFactura> detalleFacturaList;
    @JoinColumn(name = "idtipoproducto", referencedColumnName = "idtipoproducto")
    @ManyToOne(optional = false)
    private Tipoproducto idtipoproducto;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getPrNombre() {
        return prNombre;
    }

    public void setPrNombre(String prNombre) {
        this.prNombre = prNombre;
    }

    public Double getPrPrecio() {
        return prPrecio;
    }

    public void setPrPrecio(Double prPrecio) {
        this.prPrecio = prPrecio;
    }

    public Integer getPrStock() {
        return prStock;
    }

    public void setPrStock(Integer prStock) {
        this.prStock = prStock;
    }

    @XmlTransient
    public List<DetalleFactura> getDetalleFacturaList() {
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<DetalleFactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    public Tipoproducto getIdtipoproducto() {
        return idtipoproducto;
    }

    public void setIdtipoproducto(Tipoproducto idtipoproducto) {
        this.idtipoproducto = idtipoproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.empresa.modelo.Producto[ idproducto=" + idproducto + " ]";
    }

}
