package day01.A_selectTest;

import java.util.List;

import day01.A_dbClass.DBConnection;

public class mainClass {

	public static void main(String[] args) {
		
		DBConnection.initConnection();
		String id ="ccc";
		SelectTest st = new SelectTest();
//		UserDTO dto = st.search(id);
		UserDTO dto = st.select(id);
		if(dto != null) {
			System.out.println(dto.toString());
		}else {
			System.out.println("Id가 존재하지 않습니다.");
		}
		
		// 여러개의 데이터 받아오기
		
		List<UserDTO> list = st.getUserList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		
	}

}
