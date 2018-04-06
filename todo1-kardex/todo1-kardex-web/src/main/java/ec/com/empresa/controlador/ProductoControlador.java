package ec.com.empresa.controlador;

import ec.com.empresa.bb.LoginBB;
import ec.com.empresa.bb.ProductoBB;
import ec.com.empresa.dto.Usuario;
import ec.com.empresa.modelo.Producto;
import ec.com.empresa.modelo.Tipoproducto;
import ec.com.empresa.servicio.ProductoServicio;
import ec.com.empresa.servicio.TipoProductoServicio;
import ec.com.empresa.util.ServicioExcepcion;
import ec.com.empresa.utilitario.EscuchaEnum;
import ec.com.empresa.utilitario.UtilitarioJsf;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class ProductoControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;

    @Inject
    @Getter
    @Setter
    private LoginBB loginBB;
    @Inject
    @Getter
    @Setter
    private ProductoBB productoBB;

    @EJB
    @Getter
    @Setter
    private TipoProductoServicio tipoProductoServicio;

    @EJB
    @Getter
    @Setter
    private ProductoServicio productoServicio;

    @PostConstruct
    public void inicializar() {
        try {
            validarSession();
            getLoginBB().setUsuario(new Usuario());
            getProductoBB().setTipoproducto(new Tipoproducto());
            getProductoBB().setTipoproductos(new ArrayList<Tipoproducto>());
            getProductoBB().setFlagCargarProducto(new Boolean(false));
            getProductoBB().setProducto(new Producto());
            getProductoBB().setProductos(new ArrayList<Producto>());
            obtenerTipoProducto();
        } catch (ServicioExcepcion ex) {
            Logger.getLogger(ProductoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Boolean validarSession() {

        if (getSession().getAttribute(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto()) != null) {

            getLoginBB().setUsuario((Usuario) devolverObjetosSesion(EscuchaEnum.CREDENCIAL_OBJETO_SESION.getObjeto()));

            return true;
        } else {
            redirect("/todo1-kardex-web/pages/login.jsf");
            return false;
        }
    }

    private void obtenerTipoProducto() throws ServicioExcepcion {
        getProductoBB().setTipoproductos(getTipoProductoServicio().obtenerTipoProducto());

    }

    public void seleccionarTipoProducto() throws ServicioExcepcion {
        if (getProductoBB().getTipoproducto().getIdtipoproducto() == 0) {
            ponerMensajeAlerta("Escoja una Opcion");
            getProductoBB().setFlagCargarProducto(false);
        } else {
            cargarProductos(getProductoBB().getTipoproducto());
            if (getProductoBB().getProductos().isEmpty()) {
                getProductoBB().setFlagCargarProducto(true);
                ponerMensajeAlerta("No tiene productos ");
            } else {
                getProductoBB().setFlagCargarProducto(true);
            }
        }

    }

    private void cargarProductos(Tipoproducto tipoproducto) throws ServicioExcepcion {
        getProductoBB().setProductos(getProductoServicio().obtenerProductos(tipoproducto));

    }

    public void modificarProducto() {
        RequestContext.getCurrentInstance().execute("PF('dialogProducto').show();");
    }

    public void guardar() throws ServicioExcepcion {
        getProductoServicio().guardar(getProductoBB().getProducto());
        cargarProductos(getProductoBB().getTipoproducto());
        RequestContext.getCurrentInstance().execute("PF('dialogProducto').hide();");
        ponerMensajeInfo("Registro Guardado");
    }

    public void guardarProducto() {
        RequestContext.getCurrentInstance().execute("PF('dialogAplicacion').hide();");
    }

    public void crearProducto() {
        getProductoBB().setProducto(new Producto());
        if (getProductoBB().getTipoproducto().getIdtipoproducto() == 0) {
            ponerMensajeError("Escoja un Tipo Producto");
        } else {
            getProductoBB().setProducto(new Producto());
            getProductoBB().getProducto().setIdtipoproducto(getProductoBB().getTipoproducto());
            RequestContext.getCurrentInstance().execute("PF('dialogProducto').show();");

        }

    }

}
