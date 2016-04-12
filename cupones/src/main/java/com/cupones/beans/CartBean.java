package com.cupones.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import com.cupones.domain.CarritoCompra;
import com.cupones.domain.Cliente;
import com.cupones.domain.Usuario;
import com.cupones.servicio.CarritoCompraService;
import com.cupones.servicio.ClienteService;
import com.cupones.util.Messageutil;

@ManagedBean
@RequestScoped
public class CartBean {

	@EJB
	private CarritoCompraService carritoCompraService;
	@EJB
	private ClienteService clienteService;
	
	@ManagedProperty(value = "#{ofertaBean}")
	private OfertaBean ofertaBean;

	private List<CarritoCompra> itemsCarrito;
	private Usuario usuario;
	private double subTotal;
	private String direccionEnvio;

	public CartBean() {
		System.out.println("Se ejecuto el constructor de la Escape");
	}

	@PostConstruct
	public void init() {
		Cliente cliente;
		try {
			System.out.println("Inicio del metodo init clase CartBean");

			this.usuario = SessionBean.getUsurioSession();

			cliente = clienteService.findClienteByUser(this.usuario.getNombreUsuario());

			if (this.usuario != null) {
				itemsCarrito = carritoCompraService.findDatosCarritoById(cliente);
			} else {
				System.out.println("El objecto usuario no esta inicializado. ");
			}
			
			//Recorre los datos de el List itemsCarrito para determinar el subtotal.
			subTotal = 0;
			for (CarritoCompra carrito : itemsCarrito){
				subTotal += carrito.getTotal();
			}
			
			if (itemsCarrito != null){
			direccionEnvio = cliente.getCltDireccion1() + " " + cliente.getCltDireccion2(); 
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public void eliminaOfertaCarrito(CarritoCompra carritoCompra){		
		System.out.println("Se inicio el metodo eliminaOfertaCarrito");
		
		carritoCompraService.deleteCarritoCompra(carritoCompra);
		init();
		Messageutil.mensajeInfo("Se elimino la oferta " + carritoCompra.getOferta().getDetalleOferta());
	}

	public List<CarritoCompra> getItemsCarrito() {
		return itemsCarrito;
	}

	public void setItemsCarrito(List<CarritoCompra> itemsCarrito) {
		this.itemsCarrito = itemsCarrito;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public OfertaBean getOfertaBean() {
		return ofertaBean;
	}

	public void setOfertaBean(OfertaBean ofertaBean) {
		this.ofertaBean = ofertaBean;
	}

}
