package ec.com.empresa.dao;

import ec.com.empresa.dao.impl.DaoImpl;
import ec.com.empresa.modelo.Cliente;
import ec.com.empresa.util.ServicioExcepcion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteDao extends DaoImpl<Cliente> {

    public ClienteDao() {
        super(Cliente.class);
    }

//    public Cliente obtenerCliente(Cliente cliente) throws ServicioExcepcion {
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("cedula", cliente.getCliCedula());
//        List<Cliente> listClientes = getDao().listarPorConsultaJpaNombrada(Cliente.OBTENER_CLIENTECEDULA, parametros);
//        
//        if (listClientes.isEmpty()) {
//            return new Cliente();
//        } else {
//            return listClientes.get(0);
//        }
//    }

//    public Producto guardar(Producto producto) throws ServicioExcepcion {
//        return getDao().guardarRetorno(producto);
//    }

}
