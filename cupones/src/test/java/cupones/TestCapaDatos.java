package cupones;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cupones.domain.Usuario;

public class TestCapaDatos {

	
	private static EntityManager em = null;
	private static EntityTransaction tx = null;
	private static EntityManagerFactory emf = null;
	Logger log = Logger.getLogger("TestPersistirObjeto");

	
	@BeforeClass
	public static void init() throws Exception{
			EJBContainer.createEJBContainer();
			emf = Persistence.createEntityManagerFactory("CuponesPU");
	}
	
	@Before
	public void setup(){
		try {
			em = emf.createEntityManager();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
//	@Test
	public void testCupones(){
		tx = em.getTransaction();
		tx.begin();
		
		Query query = em.createNamedQuery("Usuario.findAll");
		List<Usuario> usuarios = query.getResultList();
		
		for(Usuario usuario : usuarios){
			System.out.println(usuario);
		}
		
		//
		/*
		Query query = em.createQuery("select u from Usuario u where u.nombreUsuario like :userName");
		query.setParameter("userName", DigestUtils.sha256Hex("admin"));
		Usuario usuario = (Usuario) query.getSingleResult();
		if (usuario != null){
		int id = usuario.getIdUsuario();
		usuario.setIdUsuario(id++);
		usuario.setNombreUsuario(DigestUtils.sha256Hex("admin"));
		usuario.setContrasena(DigestUtils.sha256Hex("admin"));
		usuario.setCalle("Respaldo Teo cruz");
		*/
		/*
		Usuario usuario = new Usuario();
		//usuario.setIdUsuario(id++);
		usuario.setNombreUsuario(DigestUtils.sha256Hex("keyzels"));
		usuario.setContrasena(DigestUtils.sha256Hex("admin"));
		usuario.setCalle("Respaldo Teo cruz");
		usuario.setIdSector(1);
		usuario.setFechaHoraCrea(new Date());
		usuario.setUsrCodigoCrea("KEYZELS");
		
		
		em.persist(usuario);
		*/
		/*
		Usuario usuario = new Usuario(200102);
		
		em.remove(usuario);
		tx.commit();
		log.debug("Objeto persistido" + usuario);
//		}else{
//			System.out.println("No se encontro el usuario");
//		}
 * */
 
	}
	
	@After
	public void tearDown() throws Exception{
		if (em != null){
			em.close();
		}
	}
}
