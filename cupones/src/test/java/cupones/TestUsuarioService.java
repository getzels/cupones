package cupones;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.Test;

import com.cupones.domain.Usuario;
import com.cupones.servicio.UsuarioService;

public class TestUsuarioService {

	private UsuarioService usuarioService;
	
	@Before
	public void iniciaContenedorEJB() throws Exception
	{
		EJBContainer ejb = EJBContainer.createEJBContainer();
		Context contexto = ejb.getContext();
		usuarioService = (UsuarioService) contexto.lookup("java:global/classes/UsuarioServiceImpl!com.cupones.servicio.UsuarioService");
	
	}
	
//	@Test 
	public void testUsuarioServiceM(){
		
		System.out.println("Iniciando prueba con contenedor embedido y usuario Service");
		
		assertTrue(usuarioService != null);
		
		 try {
			listaUsuario(usuarioService.findAllUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}


	private void listaUsuario(List<Usuario> usuarios) {
		
		for(Usuario usuario : usuarios){
			System.out.println(usuario);
		}
	}
}
