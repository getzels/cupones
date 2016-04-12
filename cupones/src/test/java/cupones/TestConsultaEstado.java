package cupones;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.cupones.domain.Estado;
import com.cupones.servicio.EstadoService;

public class TestConsultaEstado {

	@EJB
	private EstadoService estadoService;

	@Before
	public void init() {
		EJBContainer ejb = EJBContainer.createEJBContainer();
		Context cx = ejb.getContext();
		
		try {
			estadoService = (EstadoService) cx.lookup("java:global/classes/EstadoServiceImpl!com.cupones.EstadoService");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	//@Test
	public void testEstado(){
		System.out.println("**********Iniciando la prueba de consulta de estado por nombre**************");
		
		Estado estado = estadoService.findEstadoByName(new Estado("ACTIVO"));
		
		System.out.println(estado);
		
		System.out.println("***********Fin de la prueba***********8");
	}

}
