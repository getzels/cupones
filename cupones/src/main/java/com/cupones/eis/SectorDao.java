package com.cupones.eis;

import java.util.List;

import javax.ejb.Remote;

import com.cupones.domain.Sector;
@Remote
public interface SectorDao {

	public List<Sector> findAllSector();
	
	public Sector findSectorById(Sector sector);
	
	public void addSector(Sector sector);
	
	public void updateSector(Sector sector);
	
	public void deleteSector(Sector sector);
	
	
	
}
