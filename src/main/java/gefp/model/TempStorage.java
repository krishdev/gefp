package gefp.model;

public class TempStorage {
	
	private Integer cellid;
	
	private int sid;
	private int runid;
	private int chkid;
	private int chkuser;
	private String sname;
	private String chkpt;
	private String runway;
	public Integer getCellid() {
		return cellid;
	}
	public void setCellid(Integer cellid) {
		this.cellid = cellid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getChkpt() {
		return chkpt;
	}
	public void setChkpt(String chkpt) {
		this.chkpt = chkpt;
	}
	public String getRunway() {
		return runway;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getRunid() {
		return runid;
	}
	public void setRunid(int runid) {
		this.runid = runid;
	}
	public int getChkid() {
		return chkid;
	}
	public void setChkid(int chkid) {
		this.chkid = chkid;
	}
	public void setRunway(String runway) {
		this.runway = runway;
	}
	public int getChkuser() {
		return chkuser;
	}
	public void setChkuser(int chkuser) {
		this.chkuser = chkuser;
	}
	
}
