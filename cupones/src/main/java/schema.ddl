
    create table carrito_compras (
        ID_CLIENTE integer not null,
        ID_OFERTA integer not null,
        cantidad integer not null,
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        impuesto double precision not null,
        total double precision not null,
        USR_CODIGO_CREA varchar(255),
        USR_CODIGO_MODI varchar(255),
        VALOR_OFERTA double precision,
        primary key (ID_CLIENTE, ID_OFERTA)
    );

    create table categoria (
        ID_CATEGORIA integer not null auto_increment unique,
        CAT_ESTADO integer,
        DESCRIPCION_CATEGORIA varchar(20),
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        NOMBRE_CATEGORIA varchar(30) not null,
        USR_CODIGO_CREA varchar(15),
        USR_CODIGO_MODI varchar(20),
        primary key (ID_CATEGORIA)
    );

    create table cliente (
        ID_CLIENTE integer not null auto_increment unique,
        CLT_DIRECCION1 varchar(100) not null,
        CLT_DIRECCION2 varchar(99),
        CLT_EMAIL varchar(99),
        CLT_FECHA_HORA_CREA date not null,
        CLT_FECHA_HORA_MODI date,
        CLT_RNC varchar(20) not null,
        CLT_TELEFONO1 varchar(10),
        CLT_TELEFONO2 varchar(10),
        NOMBRE_CLIENTE varchar(40) not null,
        USR_CODIGO_CREA varchar(15) not null,
        USR_CODIGO_MODI varchar(15),
        primary key (ID_CLIENTE)
    );

    create table detalle_pedido (
        ID_PEDIDO integer not null unique,
        linea integer not null unique,
        descuento_pedido double precision not null,
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        ITBIS_PEDIDO double precision not null,
        MONEDA_MONEDA varchar(3),
        MONTO_PEDIDO double precision not null,
        NETO_PEDIDO double precision,
        USR_CODIGO_CREA varchar(15),
        USR_CODIGO_MODI varchar(15),
        primary key (ID_PEDIDO, linea)
    );

    create table detalle_solicitud (
        ID_OFERTA integer not null unique,
        ID_SOLICITUD integer not null unique,
        linea integer not null unique,
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        SOD_DESCUENTO double precision not null,
        SOD_ITBIS double precision not null,
        SOD_MONEDA varchar(3),
        SOD_MONTO double precision not null,
        SOD_NETO double precision,
        USR_CODIGO_CREA varchar(15),
        USR_CODIGO_MODI varchar(15),
        primary key (ID_OFERTA, ID_SOLICITUD, linea)
    );

    create table estado (
        ID_ESTADO integer not null auto_increment unique,
        ESTADO_DESCRIPCION varchar(30),
        primary key (ID_ESTADO)
    );

    create table fotos (
        ID_FOTOS integer not null unique,
        NOMBRE_FOTO varchar(30) not null unique,
        descripcion varchar(50) not null,
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        FOTO_ESTADO varchar(20),
        RUTA_FOTO varchar(255) not null,
        RUTA_FOTO_P varchar(200),
        USR_CODIGO_CREA varchar(15),
        USR_CODIGO_MODI varchar(15),
        ID_OFERTA integer not null,
        primary key (ID_FOTOS, NOMBRE_FOTO)
    );

    create table libro_direcciones (
        ID_DIRECCIONES integer not null,
        ID_USUARIO integer not null,
        CIUDAD varchar(255),
        CODIGO_POSTAL varchar(255),
        DIRECCION1 varchar(255),
        DIRECCION2 varchar(255),
        ID_ESTADO integer,
        ID_PAIS integer,
        ID_PROVINCIA integer,
        ID_SECTOR integer,
        NOMBRE varchar(255),
        TELEFONO varchar(255),
        primary key (ID_DIRECCIONES, ID_USUARIO)
    );

    create table oferta (
        ID_OFERTA integer not null auto_increment unique,
        AHORO_OFERTA double precision not null,
        AHORO_OFERTA_US double precision,
        DESCUETO_OFERTA integer not null,
        DETALLE_OFERTA varchar(255),
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        NOMBRE_OFERTA varchar(50) not null,
        PRECIO_OFERTA double precision not null,
        PRECIO_OFERTA_US double precision not null,
        TIEMPO_OFERTA integer,
        USR_CODIGO_CREA varchar(15) not null,
        USR_CODIGO_MODI varchar(15),
        VALOR_OFERTA double precision not null,
        VALOR_OFERTA_US double precision,
        ID_CATEGORIA integer not null,
        ID_ESTADO integer not null,
        primary key (ID_OFERTA)
    );

    create table pais (
        ID_PAIS integer not null auto_increment unique,
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        PAIS_DESCRIPCION varchar(20),
        PAIS_DESCRIPCION_CORTA varchar(20),
        USR_CODIGO_CREA varchar(15),
        USR_CODIGO_MODI varchar(15),
        primary key (ID_PAIS)
    );

    create table pedido (
        ID_PEDIDO integer not null auto_increment unique,
        DESCUENTO_PEDIDO double precision not null,
        ESTADO_PEDIDO varchar(1) not null,
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        FECHA_IMPRESION varchar(20),
        ITBIS_PEDIDO double precision not null,
        MONTO_PEDIDO double precision not null,
        NETO_PEDIDO double precision not null,
        OBSERVACIONES_PEDIDO varchar(150),
        SOLICITUD_FECHA date,
        TASA_PEDIDO integer,
        USR_CODIGO_CREA varchar(15),
        USR_CODIGO_MODI varchar(15),
        ID_SOLICITUD integer not null,
        primary key (ID_PEDIDO)
    );

    create table provincia (
        ID_PROVINCIA integer not null auto_increment unique,
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        PRO_DESCRIPCION varchar(30) not null,
        PRO_DESCRIPCION_CORTA varchar(10),
        USR_CODIGO_CREA varchar(15),
        USR_CODIGO_MODI varchar(15),
        ID_PAIS integer not null,
        primary key (ID_PROVINCIA)
    );

    create table roles (
        ID_USUARIO integer not null unique,
        ROLE_ID integer not null unique,
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        ROLE_NOMBRE varchar(20),
        USR_CODIGO_CREA varchar(15),
        USR_CODIGO_MODI varchar(15),
        primary key (ID_USUARIO, ROLE_ID)
    );

    create table sector (
        ID_SECTOR integer not null auto_increment unique,
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        SECTOR_DESCRIPCION varchar(40) not null,
        USR_CODIGO_CREA varchar(20),
        USR_CODIGO_MODI varchar(15),
        ID_PROVINCIA integer not null,
        primary key (ID_SECTOR)
    );

    create table solicitud (
        ID_SOLICITUD integer not null auto_increment unique,
        DESCUENTO_SOLICITUD double precision not null,
        ESTADO_SOLICITUD varchar(1) not null,
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        FECHA_IMPRESION varchar(20),
        ITBIS_SOLICITUD double precision not null,
        MONTO_SOLICITUD double precision not null,
        NETO_SOLICITUD double precision not null,
        OBSERVACIONES_SOLICITUD varchar(150),
        SOL_IND_TRANSPORTE varchar(1),
        SOLICITUD_FECHA date,
        TASA_SOLICITUD integer,
        USR_CODIGO_CREA varchar(15),
        USR_CODIGO_MODI varchar(15),
        ID_CLIENTE integer not null,
        primary key (ID_SOLICITUD)
    );

    create table tarjetas (
        ID_USUARIO integer not null,
        NUM_TARJETA integer not null,
        ANO_EXPIRA varchar(255),
        FECHA_HORA_CREA date,
        FECHA_HORA_MODI date,
        ID_PREFERIDA varchar(255),
        ID_TARJETA varchar(255),
        MES_EXPIRA varchar(255),
        NOMBRE varchar(255),
        USR_CODIGO_CREA varchar(255),
        USR_CODIGO_MODI varchar(255),
        primary key (ID_USUARIO, NUM_TARJETA)
    );

    create table usuario (
        ID_USUARIO integer not null auto_increment unique,
        calle varchar(40),
        contrasena varchar(200) not null,
        FECHA_HORA_CREA date not null,
        FECHA_HORA_MODI date,
        NOMBRE_USUARIO varchar(15) not null,
        NUMERO_CASO_LOCAL integer,
        PREGUNTA_SECRETA varchar(40),
        RESPUESTA_PREGUNTA varchar(88),
        USR_CODIGO_CREA varchar(15) not null,
        USR_CODIGO_MODI varchar(15),
        ID_CLIENTE integer not null,
        ID_SECTOR integer not null,
        primary key (ID_USUARIO)
    );

    alter table carrito_compras 
        add index FKCA4FDC3C874B9641 (ID_CLIENTE), 
        add constraint FKCA4FDC3C874B9641 
        foreign key (ID_CLIENTE) 
        references oferta (ID_OFERTA);

    alter table detalle_pedido 
        add index FK3979530D768FF368 (ID_PEDIDO), 
        add constraint FK3979530D768FF368 
        foreign key (ID_PEDIDO) 
        references pedido (ID_PEDIDO);

    alter table detalle_solicitud 
        add index FKC0638DDC1F2E23AA (ID_SOLICITUD), 
        add constraint FKC0638DDC1F2E23AA 
        foreign key (ID_SOLICITUD) 
        references solicitud (ID_SOLICITUD);

    alter table detalle_solicitud 
        add index FKC0638DDC7343A140 (ID_OFERTA), 
        add constraint FKC0638DDC7343A140 
        foreign key (ID_OFERTA) 
        references oferta (ID_OFERTA);

    alter table fotos 
        add index FK5D193EF7343A140 (ID_OFERTA), 
        add constraint FK5D193EF7343A140 
        foreign key (ID_OFERTA) 
        references oferta (ID_OFERTA);

    alter table oferta 
        add index FKC336EE31529E37AA (ID_ESTADO), 
        add constraint FKC336EE31529E37AA 
        foreign key (ID_ESTADO) 
        references estado (ID_ESTADO);

    alter table oferta 
        add index FKC336EE317B3268C8 (ID_CATEGORIA), 
        add constraint FKC336EE317B3268C8 
        foreign key (ID_CATEGORIA) 
        references categoria (ID_CATEGORIA);

    alter table pedido 
        add index FKC4DD17451F2E23AA (ID_SOLICITUD), 
        add constraint FKC4DD17451F2E23AA 
        foreign key (ID_SOLICITUD) 
        references solicitud (ID_SOLICITUD);

    alter table provincia 
        add index FKDF613BAD1F062A14 (ID_PAIS), 
        add constraint FKDF613BAD1F062A14 
        foreign key (ID_PAIS) 
        references pais (ID_PAIS);

    alter table roles 
        add index FK67A8EBD9E0CBD3E (ID_USUARIO), 
        add constraint FK67A8EBD9E0CBD3E 
        foreign key (ID_USUARIO) 
        references usuario (ID_USUARIO);

    alter table sector 
        add index FKC9FB57667F4B1DBC (ID_PROVINCIA), 
        add constraint FKC9FB57667F4B1DBC 
        foreign key (ID_PROVINCIA) 
        references provincia (ID_PROVINCIA);

    alter table solicitud 
        add index FKAF52BEA41479E2D6 (ID_CLIENTE), 
        add constraint FKAF52BEA41479E2D6 
        foreign key (ID_CLIENTE) 
        references cliente (ID_CLIENTE);

    alter table usuario 
        add index FKF814F32E1479E2D6 (ID_CLIENTE), 
        add constraint FKF814F32E1479E2D6 
        foreign key (ID_CLIENTE) 
        references cliente (ID_CLIENTE);

    alter table usuario 
        add index FKF814F32E80CC73AA (ID_SECTOR), 
        add constraint FKF814F32E80CC73AA 
        foreign key (ID_SECTOR) 
        references sector (ID_SECTOR);
