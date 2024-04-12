package com.main.cc;

import java.util.List;
import java.util.Scanner;

import com.dao.cc.ClientDAO;
import com.dto.cc.ClientDTO;
import com.servic.cc.ClientService;
import com.servic.cc.ClientServiceImpl;

public class ClientMain {

	public static void main(String[] args) {
		

		ClientService service = new ClientServiceImpl();
		service.setDao(new ClientDAO());
        Scanner scan  = new Scanner(System.in);	
		while(true) {
			System.out.println("1. 전체목록");
			System.out.println("0. 종료");
			System.out.println("-------------------");
			String num = scan.next();
			if("1".equals(num)) {
List<ClientDTO> list = service.findAll();
for (ClientDTO e : list) {
	System.out.println(e);
}
				
				
			}else if("0".equals(num)) {
				System.out.println("프로그램 종료됨.");
				System.exit(0);
			}
			
		}//end while
		
		

	}

}
