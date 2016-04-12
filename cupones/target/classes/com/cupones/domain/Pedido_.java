package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.319-0400")
@StaticMetamodel(Pedido.class)
public class Pedido_ {
	public static volatile SingularAttribute<Pedido, Integer> idPedido;
	public static volatile SingularAttribute<Pedido, Double> descuentoPedido;
	public static volatile SingularAttribute<Pedido, String> estadoPedido;
	public static volatile SingularAttribute<Pedido, Date> fechaHoraCrea;
	public static volatile SingularAttribute<Pedido, Date> fechaHoraModi;
	public static volatile SingularAttribute<Pedido, String> fechaImpresion;
	public static volatile SingularAttribute<Pedido, Double> itbisPedido;
	public static volatile SingularAttribute<Pedido, Double> montoPedido;
	public static volatile SingularAttribute<Pedido, Double> netoPedido;
	public static volatile SingularAttribute<Pedido, String> observacionesPedido;
	public static volatile SingularAttribute<Pedido, Date> solicitudFecha;
	public static volatile SingularAttribute<Pedido, Integer> tasaPedido;
	public static volatile SingularAttribute<Pedido, String> usrCodigoCrea;
	public static volatile SingularAttribute<Pedido, String> usrCodigoModi;
	public static volatile ListAttribute<Pedido, DetallePedido> detallePedidos;
	public static volatile SingularAttribute<Pedido, Solicitud> solicitud;
}
