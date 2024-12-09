package productMVCProject.model;

public class CustomerVO {
	private int no; // -- 고객번호(PK, SEQ)
	private String name; // -- 이름
	private String id; // -- 아이디(UK)
	private String passwd; // -- 패스워드
	private String birthday; // -- 생년월일
	private String phone; // -- 전화번호
	private String o_id; // -- 주문번호(FK(orders))

	public CustomerVO() {
		super();
	}

	public CustomerVO(int no, String name, String id, String passwd, String birthday, String phone) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.birthday = birthday;
		this.phone = phone;
	}

	public CustomerVO(int no, String name, String id, String passwd, String birthday, String phone, String o_id) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.birthday = birthday;
		this.phone = phone;
		this.o_id = o_id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getO_id() {
		return o_id;
	}

	public void setO_id(String o_id) {
		this.o_id = o_id;
	}

	@Override
	public String toString() {
		return String.format(
				"%-10s %-10s %-13s %-12s %-12s %-16s %-10s\n",
				no, name, id, passwd, birthday, phone, o_id);
	}

}
