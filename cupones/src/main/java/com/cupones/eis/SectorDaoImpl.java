package com.cupones.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cupones.domain.Sector;

@Stateless
public class SectorDaoImpl implements SectorDao {

	@PersistenceContext(unitName = "CuponesPU")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	
	public List<Sector> findAllSector() {
		return em.createNamedQuery("Sector.findAll").getResultList();
	}

	
	public Sector findSectorById(Sector sector) {
		return em.find(Sector.class, sector.getIdSector());
	}

	
	public void addSector(Sector sector) {
		em.persist(sector);

	}

	
	public void updateSector(Sector sector) {
	em.merge(sector);
	}

	
	public void deleteSector(Sector sector) {
   sector = em.find(Sector.class, sector.getIdSector());
   em.remove(sector);

	}

}
