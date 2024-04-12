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
			System.out.println("2. 고객기업삭제");
			System.out.println("3. 고객기업등록");
			System.out.println("0. 종료");
			System.out.println("-------------------");
			String num = scan.next();
			if("1".equals(num)) {
               List<ClientDTO> list = service.findAll();
               for (ClientDTO e : list) {
	               System.out.println(e);
                   }
               }else if("2".equals(num)) {
            	   System.out.println("삭제할 고객id를 입력하세요.");
            	   String id = scan.next();
            	   int n = service.removeByid(Integer.parseInt(num));
            	   System.out.println(n+" 개가 삭제됨.");
            	   
               }else if("3".equals(num)) {
            	   System.out.println("등록할 기업의 정보를 입력하세요.");
            	   String id = scan.next();
            	   int n = service.removeByid(Integer.parseInt(num));
            	   System.out.println(n+" 개가 삭제됨.");   
            	   
               }else if("0".equals(num)) {
				System.out.println("프로그램 종료됨.");
				System.exit(0);
			}
			
		}//end while
		
		

	}

}
