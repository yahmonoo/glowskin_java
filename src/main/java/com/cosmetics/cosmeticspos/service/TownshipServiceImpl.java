package com.cosmetics.cosmeticspos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosmetics.cosmeticspos.dao.TownshipDao;
import com.cosmetics.cosmeticspos.domain.Township;
import com.cosmetics.cosmeticspos.dto.TownshipDto;


@Service
public class TownshipServiceImpl implements TownshipService {
	@Autowired
	TownshipDao townshipDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<TownshipDto> getTownship() {
		return townshipDao.getTownship();
		
	}
	
	
	@Transactional(readOnly=true)
	@Override
	public TownshipDto getTownshipById(int id) {
		Township township=townshipDao.getTownshipById(id);
		if(township!=null) {
			return new TownshipDto(township);
		}
		return null;
	}
	
	@Transactional(readOnly=false)
	@Override
	public TownshipDto addTownship(TownshipDto dto) {
		// TODO Auto-generated method stub
				Township township= new Township(dto);
				townshipDao.addTownship(township);
				return dto;
	}
	
	@Transactional(readOnly=false)
	@Override
	public TownshipDto updateTownship(TownshipDto dto) {
		// TODO Auto-generated method stub
		Township township= new Township(dto);
		townshipDao.updateTownship(township);
		return dto;
		
	}

	@Override
	public int deleteTownship(int id) {
		// TODO Auto-generated method stub
		townshipDao.deleteTownship(id);
		return id;
	}

	@Override
	public int deleteTownship(TownshipDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	


}
