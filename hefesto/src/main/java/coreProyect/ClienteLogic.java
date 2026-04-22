package coreProyect;

import coreProyect.domain.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClienteLogic {
    //OJO QUE LA CONFIGURACIÓN DEL FICHERO XML.HIBERNATE ESTÁ MOMENTANEAMENTE EN PUBLIC PERSISTANCE PERO VENDRÁ AQUÍ
    public ClienteLogic() {
        
    }
    
    /**
     * Crea un cliente con los datos proporcionados y lo guarda en la base de datos.
     */
    public void crearCliente(HashMap<String, String> clienteData, SessionFactory sessionFactory) throws Exception {

        Cliente cliente = getCliente(clienteData);
        guardar(cliente, sessionFactory);
    }
    private void guardar( Object o, SessionFactory sessionFactory) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        session.close();
    }

    public void modificarCliente(HashMap<String, String> clienteData, SessionFactory sessionFactory) throws Exception {
        Cliente cliente = getCliente(clienteData);
        modificarCliente(cliente, sessionFactory);
    }

    public void eliminarCliente(Integer id, SessionFactory sessionFactory) throws Exception {
        Cliente cliente = buscarCliente(id, sessionFactory);
        eliminar(cliente, sessionFactory);
    }



    private void eliminar(Object o, SessionFactory sessionFactory) throws Exception {
        Session sesion = sessionFactory.openSession();
        sesion.beginTransaction();
        sesion.remove(o);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void modificarCliente(Cliente cliente, SessionFactory sessionFactory) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.merge(cliente);
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().getStatus().canRollback()) {
                    session.getTransaction().rollback();
                }
                throw new Exception("Error al actualizar: " + e.getMessage(), e);
            }
        }
    }
    //Localiza un cliente en la base de datos para eliminarlo.
    private Cliente buscarCliente(Integer id, SessionFactory sessionFactory) {
        try (Session sesion = sessionFactory.openSession()) {

            return (Cliente) sesion.createQuery("FROM Cliente WHERE id = :id", Cliente.class)
                    .setParameter("id", id).uniqueResult(); // Devuelve el objeto o null si no existe
        }
    }


    private static Cliente getCliente(HashMap<String, String> clienteData) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteData.get("nombre"));
        cliente.setCif(clienteData.get("cif"));
        cliente.setDireccion(clienteData.get("direccion"));
        return cliente;
    }

//Extrae todos los clientes a un ArrayList de Map<String, String> para mostrar en la tabla de la vista. Cada Map representa un cliente.
    public List<Map<String, String>> todosLosClientes(SessionFactory sessionFactory) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            List<Cliente> clientes = session.createQuery("from Cliente", Cliente.class).list();
            List<Map<String, String>> resultado = new ArrayList<>();
            for (Cliente c : clientes) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("idCliente", c.getId() != null ? c.getId().toString() : "");
                map.put("nombre", c.getNombre() != null ? c.getNombre() : "");
                map.put("CIF", c.getCif() != null ? c.getCif() : "");
                map.put("direccion", c.getDireccion() != null ? c.getDireccion() : "");
                map.put("historico_gasto", c.getHistoricoGasto() != null ? c.getHistoricoGasto().toString() : "0.00");
                resultado.add(map);
            }

            return resultado;
        } catch (Exception e) {
           throw new Exception("Error al listar los clientes: " + e.getMessage(), e);
        }
    }


}
