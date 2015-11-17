package gefp.model.dao;
import gefp.model.ChkPtDetails;
import gefp.model.Combination;
import gefp.model.DepartmentDetails;
import gefp.model.FlightPlanDetails;
import gefp.model.RunwayDetails;
import gefp.model.StageDetails;
import gefp.model.User;

import java.util.List;
import java.util.Set;

public interface StuDdao {

	User getStuDdetail (int id);
	
/*	StuDdetail getStuDdetail (int id);
*/	
	User getUserbyusernamenpassword(String uname, String pass);
	User getuser(int uname);
	User getStudbyname (String uname);
	DepartmentDetails getdeptbyid(int id);
	DepartmentDetails getdepartmentbyname(String deptname);
	ChkPtDetails getchkptnbyid(int id);
	FlightPlanDetails getflightplanbyid(int id);
	StageDetails getstagebyid(int id);
	RunwayDetails getrunwaybyid(int id);
	Combination getoptionsbycellid(int id);
	
	
	List<FlightPlanDetails> getflightplanbyidforoption(int id);
	List<DepartmentDetails> getdeptbyidlist(int id);
	List<User> getstudetailifchk(String uname);
	List<Combination> getstudplan(Integer stuid, Integer planid);
	List<Combination> getallcombi();
	List<User> getStuDdetailsbyunmae(String user);
	List<User> getStuDdetails();
	List<StageDetails> getStagedetails();
	List<StageDetails> getstagebyidlist(int id);
	List<RunwayDetails>getrunwaybyidlist(int id);
	List<RunwayDetails> getRunwaydetails();
	List<Combination> getstudetailifchkforjdoe2(String unmae);
	List<DepartmentDetails> getdepartments();
	
	List<ChkPtDetails> getchkptkbyids(int id);
	
	User saveUser(User user);
	StageDetails saveStage(StageDetails name);
	RunwayDetails saveRunway(RunwayDetails name);
	ChkPtDetails saveChkptn(ChkPtDetails name);
	Combination saveCell(Combination name);
	List<Combination> savelistCell(List<Combination> name);

	FlightPlanDetails saveFPDT(FlightPlanDetails name);
	DepartmentDetails saveDept(DepartmentDetails name);
	
	
	//autocomplete
	List<User> searchUsersByPrefix( String term, int maxResults );
	List<User> searchUsers( String term );

	User getUserByUsername(String username);

	
}