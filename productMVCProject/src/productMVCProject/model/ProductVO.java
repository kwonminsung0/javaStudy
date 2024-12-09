package productMVCProject.model;

public class ProductVO {
	private int no; // -- 제품번호(PK, SEQ)
	private String code; // 제품코드(UK)
	private String name; // -- 제품명
	private String type; // -- 제품종류
	private int price; // -- 가격
	private int stock; // -- 재고량

	public ProductVO() {
		super();
	}

	public ProductVO(String code, String name, String type, int price, int stock) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
		this.stock = stock;
	}

	public ProductVO(int no, String code, String name, String type, int price, int stock) {
		super();
		this.no = no;
		this.code = code;
		this.name = name;
		this.type = type;
		this.price = price;
		this.stock = stock;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return String.format(
				"%-13s %-10s %-10s %-10s %-13s %-10s\n",
				no, code, name, type, price, stock);
	}

}
