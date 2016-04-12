package cupones;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.Test;

import com.cupones.domain.Usuario;
import com.cupones.servicio.UsuarioService;

public class ValidaUsuario {

	UsuarioService usuarioService;

	@Before
	public void InicializacionEJB() throws Exception {
		EJBContainer ejb = EJBContainer.createEJBContainer();
		Context contexto = ejb.getContext();
		usuarioService = (UsuarioService) contexto
				.lookup("java:global/classes/UsuarioServiceImpl!com.cupones.servicio.UsuarioService");
	}

	//@Test
	public void validarUsuarioTest() {
		String nombreUsuario = "admin", contrasena = "admin";
		Usuario usuario = new Usuario();

		usuario.setNombreUsuario(nombreUsuario.toUpperCase());
		usuario.setContrasena(contrasena);

		// Validar usuario
		if (usuarioService.validate(usuario)) {
			System.out.println("Usuario Logeado exitosamente");
		} else {
			System.out
					.println("Error al inicio de seccion, verifique el usuario");
		}

	}
}
