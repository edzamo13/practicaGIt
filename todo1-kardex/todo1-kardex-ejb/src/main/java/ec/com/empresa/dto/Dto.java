
package ec.com.empresa.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

public class Dto implements Serializable {

    private static final long serialVersionUID = 8702945663795203275L;

    @Getter
    @Setter
    private String campo;
}
