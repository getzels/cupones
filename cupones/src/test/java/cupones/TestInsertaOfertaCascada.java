package cupones;

import java.io.File;
import java.util.Date;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cupones.domain.Categoria;
import com.cupones.domain.Estado;
import com.cupones.domain.Foto;
import com.cupones.domain.Oferta;
import com.cupones.servicio.CategoriaService;
import com.cupones.servicio.EstadoService;
import com.cupones.servicio.FotoService;
import com.cupones.servicio.OfertaService;

@SuppressWarnings("unused")
public class TestInsertaOfertaCascada {

	private static EntityManager em = null;
	private static EntityTransaction tx = null;
	private static EntityManagerFactory emf = null;

	private OfertaService ofertaService;
	private EstadoService estadoService;
	private CategoriaService categoriaService;
	private FotoService fotoService;

	@Before
	public void setup() throws Exception {
		EJBContainer ejb = EJBContainer.createEJBContainer();
		Context context = ejb.getContext();

		ofertaService = (OfertaService) context
				.lookup("java:global/classes/OfertaServiceImpl!com.cupones.servicio.OfertaService");
		estadoService = (EstadoService) context
				.lookup("java:global/classes/EstadoServiceImpl!com.cupones.servicio.EstadoService");
		categoriaService = (CategoriaService) context
				.lookup("java:global/classes/CategoriaServiceImpl!com.cupones.servicio.CategoriaService");
		fotoService = (FotoService) context
				.lookup("java:global/classes/FotoServiceImpl!com.cupones.servicio.FotoService");

	}

	//@Test
	public void TestInsertaOferta() {

		File directorio = new File("C:\\Users\\gdelossantos\\workspace\\fotos_cupones\\fotos_cupones\\oferta1");
		File[] archivos = null;
		String descripcionCategoria = "Todo ref. a la comida";

		// Validamos si el direcctorio existe, si existe se inicializa el array
		// con los archivos del
		// direcctorio.
		if (directorio.exists()) {
			archivos = directorio.listFiles();
		} else {
			System.out.println("Directorio "
					+ directorio.getAbsolutePath().toString() + " no existe");
		}
		// Creamos el objeto categoria
		Categoria categoria = categoriaService.findCategoriaById(new Categoria(1));
		
		
		// Creamos el objeto estado y lo buscamo en la base de datos
		Estado estado = estadoService.findEstadoById(new Estado(1));
		
		// Creamos en objeto oferta.
		Oferta oferta = new Oferta("Restaurancito oferta 1", 15, 415, 415 / 43,
				1100, 1100 / 43, 1100 - 415, (1100 - 415) / 43,
				((1100 - 415) * 100) / 1100, estado,categoria, new Date(), "user()",
				null, null);

	//	oferta.setCategoria(categoria);

		
		// Itera entre los archivos que contiene el directorio y crea los
		// objetos fotos con la oferta.
		System.out.println("Construyendo los objectos fotos");
		for (int i = 0; i < archivos.length; i++) {

			String filename = directorio.getAbsolutePath() + "\\"
					+ archivos[i].getName();
			String extencion;
			// Valida si el array esta inicializado.
			if (archivos != null) {
				// if que Comprueba si es un directorio
				if (archivos[i] == null || archivos[i].isDirectory()) {
					extencion = "nulo o directorio";// System.out.println("nulo o directorio");
				} else if (archivos[i].isFile()) { // Comprueba si es un
					                                  // archivo.
					int index = filename.lastIndexOf('.');
					if (index == -1) {
						extencion = "";// System.out.println("");;
					} else {
						// Nos da la extencion.
						extencion = filename.substring(index + 1);
					}
				} else {
					extencion = "que has enviado?";
				}

				System.out.println(extencion); // Test

				if (extencion.equals("jpg")) {

					System.out
							.println("Insertando la oferta atraves de la fotos");

					Foto foto = new Foto("Foto de la oferta 1", "oferta1-1",
							directorio.getAbsolutePath() + "/"
									+ archivos[i].getName(), "A", new Date(),
							"xdlsantos", null, null);

					foto.setOferta(oferta);

					if (foto != null) {

						System.out.println(foto.getOferta().getCategoria()
								.getIdCategoria()
								+ " "
								+ foto.getOferta().getCategoria()
										.getNombreCategoria());

						fotoService.addFoto(foto);
					} else {
						System.out.println("La foto esta nula");
					}

				}

			} else {
				System.out.println("El directorio esta vacio");
			}
		}

		// if (oferta != null) {
		// System.out.println("*********Insertando el objeto oferta*********");
		//
		// ofertaService.addOferta(oferta);
		//
		// } else {
		// System.out.println("La oferta esta nula por favor verifcar");
		// }
		System.out.println("************Fin de la prueba***************");

	}

}
