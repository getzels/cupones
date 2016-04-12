package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.309-0400")
@StaticMetamodel(Categoria.class)
public class Categoria_ {
	public static volatile SingularAttribute<Categoria, Integer> idCategoria;
	public static volatile SingularAttribute<Categoria, Integer> catEstado;
	public static volatile SingularAttribute<Categoria, String> descripcionCategoria;
	public static volatile SingularAttribute<Categoria, Date> fechaHoraCrea;
	public static volatile SingularAttribute<Categoria, Date> fechaHoraModi;
	public static volatile SingularAttribute<Categoria, String> nombreCategoria;
	public static volatile SingularAttribute<Categoria, String> usrCodigoCrea;
	public static volatile SingularAttribute<Categoria, String> usrCodigoModi;
	public static volatile ListAttribute<Categoria, Oferta> ofertas;
}
