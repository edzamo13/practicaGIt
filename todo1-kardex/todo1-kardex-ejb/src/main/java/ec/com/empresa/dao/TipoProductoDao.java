package ec.com.empresa.dao;

import ec.com.empresa.dao.impl.DaoImpl;
import ec.com.empresa.modelo.Tipoproducto;
import ec.com.empresa.util.ServicioExcepcion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TipoProductoDao extends DaoImpl<Tipoproducto> {

    public TipoProductoDao() {
        super(Tipoproducto.class);
    }

    public List<Tipoproducto> obtenerTipoProducto() throws ServicioExcepcion {
        Map<String, Object> parametros = new HashMap<>();
        //  parametros.put("idDependencia", idDependencia);        
        List<Tipoproducto> listTipoProductos = getDao().listarPorConsultaJpaNombrada(Tipoproducto.OBTENER_TIPOPRODUCTO, null);
        if (listTipoProductos.isEmpty()) {
            return new ArrayList<>();
        } else {
            return listTipoProductos;
        }
    }

//
//    public boolean guardarAplicacion(Aplicacion aplicacion) throws ServicioExcepcion {
//        
//        try{
//            getDao().guardar(aplicacion);
//
//            return true;
//        }
//        catch(Exception e){
//            Log.error(AplicacionDao.class.getName(), "Error al Guardar objeto Aplicación", e);
//            return false;
//        }
//       
//    }
}
