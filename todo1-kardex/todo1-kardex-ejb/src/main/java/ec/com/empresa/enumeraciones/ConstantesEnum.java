
package ec.com.empresa.enumeraciones;

import lombok.Getter;
import lombok.Setter;


public enum ConstantesEnum {

    CONSTANTE("VALOR");

    @Getter
    @Setter
    private String codigo;

  
    ConstantesEnum(String codigo) {
        setCodigo(codigo);
    }
}
