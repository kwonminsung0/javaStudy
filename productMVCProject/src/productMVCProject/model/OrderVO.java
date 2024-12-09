package productMVCProject.model;

import java.util.Date;

public class OrderVO {
	private int no; // -- 주문번호(PK, SEQ)
	private String id; // -- 주문ID(UK)
	private String c_name; // -- 주문자이름
	private String p_code; // -- 제품번호(FK(products))
	private int quantity; // -- 주문수량
	private Date odate; // -- 주문날짜

	public OrderVO() {
		super();
	}

	public OrderVO(String id, String c_name, String p_code, int quantity) {
		super();
		this.id = id;
		this.c_name = c_name;
		this.p_code = p_code;
		this.quantity = quantity;
	}

	public OrderVO(int no, String id, String c_name, String p_code, int quantity, Date odate) {
		super();
		this.no = no;
		this.id = id;
		this.c_name = c_name;
		this.p_code = p_code;
		this.quantity = quantity;
		this.odate = odate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOdate() {
		return odate;
	}

	public void setOdate(Date odate) {
		this.odate = odate;
	}

	@Override
	public String toString() {
		return String.format(
				"%-10s %-14s %-12s %-11s %-9s %-10s\n",
				no, id, c_name, p_code, quantity, odate);
	}

}
