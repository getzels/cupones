package com.cupones.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.cupones.domain.Sector;
import com.cupones.eis.SectorDao;

@Stateless
public class SectorServiceImpl implements SectorService {

	@EJB
	SectorDao sectorDao;
	
	@Override
	public List<Sector> findAllSector() {
		return sectorDao.findAllSector();
	}

	@Override
	public Sector findSectorById(Sector sector) {
		return sectorDao.findSectorById(sector);
	}

	@Override
	public void addSector(Sector sector) {
		sectorDao.addSector(sector);

	}

	@Override
	public void updateSector(Sector sector) {
		sectorDao.updateSector(sector);
	}

	@Override
	public void deleteSector(Sector sector) {
		sectorDao.deleteSector(sector);

	}

}
