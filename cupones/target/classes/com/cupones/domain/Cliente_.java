package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.309-0400")
@StaticMetamodel(Cliente.class)
public class Cliente_ {
	public static volatile SingularAttribute<Cliente, Integer> idCliente;
	public static volatile SingularAttribute<Cliente, String> cltDireccion1;
	public static volatile SingularAttribute<Cliente, String> cltDireccion2;
	public static volatile SingularAttribute<Cliente, String> cltEmail;
	public static volatile SingularAttribute<Cliente, Date> cltFechaHoraCrea;
	public static volatile SingularAttribute<Cliente, Date> cltFechaHoraModi;
	public static volatile SingularAttribute<Cliente, String> cltRnc;
	public static volatile SingularAttribute<Cliente, String> cltTelefono1;
	public static volatile SingularAttribute<Cliente, String> cltTelefono2;
	public static volatile SingularAttribute<Cliente, String> nombreCliente;
	public static volatile SingularAttribute<Cliente, String> usrCodigoCrea;
	public static volatile SingularAttribute<Cliente, String> usrCodigoModi;
	public static volatile SingularAttribute<Cliente, Usuario> usuario;
	public static volatile ListAttribute<Cliente, Solicitud> solicituds;
}
