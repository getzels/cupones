package cupones;

import java.util.Date;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.cupones.domain.Categoria;
import com.cupones.servicio.CategoriaService;

public class TestInsertCategoria {

	private CategoriaService categoriaService;

	@Before
	public void init() throws NamingException {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		Context contexto = contenedor.getContext();

		categoriaService = (CategoriaService) contexto
				.lookup("java:global/classes/CategoriaServiceImpl!com.cupones.servicio.CategoriaService");

	}

	//@Test
	public void testInsetaCategoria() {

		System.out
				.println("********Inicia prueba de insertar categoria********");

		String descripcionCategoria = "Todo ref. a la comida";

		// Creamos el objeto categoria
		Categoria categoria = new Categoria("gourmet",
				descripcionCategoria.substring(0, 19), 1, new Date(), "user()",
				null, null);
		
		categoriaService.addCategoria(categoria);
		
		
		System.out.println("********Fin de la prueba de insertar categoria********");

	}

}
