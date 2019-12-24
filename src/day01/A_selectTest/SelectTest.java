package day01.A_selectTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day01.A_dbClass.DBClose;
import day01.A_dbClass.DBConnection;

public class SelectTest {
	
	// Insert / Update / Delete는 방법이 정해져있는 편이나
	// Select는 다양한 방법으로 데이터를 취득할 수 있다.
	
	// select는 1개의 데이터만을 취득거나 
	// 데이터 전부를 취득하는 방법
	// 크게 2가지로 나눌 수 있다
	
	
	// 1. 1개의 데이터(row)만을 취득 
	public UserDTO search(String id) {
		
		String sql =  " SELECT ID, NAME, AGE, JOINDATE "
					+ " FROM USERDTO "
					+ " WHERE ID = '" + id + "'";
		
		
	
		// select는 int형의 count변수와  exxcuteUpdate를 사용하지 않는다
		// (데이터베이스 내에서 변경이 있는 것이 아니기 때문에)
		// 대신, resultSet을 사용한다
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		UserDTO dto = null; 	// null하는 이유 : id가 없을경우 null값을 반환하여 구분하기 위해
		System.out.println("sql : " + sql);
		
		// DB와 연결하여 쿼리문 보내기
		try {
			psmt = conn.prepareStatement(sql);
			// 커리문의 결과를 rs에 담을 수 있는 메소드 
			rs = psmt.executeQuery();
			//rs의 데이터가 있을때 = rs.next()
			if(rs.next()) { 
				// 아래는 DB에서 받아서 자바로 불어오는 부분
				String _id = rs.getString("id");	// ()안에 컬럼명을 써주면 찾아준다
				String _name = rs.getString("name"); // ()dksd
				int _age = rs.getInt("age");
				String _joindate = rs.getString("joindate");
			
				dto = new UserDTO(_id, _name, _age, _joindate);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			DBClose.close(psmt, conn, rs);
		}
		
		
		return dto;
	}
	
	//preparedStatement 사용해서 만들기
	public UserDTO select(String id) {
		String sql = " SELECT ID, NAME, AGE  "
					+" FROM USERDTO "
					+" WHERE ID = ? OR AGE = ? ";
		// preparedStatement 는 ?에 값을 채워넣는 방식으로 찾는다 
		
		// 기본 세팅
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		UserDTO dto = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);	

			// DB는 인덱스가 1부터 시작이기 때문에 id의 인덱스는 1
			// sql 변수의 ? 에 들어가는 값이 바로 위의 코드임
			
			// 쿼리문 실행하기 
			rs = psmt.executeQuery();
			
			// 데이터가 있을 때
			if(rs.next()) {
				dto = new UserDTO();
				//하나씩 꺼내서 set
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setJoindate(rs.getString("joindate"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return dto;
		
	}
	
	// 다수의 데이터 취득하기
	// 리스트에 추가하는 형태여야 함
	public List<UserDTO> getUserList(){
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
					+ " FROM USERDTO ";
		
		// 가독성 좋게  기본 세팅하기
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		System.out.println("sql: " + sql);
		
		
		try {
			// 처리부분 try-catch로 묶기
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {	// 데이터가 있을 때까지 루프 돌리기
				// 디비에서 데이터 받아오기
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String joindate = rs.getString("joindate");
				
				// 추가하기
				list.add(new UserDTO(id, name, age, joindate));
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
	
	
	
	
	
	
}
