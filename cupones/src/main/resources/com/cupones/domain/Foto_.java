package com.cupones.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-11-26T23:16:11.319-0400")
@StaticMetamodel(Foto.class)
public class Foto_ {
	public static volatile SingularAttribute<Foto, FotoPK> id;
	public static volatile SingularAttribute<Foto, String> descripcion;
	public static volatile SingularAttribute<Foto, Date> fechaHoraCrea;
	public static volatile SingularAttribute<Foto, Date> fechaHoraModi;
	public static volatile SingularAttribute<Foto, String> fotoEstado;
	public static volatile SingularAttribute<Foto, String> rutaFoto;
	public static volatile SingularAttribute<Foto, String> usrCodigoCrea;
	public static volatile SingularAttribute<Foto, String> usrCodigoModi;
	public static volatile ListAttribute<Foto, Oferta> ofertas;
}
