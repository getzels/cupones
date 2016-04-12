package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.319-0400")
@StaticMetamodel(Role.class)
public class Role_ {
	public static volatile SingularAttribute<Role, RolePK> id;
	public static volatile SingularAttribute<Role, Date> fechaHoraCrea;
	public static volatile SingularAttribute<Role, Date> fechaHoraModi;
	public static volatile SingularAttribute<Role, String> roleNombre;
	public static volatile SingularAttribute<Role, String> usrCodigoCrea;
	public static volatile SingularAttribute<Role, String> usrCodigoModi;
	public static volatile SingularAttribute<Role, Usuario> usuario;
}
