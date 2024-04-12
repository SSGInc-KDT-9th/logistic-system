package com.dao.cc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.cc.ClientDTO;

public class ClientDAO {

	public List<ClientDTO> findAll(SqlSession session){
		List<ClientDTO> list = 
				session.selectList("com.config.cc.ClientMapper.findAll");
		return list;
	}

	
	
	
}
