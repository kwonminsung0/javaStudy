package studentTest2;

public class Students {
	private int stuId;
	private String name;
	private int kor;
	private int math;
	private int eng;
	private int total;
	private double avg;
	
	public Students(int stuId, String name, int kor, int math, int eng, int total, double avg) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.total = total;
		this.avg = avg;
	}

	public Students(String name, int kor, int math, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	public Students(int stuId, int kor, int math, int eng) {
		super();
		this.stuId = stuId;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Students [stuId=" + stuId + ", name=" + name + ", kor=" + kor + ", math=" + math + ", eng=" + eng
				+ ", total=" + total + ", avg=" + avg + "]";
	}
	
}
