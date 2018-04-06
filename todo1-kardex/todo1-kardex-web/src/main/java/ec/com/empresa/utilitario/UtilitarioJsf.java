
package ec.com.empresa.utilitario;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import javax.servlet.ServletOutputStream;


public class UtilitarioJsf implements Serializable {

    private static final long serialVersionUID = 4837181833528660429L;

    public static final SelectItem SELECCIONE = new SelectItem(null, ComunEnum.SELECCIONE.getDescripcion());


    public UtilitarioJsf() {
        super();
    }

    protected void ponerMensajeInfo(final String mensaje) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje));
    }


    protected void redirect(String url) {
        try {
            getExternalContext().redirect(getRequest().getContextPath() + url);
        } catch (IOException e) {
            Log.error(getClass().getName(), ComunEnum.ERROR_REDIRECCION.getDescripcion(), e);
        }
    }




    protected static boolean validarClavePorPatron(String clave, String patron) {
        boolean valido = false;
        Pattern patronClave = Pattern.compile(patron);
        Matcher mClave = patronClave.matcher(clave);
        if (mClave.matches()) {
            valido = true;
        }
        return valido;
    }


    protected void cerrarSesion() {
        try {
            getExternalContext().redirect(getRequest().getContextPath() + "/index.xhtml");
            HttpSession session = getSession();
            session.invalidate();
        } catch (Exception e) {
            Log.error(getClass().getName(), ComunEnum.ERROR_CERRAR_SESION.getDescripcion(), e);
        }
    }

    protected static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

 
    protected void ponerMensajeInfo(final List<String> listaMensaje) {
        for (String mensaje : listaMensaje) {
            getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje));
        }
    }

 
    protected void ponerMensajeAlerta(final String mensaje) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, mensaje));
    }

  
    protected void ponerMensajeAlerta(final List<String> listaMensaje) {
        for (String mensaje : listaMensaje) {
            getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, mensaje));
        }
    }


    protected void ponerMensajeError(final String mensaje) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje));
    }

    protected void ponerMensajeErrorExcepcion(final String mensaje, final String excepcion) {
        getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, excepcion));
    }

   
    protected void ponerMensajeError(final List<String> listaMensaje) {
        for (String mensaje : listaMensaje) {
            getContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje));
        }
    }


    protected void ponerMensajeErrorComponente(final String componente, final String mensaje) {
        getContext().addMessage(componente, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", mensaje));
    }


    protected Object devolverObjetosSesion(String nombre) {
        return getRequest().getSession().getAttribute(nombre);
    }

    protected String obtenerIpHost() {

        String direccionIp = getRequest().getHeader("X-FORWARDED-FOR");
        if (direccionIp == null) {
            direccionIp = getRequest().getRemoteAddr();
        }

        return direccionIp;
    }

   
    protected FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }


    protected ExternalContext getExternalContext() {
        return getContext().getExternalContext();
    }

  
    protected ELContext getElContext() {
        return getContext().getELContext();
    }


    protected Application getApplication() {
        return getContext().getApplication();
    }

   
    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getExternalContext().getRequest();
    }

  
    protected HttpServletResponse getResponse() {
        return (HttpServletResponse) getContext().getExternalContext().getResponse();

    }

    protected File cargarArchivoUpload(byte[] contenido, String extension, String nombreArchivo) {
        try {
            File file = new File(getContext().getExternalContext().getRealPath("upload") + "/" + nombreArchivo + "." + extension);
            FileOutputStream out = new FileOutputStream(file);
            out.write(contenido);
            out.close();
            return file;
        } catch (IOException e) {
            Log.error(getClass().getName(), "Error al cargar el archivo", e);
            return null;
        }
    }

 
    protected File cargarArchivoUpload(byte[] contenido, String extension) {
        try {
            String nombreArchivo = "reporte_" + new Date().getTime();
            File file = new File(getContext().getExternalContext().getRealPath("upload") + "/" + nombreArchivo + "." + extension);
            FileOutputStream out = new FileOutputStream(file);
            out.write(contenido);
            out.close();
            return file;
        } catch (IOException e) {
            Log.error(getClass().getName(), "Error al cargar el archivo", e);
            return null;
        }
    }

    protected void reversaByte(byte[] dato, String nombre, String contentType) {
        try {
            FacesContext ctx = getContext();
            HttpServletResponse response = (HttpServletResponse) ctx.getExternalContext().getResponse();
            response.setContentType(contentType);
            response.setHeader("Content-Disposition", "attachment;filename=" + nombre + ".pdf");
            ServletOutputStream out = response.getOutputStream();
            out.write(dato);
            out.flush();
            out.close();
            ctx.responseComplete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String obtenerNavegador() {
        String userAgent = getExternalContext().getRequestHeaderMap().get("User-Agent");

        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            return "Internet Explorer";
        }

        if (userAgent.contains("Firefox")) {
            return "Firefox";
        }
        if (userAgent.contains("Chrome")) {
            return "Chrome";
        }
        if (userAgent.contains("Opera")) {
            return "Opera";
        }
        if (userAgent.contains("Safari")) {
            return "Safari";
        }
        return "Desconocido";
    }

    public String obtenerNavegador(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");

        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            return "Internet Explorer";
        }

        if (userAgent.contains("Firefox")) {
            return "Firefox";
        }
        if (userAgent.contains("Chrome")) {
            return "Chrome";
        }
        if (userAgent.contains("Opera")) {
            return "Opera";
        }
        if (userAgent.contains("Safari")) {
            return "Safari";
        }
        return "Desconocido";
    }

}
