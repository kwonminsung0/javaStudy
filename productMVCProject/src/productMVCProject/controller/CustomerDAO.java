package productMVCProject.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import productMVCProject.model.CustomerAllVO;
import productMVCProject.model.CustomerVO;

public class CustomerDAO {
	public final String CUSTOMER_SELECT = "SELECT * FROM CUSTOMERS";
	public final String CUSTOMER_INSERT = "INSERT INTO CUSTOMERS VALUES(customers_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
	public final String CUSTOMER_UPDATE = "UPDATE CUSTOMERS SET NAME = ?, ID = ?, PASSWD = ?, BIRTHDAY = ?, PHONE = ? WHERE NO = ?";
	public final String CUSTOMER_DELETE = "DELETE FROM CUSTOMERS WHERE NO = ?";
	public final String CUSTOMER_ID_CHECK = "SELECT COUNT(*) AS COUNT FROM CUSTOMERS WHERE ID = ?";
	public final String CUSTOMER_SORT = "SELECT * FROM CUSTOMERS ORDER BY NO";
	public final String CUSTOMER_ORDER_JOIN_SELECT = "SELECT C.NO, C.NAME, C.ID, C.PASSWD, C.BIRTHDAY, C.PHONE, C.O_ID, O.QUANTITY AS ORDER_QUANTITY\r\n"
			+ "FROM CUSTOMERS C INNER JOIN ORDERS O ON C.O_ID = O.ID";

	public ArrayList<CustomerVO> customerSelect(CustomerVO cvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CustomerVO> customerList = new ArrayList<CustomerVO>();

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(CUSTOMER_SELECT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String id = rs.getString("ID");
				String passwd = rs.getString("PASSWD");
				String birthday = rs.getString("BIRTHDAY");
				String phone = rs.getString("PHONE");
				String o_id = rs.getString("O_ID");
				CustomerVO customerVO = new CustomerVO(no, name, id, passwd, birthday, phone, o_id);
				customerList.add(customerVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return customerList;
	}

	public boolean customerInsert(CustomerVO cvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(CUSTOMER_INSERT);
			pstmt.setString(1, cvo.getName());
			pstmt.setString(2, cvo.getId());
			pstmt.setString(3, cvo.getPasswd());
			pstmt.setString(4, cvo.getBirthday());
			pstmt.setString(5, cvo.getPhone());
			pstmt.setString(6, cvo.getO_id());

			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public boolean customerUpdate(CustomerVO cvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(CUSTOMER_UPDATE);
			pstmt.setString(1, cvo.getName());
			pstmt.setString(2, cvo.getId());
			pstmt.setString(3, cvo.getPasswd());
			pstmt.setString(4, cvo.getBirthday());
			pstmt.setString(5, cvo.getPhone());
			pstmt.setInt(6, cvo.getNo());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public boolean customerDelete(CustomerVO cvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(CUSTOMER_DELETE);
			pstmt.setInt(1, cvo.getNo());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public ArrayList<CustomerVO> customerSort() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CustomerVO> customerList = new ArrayList<CustomerVO>();

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(CUSTOMER_SORT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String id = rs.getString("ID");
				String passwd = rs.getString("PASSWD");
				String birthday = rs.getString("BIRTHDAY");
				String phone = rs.getString("PHONE");
				String o_id = rs.getString("O_ID");
				CustomerVO customerVO = new CustomerVO(no, name, id, passwd, birthday, phone, o_id);
				customerList.add(customerVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return customerList;
	}

	// 중복아이디 체크
	public boolean customerIdCheck(CustomerVO cvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(CUSTOMER_ID_CHECK);
			pstmt.setString(1, cvo.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("COUNT");
			} else {
				count = 0;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return (count != 0) ? (true) : (false);
	}

	// 해당주문과 고객정보를 조인해서 가져오기
	public ArrayList<CustomerAllVO> customerAllSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CustomerAllVO> customerAllList = new ArrayList<CustomerAllVO>();
		
		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(CUSTOMER_ORDER_JOIN_SELECT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String id = rs.getString("ID");
				String passwd = rs.getString("PASSWD");
				String birthday = rs.getString("BIRTHDAY");
				String phone = rs.getString("PHONE");
				String o_id = rs.getString("O_ID");
				int o_quantity = rs.getInt("ORDER_QUANTITY");
				CustomerAllVO cavo = new CustomerAllVO(no, name, id, passwd, birthday, phone, o_id, o_quantity);
				customerAllList.add(cavo);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return customerAllList;
	}
}
