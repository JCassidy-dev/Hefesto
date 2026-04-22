package coreProyect;

import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorePublic {
    
    private ClienteLogic logicCliente;
    private ProductoLogic logicProducto;
    public CorePublic() {
        logicCliente = new ClienteLogic();
        logicProducto = new ProductoLogic();
    }
    //CLIENTE
    public void crearCliente(HashMap<String, String> clienteData, SessionFactory sessionFactory) throws Exception {
        logicCliente.crearCliente(clienteData, sessionFactory);

    }

    public List<Map<String, String>> obtenerClientesTabla(SessionFactory sessionFactory) throws Exception {
        return logicCliente.todosLosClientes(sessionFactory);
    }

    public void borrarCliente(Integer idCliente,  SessionFactory sessionFactory) throws Exception {

        logicCliente.eliminarCliente(idCliente, sessionFactory);

    }


    //PRODUCTO
    public void crearProducto(HashMap<String, String> productoData, SessionFactory sessionFactory) throws Exception {
        logicProducto.crearProducto(productoData, sessionFactory);

    }

    public List<Map<String, String>> obtenerProductosTabla(SessionFactory sessionFactory) throws Exception {
        return logicProducto.todosLosProductos(sessionFactory);
    }

    public void borrarProducto(Integer idProducto,  SessionFactory sessionFactory) throws Exception {

        logicProducto.eliminarProducto(idProducto, sessionFactory);

    }
}
