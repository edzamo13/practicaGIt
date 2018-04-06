package ec.com.empresa.utilitario;

import lombok.Getter;

public enum EscuchaEnum {
    CREDENCIAL_OBJETO_SESION("usuario");
    @Getter
    private String objeto;
    public static final Integer TIEMPO_ESPERA = 30;
    public static final Integer TIEMPO_ESPERA_SERVLET_MILISEGUNDOS = 30000;

    /**
     * <b>
     * Constructor de la clase.
     * </b>
     * <p>
     * [Author: fochoac, Date: 10/9/2015]</p>
     *
     * @param objeto cadena
     */
    private EscuchaEnum(String objeto) {
        this.objeto = objeto;
    }
}
