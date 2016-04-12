package cupones;

import java.util.Date;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.Test;

import com.cupones.domain.Categoria;
import com.cupones.domain.Estado;
import com.cupones.domain.Foto;
import com.cupones.domain.Oferta;
import com.cupones.eis.CategoriaDao;
import com.cupones.servicio.CategoriaService;
import com.cupones.servicio.EstadoService;
import com.cupones.servicio.OfertaService;

@SuppressWarnings("unused")
public class TestInsertaOferta {

	private OfertaService ofertaService;

	private EstadoService estadoService;

	private CategoriaService categoriaService;

	@Before
	public void init() throws Exception {
		EJBContainer ejb = EJBContainer.createEJBContainer();
		Context context = ejb.getContext();

		ofertaService = (OfertaService) context
				.lookup("java:global/classes/OfertaServiceImpl!com.cupones.servicio.OfertaService");
		estadoService = (EstadoService) context
				.lookup("java:global/classes/EstadoServiceImpl!com.cupones.servicio.EstadoService");
		categoriaService = (CategoriaService) context
				.lookup("java:global/classes/CategoriaServiceImpl!com.cupones.servicio.CategoriaService");

	}

	//@Test
	public void TestOferta() {

		Categoria categoria = categoriaService.findCategoriaById(new Categoria(
				1));
		

		System.out.println(categoria);

		Estado estado = estadoService.findEstadoById(new Estado(1));
  
		System.out.println(estado);

		Oferta oferta = new Oferta("Restaurancito", 15, 415, 415 / 43,
				1100, 1100 / 43, 1100 - 415, (1100 - 415) / 43,
				((1100 - 415) * 100) / 1100, estado, categoria, new Date(),
				"user()", null, null);

		// oferta.setCategoria(categoria);

		// oferta.setEstado(estado);

		System.out.println(oferta);

		if (oferta != null) {
			System.out.println("*********Insertando el objeto oferta*********");

			ofertaService.addOferta(oferta);

		} else {
			System.out.println("La oferta esta nula por favor verifcar");
		}

	}

}
