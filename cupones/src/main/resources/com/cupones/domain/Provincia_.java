package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-12-17T11:48:12.205-0400")
@StaticMetamodel(Provincia.class)
public class Provincia_ {
	public static volatile SingularAttribute<Provincia, Integer> idProvincia;
	public static volatile SingularAttribute<Provincia, Date> fechaHoraCrea;
	public static volatile SingularAttribute<Provincia, Date> fechaHoraModi;
	public static volatile SingularAttribute<Provincia, String> proDescripcion;
	public static volatile SingularAttribute<Provincia, String> proDescripcionCorta;
	public static volatile SingularAttribute<Provincia, String> usrCodigoCrea;
	public static volatile SingularAttribute<Provincia, String> usrCodigoModi;
	public static volatile SingularAttribute<Provincia, Pais> pais;
	public static volatile ListAttribute<Provincia, Sector> sectors;
}
