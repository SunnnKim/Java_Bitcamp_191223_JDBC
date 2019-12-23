package day01.A_deleteTest;

import day01.A_dbClass.DBConnection;

public class mainClass {

	public static void main(String[] args) {

		
		DeleteClass dc = new DeleteClass();
		DBConnection.initConnection();
		int count = dc.Delete("bbb");
		if(count > 0) System.out.println("정상적으로 추가되었습니다.");
		
	}

}
