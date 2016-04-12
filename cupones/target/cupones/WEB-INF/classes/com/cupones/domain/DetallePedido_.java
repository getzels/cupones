package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.309-0400")
@StaticMetamodel(DetallePedido.class)
public class DetallePedido_ {
	public static volatile SingularAttribute<DetallePedido, DetallePedidoPK> id;
	public static volatile SingularAttribute<DetallePedido, Double> descuentoPedido;
	public static volatile SingularAttribute<DetallePedido, Date> fechaHoraCrea;
	public static volatile SingularAttribute<DetallePedido, Date> fechaHoraModi;
	public static volatile SingularAttribute<DetallePedido, Double> itbisPedido;
	public static volatile SingularAttribute<DetallePedido, String> monedaMoneda;
	public static volatile SingularAttribute<DetallePedido, Double> montoPedido;
	public static volatile SingularAttribute<DetallePedido, Double> netoPedido;
	public static volatile SingularAttribute<DetallePedido, String> usrCodigoCrea;
	public static volatile SingularAttribute<DetallePedido, String> usrCodigoModi;
	public static volatile SingularAttribute<DetallePedido, Pedido> pedido;
}
