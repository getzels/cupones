package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.319-0400")
@StaticMetamodel(Sector.class)
public class Sector_ {
	public static volatile SingularAttribute<Sector, Integer> idSector;
	public static volatile SingularAttribute<Sector, Date> fechaHoraCrea;
	public static volatile SingularAttribute<Sector, Date> fechaHoraModi;
	public static volatile SingularAttribute<Sector, String> sectorDescripcion;
	public static volatile SingularAttribute<Sector, String> usrCodigoCrea;
	public static volatile SingularAttribute<Sector, String> usrCodigoModi;
	public static volatile SingularAttribute<Sector, Provincia> provincia;
	public static volatile ListAttribute<Sector, Usuario> usuarios;
}
