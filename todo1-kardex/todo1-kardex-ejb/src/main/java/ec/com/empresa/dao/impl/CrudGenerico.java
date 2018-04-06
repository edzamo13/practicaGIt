
package ec.com.empresa.dao.impl;

import ec.com.empresa.util.ServicioExcepcion;
import java.util.List;
import java.util.Map;





public interface CrudGenerico<T> {

    void guardar(final T t) throws ServicioExcepcion;

    T guardarRetorno(final T t) throws ServicioExcepcion;

    void guardarLote(final List<T> lista) throws ServicioExcepcion;

  
    T obtenerPorLlavePrimaria(final Object id) throws ServicioExcepcion;


    List<T> listarPorConsultaJpaNombrada(final String consultaNombrada, final Map<String, Object> parametros)
            throws ServicioExcepcion;

 
    T obtenerPorConsultaJpaNombrada(final String consultaNombrada, final Map<String, Object> parametros)
            throws ServicioExcepcion;

 
    List<T> listarPorJpaConsulta(final String consulta, final Map<String, Object> parametros) throws ServicioExcepcion;

  
    T obtenerPorJpaConsulta(final String consulta, final Map<String, Object> parametros) throws ServicioExcepcion;


    List<T> listarPorConsultaNativa(final String consultaSql, final Class clase) throws ServicioExcepcion;

   
    List<Object> listarPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros)
            throws ServicioExcepcion;

    
    Object obtenerPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros)
            throws ServicioExcepcion;

    
    Object llamarProcedimientoOFuncion(final String nombreConsulta, final Map<String, Object> parametros)
            throws ServicioExcepcion;

    Object llamarProcedimientoOFuncionLista(final String nombreConsulta, final Map<String, Object> parametros)
            throws ServicioExcepcion;

    void remover(final T t) throws ServicioExcepcion;

    
    List<Object> listarPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros,
            final String nombreSetResultado) throws ServicioExcepcion;

   
    public List<Object> listarPorConsultaJpaNombradaObjeto(final String consultaNombrada,
            final Map<String, Object> parametros) throws ServicioExcepcion;

   
    public boolean ejecutarActualizacion(final String consultaNativa, final Map<String, Object> parametros)
            throws ServicioExcepcion;
}
