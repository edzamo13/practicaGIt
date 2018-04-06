package ec.com.empresa.utilitario;

import java.math.RoundingMode;
import java.util.Locale;
import java.util.TimeZone;

import lombok.Getter;


public enum ComunEnum {

   
    SELECCIONE("Seleccione"),
    ERROR_CERRAR_SESION("No se puede cerrar la sesión."),
    ERROR_REDIRECCION("Url no existe."),
    SI("SI"),
    /**
     * Constantes para mostrar: NO
     */
    NO("NO");
    @Getter
    private String descripcion;

  
    public static final TimeZone TIMEZONE_ECUADOR = TimeZone.getTimeZone("America/Guayaquil");

  
    public static final Locale LOCALE_ECUADOR = new Locale("es_EC");

    public static final int NUMERO_DECIMALES = 2;

    public static final RoundingMode MODO_REDONDEO = RoundingMode.HALF_UP;


    private ComunEnum(String descripcion) {
        this.descripcion = descripcion;
    }
}
