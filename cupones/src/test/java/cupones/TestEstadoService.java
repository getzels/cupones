package cupones;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.cupones.domain.Estado;
import com.cupones.servicio.EstadoService;

public class TestEstadoService {

	private EstadoService estadoService;
	
	
	@Before
	public void init() throws NamingException{
		EJBContainer ejb = EJBContainer.createEJBContainer();
		Context cx = ejb.getContext();
		estadoService = (EstadoService) cx.lookup("java:global/classes/EstadoServiceImpl!com.cupones.servicio.EstadoService");
	}
	
	//@Test
	public void TestEstadoServiceI(){
		System.out.println("Inicio prueba de EstadoService");
		
		List<Estado> estados = estadoService.findAllEstado();
		
		if (estados != null)
		listarEstados(estados);
		else
	    System.out.println("No se encontraron estados");
		
		
		System.out.println("Fin de la prueba.");
				
	}
	
	public void listarEstados(List<Estado> estados){
		for(Estado estado : estados){
			System.out.println(estado);
		}
		
		
	}
}
