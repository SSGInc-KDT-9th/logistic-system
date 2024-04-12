package com.servic.cc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.cc.MySqlSessionFactory;
import com.dao.cc.ClientDAO;
import com.dto.cc.ClientDTO;

public class ClientServiceImpl implements ClientService {

	private ClientDAO dao;
	
	
	@Override
	public List<ClientDTO> findAll() {
		 List<ClientDTO> list = null;
		SqlSession session = null;
		 try {
				session = MySqlSessionFactory.getSession();
				//DAO 연동코드
				list = dao.findAll(session);
		      }finally {
				session.close();
		      }
		return list;
	}


	@Override
	public void setDao(ClientDAO dao) {
		this.dao=dao;
		
	}


	
}
