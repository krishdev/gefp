package gefp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CombinationTable")
public class Combination {
	
	@Id
	@GeneratedValue
	@Column(name="Comid")
	private Integer Comid;
	
	//stage
	@ManyToOne
	@JoinColumn(name="Sid")
	private StageDetails stagedt;
	
	//runway
	@ManyToOne
	@JoinColumn(name="rid")
	private RunwayDetails runway;
	
	//chkpt 
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cid")
	@OrderBy("cid asc")
	private ChkPtDetails chkdt;
	
	private boolean chker=false;
	

	@ManyToOne
	private FlightPlanDetails flpd;

	public Combination(){
			
	}

	public FlightPlanDetails getFlpd() {
		return flpd;
	}



	public void setFlpd(FlightPlanDetails flpd) {
		this.flpd = flpd;
	}



	public Integer getComid() {
		return Comid;
	}
	public boolean isChker() {
		return chker;
	}


	public void setChker(boolean chker) {
		this.chker = chker;
	}


	public void setComid(Integer comid) {
		Comid = comid;
	}



	public StageDetails getStagedt() {
		return stagedt;
	}


	public void setStagedt(StageDetails stagedt) {
		this.stagedt = stagedt;
	}


	public RunwayDetails getRunway() {
		return runway;
	}


	public void setRunway(RunwayDetails runway) {
		this.runway = runway;
	}


	public ChkPtDetails getChkdt() {
		return chkdt;
	}


	public void setChkdt(ChkPtDetails chkdt) {
		this.chkdt = chkdt;
	}


		
}
