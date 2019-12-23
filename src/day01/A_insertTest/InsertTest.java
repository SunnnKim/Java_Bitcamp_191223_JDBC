package day01.A_insertTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import day01.A_dbClass.DBConnection;

public class InsertTest {

	
		public int insert(String id, String name, int age) {
			//
			// 1. createStatement : 문자열 부분의 sql구문은 '' 으로 항상 처리해주어야한다.
			// 2. preparedStatement

			
			// 1. createStatement로 DB 테이블에 데이터 추가하기
			String sql = "INSERT INTO USERDTO (ID, NAME, AGE, JOINDATE) " 
					   + "VALUES ('" + id + "', '" + name + "'," + age + ",SYSDATE)";
			// 연결을 한 부분의 인스턴스 (현재 클래스의 메소드로 호출하기)
			Connection conn = DBConnection.getConnection();
			Statement stmt = null; // 디비 관련 statement
			System.out.println("sql = " + sql); // SQL문은 항상 확인하는 것이 좋음
			int count = 0; // 데이터가 몇개 변경 되었는지 확인하는 변수

			try {
				stmt = conn.createStatement();
				// 현재 연결부분에 대한 상태를 생성
				count = stmt.executeUpdate(sql); // 몇개가 업데이트되었는지에 대한 변수
				// 이 아래코드부터는 데이터 추가에 성공한 다음의 코드
				System.out.println("성공적으로 추가되었습니다.");

				// 디비 서버는

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					// DBClose 클래스 안쓰고 만들기 ( Statement일때 )
					if (stmt != null) { // 값이 들어가 있음
						stmt.close(); // statement 닫음
					}
					if (conn != null) { // 디비 연결되어 있음
						conn.close(); // connection닫아줌
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				// 이클립스는 자동커밋이라 데이터가 자동으로 저장된다.
			}

			return count;
		}
	
}
