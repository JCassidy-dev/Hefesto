package com.josan.vistas;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// Clase que representa la ventana principal de la aplicación, con pestañas para diferentes secciones como Clientes, Productos, etc.
public class VentanaPrincipal {
    // Panel principal que contiene todos los componentes de la interfaz
    private JPanel panel1;
    // Pestañas para organizar las diferentes secciones de la aplicación
    private JTabbedPane tabbedPane1;
    // Paneles para cada pestaña
    private JPanel panelProducto;
    private JPanel panelVentas;
    private JPanel panelBancoDatos;
    private JPanel panelPedidos;
    private JPanel panelUsuario;
    private JPanel panelAyuda;

    // Campos de texto y etiquetas para la gestión de clientes
    public JPanel panelClientes;
    public JTextField nombreClienteLabel;
    public JTextField cifClienteLabel;
    public JTextField direccionClienteLabel;
    public JButton crearClienteButton;
    public JButton modificarClienteButton;
    public JButton buscarClienteButton;
    public JButton limpiarClienteButton;
    public JButton eliminarClienteButton;
    public JLabel historicoGastoTextfield;
    public JTable mostrarClienteTabla;
    public JLabel idClienteTextfield;
    public DefaultTableModel dtmClientes;

    // Campos para la sección de Productos
    public JTextField productoSkuLabel;
    public JLabel idProductoTextfield;
    public JTextField nombreProductoLabel;
    public JTextField aliasProductoLabel;
    public JTextField eanProductoLabel;
    public JTextField descripcionProductoLabel;
    public JTextField precioProductoLabel;
    public JButton crearProductoButton;
    public JButton modificarProductoButton;
    public JButton buscarProductoButton;
    public JButton limpiarProductoButton;
    public JButton eliminarProductoButton;
    public JLabel stockProductoTextfield;
    public JTable mostrarProductoTabla;
    public DefaultTableModel dtmProductos;

    // Bloque inicializador para configurar la interfaz de usuario al crear la instancia
    {
        $$$setupUI$$$();
    }

    // Constructor que inicializa la ventana al instanciar la clase
    public VentanaPrincipal() {
        initializeWindow();
    }

    // Método generado por IntelliJ para configurar todos los componentes de la UI
    private void $$$setupUI$$$() {
        // Crear el panel principal
        panel1 = new JPanel();
        // Establecer el layout para que ocupe toda la pantalla
        panel1.setLayout(new FormLayout("fill:d:grow", "fill:d:grow"));
        // Crear el panel de pestañas
        tabbedPane1 = new JTabbedPane();
        CellConstraints cc = new CellConstraints();
        // Agregar el panel de pestañas al panel principal
        panel1.add(tabbedPane1, cc.xy(1, 1));
        // Crear el panel para Clientes
        panelClientes = new JPanel();
        // Establecer el layout para el panel de Clientes
        panelClientes.setLayout(new FormLayout("fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:grow", "center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:grow"));
        // Agregar la pestaña de Clientes
        tabbedPane1.addTab("Clientes", panelClientes);
        // Campo de texto para CIF
        cifClienteLabel = new JTextField();
        panelClientes.add(cifClienteLabel, cc.xy(3, 5, CellConstraints.FILL, CellConstraints.DEFAULT));
        // Etiqueta para Nombre
        final JLabel label1 = new JLabel();
        label1.setText("Nombre");
        panelClientes.add(label1, cc.xy(1, 3));
        // Etiqueta para CIF
        final JLabel label2 = new JLabel();
        label2.setText("CIF");
        panelClientes.add(label2, cc.xy(1, 5));
        // Etiqueta para Dirección
        final JLabel label3 = new JLabel();
        label3.setText("Dirección");
        panelClientes.add(label3, cc.xy(1, 7));
        // Campo de texto para Dirección
        direccionClienteLabel = new JTextField();
        panelClientes.add(direccionClienteLabel, cc.xy(3, 7, CellConstraints.FILL, CellConstraints.DEFAULT));
        // Etiqueta para Histórico de gasto
        final JLabel label4 = new JLabel();
        label4.setText("Histórico de gasto");
        panelClientes.add(label4, cc.xy(1, 9));
        // Etiqueta para mostrar el histórico
        historicoGastoTextfield = new JLabel();
        historicoGastoTextfield.setText("Label");
        panelClientes.add(historicoGastoTextfield, cc.xy(3, 9));
        // Botón para crear cliente
        crearClienteButton = new JButton();
        crearClienteButton.setText("Crear");
        panelClientes.add(crearClienteButton, cc.xy(1, 11));
        modificarClienteButton = new JButton();
        modificarClienteButton.setText("Modificar");
        panelClientes.add(modificarClienteButton, cc.xy(1, 13));
        // Campo de texto para Nombre
        nombreClienteLabel = new JTextField();
        panelClientes.add(nombreClienteLabel, cc.xy(3, 3, CellConstraints.FILL, CellConstraints.DEFAULT));
        // Botón para buscar cliente
        buscarClienteButton = new JButton();
        buscarClienteButton.setText("Buscar");
        panelClientes.add(buscarClienteButton, cc.xy(1, 15));
        // Botón para limpiar campos
        limpiarClienteButton = new JButton();
        limpiarClienteButton.setText("Limpiar");
        panelClientes.add(limpiarClienteButton, cc.xy(1, 17));
        // Botón para eliminar cliente
        eliminarClienteButton = new JButton();
        eliminarClienteButton.setText("Eliminar");
        panelClientes.add(eliminarClienteButton, cc.xy(1, 19));
        // Tabla para mostrar clientes
        mostrarClienteTabla = new JTable();
        JScrollPane scrollPaneClientes = new JScrollPane(mostrarClienteTabla);
        panelClientes.add(scrollPaneClientes, cc.xywh(3, 11, 1, 9, CellConstraints.FILL, CellConstraints.FILL));
        // Etiqueta para ID
        final JLabel label5 = new JLabel();
        label5.setText("ID");
        panelClientes.add(label5, cc.xy(1, 1));
        // Etiqueta para mostrar ID
        idClienteTextfield = new JLabel();
        idClienteTextfield.setText("Label");
        panelClientes.add(idClienteTextfield, cc.xy(3, 1));
        // Crear el panel para Productos
        panelProducto = new JPanel();
        // Establecer el layout para el panel de Productos
        panelProducto.setLayout(new FormLayout("fill:d:noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        // Agregar la pestaña de Producto
        tabbedPane1.addTab("Producto", panelProducto);
        // Etiqueta para ID en Productos
        final JLabel label6 = new JLabel();
        label6.setText("ID");
        panelProducto.add(label6, cc.xy(1, 1));
        // Etiqueta para Nombre
        final JLabel label7 = new JLabel();
        label7.setText("Nombre");
        panelProducto.add(label7, cc.xy(1, 3));
        // Etiqueta para Alias
        final JLabel label8 = new JLabel();
        label8.setText("Alias");
        panelProducto.add(label8, cc.xy(1, 5));
        // Etiqueta para EAN
        final JLabel label9 = new JLabel();
        label9.setText("EAN");
        panelProducto.add(label9, cc.xy(1, 7));
        // Etiqueta para mostrar ID del producto
        idProductoTextfield = new JLabel();
        idProductoTextfield.setText("Label");
        panelProducto.add(idProductoTextfield, cc.xy(3, 1));
        // Etiqueta para Código
        final JLabel label10 = new JLabel();
        label10.setText("Código");
        panelProducto.add(label10, cc.xy(5, 1));
        // Campo de texto para SKU
        productoSkuLabel = new JTextField();
        panelProducto.add(productoSkuLabel, cc.xy(7, 1, CellConstraints.FILL, CellConstraints.DEFAULT));
        // Etiqueta para Descripción
        final JLabel label11 = new JLabel();
        label11.setText("Descripción");
        panelProducto.add(label11, cc.xy(1, 9));
        // Campo de texto para Nombre del producto
        nombreProductoLabel = new JTextField();
        panelProducto.add(nombreProductoLabel, cc.xyw(3, 3, 15, CellConstraints.FILL, CellConstraints.DEFAULT));
        // Campo de texto para Alias
        aliasProductoLabel = new JTextField();
        panelProducto.add(aliasProductoLabel, cc.xyw(3, 5, 15, CellConstraints.FILL, CellConstraints.DEFAULT));
        // Campo de texto para EAN
        eanProductoLabel = new JTextField();
        panelProducto.add(eanProductoLabel, cc.xyw(3, 7, 15, CellConstraints.FILL, CellConstraints.DEFAULT));
        // Campo de texto para Descripción
        descripcionProductoLabel = new JTextField();
        panelProducto.add(descripcionProductoLabel, cc.xyw(3, 9, 15, CellConstraints.FILL, CellConstraints.DEFAULT));
        // Botón para crear producto
        crearProductoButton = new JButton();
        crearProductoButton.setText("Crear");
        panelProducto.add(crearProductoButton, cc.xy(1, 11));
        modificarProductoButton= new JButton();
        modificarProductoButton.setText("modificar");
        panelProducto.add(crearProductoButton, cc.xy(1, 13));
        // Etiqueta para Precio
        final JLabel label12 = new JLabel();
        label12.setText("Precio");
        panelProducto.add(label12, cc.xyw(9, 1, 8));
        // Campo de texto para Precio
        precioProductoLabel = new JTextField();
        panelProducto.add(precioProductoLabel, cc.xy(17, 1, CellConstraints.FILL, CellConstraints.DEFAULT));
        // Botón para buscar producto
        buscarProductoButton = new JButton();
        buscarProductoButton.setText("Buscar");
        panelProducto.add(buscarProductoButton, cc.xy(1, 15));
        // Botón para limpiar campos de producto
        limpiarProductoButton = new JButton();
        limpiarProductoButton.setText("Limpiar");
        panelProducto.add(limpiarProductoButton, cc.xy(1, 17));
        // Botón para eliminar producto
        eliminarProductoButton = new JButton();
        eliminarProductoButton.setText("Eliminar");
        panelProducto.add(eliminarProductoButton, cc.xy(1, 19));
        // Etiqueta para Stock
        final JLabel label13 = new JLabel();
        label13.setText("Stock");
        panelProducto.add(label13, cc.xy(19, 1));
        // Etiqueta para mostrar Stock
        stockProductoTextfield = new JLabel();
        stockProductoTextfield.setText("Label");
        panelProducto.add(stockProductoTextfield, cc.xy(21, 1));
        // Tabla para mostrar productos
        mostrarProductoTabla = new JTable();
        JScrollPane scrollPaneProductos = new JScrollPane(mostrarProductoTabla);
        panelProducto.add(scrollPaneProductos, cc.xywh(3, 11, 19, 7, CellConstraints.FILL, CellConstraints.FILL));
        // Crear paneles vacíos para otras pestañas
        panelVentas = new JPanel();
        panelVentas.setLayout(new FormLayout("fill:d:grow", "center:d:grow"));
        tabbedPane1.addTab("Ventas", panelVentas);
        panelBancoDatos = new JPanel();
        panelBancoDatos.setLayout(new FormLayout("fill:d:grow", "center:d:grow"));
        tabbedPane1.addTab("Banco de datos", panelBancoDatos);
        panelPedidos = new JPanel();
        panelPedidos.setLayout(new FormLayout("fill:d:grow", "center:d:grow"));
        tabbedPane1.addTab("Pedidos", panelPedidos);
        panelUsuario = new JPanel();
        panelUsuario.setLayout(new FormLayout("fill:d:grow", "center:d:grow"));
        tabbedPane1.addTab("Usuarios", panelUsuario);
        panelAyuda = new JPanel();
        panelAyuda.setLayout(new FormLayout("fill:d:grow", "center:d:grow"));
        tabbedPane1.addTab("Ayuda", panelAyuda);
    }

    // Método para obtener el componente raíz
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    // Método para inicializar y mostrar la ventana
    public void initializeWindow() {
        JFrame frame = new JFrame("Ventana Principal");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        limpiarCliente();
        limpiarProducto();
        setTableModels();
        frame.setVisible(true);
    }

    public void limpiarCliente() {
        idClienteTextfield.setText("");
        historicoGastoTextfield.setText("");
    }
    private void setTableModels() {
        this.dtmClientes =  new DefaultTableModel();
        this.mostrarClienteTabla.setModel(this.dtmClientes);

        this.dtmProductos = new DefaultTableModel();
        this.mostrarProductoTabla.setModel(this.dtmProductos);
    }
    public void limpiarProducto() {
        idProductoTextfield.setText("");
        stockProductoTextfield.setText("");
    }


}

