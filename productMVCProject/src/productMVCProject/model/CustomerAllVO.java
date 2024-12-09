package productMVCProject.model;

public class CustomerAllVO {
	private int no; // -- 고객번호(PK, SEQ)
	private String name; // -- 이름
	private String id; // -- 아이디(UK)
	private String passwd; // -- 패스워드
	private String birthday; // -- 생년월일
	private String phone; // -- 전화번호
	private String o_id; // -- 주문번호(FK(orders))
	private int o_quantity; // -- 주문수량(orders)

	public CustomerAllVO(int no, String name, String id, String passwd, String birthday, String phone, String o_id,
			int o_quantity) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.birthday = birthday;
		this.phone = phone;
		this.o_id = o_id;
		this.o_quantity = o_quantity;
	}

	@Override
	public String toString() {
		return String.format(
				"%-10s %-10s %-13s %-12s %-12s %-16s %-16s %-10s\n",
				no, name, id, passwd, birthday, phone, o_id, o_quantity);
	}

}
