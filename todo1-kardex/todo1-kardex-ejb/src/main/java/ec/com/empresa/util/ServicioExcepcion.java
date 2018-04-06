
package ec.com.empresa.util;


public class ServicioExcepcion extends Exception {

    private static final long serialVersionUID = -5401498301486094378L;


    public ServicioExcepcion() {
    }

    public ServicioExcepcion(String message) {
        super(message);
    }


    public ServicioExcepcion(Throwable cause) {
        super(cause);
    }

  
    public ServicioExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

}
