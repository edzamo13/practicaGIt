package ec.com.empresa.controlador;

import ec.com.empresa.bb.LoginBB;
import ec.com.empresa.bb.ProductoBB;
import ec.com.empresa.dto.Usuario;
import ec.com.empresa.modelo.Tipoproducto;
import ec.com.empresa.utilitario.UtilitarioJsf;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class LoginControlador extends UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 162915581869504377L;

    @Inject
    @Getter
    @Setter
    private LoginBB loginBB;

//    @EJB
//    @Getter
//    @Setter
//    private AplicacionServicio aplicacionDaoObj;
    @PostConstruct
    public void inicializar() {
        getLoginBB().setUsuario(new Usuario());

    }

    public void validarCredenciales() throws IOException {
        if (getLoginBB().getUsuario().getUsuario().toLowerCase().equals("ezamora") && getLoginBB().getUsuario().getContrasenia().toLowerCase().equals("123")) {
            getRequest().getSession().setAttribute("usuario", getLoginBB().getUsuario());
            getExternalContext().redirect(getRequest().getContextPath() + "/pages/welcome.jsf");

        } else {
            ponerMensajeError("Usuario y Contraseña incorrectos");

        }

    }

    public void cancelar() {
        getLoginBB().setUsuario(new Usuario());

    }

}
