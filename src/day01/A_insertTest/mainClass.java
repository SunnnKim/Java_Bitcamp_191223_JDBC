package day01.A_insertTest;

import day01.A_dbClass.DBConnection;

public class mainClass {
	public static void main(String[] args) {
		
		// insert
		
		InsertTest it = new InsertTest();
		DBConnection.initConnection();
		int count = it.insert("bbb", "일지매", 21);
		if(count >0) System.out.println("정상적으로 추가되었습니다.");
		
		
		
		
		
		
		
		
	}
}
