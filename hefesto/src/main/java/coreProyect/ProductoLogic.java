package coreProyect;

import coreProyect.domain.Producto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.*;

public class ProductoLogic {

    public ProductoLogic() {

    }

    public void crearProducto(HashMap<String, String> proudctoData, SessionFactory sessionFactory) throws Exception {

        Producto producto = getProducto(proudctoData);
        guardar(producto, sessionFactory);

    }

    public void modificarProducto(HashMap<String, String> proudctoData, SessionFactory sessionFactory) throws Exception {
        Producto producto = getProducto(proudctoData);
        modificarProducto(producto, sessionFactory);
    }

    public void eliminarProducto(Integer id, SessionFactory sessionFactory) throws Exception {
        Producto producto = buscarProducto(id, sessionFactory);
        eliminar(producto, sessionFactory);
    }

    private void guardar(Object o, SessionFactory sessionFactory) throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        session.close();
    }

    private void eliminar(Object o, SessionFactory sessionFactory) throws Exception {
        Session sesion = sessionFactory.openSession();
        sesion.beginTransaction();
        sesion.remove(o);
        sesion.getTransaction().commit();
        sesion.close();
    }

    private Producto buscarProducto(Integer id, SessionFactory sessionFactory) {
        try (Session sesion = sessionFactory.openSession()) {

            return (Producto) sesion.createQuery("FROM Producto WHERE id = :id", Producto.class)
                    .setParameter("id", id).uniqueResult(); // Devuelve el objeto o null si no existe
        }
    }

    public void modificarProducto(Producto producto, SessionFactory sessionFactory) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.merge(producto);
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().getStatus().canRollback()) {
                    session.getTransaction().rollback();
                }
                throw new Exception("Error al actualizar: " + e.getMessage(), e);
            }
        }
    }

    private static Producto getProducto(HashMap<String, String> proudctoData) throws Exception {
        Producto producto = new Producto();
        producto.setNombre(proudctoData.get("nombre"));
        producto.setDescripcion(proudctoData.get("descripcion"));
        producto.setPrecioTotal(BigDecimal.valueOf(Double.parseDouble(proudctoData.get("precioTotal"))));
        producto.setSku(proudctoData.get("sku"));
        producto.setAlias(proudctoData.get("alias"));
        producto.setEan(proudctoData.get("ean"));
        return producto;
    }

    public List<Map<String, String>> todosLosProductos(SessionFactory sessionFactory) throws Exception {
        try (Session session = sessionFactory.openSession()) {
            List<Producto> productos = session.createQuery("from Producto", Producto.class).list();
            List<Map<String, String>> resultado = new ArrayList<>();
            for (Producto p : productos) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("idProducto", p.getId() != null ? p.getId().toString() : "");
                map.put("nombre", p.getNombre() != null ? p.getNombre() : "");
                map.put("descripcion", p.getDescripcion() != null ? p.getDescripcion() : "");
                map.put("precioTotal", p.getPrecioTotal() != null ? p.getPrecioTotal().toString() : "0.00");
                map.put("sku", p.getSku() != null ? p.getSku() : "");
                map.put("alias", p.getAlias() != null ? p.getAlias() : "");
                map.put("ean", p.getEan() != null ? p.getEan() : "");
                resultado.add(map);
            }
            return resultado;
        } catch (Exception e) {
            throw new Exception("Error al listar los productos: " + e.getMessage(), e);
        }
    }
}
