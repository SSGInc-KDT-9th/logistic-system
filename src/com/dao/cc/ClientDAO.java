package com.dao.cc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.cc.ClientDTO;

public class ClientDAO {

	//전체 고객기업 조회
	public List<ClientDTO> findAll(SqlSession session){
		List<ClientDTO> list = 
				session.selectList("com.config.cc.ClientMapper.findAll");
		return list;
	}

	//기업 id를 통한 기업 삭제
		public int removeByid(SqlSession session, int id) {
			return session.delete("com.config.cc.ClientMapper.removeByid", id);
		}
	
	
}
