package com.servic.cc;

import java.util.List;

import com.dao.cc.ClientDAO;
import com.dto.cc.ClientDTO;

public interface ClientService {

	
	public void setDao(ClientDAO dao);
	public List<ClientDTO> findAll();
	

	
	
}
