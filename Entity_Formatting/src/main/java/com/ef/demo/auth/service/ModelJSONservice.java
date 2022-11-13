package com.ef.demo.auth.service;

import java.util.List;

import com.ef.demo.model.ModelJSON;


public interface ModelJSONservice {
	public boolean findAll();
	public void save(List<ModelJSON> list);
	public void deleteAll();
//	public List<ModelJSON> formatting(String columnName,String currFormatt, String typeFormatt);
}
