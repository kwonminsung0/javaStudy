package studentTest2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;

		while (!exitFlag) {
			printMenu();
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case StudentMenu.PRINT:
				stuPrint();
				break;
			case StudentMenu.INSERT:
				stuInsert();
				break;
			case StudentMenu.UPDATE:
				stuUpdate();
				break;
			case StudentMenu.DELETE:
				stuDelete();
				break;
			case StudentMenu.EXIT:
				exitFlag = true;
				break;
			}
		}
	}

	private static void stuDelete() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		
		con = DBConnection.dbCon();
		stmt = con.createStatement();
		
		System.out.print("삭제할 학생의 학번을 입력하세요. : ");
		int stuId = Integer.parseInt(sc.nextLine());
		
		int result = stmt.executeUpdate("DELETE FROM students WHERE stuId = " + stuId);
		System.out.println((result != 0) ? "삭제완료" : "삭제실패");
		
		DBConnection.dbClose(con, stmt);
	}

	private static void stuUpdate() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		
		con = DBConnection.dbCon();
		stmt = con.createStatement();
		
		System.out.print("수정할 학생의 학번을 입력하세요. : ");
		int stuId = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 국어 점수를 입력하세요. : ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 수학 점수를 입력하세요. : ");
		int math = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 영어 점수를 입력하세요. : ");
		int eng = Integer.parseInt(sc.nextLine());
		
		Students students = new Students(stuId, kor, math, eng);
		int result = stmt.executeUpdate("UPDATE students SET kor = " + students.getKor() + ", " 
				+ "math = " + students.getMath() + ", " + "eng = " + students.getEng() + " WHERE stuId = " + stuId);
		System.out.println((result != 0) ? "수정완료" : "수정실패");
		
		DBConnection.dbClose(con, stmt);
	}

	private static void stuInsert() throws SQLException {
		Connection con = null;
		Statement stmt = null;

		con = DBConnection.dbCon();
		stmt = con.createStatement();

		System.out.print("학생 이름을 입력하세요. : ");
		String name = sc.nextLine();
		System.out.print("국어 점수를 입력하세요. : ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("수학 점수를 입력하세요. : ");
		int math = Integer.parseInt(sc.nextLine());
		System.out.print("영어 점수를 입력하세요. : ");
		int eng = Integer.parseInt(sc.nextLine());

		Students students = new Students(name, kor, math, eng);
		int result = stmt.executeUpdate("INSERT INTO students(stuId, name, kor, math, eng) "
				+ "VALUES( students_SEQ.NEXTVAL, " + students.getName() + ", " + students.getKor() + ", " + students.getMath()
				+ ", " + students.getEng() + ")");

		System.out.println((result != 0) ? "입력완료" : "입력실패");

		DBConnection.dbClose(con, stmt);
	}

	private static void stuPrint() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Students> stuList = new ArrayList<Students>();

		con = DBConnection.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM students");

		while (rs.next()) {
			int stuId = rs.getInt("stuId");
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int math = rs.getInt("math");
			int eng = rs.getInt("eng");
			int total = rs.getInt("total");
			double avg = rs.getDouble("avg");
			Students students = new Students(stuId, name, kor, math, eng, total, avg);
			stuList.add(students);
		}
		stuListPrint(stuList);
		DBConnection.dbClose(con, stmt, rs);
	}

	private static void stuListPrint(ArrayList<Students> stuList) {
		for (Students students : stuList) {
			System.out.println(students.toString());
		}
	}

	private static void printMenu() {
		System.out.println("menu[1.학생정보출력, 2.점수입력, 3.점수수정, 4. 점수삭제, 5.종료]");
		System.out.print(">>");
	}

}
