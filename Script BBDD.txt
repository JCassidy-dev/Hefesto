create database hefestoData;
use hefestoData;
CREATE TABLE PROVEEDOR (
    idProveedor INT AUTO_INCREMENT PRIMARY KEY,
    cif VARCHAR(50) UNIQUE,
    nombre VARCHAR(255),
    alias VARCHAR(75) UNIQUE,
    direccion VARCHAR(255),
    telefono VARCHAR(50)
);

CREATE TABLE TARIFA (
    idTarifa INT AUTO_INCREMENT PRIMARY KEY,
    nombre_tarifa VARCHAR(100),
    fecha_vigencia DATE,
    total_productos INT
);

CREATE TABLE EMPRESA(
    idEmpresa INT AUTO_INCREMENT PRIMARY KEY,
    cif VARCHAR(50) UNIQUE,
    nombre VARCHAR(255),
    direccion VARCHAR(255)
);

CREATE TABLE PRODUCTO (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    sku VARCHAR(50) UNIQUE,
    nombre VARCHAR(255),
    alias VARCHAR(100),
    ean VARCHAR(50) UNIQUE,
    descripcion TEXT,
    precio_unitario DECIMAL(10,2),
    precio_total DECIMAL(10,2),
    stock INT,
    id_tarifa INT NULL
);
CREATE TABLE ESTADO_PEDIDO (
    idEstadoPedido INT PRIMARY KEY,
    tipoEstadoPedido VARCHAR(50)
);

CREATE TABLE PEDIDO (
    idPedido INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(50) UNIQUE,
    id_estadoPedido INT,
    id_proveedor INT
);

CREATE TABLE PRODUCTO_PEDIDO (
    idProductoPedido INT AUTO_INCREMENT PRIMARY KEY,
    estado VARCHAR(50),
    cantidad INT,
    nombre_producto VARCHAR(255),
    id_producto INT NULL,
    id_pedido INT
);
CREATE TABLE CLIENTE (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    CIF VARCHAR(50) UNIQUE,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(50),
    historico_gasto DECIMAL(12,2)
);

CREATE TABLE USUARIO (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) UNIQUE,
    clave BINARY(32),
    esAdmin BOOL
);

CREATE TABLE VENTA (
    idVenta INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(50) UNIQUE,
    fecha DATE,
    id_cliente INT,
    id_usuario INT
);

CREATE TABLE VENTA_PRODUCTO (
    idVentaProducto INT AUTO_INCREMENT PRIMARY KEY,
    precio_unitario DECIMAL(10,2),
    nombre_producto VARCHAR(255),
    cantidad INT,
    id_producto INT NULL,
    id_venta INT
);

-- ===============================
-- FOREIGN KEYS
-- ===============================

ALTER TABLE PEDIDO
ADD FOREIGN KEY (id_proveedor) REFERENCES PROVEEDOR(idProveedor);

ALTER TABLE PRODUCTO
ADD FOREIGN KEY (id_tarifa) REFERENCES TARIFA(idTarifa) 
ON DELETE SET NULL;

ALTER TABLE VENTA
ADD CONSTRAINT FOREIGN KEY (id_cliente) REFERENCES CLIENTE(idCliente);

ALTER TABLE VENTA
ADD CONSTRAINT FOREIGN KEY (id_usuario) REFERENCES USUARIO(idUsuario);

ALTER TABLE VENTA_PRODUCTO
ADD CONSTRAINT FOREIGN KEY (id_producto) REFERENCES PRODUCTO(idProducto)
ON DELETE SET NULL;

ALTER TABLE VENTA_PRODUCTO
ADD CONSTRAINT FOREIGN KEY (id_venta) REFERENCES VENTA(idVenta);

ALTER TABLE PEDIDO
ADD CONSTRAINT FOREIGN KEY (id_estadoPedido) REFERENCES ESTADO_PEDIDO(idEstadoPedido);

ALTER TABLE PRODUCTO_PEDIDO
ADD CONSTRAINT FOREIGN KEY (id_producto) REFERENCES PRODUCTO(idProducto)
ON DELETE SET NULL;

ALTER TABLE PRODUCTO_PEDIDO
ADD CONSTRAINT FOREIGN KEY (id_pedido) REFERENCES PEDIDO(idPedido);

INSERT INTO ESTADO_PEDIDO (idEstadoPedido,tipoEstadoPedido)
VALUES
(1, 'pedido realizado'),
(2, 'pedido recibido parcialmente'),
(3, 'pedido recibido completamente');