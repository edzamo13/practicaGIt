package ec.com.empresa.bb;

import ec.com.empresa.modelo.Producto;
import ec.com.empresa.modelo.Tipoproducto;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import lombok.Getter;
import lombok.Setter;

@Dependent
public class ProductoBB implements Serializable {

    private static final long serialVersionUID = -3866921790148950327L;

    @Getter
    @Setter
    private Tipoproducto tipoproducto;
    @Getter
    @Setter
    private List<Tipoproducto> tipoproductos;
    @Getter
    @Setter
    private Producto producto;
      @Getter
    @Setter
    private  List<Producto> productos;
    
    @Getter
    @Setter
    private Boolean flagCargarProducto;

}
