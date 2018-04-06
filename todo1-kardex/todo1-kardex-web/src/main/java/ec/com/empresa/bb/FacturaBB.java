package ec.com.empresa.bb;

import ec.com.empresa.dto.Usuario;
import ec.com.empresa.modelo.Cliente;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;

@Dependent
public class FacturaBB implements Serializable {

    private static final long serialVersionUID = -3866921790148950327L;

    @Getter
    @Setter
    private Cliente cliente;

}
