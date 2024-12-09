package productMVCProject.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import productMVCProject.model.OrderAllVO;
import productMVCProject.model.OrderVO;

public class OrderDAO {
	public final String ORDER_SELECT = "SELECT * FROM ORDERS";
	public final String ORDER_INSERT = "INSERT INTO ORDERS VALUES(orders_seq.NEXTVAL, ?, ?, ?, ?, sysdate)";
	public final String ORDER_UPDATE = "UPDATE ORDERS SET C_NAME = ?, P_CODE = ?, QUANTITY = ? WHERE ID = ? ";
	public final String ORDER_DELETE = "DELETE FROM ORDERS WHERE NO = ?";
	public final String ORDER_NUM_COUNT = "select LPAD(count(*)+1,4,'0') as TOTAL_COUNT from orders where p_code = ?";
	public final String ORDER_SORT = "SELECT * FROM ORDERS ORDER BY ID";
	public final String ORDER_PRODUCT_JOIN_SELECT = "SELECT O.NO, O.ID, O.C_NAME, O.P_CODE, P.NAME AS PRODUCT_NAME, O.QUANTITY, O.ODATE \r\n"
			+ "FROM ORDERS O INNER JOIN PRODUCTS P ON O.P_CODE = P.CODE";

	public ArrayList<OrderVO> orderSelect(OrderVO ovo){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		
		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(ORDER_SELECT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("NO");
				String id = rs.getString("ID");
				String c_name = rs.getString("C_NAME");
				String p_code = rs.getString("P_CODE");
				int quantity = rs.getInt("QUANTITY");
				Date odate = rs.getDate("ODATE");
				OrderVO orderVO = new OrderVO(no, id, c_name, p_code, quantity, odate);
				orderList.add(orderVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return orderList;
	}

	public boolean orderInsert(OrderVO ovo){
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(ORDER_INSERT);
			pstmt.setString(1, ovo.getId());
			pstmt.setString(2, ovo.getC_name());
			pstmt.setString(3, ovo.getP_code());
			pstmt.setInt(4, ovo.getQuantity());

			int result = pstmt.executeUpdate();
			System.out.println((result != 0) ? "입력성공" : "입력실패");
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, cstmt);
		}
		return successFlag;
	}

	public boolean orderUpdate(OrderVO ovo){
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(ORDER_UPDATE);
			pstmt.setString(1, ovo.getC_name());
			pstmt.setString(2, ovo.getP_code());
			pstmt.setInt(3, ovo.getQuantity());
			pstmt.setString(4, ovo.getId());
			int result = pstmt.executeUpdate();
			System.out.println((result != 0) ? "입력성공" : "입력실패");
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, cstmt);
		}
		return successFlag;
	}

	public boolean orderDelete(OrderVO ovo){
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(ORDER_DELETE);
			pstmt.setInt(1, ovo.getNo());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public ArrayList<OrderVO> orderSort(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(ORDER_SORT);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("NO");
				String id = rs.getString("ID");
				String c_name = rs.getString("C_NAME");
				String p_code = rs.getString("P_CODE");
				int quantity = rs.getInt("QUANTITY");
				Date odate = rs.getDate("ODATE");
				OrderVO orderVO = new OrderVO(no, id, c_name, p_code, quantity, odate);
				orderList.add(orderVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return orderList;
	}

	// 해당 제품번호가져오기
	public String getOrderCount(OrderVO ovo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;

		con = DBUtility.dbCon();
		try {
			pstmt = con.prepareStatement(ORDER_NUM_COUNT);
			pstmt.setString(1, ovo.getP_code());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("TOTAL_COUNT");
			} else {
				result = null;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return result;
	}

	// 해당재고와 주문정보를 조인해서 가져오기
	public ArrayList<OrderAllVO> orderAllSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<OrderAllVO> orderAllList = new ArrayList<OrderAllVO>();
		con = DBUtility.dbCon();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(ORDER_PRODUCT_JOIN_SELECT);
			if (rs.next()) {
				do {
					int no = rs.getInt("NO");
					String ID = rs.getString("ID");
					String c_name = rs.getString("C_NAME");
					String p_code = rs.getString("P_CODE");
					String p_name = rs.getString("PRODUCT_NAME");
					int quantity = rs.getInt("QUANTITY");
					Date odate = rs.getDate("ODATE");
					OrderAllVO oavo = new OrderAllVO(no, ID, c_name, p_code, p_name, quantity, odate);
					orderAllList.add(oavo);
				} while (rs.next());
			} else {
				orderAllList = null;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, stmt, rs);
		}
		return orderAllList;
	}
}
