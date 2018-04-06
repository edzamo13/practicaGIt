package ec.com.empresa.dao;

import ec.com.empresa.dao.impl.DaoImpl;
import ec.com.empresa.modelo.Factura;
import ec.com.empresa.modelo.Producto;
import ec.com.empresa.modelo.Tipoproducto;
import ec.com.empresa.util.ServicioExcepcion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacturaDao extends DaoImpl<Factura> {

    public FacturaDao() {
        super(Factura.class);
    }

////    public List<Producto> obtenerProductos(Tipoproducto tipoproducto) throws ServicioExcepcion {
////        Map<String, Object> parametros = new HashMap<>();
////        parametros.put("idtipoproducto", tipoproducto.getIdtipoproducto());
////        List<Producto> listProductos = getDao().listarPorConsultaJpaNombrada(Producto.OBTENER_PRODUCTO, parametros);
////        if (listProductos.isEmpty()) {
////            return new ArrayList<>();
////        } else {
////            return listProductos;
////        }
////    }
//
//    public Producto guardar(Producto producto) throws ServicioExcepcion {
//        return getDao().guardarRetorno(producto);
//    }

}
