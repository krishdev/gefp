package gefp.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ChkPtDetails")
public class ChkPtDetails {
	@Id
    @GeneratedValue
    @Column(name="cid")
    private Integer cid;
	private String CName;
	private String filepath;
	private String typeoffile;
	private Boolean chkmark=false;
	private boolean cdlt=false;
	
	@OneToMany(targetEntity=Combination.class,mappedBy="chkdt")
	private List<Combination> comb = new ArrayList<>();
	
	@ManyToMany(mappedBy="chkpt")
	private List<User> user = new ArrayList<>();
	
	public ChkPtDetails(){
		
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getTypeoffile() {
		return typeoffile;
	}
	public void setTypeoffile(String typeoffile) {
		this.typeoffile = typeoffile;
	}
	
	
	
	public Boolean getChkmark() {
		return chkmark;
	}

	public void setChkmark(Boolean chkmark) {
		this.chkmark = chkmark;
	}

	public boolean isCdlt() {
		return cdlt;
	}
	public void setCdlt(boolean cdlt) {
		this.cdlt = cdlt;
	}

	public List<Combination> getComb() {
		return comb;
	}

	public void setComb(List<Combination> comb) {
		this.comb = comb;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	


}
