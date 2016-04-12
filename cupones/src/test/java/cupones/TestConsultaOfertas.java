package cupones;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.cupones.domain.Oferta;
import com.cupones.servicio.OfertaService;

public class TestConsultaOfertas {
	
	
	
	private OfertaService ofertaService;
	
	
	@Before
	public  void init(){
		EJBContainer ejb = EJBContainer.createEJBContainer();
		Context cn = ejb.getContext();
		
		try {
			ofertaService = (OfertaService) cn.lookup("java:global/classes/OfertaServiceImpl!com.cupones.servicio.OfertaService");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testConsultaOferta(){
		System.out.println("Inicio de prueba");
		
		List<Oferta> ofertas = ofertaService.findAllOferta();
		
		for(Oferta oferta : ofertas){
			System.out.println(oferta);
		}
		
		System.out.println("FIn de la prueba");
		
	}

}
