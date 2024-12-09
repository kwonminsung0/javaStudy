package productMVCProject.model;

import java.util.Date;

public class OrderAllVO {
	private int no; // -- 주문번호(PK, SEQ)
	private String id; // -- 주문ID(UK)
	private String c_name; // -- 주문자이름
	private String p_code; // -- 제품번호(FK(products))
	private String p_name; // -- 제품명
	private int quantity; // -- 주문수량
	private Date odate; // -- 주문날짜

	public OrderAllVO(int no, String id, String c_name, String p_code, String p_name, int quantity, Date odate) {
		super();
		this.no = no;
		this.id = id;
		this.c_name = c_name;
		this.p_code = p_code;
		this.p_name = p_name;
		this.quantity = quantity;
		this.odate = odate;
	}

	@Override
	public String toString() {
		return String.format(
				"%-10s %-14s %-12s %-10s %-12s %-8s %-10s\n",
				no, id, c_name, p_code, p_name, quantity, odate);
	}

}
