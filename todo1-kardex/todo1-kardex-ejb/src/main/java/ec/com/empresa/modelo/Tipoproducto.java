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

/**
 *
 * @author ezamora
 */
@Entity
@Table(name = "tipoproducto", catalog = "todo1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Tipoproducto.OBTENER_TIPOPRODUCTO, query = "SELECT t FROM Tipoproducto t")})
public class Tipoproducto implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String OBTENER_TIPOPRODUCTO = "Tipoproducto.OBTENER_TIPOPRODUCTO";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoproducto")
    private Integer idtipoproducto;
    @Size(max = 45)
    @Column(name = "tp_nombre")
    private String tpNombre;
    @Size(max = 45)
    @Column(name = "tp_detalle")
    private String tpDetalle;
    @Size(max = 45)
    @Column(name = "tp_observacion")
    private String tpObservacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoproducto")
    private List<Producto> productoList;

    public Tipoproducto() {
    }

    public Tipoproducto(Integer idtipoproducto) {
        this.idtipoproducto = idtipoproducto;
    }

    public Integer getIdtipoproducto() {
        return idtipoproducto;
    }

    public void setIdtipoproducto(Integer idtipoproducto) {
        this.idtipoproducto = idtipoproducto;
    }

    public String getTpNombre() {
        return tpNombre;
    }

    public void setTpNombre(String tpNombre) {
        this.tpNombre = tpNombre;
    }

    public String getTpDetalle() {
        return tpDetalle;
    }

    public void setTpDetalle(String tpDetalle) {
        this.tpDetalle = tpDetalle;
    }

    public String getTpObservacion() {
        return tpObservacion;
    }

    public void setTpObservacion(String tpObservacion) {
        this.tpObservacion = tpObservacion;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoproducto != null ? idtipoproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoproducto)) {
            return false;
        }
        Tipoproducto other = (Tipoproducto) object;
        if ((this.idtipoproducto == null && other.idtipoproducto != null) || (this.idtipoproducto != null && !this.idtipoproducto.equals(other.idtipoproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.empresa.modelo.Tipoproducto[ idtipoproducto=" + idtipoproducto + " ]";
    }

}
