package cupones;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.Test;

import com.cupones.domain.Usuario;
import com.cupones.servicio.UsuarioService;

public class TestFindUserByName {

	private UsuarioService usuarioService;

	@Before
	public void init() throws Exception {
		EJBContainer ejb = EJBContainer.createEJBContainer();
		Context context = ejb.getContext();
		usuarioService = (UsuarioService) context
				.lookup("java:global/classes/UsuarioServiceImpl!com.cupones.servicio.UsuarioService");
	}

	//@Test
	public void testEncontrarUsuarioPorNombre() throws Exception {
		System.out.println("Inicio de prueba, encontrar usuario por nombre");

		Usuario usuario = new Usuario();

		String nombreUsuario = "xdlsantos";
		usuario.setNombreUsuario(nombreUsuario);

		usuario = usuarioService.findUserByUserName(usuario);

		System.out.println(usuario);
		System.out.println("Fin de la prueba");

	}

}
