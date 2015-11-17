package gefp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Departmentdetails")
public class DepartmentDetails {
 
	@Id
    @GeneratedValue
    @Column(name = "deptid")
	private Integer deptid;
	 
	
	@Column(name="DepartmentName")
	private String departmentName;
	
	//Creating instance of User class 
	@OneToMany(targetEntity=User.class,mappedBy="major")
	private List<User> user = new ArrayList<User>();
	
	
	@OneToOne
	@JoinColumn(name="id")
	private FlightPlanDetails flpid;
	
	@ManyToMany(mappedBy="deptdetails")
	private List<FlightPlanDetails> plans;
	

	public DepartmentDetails(){
		
	}
	
	
	public FlightPlanDetails getFlpid() {
		return flpid;
	}


	public void setFlpid(FlightPlanDetails flpid) {
		this.flpid = flpid;
	}

	
	
	public List<User> getUser() {
		return user;
	}


	public void setUser(List<User> user) {
		this.user = user;
	}




	public Integer getDeptid() {
		return deptid;
	}


	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}


	

	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public List<FlightPlanDetails> getPlans() {
		return plans;
	}


	public void setPlans(List<FlightPlanDetails> plans) {
		this.plans = plans;
	}
	
	
}
