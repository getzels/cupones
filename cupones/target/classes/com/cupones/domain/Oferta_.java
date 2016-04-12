package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-12-26T11:22:04.079-0400")
@StaticMetamodel(Oferta.class)
public class Oferta_ {
	public static volatile SingularAttribute<Oferta, String> idOferta;
	public static volatile SingularAttribute<Oferta, Float> ahoroOferta;
	public static volatile SingularAttribute<Oferta, Float> ahoroOfertaUs;
	public static volatile SingularAttribute<Oferta, Integer> descuetoOferta;
	public static volatile SingularAttribute<Oferta, Date> fechaHoraCrea;
	public static volatile SingularAttribute<Oferta, Date> fechaHoraModi;
	public static volatile SingularAttribute<Oferta, String> nombreOferta;
	public static volatile SingularAttribute<Oferta, Float> precioOferta;
	public static volatile SingularAttribute<Oferta, Float> precioOfertaUs;
	public static volatile SingularAttribute<Oferta, Integer> tiempoOferta;
	public static volatile SingularAttribute<Oferta, String> usrCodigoCrea;
	public static volatile SingularAttribute<Oferta, String> usrCodigoModi;
	public static volatile SingularAttribute<Oferta, Float> valorOferta;
	public static volatile SingularAttribute<Oferta, Float> valorOfertaUs;
	public static volatile SingularAttribute<Oferta, String> ofertaDescripcion;
	public static volatile ListAttribute<Oferta, DetalleSolicitud> detalleSolicituds;
	public static volatile SingularAttribute<Oferta, Categoria> categoria;
	public static volatile SingularAttribute<Oferta, Estado> estado;
	public static volatile SingularAttribute<Oferta, Foto> foto;
}
