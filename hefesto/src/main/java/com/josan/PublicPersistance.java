package com.josan;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import coreProyect.domain.Cliente;
import coreProyect.domain.Producto;
import coreProyect.domain.Usuario;
import com.josan.pedido.Pedido;
import com.josan.pedido.ProductoPedido;
import com.josan.pedido.Proveedor;
import coreProyect.venta.Venta;
import coreProyect.venta.VentaProducto;

/**
 * Clase para manejar la persistencia con Hibernate.
 * Se instancia en Controller cuando se necesite.
 */
public class PublicPersistance {

    private SessionFactory sessionFactory;

    /**
     * Constructor de la clase PublicPersistance.
     * Inicializa la instancia sin configuración.
     */
    public PublicPersistance() {
        conectar();
    }

    /**
     * Método para conectar y configurar Hibernate.
     * Configura hibernate.cfg.xml y añade las clases anotadas para el mapeo.
     */
    public void conectar() {
        try {
            Configuration configuration = new Configuration().configure();
            // Añadir clases anotadas para el mapeo
            configuration.addAnnotatedClass(Cliente.class);
            configuration.addAnnotatedClass(Producto.class);
            configuration.addAnnotatedClass(Usuario.class);
            configuration.addAnnotatedClass(Pedido.class);
            configuration.addAnnotatedClass(ProductoPedido.class);
            configuration.addAnnotatedClass(Proveedor.class);
            configuration.addAnnotatedClass(Venta.class);
            configuration.addAnnotatedClass(VentaProducto.class);
            // Construir el SessionFactory
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar con Hibernate: " + e.getMessage());
        }
    }

    public SessionFactory getSession() {
        return sessionFactory;
    }
    /**
     * Método para eliminar la conexión con Hibernate.
     * Cierra el SessionFactory si está abierto.
     */
    public void eliminarConexion() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
