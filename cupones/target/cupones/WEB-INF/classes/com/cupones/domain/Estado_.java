package com.cupones.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.319-0400")
@StaticMetamodel(Estado.class)
public class Estado_ {
	public static volatile SingularAttribute<Estado, Integer> idEstado;
	public static volatile SingularAttribute<Estado, String> estadoDescripcion;
	public static volatile ListAttribute<Estado, Oferta> ofertas;
}
