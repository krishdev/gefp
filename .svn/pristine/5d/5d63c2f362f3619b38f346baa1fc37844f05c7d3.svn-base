package gefp.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "StageDetails")
public class StageDetails {

	@Id
    @GeneratedValue
    @Column(name="Sid")
    private Integer sid;
	private String SName;
	private boolean sdlt=false;
	
	@OneToMany(targetEntity=Combination.class,mappedBy="stagedt")
	private List<Combination> comb = new ArrayList<>();
	
	
	
	public StageDetails()
	{
		
	}
	


	public List<Combination> getComb() {
		return comb;
	}

	public void setComb(List<Combination> comb) {
		this.comb = comb;
	}

	
	


	public Integer getSid() {
		return sid;
	}



	public void setSid(Integer sid) {
		this.sid = sid;
	}



	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}

	public boolean isSdlt() {
		return sdlt;
	}

	public void setSdlt(boolean sdlt) {
		this.sdlt = sdlt;
	}

	
	
}
