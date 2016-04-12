package cupones;

import java.util.Date;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.cupones.domain.Cliente;
import com.cupones.domain.Pais;
import com.cupones.domain.Provincia;
import com.cupones.domain.Sector;
import com.cupones.domain.Usuario;
import com.cupones.servicio.ClienteService;
import com.cupones.servicio.UsuarioService;

public class TestInsertarUsuario {

	@SuppressWarnings("unused")
	private ClienteService clienteService;
	private UsuarioService usuarioService;

	@Before
	public void iniciarContenedorEJB() throws NamingException {
		EJBContainer contenedorEJB = EJBContainer.createEJBContainer();
		Context contexto = contenedorEJB.getContext();
		clienteService = (ClienteService) contexto
				.lookup("java:global/classes/ClienteServiceImpl!com.cupones.servicio.ClienteService");
		usuarioService = (UsuarioService) contexto
				.lookup("java:global/classes/UsuarioServiceImpl!com.cupones.servicio.UsuarioService");

	}

	//@Test
	public void TestPersistenciaCascada() {

		System.out.println("Inicio de prueba con EJB, Persistencia en cascada");

		// Creando el objecto Pais.
		Pais pais = new Pais("Republica Dominicana", "RD", new Date(), "root",
				null, null);
		// Creacion del objecto provincia el cual tiene el objecto Pais
		Provincia provincia = new Provincia("Santo Domingo", "Sto. Dgo.",
				new Date(), "root", null, null, pais);
		// Creacrion del objecto sector el cual tiene el objecto Provincia
		Sector sector = new Sector("Los frailes", new Date(), "root", null,
				null, provincia);
		//
		Cliente cliente = new Cliente("Xavier", "00000000",
				"Respaldo simon bolivar", null, "xavier@gmail.com",
				"8092346138", null, new Date(), "root", null, null);

		// Creacion del objecto usuario
		Usuario usuario = new Usuario("xdlsantos", "admin",
				"Resp. simon bolivar", 5, sector, null, null, new Date(),
				"root", null, null, cliente);

		if (usuario != null) {
			System.out.println("Se crearon los usuarios correctamente");
			try {
				usuarioService.addUser(usuario);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		System.out.println("Fin de la prueba!!!!!!");

	}

}
