package ec.com.empresa.bb;

import ec.com.empresa.dto.Usuario;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;

@Dependent
public class LoginBB implements Serializable {

    private static final long serialVersionUID = -3866921790148950327L;

    @Getter
    @Setter
    private Usuario usuario;

}
