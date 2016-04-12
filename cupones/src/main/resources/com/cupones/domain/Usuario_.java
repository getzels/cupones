package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.380-0400")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, Integer> idUsuario;
	public static volatile SingularAttribute<Usuario, String> calle;
	public static volatile SingularAttribute<Usuario, String> contrasena;
	public static volatile SingularAttribute<Usuario, Date> fechaHoraCrea;
	public static volatile SingularAttribute<Usuario, Date> fechaHoraModi;
	public static volatile SingularAttribute<Usuario, String> nombreUsuario;
	public static volatile SingularAttribute<Usuario, Integer> numeroCasoLocal;
	public static volatile SingularAttribute<Usuario, String> preguntaSecreta;
	public static volatile SingularAttribute<Usuario, String> respuestaPregunta;
	public static volatile SingularAttribute<Usuario, String> usrCodigoCrea;
	public static volatile SingularAttribute<Usuario, String> usrCodigoModi;
	public static volatile ListAttribute<Usuario, Cliente> clientes;
	public static volatile ListAttribute<Usuario, Role> roles;
	public static volatile SingularAttribute<Usuario, Sector> sector;
}
