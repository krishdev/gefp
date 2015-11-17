package gefp.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "FlightPlanDetails")
public class FlightPlanDetails {
	@Id
    @GeneratedValue
    private Integer id;
	private String name;
	
	private boolean ennabled=false;
	
	@OneToOne(mappedBy="flpid")
	private DepartmentDetails deptdetail;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "departmentdetails_flightplandetails",
    joinColumns = @JoinColumn(name = "plans_id"),
    inverseJoinColumns = @JoinColumn(name = "deptdetails_deptid"))
	private List<DepartmentDetails> deptdetails;
	
	@OneToMany(targetEntity=User.class,mappedBy="plan")
	private List<User> user;


	
	@OneToMany(targetEntity=Combination.class,mappedBy="flpd")
	private List<Combination> comb;	
	
	@ManyToMany(targetEntity=StageDetails.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name="fpstage",joinColumns={@JoinColumn(name="fpid",referencedColumnName="id")},inverseJoinColumns={@JoinColumn(name="stageid",referencedColumnName="sid")})
	@OrderColumn(name="orderIndex")
	private List<StageDetails> stage; 
	
	@ManyToMany(targetEntity=RunwayDetails.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name="fprunway",joinColumns={@JoinColumn(name="fpid",referencedColumnName="id")},inverseJoinColumns={@JoinColumn(name="runwayid",referencedColumnName="rid")})
	@OrderColumn(name="orderIndex")
	private List<RunwayDetails> runway; 
	
	public FlightPlanDetails(){
		
	}
	
	public List<Combination> getComb() {
		return comb;
	}
	public void setComb(List<Combination> comb) {
		this.comb = comb;
	}
	
	public DepartmentDetails getDeptdetail() {
		return deptdetail;
	}

	public void setDeptdetail(DepartmentDetails deptdetail) {
		this.deptdetail = deptdetail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isEnnabled() {
		return ennabled;
	}

	public void setEnnabled(boolean ennabled) {
		this.ennabled = ennabled;
	}



	

	public List<User> getUser() {
		return user;
	}



	public void setUser(List<User> user) {
		this.user = user;
	}



	public List<DepartmentDetails> getDeptdetails() {
		return deptdetails;
	}

	public void setDeptdetails(List<DepartmentDetails> deptdetails) {
		this.deptdetails = deptdetails;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//manytomanystage
	public List<StageDetails> getStage() {
		return stage;
	}

	public void setStage(List<StageDetails> stage) {
		this.stage = stage;
	}

	//manytomany runway
	public List<RunwayDetails> getRunway() {
		return runway;
	}

	public void setRunway(List<RunwayDetails> runway) {
		this.runway = runway;
	}

	
	
	
	
}
 