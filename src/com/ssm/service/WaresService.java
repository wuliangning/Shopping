package com.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.WaresMapper;
import com.ssm.model.Member;
import com.ssm.model.Wares;

@Service
public class WaresService {

	@Resource
	private WaresMapper waresMapper;
	
    public void add(Wares wares){
    	waresMapper.add(wares);
    }
	
	public void update(Wares wares){
		waresMapper.update(wares);
	}
	
	public void delete(Wares wares){
		waresMapper.delete(wares);
	}
	
	public List<Wares> getUserList(){
		return waresMapper.getUserList();
	}
	
	public Wares getWares(Wares wares){
		return waresMapper.getWares(wares);
	}

	public List<Wares> keyWord(String keyWord){
    	keyWord="%"+keyWord+"%";
		List<Wares> wares = waresMapper.keyWord(keyWord);
		return wares;
	}
}
