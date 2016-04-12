package com.cupones.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import com.cupones.domain.Pais;
import com.cupones.domain.Provincia;
import com.cupones.servicio.PaisService;
import com.cupones.servicio.ProvinciaService;

@ManagedBean
public class MenuBean {

	private Pais pais;
	private Provincia provincia;
	//
	@EJB
	private PaisService paisService;
	@EJB
	private ProvinciaService provinciaService;

	private String ciudad;

	private List<SelectItem> ciudades;

	
	public MenuBean() {
		/*List<Pais> paises = paisService.findAllPais();
		SelectItemGroup g1;
		ciudades = new ArrayList<SelectItem>();
		for (Pais pais : paises) {
			g1 = new SelectItemGroup(pais.getPaisDescripcion());
			g1.setSelectItems(this.ListToSelect(pais));
		
			  g1 = new SelectItemGroup("German Cars");
		       g1.setSelectItems(new SelectItem[] {new SelectItem("BMW", "BMW"), new SelectItem("Mercedes", "Mercedes"), new SelectItem("Volkswagen", "Volkswagen")});

			
			ciudades.add(g1);
		}
       
		*/
		
		SelectItemGroup g1 = new SelectItemGroup("German Cars");
        g1.setSelectItems(new SelectItem[] {new SelectItem("BMW", "BMW"), new SelectItem("Mercedes", "Mercedes"), new SelectItem("Volkswagen", "Volkswagen")});
       
        SelectItemGroup g2 = new SelectItemGroup("American Cars");
        g2.setSelectItems(new SelectItem[] {new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"), new SelectItem("Ford", "Ford")});
       
        ciudades = new ArrayList<SelectItem>();
        ciudades.add(g1);
        ciudades.add(g2);

	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public PaisService getPaisService() {
		return paisService;
	}

	public void setPaisService(PaisService paisService) {
		this.paisService = paisService;
	}

	public ProvinciaService getProvinciaService() {
		return provinciaService;
	}

	public void setProvinciaService(ProvinciaService provinciaService) {
		this.provinciaService = provinciaService;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@SuppressWarnings("unused")
	private SelectItem[] ListToSelect(Pais pais) {

		List<Provincia> provincias = provinciaService.findProvinciaByPais(pais);

		SelectItem[] ciudades = new SelectItem[provincias.size()];

		for (int i = 0; i < ciudades.length; i++) {
			ciudades[i] = new SelectItem(provincias.get(i).getProDescripcion(),
					provincias.get(i).getProDescripcion());
		}

		return ciudades;
	}

	public List<SelectItem> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<SelectItem> ciudades) {
		this.ciudades = ciudades;
	}

}
