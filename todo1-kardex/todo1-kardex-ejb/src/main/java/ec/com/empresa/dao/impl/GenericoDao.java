
package ec.com.empresa.dao.impl;


import ec.com.empresa.util.ServicioExcepcion;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import lombok.Getter;
import lombok.Setter;



public class GenericoDao<T>    implements CrudGenerico<T>{

    //@EJB
//    private AuditoriaServicio<T, T, Serializable> auditoriaServicio = new AuditoriaServicio<T,T,Serializable>();
    
    @Setter
    @Getter
    private EntityManager entityManager;
    @Getter
    @Setter
    private Class<T> entity;

    public GenericoDao() {
    }

 
    public GenericoDao(Class<T> entity) {
        this.entity = entity;
    }

    @Override
    public void guardar(T t) throws ServicioExcepcion {
        try {
//            registrarAuditoria(t);
            
            T tipo = null;
            if(t.hashCode()==0){
                tipo = getEntityManager().merge(t);
                getEntityManager().flush();
          //      registrarAuditoriaBdd(tipo,t);
                
            }else{
         //       registrarAuditoriaBdd(t,t);
                getEntityManager().merge(t);
                getEntityManager().flush();
                
            }
            //registrarAuditoria(t);            
            //getEntityManager().merge(t);
            //getEntityManager().flush();
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public T guardarRetorno(T t) throws ServicioExcepcion {
        try {
//            registrarAuditoria(t);
            
               
            T tipo = null;
            if(t.hashCode()==0){
                tipo = getEntityManager().merge(t);
                getEntityManager().flush();
//                registrarAuditoriaBdd(tipo,t);                
            }else{
  //              registrarAuditoriaBdd(t,t);
                tipo = getEntityManager().merge(t);
                getEntityManager().flush();                
            }
            
            return tipo;
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public void guardarLote(List<T> lista) throws ServicioExcepcion {
        try {
            for (T en : lista) {
//                registrarAuditoria(en);
                getEntityManager().merge(en);
            }
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public T obtenerPorLlavePrimaria(Object id) throws ServicioExcepcion {
        try {
            return getEntityManager().find(getEntity(), id);
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<T> listarPorConsultaJpaNombrada(String consultaNombrada, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createNamedQuery(consultaNombrada);
            if (null != parametros) {
                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }
            }
            List<T> lista = query.getResultList();
            if (null != lista && !lista.isEmpty()) {
                return lista;
            } else {
                return new ArrayList();
            }
        } catch (Exception e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<Object> listarPorConsultaJpaNombradaObjeto(String consultaNombrada, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createNamedQuery(consultaNombrada);
            if (null != parametros && !parametros.isEmpty()) {
                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }
            }
            List<Object> lista = query.getResultList();
            if (null != lista && !lista.isEmpty()) {
                return lista;
            } else {
                return new ArrayList();
            }
        } catch (Exception e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public T obtenerPorConsultaJpaNombrada(String consultaNombrada, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createNamedQuery(consultaNombrada);
            return obtenerPorConsultaGenerico(query, parametros);
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<T> listarPorJpaConsulta(String consulta, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createQuery(consulta);
            if (null != parametros) {
                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }
            }
            List<T> lista = query.getResultList();
            if (null != lista && !lista.isEmpty()) {
                return lista;
            } else {
                return new ArrayList();
            }

        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public T obtenerPorJpaConsulta(String consulta, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createQuery(consulta);
            return obtenerPorConsultaGenerico(query, parametros);
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<T> listarPorConsultaNativa(String consultaSql, Class clase) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createNativeQuery(consultaSql, clase);
            List<T> lista = query.getResultList();
            if (null != lista && !lista.isEmpty()) {
                return lista;
            } else {
                return new ArrayList();
            }
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<Object> listarPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros) throws ServicioExcepcion {

        return listarPorConsultaNativaGenerica(consultaSql, parametros, null);

    }

    @Override
    public List<Object> listarPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros, String nombreSetResultado) throws ServicioExcepcion {

        return listarPorConsultaNativaGenerica(consultaSql, parametros, nombreSetResultado);

    }

    @Override
    public Object obtenerPorConsultaNativa(final String consultaSql, final Map<String, Object> parametros) throws ServicioExcepcion {

        List<Object> resultado = listarPorConsultaNativaGenerica(consultaSql, parametros, null);
        if (!resultado.isEmpty()) {
            return resultado.get(0);
        } else {
            return null;
        }

    }

    @Override
    public Object llamarProcedimientoOFuncion(String nombreConsulta, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createNamedQuery(nombreConsulta);
            if (null != parametros && !parametros.isEmpty()) {
                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }
            }
            List<Object> lista = query.getResultList();
            if (null != lista && !lista.isEmpty()) {
                return lista.get(0);
            } else {
                return null;
            }
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public List<Object> llamarProcedimientoOFuncionLista(String nombreConsulta, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            Query query = getEntityManager().createNamedQuery(nombreConsulta);
            if (null != parametros && !parametros.isEmpty()) {
                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }
            }
            List<Object> lista = query.getResultList();
            if (null != lista) {
                return lista;
            } else {
                return new ArrayList();
            }
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    @Override
    public void remover(T t) throws ServicioExcepcion {
        try {
            getEntityManager().remove(t);
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }

    }

    private T obtenerPorConsultaGenerico(Query query, Map<String, Object> parametros) {
        if (null != parametros) {
            for (Map.Entry en : parametros.entrySet()) {
                query.setParameter(en.getKey().toString(), en.getValue());
            }
        }
        List<T> lista = query.getResultList();
        if (null != lista && !lista.isEmpty()) {
            return lista.get(0);
        } else {
            return null;
        }

    }

    private List<Object> listarPorConsultaNativaGenerica(Query query, Map<String, Object> parametros) throws ServicioExcepcion {
        try {
            if (null != parametros && !parametros.isEmpty()) {

                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }

            }
            List<Object> lista = query.getResultList();
            if (null != lista && !lista.isEmpty()) {
                return lista;
            } else {
                return new ArrayList();
            }

        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    private List<Object> listarPorConsultaNativaGenerica(final String consultaSql, final Map<String, Object> parametros, String resulSet) throws ServicioExcepcion {
        Query query = null;
        try {
            if (null != resulSet) {
                query = getEntityManager().createNativeQuery(consultaSql, resulSet);
            } else {

                query = getEntityManager().createNativeQuery(consultaSql);
            }
            return listarPorConsultaNativaGenerica(query, parametros);
        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see ec.gob.iess.componente.comun.crud.CrudGenerico#ejecutarActualizacion(java.lang.String, java.util.Map)
     */
    @Override
    public boolean ejecutarActualizacion(String consultaNativa, Map<String, Object> parametros) throws ServicioExcepcion {

        try {
            Query query = getEntityManager().createNativeQuery(consultaNativa);
            if (null != parametros && !parametros.isEmpty()) {

                for (Map.Entry en : parametros.entrySet()) {
                    query.setParameter(en.getKey().toString(), en.getValue());
                }

            }
            int filasActualizadas = query.executeUpdate();
            if (filasActualizadas > 0) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }

        } catch (RuntimeException e) {
            throw new ServicioExcepcion(e);
        }
    }

    
   
}
