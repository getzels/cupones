package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.319-0400")
@StaticMetamodel(Solicitud.class)
public class Solicitud_ {
	public static volatile SingularAttribute<Solicitud, Integer> idSolicitud;
	public static volatile SingularAttribute<Solicitud, Double> descuentoSolicitud;
	public static volatile SingularAttribute<Solicitud, String> estadoSolicitud;
	public static volatile SingularAttribute<Solicitud, Date> fechaHoraCrea;
	public static volatile SingularAttribute<Solicitud, Date> fechaHoraModi;
	public static volatile SingularAttribute<Solicitud, String> fechaImpresion;
	public static volatile SingularAttribute<Solicitud, Double> itbisSolicitud;
	public static volatile SingularAttribute<Solicitud, Double> montoSolicitud;
	public static volatile SingularAttribute<Solicitud, Double> netoSolicitud;
	public static volatile SingularAttribute<Solicitud, String> observacionesSolicitud;
	public static volatile SingularAttribute<Solicitud, String> solIndTransporte;
	public static volatile SingularAttribute<Solicitud, Date> solicitudFecha;
	public static volatile SingularAttribute<Solicitud, Integer> tasaSolicitud;
	public static volatile SingularAttribute<Solicitud, String> usrCodigoCrea;
	public static volatile SingularAttribute<Solicitud, String> usrCodigoModi;
	public static volatile ListAttribute<Solicitud, DetalleSolicitud> detalleSolicituds;
	public static volatile ListAttribute<Solicitud, Pedido> pedidos;
	public static volatile SingularAttribute<Solicitud, Cliente> cliente;
}
