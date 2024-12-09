package com.kh.subjectMVCProject.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.kh.subjectMVCProject.model.LandPriceVO;


public class SubjectDAO {
		
	public final String SUBJECT_SELECT = "SELECT * FROM SUBJECT";
    public final String SUBJECT_INSERT = "insert into subject(no, num, name) values (subject_seq.nextval, ?, ?)";
    public final String SUBJECT_CALL_RANK_PROC = "{call STUDENT_RANK_PROC()}";
    public final String SUBJECT_UPDATE = "UPDATE SUBJECT SET NAME = ? WHERE NUM = ?";
    public final String SUBJECT_DELETE = "DELETE FROM SUBJECT WHERE NUM = ?";
    public final String SUBJECT_SORT = "SELECT * FROM SUBJECT ORDER BY NUM";
	
	public ArrayList<LandPriceVO> subjectSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<LandPriceVO> subjectList = new ArrayList<LandPriceVO>();

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(SUBJECT_SELECT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String name = rs.getString("NAME");
				LandPriceVO svo = new LandPriceVO(no, num, name); 
				subjectList.add(svo);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return subjectList;
	}
	
	public boolean subjectInsert(LandPriceVO svo) {
		//Conection
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean successFlag = false; 

		// 1 Load, 2. connect
		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(SUBJECT_INSERT);
			pstmt.setString(1, svo.getNum());
			pstmt.setString(2, svo.getName());

			int result = pstmt.executeUpdate();
			successFlag = (result != 0 ) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag; 
	}

	public boolean subjectUpdate(LandPriceVO svo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean successFlag = false; 

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(SUBJECT_UPDATE);
			pstmt.setString(1, svo.getName());
			pstmt.setString(2, svo.getNum());

			int result = pstmt.executeUpdate();
			successFlag = (result != 0 ) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag; 
	}

	public boolean subjectDelete(LandPriceVO svo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean successFlag =false; 

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(SUBJECT_DELETE);
			pstmt.setString(1, svo.getNum());

			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false ;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag; 
	}

	public ArrayList<LandPriceVO> subjectSort() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<LandPriceVO> subjectList = new ArrayList<LandPriceVO>();

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(SUBJECT_SORT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String name = rs.getString("NAME");
				
				LandPriceVO svo = new LandPriceVO(no, num, name);
				subjectList.add(svo);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return subjectList; 
	}


}