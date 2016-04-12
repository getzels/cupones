package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.319-0400")
@StaticMetamodel(Pais.class)
public class Pais_ {
	public static volatile SingularAttribute<Pais, Integer> idPais;
	public static volatile SingularAttribute<Pais, Date> fechaHoraCrea;
	public static volatile SingularAttribute<Pais, Date> fechaHoraModi;
	public static volatile SingularAttribute<Pais, String> paisDescripcion;
	public static volatile SingularAttribute<Pais, String> paisDescripcionCorta;
	public static volatile SingularAttribute<Pais, String> usrCodigoCrea;
	public static volatile SingularAttribute<Pais, String> usrCodigoModi;
	public static volatile ListAttribute<Pais, Provincia> provincias;
}
