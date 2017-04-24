package com.cupones.beans;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.model.UploadedFile;

import com.cupones.domain.CarritoCompra;
import com.cupones.domain.Categoria;
import com.cupones.domain.Cliente;
import com.cupones.domain.Estado;
import com.cupones.domain.Foto;
import com.cupones.domain.Oferta;
import com.cupones.servicio.CarritoCompraService;
import com.cupones.servicio.CategoriaService;
import com.cupones.servicio.ClienteService;
import com.cupones.servicio.EstadoService;
import com.cupones.servicio.FotoService;
import com.cupones.servicio.OfertaService;
import com.cupones.util.Messageutil;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

@ManagedBean
@SessionScoped
public class OfertaBean {

	@EJB(name = "/com/cupones/servicio/OfertaService")
	private OfertaService ofertaService;
	@EJB
	private CategoriaService categoriaService;
	@EJB
	private EstadoService estadoService;
	@EJB
	private FotoService fotoService;
	@EJB
	private CarritoCompraService carritoCompra;
	@EJB
	private ClienteService clienteService;

	private List<Oferta> ofertas;
	private Oferta oferta;
	private List<Estado> estados;
	private List<Categoria> categorias;
	private UploadedFile file;
	private boolean visible = false;
	private List<Foto> fotos;

	private static Logger logger = LogManager.getLogger(OfertaBean.class);

	public OfertaBean() {
		// Metodo para cumplir con el bean
	}

	@PostConstruct
	public void inicializar() {
		logger.traceEntry();

		logger.debug("Buscando las ofertas");
		ofertas = ofertaService.findAllOferta();
		logger.debug("Se obtuvieron las ofertas " + ofertas);

		logger.debug("Buscando las categorias");
		categorias = categoriaService.findAllCategoria();
		logger.debug("Se obtuvieron las categorias " + categorias);

		logger.debug("Buscando las categorias");
		estados = estadoService.findAllEstado();
		logger.debug("Se obtuvieron las categorias " + categorias);

		oferta = new Oferta();

		logger.traceExit();
	}

	public String addToCart() throws MySQLIntegrityConstraintViolationException {
		logger.traceEntry();

		try {

			Cliente cliente = clienteService.findClienteByUser("admin");

			if (cliente != null) {
				logger.debug(cliente);
				CarritoCompra carrito = new CarritoCompra(1, new Date(), new Date(), 0.0,"adimn", 1 , oferta.getValorOferta(),
						SessionBean.getUsurioSession().getNombreUsuario(),
						Integer.toString(SessionBean.getUsurioSession().getIdUsuario()), oferta.getValorOferta(),
						oferta, cliente);
				logger.debug(carrito);
				carritoCompra.addCarritoCompra(carrito);
			} else {
				logger.debug("El Objecto cliente no esta inicializado");
				return "error";
			}

			return "/user/cart" + "?faces-redirect=true";

		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.getMessage();
			return "/user/cart" + "?faces-redirect=true";
		}

	}

	public String eligeOferta(Oferta oferta) {
		logger.debug("Inicio el metodo eligeOferta");

		this.oferta = ofertaService.findOfertaById(oferta);

		setFotos(ofertaService.findFotosOferta(oferta));

		if (this.oferta != null) {
			logger.debug("Ojecto Oferta " + this.oferta.toString());
			return "oferta" + "?faces-redirect=true";
		} else {
			logger.debug("Ojecto persona null");
			return null;
		}
	}

	public String creaOferta() {
		logger.trace("Iniciando el metodo crear");
		logger.debug("Iniciando el metodo crear");
		try {

			oferta.setUsrCodigoCrea(SessionBean.getUsurioSession().getNombreUsuario());
			oferta.setFechaHoraCrea(new Date());
			oferta.setEstado(estadoService.findEstadoById(new Estado(1)));

			logger.debug(oferta);

			// Oferta oferta1 = oferta;

			logger.debug("Oferta1 " + oferta);

			String ruta = "/imagenes/oferta1/";

			logger.debug("ruta " + ruta);

			File folder = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath(ruta));

			logger.debug("   1");

			String fileName = FilenameUtils.getBaseName(file.getFileName());

			logger.debug("   2");

			String extencion = FilenameUtils.getExtension(file.getFileName());

			logger.debug("   3" + file);

			File file2 = File.createTempFile(fileName + "-", "." + extencion, folder);

			logger.debug(file2.getAbsolutePath() + "\\" + file2.getName());

			// Crea la instancia de la
			Foto foto = new Foto("Oferta " + oferta.getNombreOferta(), fileName, file2.getAbsolutePath(),
					ruta + file2.getName(), "A", new Date(), "user()", null, null, oferta);


			if (foto != null) {
				logger.debug("Insertando la oferta. " + foto);
				fotoService.addFoto(foto);
				logger.debug("Se creo la oferta con su foto");
			}

			Messageutil.mensajeInfo("Se guardo satifactoriamente.");

			logger.debug("Se va a guardar el archivo");

			InputStream input = file.getInputstream();

			logger.debug("Se guardo el archivo");
			logger.debug("Se va a copiar el archvo a " + file2.toPath());

			Files.copy(input, file2.toPath(), StandardCopyOption.REPLACE_EXISTING);

			return "/deals/cuponesdia.xhtml" + "?faces-redirect=true";

		} catch (Exception e) {
			Messageutil.mensajeError(
					"Error al intentar guardar la oferta. " + e.getMessage() + "Error: " + e.getCause().toString());
			logger.error("Error al intentar guardar la oferta.", e);

		}

		return "/error" + "?faces-redirect=true";
	}

	// Creamos el metodo de consultar la oferta
	public void consultaOferta() {

		logger.debug("Ejecutando el metodo buscar.");

		Messageutil.mensajeInfo("Se esta ejecutando el metodo consultar");

		logger.debug(oferta.getIdOferta() + " Oferta");

		oferta = ofertaService.findOfertaById(new Oferta(oferta.getIdOferta()));

		oferta.setFotos(null);

		logger.debug("Se esta ejecutando el metodo consultar");

	}

	public String actualizaOferta() {

		if (oferta != null) {
			ofertaService.updateOferta(oferta);

			return "/deals/cuponesdia" + "?faces-redirect=true";
		} else {
			Messageutil.mensajeError("No se encuentra la oferta, verificar el metodo actualizar.");
		}

		return null;
	}

	public boolean desavilita(boolean a) {
		logger.debug("Se desavilito el buscador de imagen");
		return a;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public OfertaService getOfertaService() {
		return ofertaService;
	}

	public void setOfertaService(OfertaService ofertaService) {
		this.ofertaService = ofertaService;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public boolean getVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	@Override
	public String toString() {
		return "OfertaBean [ofertaService=" + ofertaService + ", categoriaService=" + categoriaService
				+ ", estadoService=" + estadoService + ", fotoService=" + fotoService + ", carritoCompra="
				+ carritoCompra + ", clienteService=" + clienteService + ", ofertas=" + ofertas + ", oferta=" + oferta
				+ ", estados=" + estados + ", categorias=" + categorias + ", file=" + file + ", visible=" + visible
				+ ", fotos=" + fotos + "]";
	}

}
