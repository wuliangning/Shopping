package com.ssm.dao;

import java.util.List;

import com.ssm.model.Wares;
import org.apache.ibatis.annotations.Select;


public interface WaresMapper {
	
	public void add(Wares wares);
	
	public void update(Wares wares);
	
	public void delete(Wares wares);
	
	public List<Wares> getUserList();
	
	public Wares getWares(Wares wares);
	@Select("select * from wares where wareName like #{keyWord}")
	public List<Wares> keyWord(String keyWord);
	
}
