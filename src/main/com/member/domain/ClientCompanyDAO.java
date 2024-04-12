package main.com.member.domain;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.ClientCompanyDTO;

public class ClientCompanyDAO {

	public List<ClientCompanyDTO> findAll(SqlSession session){
		List<ClientCompanyDTO> list = 
				session.selectList("com.config.EmpMapper.findAll");
		return list;
	}
	//save
	public int save(SqlSession session, ClientCompanyDTO dto) {
		
		return 0;
	}
	//remove
	public int removeByEmpno(SqlSession session, int empno) {
		return session.delete("com.config.EmpMapper.removeByEmpno", empno);
	}
	
	
	
}
