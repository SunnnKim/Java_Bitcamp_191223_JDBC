package day01.A_deleteTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import day01.A_dbClass.DBClose;
import day01.A_dbClass.DBConnection;

public class DeleteClass {

	
	
	// delete 함수
	
		public int Delete(String id) {
			
			String sql = "DELETE FROM USERDTO "
						+ "WHERE ID = '"+ id + "'";
			
			// 기본 셋팅
			Connection conn = DBConnection.getConnection();
			PreparedStatement psmt = null;
			int count = 0;
			
			
			
			// sql문 확인
			System.out.println("sql = " + sql);
			// 데이터 삭제하기 SQL실행 
			try {
				psmt = conn.prepareStatement(sql);
				
				count = psmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally{
				try {
					
					DBClose.close(psmt, conn, null);
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			System.out.println(id+ "를 삭제했습니다.");
			return count;
		}
		
		
		
		
}
