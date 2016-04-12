package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.309-0400")
@StaticMetamodel(DetalleSolicitud.class)
public class DetalleSolicitud_ {
	public static volatile SingularAttribute<DetalleSolicitud, DetalleSolicitudPK> id;
	public static volatile SingularAttribute<DetalleSolicitud, Date> fechaHoraCrea;
	public static volatile SingularAttribute<DetalleSolicitud, Date> fechaHoraModi;
	public static volatile SingularAttribute<DetalleSolicitud, Double> sodDescuento;
	public static volatile SingularAttribute<DetalleSolicitud, Double> sodItbis;
	public static volatile SingularAttribute<DetalleSolicitud, String> sodMoneda;
	public static volatile SingularAttribute<DetalleSolicitud, Double> sodMonto;
	public static volatile SingularAttribute<DetalleSolicitud, Double> sodNeto;
	public static volatile SingularAttribute<DetalleSolicitud, String> usrCodigoCrea;
	public static volatile SingularAttribute<DetalleSolicitud, String> usrCodigoModi;
	public static volatile SingularAttribute<DetalleSolicitud, Oferta> oferta;
	public static volatile SingularAttribute<DetalleSolicitud, Solicitud> solicitud;
}
