package day01.A_updateTest;

import day01.A_dbClass.DBConnection;

public class mainClass {

	public static void main(String[] args) {
		
		UpdateTest ut = new UpdateTest();
		DBConnection.initConnection();
		boolean b = ut.Update("bbb", 55);
		if(b) System.out.println("데이터를 성공적으로 수정했습니다.");
		
		
	}

}
