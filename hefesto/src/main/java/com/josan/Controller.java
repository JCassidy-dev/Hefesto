package com.josan;

import com.josan.util.Util;
import com.josan.vistas.VentanaPrincipal;
import com.josan.coreProyect.CorePublic;
import org.hibernate.SessionFactory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller implements ActionListener, ListSelectionListener {

    private VentanaPrincipal ventanaPrincipal;
    private CorePublic corePublic;
    private boolean refrescar;

    //21/04/2026 De momento se queda así cuando implemente el log in del usuario veremos cambios
    public Controller(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        corePublic = new CorePublic();
        PublicPersistance persistance = new PublicPersistance();
        construirTablaCliente(persistance.getSession());
        construirTablaProducto(persistance.getSession());
        persistance.eliminarConexion();
        refrescar = false;
        iniciar();
        addActionListener();
    }

    /**
     * Método para agregar ActionListener a todos los botones de cliente y producto.
     */
    private void addActionListener() {
        // ActionListener para botones de cliente
        ventanaPrincipal.crearClienteButton.setActionCommand("CREAR_CLIENTE");
        ventanaPrincipal.crearClienteButton.addActionListener(this);
        ventanaPrincipal.modificarClienteButton.setActionCommand("MODIFICAR_CLIENTE");
        ventanaPrincipal.modificarClienteButton.addActionListener(this);
        ventanaPrincipal.buscarClienteButton.setActionCommand("BUSCAR_CLIENTE");
        ventanaPrincipal.buscarClienteButton.addActionListener(this);
        ventanaPrincipal.limpiarClienteButton.setActionCommand("LIMPIAR_CLIENTE");
        ventanaPrincipal.limpiarClienteButton.addActionListener(this);
        ventanaPrincipal.eliminarClienteButton.setActionCommand("ELIMINAR_CLIENTE");
        ventanaPrincipal.eliminarClienteButton.addActionListener(this);
        
        // ActionListener para botones de producto
        ventanaPrincipal.crearProductoButton.setActionCommand("CREAR_PRODUCTO");
        ventanaPrincipal.crearProductoButton.addActionListener(this);
        ventanaPrincipal.modificarProductoButton.setActionCommand("MODIFICAR_PRODUCTO");
        ventanaPrincipal.modificarProductoButton.addActionListener(this);
        ventanaPrincipal.buscarProductoButton.setActionCommand("BUSCAR_PRODUCTO");
        ventanaPrincipal.buscarProductoButton.addActionListener(this);
        ventanaPrincipal.limpiarProductoButton.setActionCommand("LIMPIAR_PRODUCTO");
        ventanaPrincipal.limpiarProductoButton.addActionListener(this);
        ventanaPrincipal.eliminarProductoButton.setActionCommand("ELIMINAR_PRODUCTO");
        ventanaPrincipal.eliminarProductoButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        PublicPersistance publicPersistance = new PublicPersistance();
        switch (command) {
            case "INICIAR_SESION":
                // Lógica para iniciar sesión
                System.out.println("Iniciar sesión");
                break;
            case "CREAR_CLIENTE":
                if (validarClienteNoVacio()) {
                   HashMap <String, String> datosCliente = crearCliente();
                    try{
                        corePublic.crearCliente(datosCliente, publicPersistance.getSession());
                    } catch (Exception exception){
                       Util.showWarningAlert("Error al crear el cliente");
                    }
                } else {
                    Util.showWarningAlert("Error: Los campos de cliente no pueden estar vacíos");
                }
                borrarCamposCliente();
                construirTablaCliente( publicPersistance.getSession());

                break;
            case "BUSCAR_CLIENTE":

                break;
            case "MODIFICAR_CLIENTE":
                if (validarClienteNoVacio()) {
                    HashMap <String, String> datosCliente = crearCliente();
                    try{
                        corePublic.modificarCliente(datosCliente, publicPersistance.getSession());
                    } catch (Exception exception){
                        System.out.println(exception.getMessage());
                        Util.showWarningAlert("Error al modificar el cliente");
                    }
                } else {
                    Util.showWarningAlert("Error: Los campos de cliente no pueden estar vacíos");
                }
                borrarCamposCliente();
                construirTablaCliente( publicPersistance.getSession());
                break;
            case "LIMPIAR_CLIENTE":
                borrarCamposCliente();
                    break;
            case "ELIMINAR_CLIENTE":
                if (ventanaPrincipal.mostrarClienteTabla.getSelectedRow() == -1) {
                    Util.showWarningAlert("Error: Debe seleccionar un cliente de la tabla para eliminar");

                    break;
                }
                try {
                    int idCliente = Integer.parseInt(ventanaPrincipal.mostrarClienteTabla
                            .getValueAt(ventanaPrincipal.mostrarClienteTabla.getSelectedRow(), 0).toString());
                    corePublic.borrarCliente(idCliente, publicPersistance.getSession());
                    Util.showInfoAlert("Cliente eliminado correctamente");
                } catch (NumberFormatException nfe) {
                    Util.showWarningAlert("Error: El ID del cliente no es válido");
                } catch (Exception ex) {
                    Util.showWarningAlert("Error al eliminar el cliente: " + ex.getMessage());
                    System.out.println(ex.getMessage());
                }
                construirTablaCliente(publicPersistance.getSession());
                publicPersistance.eliminarConexion();
                break;
            case "CREAR_PRODUCTO":
                if (validarProductoNoVacio()) {
                    HashMap <String, String> datosProducto = crearProducto();
                    try{
                        corePublic.crearProducto(datosProducto, publicPersistance.getSession());
                    } catch (Exception exception){
                        Util.showWarningAlert("Error al crear el producto\n" + exception.getMessage());
                    }
                } else{
                    Util.showInfoAlert("Error: Los campos de producto no pueden estar vacíos");
                }
                borrarCamposProducto();
                construirTablaProducto(publicPersistance.getSession());
                break;
            case "MODIFICAR_PRODUCTO":
                if (validarProductoNoVacio()) {
                    HashMap <String, String> datosProducto = crearProducto();
                    try{
                        corePublic.modificarProducto(datosProducto, publicPersistance.getSession());
                    } catch (Exception exception){
                        Util.showWarningAlert("Error al modificar el producto el producto\n" + exception.getMessage());
                    }
                } else{
                    Util.showInfoAlert("Error: Los campos de producto no pueden estar vacíos");
                }
                borrarCamposProducto();
                construirTablaProducto(publicPersistance.getSession());
                break;
            case "BUSCAR_PRODUCTO":
                break;
            case "LIMPIAR_PRODUCTO":
                borrarCamposProducto();
                break;
            case "ELIMINAR_PRODUCTO":
                if (ventanaPrincipal.mostrarProductoTabla.getSelectedRow() == -1) {
                    Util.showWarningAlert("Error: Debe seleccionar un producto de la tabla para eliminar");
                    break;
                    }
                try {
                     int idProducto = Integer.parseInt(ventanaPrincipal.mostrarProductoTabla
                             .getValueAt(ventanaPrincipal.mostrarProductoTabla.getSelectedRow(), 0).toString());
                     corePublic.borrarProducto(idProducto, publicPersistance.getSession());
                     Util.showInfoAlert("Producto eliminado correctamente");
                } catch (NumberFormatException nfe) {
                    Util.showWarningAlert("Error: El ID del Producto no es válido");
                } catch (Exception ex) {
                    Util.showWarningAlert("Error al eliminar el producto: " + ex.getMessage());
                    System.out.println(ex.getMessage());
                }
                construirTablaProducto(publicPersistance.getSession());
                break;


        }
        publicPersistance.eliminarConexion();
    }

    void iniciar(){
        // Configurar selección para tabla de clientes
        ventanaPrincipal.mostrarClienteTabla.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = ventanaPrincipal.mostrarClienteTabla.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel.addListSelectionListener(this);

        // Configurar selección para tabla de productos
        ventanaPrincipal.mostrarProductoTabla.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel2 = ventanaPrincipal.mostrarProductoTabla.getSelectionModel();
        cellSelectionModel2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel2.addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            return; // Evitar procesamiento múltiple durante ajustes
        }

        ListSelectionModel source = (ListSelectionModel) e.getSource();

        // Manejar selección en tabla de clientes
        if (source.equals(ventanaPrincipal.mostrarClienteTabla.getSelectionModel())) {
            if (!source.isSelectionEmpty()) {
                int row = ventanaPrincipal.mostrarClienteTabla.getSelectedRow();
                ventanaPrincipal.idClienteTextfield.setText(String.valueOf(ventanaPrincipal.mostrarClienteTabla.getValueAt(row, 0)));
                ventanaPrincipal.nombreClienteLabel.setText(String.valueOf(ventanaPrincipal.mostrarClienteTabla.getValueAt(row, 1)));
                ventanaPrincipal.cifClienteLabel.setText(String.valueOf(ventanaPrincipal.mostrarClienteTabla.getValueAt(row, 2)));
                ventanaPrincipal.direccionClienteLabel.setText(String.valueOf(ventanaPrincipal.mostrarClienteTabla.getValueAt(row, 3)));
                ventanaPrincipal.historicoGastoTextfield.setText(String.valueOf(ventanaPrincipal.mostrarClienteTabla.getValueAt(row, 4)));
            } else if (!refrescar) {
                borrarCamposCliente();
            }
        }
        // Manejar selección en tabla de productos
        else if (source.equals(ventanaPrincipal.mostrarProductoTabla.getSelectionModel())) {
            if (!source.isSelectionEmpty()) {
                int row = ventanaPrincipal.mostrarProductoTabla.getSelectedRow();
                ventanaPrincipal.idProductoTextfield.setText(String.valueOf(ventanaPrincipal.mostrarProductoTabla.getValueAt(row, 0)));
                ventanaPrincipal.nombreProductoLabel.setText(String.valueOf(ventanaPrincipal.mostrarProductoTabla.getValueAt(row, 1)));
                ventanaPrincipal.descripcionProductoLabel.setText(String.valueOf(ventanaPrincipal.mostrarProductoTabla.getValueAt(row, 2)));
                ventanaPrincipal.precioProductoLabel.setText(String.valueOf(ventanaPrincipal.mostrarProductoTabla.getValueAt(row, 3)));
                ventanaPrincipal.productoSkuLabel.setText(String.valueOf(ventanaPrincipal.mostrarProductoTabla.getValueAt(row, 4)));
                ventanaPrincipal.aliasProductoLabel.setText(String.valueOf(ventanaPrincipal.mostrarProductoTabla.getValueAt(row, 5)));
                ventanaPrincipal.eanProductoLabel.setText(String.valueOf(ventanaPrincipal.mostrarProductoTabla.getValueAt(row, 6)));
            } else if (!refrescar) {
                borrarCamposProducto();
            }
        }
    }

    public HashMap <String,String> crearCliente() {
        String id = ventanaPrincipal.idClienteTextfield.getText();
        String nombre = ventanaPrincipal.nombreClienteLabel.getText();
        String cif = ventanaPrincipal.cifClienteLabel.getText();
        String direccion = ventanaPrincipal.direccionClienteLabel.getText();
        HashMap<String, String> datosCliente = new HashMap<>();
        datosCliente.put("id", id);
        datosCliente.put("nombre", nombre);
        datosCliente.put("cif", cif);
        datosCliente.put("direccion", direccion);
        return datosCliente;
    }

    public HashMap <String, String> crearProducto() {
        String id = ventanaPrincipal.idProductoTextfield.getText();
        String nombre = ventanaPrincipal.nombreProductoLabel.getText();
        String descripcion = ventanaPrincipal.descripcionProductoLabel.getText();
        String precio = ventanaPrincipal.precioProductoLabel.getText();
        String alias=  ventanaPrincipal.aliasProductoLabel.getText();
        String ean = ventanaPrincipal.eanProductoLabel.getText();
        String sku = ventanaPrincipal.productoSkuLabel.getText();
        HashMap<String, String> datosProducto = new HashMap<>();
        datosProducto.put("nombre", nombre);
        datosProducto.put("descripcion", descripcion);
        datosProducto.put("precio", precio);
        datosProducto.put("alias", alias);
        datosProducto.put("ean", ean);
        datosProducto.put("sku", sku);
        return datosProducto;
    }
    /**
     * Comprueba que los campos de cliente no están vacíos.
     */
    public boolean validarClienteNoVacio() {
        String nombre = ventanaPrincipal.nombreClienteLabel.getText().trim();
        String cif = ventanaPrincipal.cifClienteLabel.getText().trim();
        String direccion = ventanaPrincipal.direccionClienteLabel.getText().trim();
        return !nombre.isEmpty() && !cif.isEmpty() && !direccion.isEmpty();
    }

    public boolean validarProductoNoVacio(){
        String nombre = ventanaPrincipal.nombreProductoLabel.getText().trim();
        String descripcion = ventanaPrincipal.descripcionProductoLabel.getText().trim();
        String precio = ventanaPrincipal.precioProductoLabel.getText().trim();
        String alias=  ventanaPrincipal.aliasProductoLabel.getText().trim();
        String ean = ventanaPrincipal.eanProductoLabel.getText().trim();
        String sku = ventanaPrincipal.productoSkuLabel.getText().trim();
        return !nombre.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty() && !alias.isEmpty() && !ean.isEmpty() && !sku.isEmpty();
    }

    //Borra los campos de cliente. Tiene en cuenta que se borran los Label en  VentanaPrincipal
    public void borrarCamposCliente() {
        ventanaPrincipal.nombreClienteLabel.setText("");
        ventanaPrincipal.cifClienteLabel.setText("");
        ventanaPrincipal.direccionClienteLabel.setText("");
        ventanaPrincipal.limpiarCliente();
    }

    public void borrarCamposProducto() {
        ventanaPrincipal.nombreProductoLabel.setText("");
        ventanaPrincipal.descripcionProductoLabel.setText("");
        ventanaPrincipal.precioProductoLabel.setText("");
        ventanaPrincipal.aliasProductoLabel.setText("");
        ventanaPrincipal.eanProductoLabel.setText("");
        ventanaPrincipal.productoSkuLabel.setText("");
        ventanaPrincipal.limpiarProducto();
    }



    //recibe en un List Map los datos de los clientes, los traspasa al
    // método que genera DTM automáticamente y asigna el modelo a la tabla de clientes de la vista.
    public void construirTablaCliente(SessionFactory sessionFactory) {
        // Obtener los datos de los clientes desde la lógica de negocio
        try {
            List<Map<String, String>> listadoClientes = corePublic.obtenerClientesTabla(sessionFactory);



            // Generar el DefaultTableModel utilizando el método genérico
            DefaultTableModel dtmClientes = generarDTMGenerico(listadoClientes);

            // Asignar el modelo a la tabla de clientes en la vista
            ventanaPrincipal.mostrarClienteTabla.setModel(dtmClientes);
        } catch (Exception exception) {
            Util.showWarningAlert("Error al obtener los clientes de la tabla "+exception.getMessage());
        }
    }



    public void construirTablaProducto(SessionFactory sessionFactory) {
        try {
            List<Map<String, String>> listadoProducto = corePublic.obtenerProductosTabla(sessionFactory);

            // Generar el DefaultTableModel utilizando el método genérico
            DefaultTableModel dtmProductos = generarDTMGenerico(listadoProducto);

            // Asignar el modelo a la tabla de clientes en la vista
            ventanaPrincipal.mostrarProductoTabla.setModel(dtmProductos);
        } catch (Exception exception) {
            Util.showWarningAlert("Error al obtener los productos de la tabla "+exception.getMessage());
        }
    }
    //Método general para crear los dtm de la vista. Recibe un List Map con los datos a mostrar, extrae los nombres de las columnas del primer mapa
    // y luego llena el modelo con los datos de cada fila.
    public DefaultTableModel generarDTMGenerico(List<Map<String, String>> listadoDatos) {
        // Compruebo si está vacío para evitar errores al intentar acceder a la primera fila
        if (listadoDatos == null || listadoDatos.isEmpty()) {
            return new DefaultTableModel();
        }

        Object[] nombresColumnas = listadoDatos.get(0).keySet().toArray();

        // 2. Crear el modelo con los encabezados (no editable)
        DefaultTableModel dtm = new DefaultTableModel(nombresColumnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Las celdas no son editables
            }
        };

        // 3. Llenar las filas
        for (Map<String, String> fila : listadoDatos) {
            Object[] renglon = new Object[nombresColumnas.length];

            for (int i = 0; i < nombresColumnas.length; i++) {
                // Buscamos el valor usando el nombre de la columna actual
                renglon[i] = fila.get(nombresColumnas[i]);
            }
            dtm.addRow(renglon);
        }
        return dtm;
    }
}
