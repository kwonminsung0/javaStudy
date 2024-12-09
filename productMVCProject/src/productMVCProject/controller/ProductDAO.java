package productMVCProject.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import productMVCProject.model.ProductVO;

public class ProductDAO {

	public final String PRODUCT_SELECT = "SELECT * FROM PRODUCTS";
	public final String PRODUCT_INSERT = "INSERT INTO PRODUCTS VALUES (products_seq.nextval, ?, ?, ?, ?, ?)";
	public final String PRODUCT_UPDATE = "UPDATE PRODUCTS SET CODE = ?, NAME = ?, TYPE = ?, PRICE = ?, STOCK = ? WHERE NO = ?";
	public final String PRODUCT_DELETE = "DELETE FROM PRODUCTS WHERE NO = ?";
	public final String PRODUCT_SORT = "SELECT * FROM PRODUCTS ORDER BY CODE";

	public ArrayList<ProductVO> productSelect(ProductVO pvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(PRODUCT_SELECT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String code = rs.getString("CODE");
				String name = rs.getString("NAME");
				String type = rs.getString("TYPE");
				int price = rs.getInt("PRICE");
				int stock = rs.getInt("STOCK");
				ProductVO productVO = new ProductVO(no, code, name, type, price, stock);
				productList.add(productVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return productList;
	}

	public boolean productInsert(ProductVO pvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(PRODUCT_INSERT);
			pstmt.setString(1, pvo.getCode());
			pstmt.setString(2, pvo.getName());
			pstmt.setString(3, pvo.getType());
			pstmt.setInt(4, pvo.getPrice());
			pstmt.setInt(5, pvo.getStock());
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

	public boolean productUpdate(ProductVO pvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(PRODUCT_UPDATE);
			pstmt.setString(1, pvo.getCode());
			pstmt.setString(2, pvo.getName());
			pstmt.setString(3, pvo.getType());
			pstmt.setInt(4, pvo.getPrice());
			pstmt.setInt(5, pvo.getStock());
			pstmt.setInt(6, pvo.getNo());

			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, cstmt);
		}
		return successFlag;
	}

	public boolean productDelete(ProductVO pvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(PRODUCT_DELETE);
			pstmt.setInt(1, pvo.getNo());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? (true) : (false);
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public ArrayList<ProductVO> productSort(ProductVO pvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(PRODUCT_SORT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String code = rs.getString("CODE");
				String name = rs.getString("NAME");
				String type = rs.getString("TYPE");
				int price = rs.getInt("PRICE");
				int stock = rs.getInt("STOCK");
				ProductVO productVO = new ProductVO(no, code, name, type, price, stock);
				productList.add(productVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return productList;
	}
}
