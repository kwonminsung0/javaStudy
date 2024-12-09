package publicDataTest.model;

public class LandPriceVO {
	private int nodeno; 		// <nodeno>44810</nodeno>
	private Double gpslati; 	// <gpslati>36.43535</gpslati>
	private Double gpslong; 	// <gpslong>127.3863</gpslong>
	private String nodeid; 		// <nodeid>DJB8001793</nodeid>
	private String nodenm; 		// <nodenm>송강전통시장</nodenm>

	public LandPriceVO() {
	}

	public LandPriceVO(int nodeno, Double gpslati, Double gpslong, String nodeid, String nodenm) {
		super();
		this.nodeno = nodeno;
		this.gpslati = gpslati;
		this.gpslong = gpslong;
		this.nodeid = nodeid;
		this.nodenm = nodenm;
	}

	public int getNodeno() {
		return nodeno;
	}

	public void setNodeno(int nodeno) {
		this.nodeno = nodeno;
	}

	public Double getGpslati() {
		return gpslati;
	}

	public void setGpslati(Double gpslati) {
		this.gpslati = gpslati;
	}

	public Double getGpslong() {
		return gpslong;
	}

	public void setGpslong(Double gpslong) {
		this.gpslong = gpslong;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public String getNodenm() {
		return nodenm;
	}

	public void setNodenm(String nodenm) {
		this.nodenm = nodenm;
	}

	@Override
	public String toString() {
		return "LandPriceVO [nodeno=" + nodeno + ", gpslati=" + gpslati + ", gpslong=" + gpslong + ", nodeid=" + nodeid
				+ ", nodenm=" + nodenm + "]";
	}

}
