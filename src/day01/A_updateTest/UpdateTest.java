package day01.A_updateTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import day01.A_dbClass.DBClose;
import day01.A_dbClass.DBConnection;

public class UpdateTest {

	                       
	public boolean Update(String id,int age) {
		
		String sql = "UPDATE USERDTO "
				   + " SET AGE = " + age + " "
				   + " WHERE ID = '"+id+"'";
		
		PreparedStatement stmt = null;
		Connection conn = DBConnection.getConnection();
		int count = 0;
		// sql확인
		System.out.println("sql= " + sql);
		
		// 데이터 수정하는 sql
		try {
			stmt = conn.prepareStatement(sql);
			
			count = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			
			DBClose.close(stmt, conn, null);
			
		}
		
	
		return count > 0? true : false ;
	}

	
}
