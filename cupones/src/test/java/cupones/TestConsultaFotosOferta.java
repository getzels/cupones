package cupones;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.cupones.domain.Foto;
import com.cupones.domain.Oferta;
import com.cupones.servicio.OfertaService;

public class TestConsultaFotosOferta {

	private OfertaService ofertaService;

	@Before
	public void init() {
		EJBContainer ejb = EJBContainer.createEJBContainer();
		Context cx = ejb.getContext();

		try {
			ofertaService = (OfertaService) cx
					.lookup("java:global/classes/OfertaServiceImpl!com.cupones.servicio.OfertaService");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	//@Test
	public void testConsulta() {
		System.out.println("*************Inicia prueba de EJB**************");

		//Oferta oferta = ofertaService.findOfertaById(new Oferta(4));

		List<Foto> fotos = ofertaService.findFotosOferta(new Oferta(274));
		
		for(Foto foto : fotos){
			System.out.println(foto);
		}

		System.out.println("***************Fin de la prueba*****************");

	}

}
