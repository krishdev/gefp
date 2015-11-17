package gefp.web.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;

import gefp.model.ChkPtDetails;
import gefp.model.Combination;
import gefp.model.DepartmentDetails;
import gefp.model.FlightPlanDetails;
import gefp.model.RunwayDetails;
import gefp.model.StageDetails;
import gefp.model.TempRunway;
import gefp.model.TempStage;
import gefp.model.TempStorage;
import gefp.model.User;
import gefp.model.dao.Combintaiondao;
import gefp.model.dao.StuDdao;
import gefp.web.validator.LoginValidator;
import gefp.web.validator.PlanValidator;
import gefp.web.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("users")
public class UserController {

	@Autowired
	StuDdao userdao;
	
	@Autowired
	Combintaiondao combdao;
	
	@Autowired
	UserValidator validator;
	
	@Autowired
	LoginValidator loginvalid;
	
	@Autowired
	PlanValidator planvalidator;
	
	@RequestMapping("/list.html")
	public String users( ModelMap model )
	{
	/*	model.put("users", userdao.getStuDdetails());*/
		return "list";
	}
	
	@RequestMapping("/view.html")
	public String view(@RequestParam Integer id, ModelMap model)
	{
		model.put("user", userdao.getStuDdetail(id));
		return "view";
	}
	
	@RequestMapping("/view/{id}.html")
	public String view2(@PathVariable Integer id, ModelMap model )
	{
		return view( id, model );
	}
	
	@RequestMapping("/user/viewPlan.html")
	public String viewPlan( ModelMap model,Authentication authentication)
	{
		User user=(User) authentication.getPrincipal();
		Integer stuid= user.getId();
		int planid=userdao.getStuDdetail(stuid).getPlan().getId();
		FlightPlanDetails fpobj = userdao.getflightplanbyid(planid);
		int sizeofchkbyuser=userdao.getStuDdetail(stuid).getChkpt().size();
		int combi = userdao.getflightplanbyid(planid).getComb().size();
		List<TempStorage> temps = new ArrayList<>();
	
		
		//plan runway
		List<RunwayDetails> listofrunway = fpobj.getRunway();
		model.put("planrunwaydetails", listofrunway);
		
		//plan stage
		
		List<StageDetails> listofstage = fpobj.getStage();
		model.put("planstagedetails", listofstage);
		
		//cells
		for(int i=0;i<combi;i++){
			TempStorage tmp = new TempStorage();
			int curent =userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getChkdt().getCid();
			if(userdao.getflightplanbyid(planid).getComb().get(i).isChker()==true){
		//System.out.println("Runway: "+userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getRunway().getRName());
		tmp.setCellid(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getComid());
		tmp.setRunway(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getRunway().getRName());
		tmp.setRunid(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getRunway().getRid());
		tmp.setChkpt(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getChkdt().getCName());
		tmp.setChkid(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getChkdt().getCid());
		tmp.setSname(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getStagedt().getSName());
		tmp.setSid(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getStagedt().getSid());
		
		for(int j=0;j<sizeofchkbyuser;j++){
			int chus= userdao.getStuDdetail(stuid).getChkpt().get(j).getCid();
			if(chus==curent){
				tmp.setChkuser(chus);
				break;
			}
		}
		
		temps.add(tmp);
			}
		}
		model.put("cells", temps);
		
		List<ChkPtDetails>chkpts = new ArrayList<>();
		
		for(int i=0;i<sizeofchkbyuser;i++){
			ChkPtDetails chk = new ChkPtDetails();
			chk.setCid(userdao.getStuDdetail(stuid).getChkpt().get(i).getCid());
			chkpts.add(chk);
		}
		model.put("chuser", chkpts);
		model.put("flplanid", planid);
		model.put("u", userdao.getStuDdetail(stuid));
		return "/user/planSearch";
	}
	
	//advisor planview
	@RequestMapping("/advi/advisorPlan.html")
	public String advisorPlan(@RequestParam int stuid, ModelMap model,Authentication authentication)
	{
		/*User user=(User) authentication.getPrincipal();
		Integer stuid= user.getId();*/
		User verify = userdao.getStuDdetail(stuid);
		String plan="/advi/advisor";
		if(verify.isStudent()){
			int planid=userdao.getStuDdetail(stuid).getPlan().getId();
			FlightPlanDetails fpobj = userdao.getflightplanbyid(planid);

			int sizeofchkbyuser=userdao.getStuDdetail(stuid).getChkpt().size();
			int combi = userdao.getflightplanbyid(planid).getComb().size();
			List<TempStorage> temps = new ArrayList<>();
			
			//plan runway
			List<RunwayDetails> listofrunway = fpobj.getRunway();
			model.put("planrunwaydetails", listofrunway);
			
			//plan stage
			List<StageDetails> listofstage = fpobj.getStage();
			model.put("planstagedetails", listofstage);
			
			//cells
			for(int i=0;i<combi;i++){
				TempStorage tmp = new TempStorage();
				int curent =userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getChkdt().getCid();
			//System.out.println("Runway: "+userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getRunway().getRName());
				if(userdao.getflightplanbyid(planid).getComb().get(i).isChker()==true){
			tmp.setCellid(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getComid());
			tmp.setRunway(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getRunway().getRName());
			tmp.setRunid(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getRunway().getRid());
			tmp.setChkpt(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getChkdt().getCName());
			tmp.setChkid(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getChkdt().getCid());
			tmp.setSname(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getStagedt().getSName());
			tmp.setSid(userdao.getStuDdetail(stuid).getPlan().getComb().get(i).getStagedt().getSid());
			
			for(int j=0;j<sizeofchkbyuser;j++){
				int chus= userdao.getStuDdetail(stuid).getChkpt().get(j).getCid();
				if(chus==curent){
					tmp.setChkuser(chus);
					break;
				}
			}
			
			temps.add(tmp);
				}
			}
			model.put("cells", temps);
			
			List<ChkPtDetails>chkpts = new ArrayList<>();
			
			for(int i=0;i<sizeofchkbyuser;i++){
				ChkPtDetails chk = new ChkPtDetails();
				chk.setCid(userdao.getStuDdetail(stuid).getChkpt().get(i).getCid());
				chkpts.add(chk);
			}
			model.put("chuser", chkpts);
			model.put("flplanid", planid);
			model.put("aduserid",stuid);
			model.put("u", userdao.getStuDdetail(stuid));
			plan="/advi/adviPlanSearch";
		}
		else model.put("error", "sorry! selected user is not a student");
		
		return plan;
	}
	
	@RequestMapping("/user/profile.html")
	public String profile(ModelMap models, Authentication authentication){
		User users = (User) authentication.getPrincipal();
		
		String uname = users.getUsername();
		User user = userdao.getStudbyname(uname);
		int stuid = user.getId();
		int planid = user.getPlan().getId();
		models.put("usern", user);
		models.put("stud", stuid);
		models.put("plan", planid);
		return "/user/profile";
	}
	
	@RequestMapping(value="/user/editProfile.html",method=RequestMethod.GET)
	public String editProfile(ModelMap model,Authentication authentication){
		
	
		User users = (User) authentication.getPrincipal();
		String uname = users.getUsername();
		User user = userdao.getStudbyname(uname);
		int stuid = user.getId();
		int planid = user.getPlan().getId();
		User eProfile = userdao.getStudbyname(uname);
		model.put("users", userdao.getuser(stuid));
		System.out.println("userchk: "+ userdao.getuser(stuid).getChkpt());
		List<DepartmentDetails> deptlist=new ArrayList<>();
		int deptsize=userdao.getdepartments().size();
		for(int i=0; i<deptsize; i++){
			String deptname=userdao.getdepartments().get(i).getDepartmentName();
			int deptsid=userdao.getdepartments().get(i).getDeptid();
			DepartmentDetails setdept = new DepartmentDetails();
			setdept.setDepartmentName(deptname);
			setdept.setDeptid(deptsid);
			deptlist.add(setdept);
			System.out.println(userdao.getdepartments().get(i).getDeptid());
		}
		model.put("deptnames", deptlist);

		
		int dp=eProfile.getMajor().getDeptid();
		model.put("cdpt", dp);
		model.put("stud", stuid);
		model.put("plan", planid);
		return "/user/editProfile";
	}
	
	@RequestMapping(value="/user/editProfile.html",method=RequestMethod.POST)
	public String editProfile(@ModelAttribute("users") User users, BindingResult result,@RequestParam int deptid,SessionStatus status,ModelMap model,Authentication authentication){
	//	
		
		validator.validate(users, result);
		if(result.hasErrors()) return "editProfile";
		
		int uid = users.getId();
		List<ChkPtDetails> cklist = userdao.getStuDdetail(uid).getChkpt();
		System.out.println("chkpts");
		DepartmentDetails major = userdao.getdeptbyid(deptid);
		DepartmentDetails previousmajor = users.getMajor();
		
		FlightPlanDetails fpd=null;
		if(!users.getPassword1().isEmpty()){
			users.setPassword(users.getPassword1());
		}
		else{
			users.setPassword(users.getPassword());
		}
		if(previousmajor.getDeptid().equals(major.getDeptid())){
			 fpd = users.getPlan();
		}
		else fpd = major.getFlpid();

		//users.setChkpt(userchk);
		users.setMajor(major);
		users.setPlan(fpd);
		users.setChkpt(cklist);
		users = userdao.saveUser(users);
		status.setComplete();
		return "redirect:/user/profile.html";
	}
	
	
	@RequestMapping(value="/admin/planHome.html", method=RequestMethod.GET)
	public String plan( Map<String, Object> model )
	{
		DepartmentDetails deptdForm = new DepartmentDetails();
		model.put("deptForm", deptdForm);

		List<DepartmentDetails> deptlist=new ArrayList<>();
		int deptsize=userdao.getdepartments().size();
		for(int i=0; i<deptsize; i++){
			String deptname=userdao.getdepartments().get(i).getDepartmentName();
			int deptsid=userdao.getdepartments().get(i).getDeptid();
			DepartmentDetails setdept = new DepartmentDetails();
			setdept.setDepartmentName(deptname);
			setdept.setDeptid(deptsid);
			deptlist.add(setdept);
			System.out.println(userdao.getdepartments().get(i).getDeptid());
		}
		model.put("deptnames", deptlist);
		
		model.put("user",new User());
		return "/admin/planHome";
	}
	
	@RequestMapping(value="/admin/planHome.html", method=RequestMethod.POST)
	public String plan(@ModelAttribute("deptForm") DepartmentDetails dept,@RequestParam int deptid,String ok, ModelMap model)
	{
		String path="/admin/planHome";
		String btntype=ok;
		//int sizeofplanbydept= userdao.getdepartmentbyname(departmentName).getPlans().size();
		//int mainplanidofdept= userdao.getdepartmentbyname(departmentName).getDeptid().
		if(btntype.equals("OK")){
			int sizeofplans=userdao.getdeptbyid(deptid).getPlans().size();
			List<FlightPlanDetails> fpd= new ArrayList<>();
			for(int i=0; i<sizeofplans;i++){
				FlightPlanDetails fpds=new FlightPlanDetails();
				fpds.setId(userdao.getdeptbyid(deptid).getPlans().get(i).getId());
				fpds.setName(userdao.getdeptbyid(deptid).getPlans().get(i).getName());
				fpd.add(fpds);
			}
			model.put("flpdetail", fpd);
			int currentplan =userdao.getdeptbyid(deptid).getFlpid().getId();
			model.put("currentplan", currentplan);
			model.put("deptid", deptid);
			List<DepartmentDetails> deptlist=new ArrayList<>();
			int deptsize=userdao.getdepartments().size();
			for(int i=0; i<deptsize; i++){
				String deptname=userdao.getdepartments().get(i).getDepartmentName();
				int deptsid=userdao.getdepartments().get(i).getDeptid();
				DepartmentDetails setdept = new DepartmentDetails();
				setdept.setDepartmentName(deptname);
				setdept.setDeptid(deptsid);
				deptlist.add(setdept);
				System.out.println(userdao.getdepartments().get(i).getDeptid());
			}
			model.put("deptnames", deptlist);
			//model.put("deptnames",professionList);
			model.put("deptnamess",userdao.getdeptbyid(deptid).getDepartmentName());
			path="/admin/planHome";
		}
		
	
		return path;
	}
	
	@RequestMapping("/admin/viewSearchResult.html")
	public String viewSearchResult(@RequestParam int deptid,String ok, ModelMap model){
		String path="/admin/planHome";
		String btntype=ok;
		//int sizeofplanbydept= userdao.getdepartmentbyname(departmentName).getPlans().size();
		//int mainplanidofdept= userdao.getdepartmentbyname(departmentName).getDeptid().
		if(btntype.equals("OK")){
			int sizeofplans=userdao.getdeptbyid(deptid).getPlans().size();
			List<FlightPlanDetails> fpd= new ArrayList<>();
			for(int i=0; i<sizeofplans;i++){
				FlightPlanDetails fpds=new FlightPlanDetails();
				fpds.setId(userdao.getdeptbyid(deptid).getPlans().get(i).getId());
				fpds.setName(userdao.getdeptbyid(deptid).getPlans().get(i).getName());
				fpd.add(fpds);
			}
			
			model.put("flpdetail", fpd);
			int currentplan =userdao.getdeptbyid(deptid).getFlpid().getId();
			model.put("currentplan", currentplan);
			model.put("deptid", deptid);
			List<DepartmentDetails> deptlist=new ArrayList<>();
			int deptsize=userdao.getdepartments().size();
			for(int i=0; i<deptsize; i++){
				String deptname=userdao.getdepartments().get(i).getDepartmentName();
				int deptsid=userdao.getdepartments().get(i).getDeptid();
				DepartmentDetails setdept = new DepartmentDetails();
				setdept.setDepartmentName(deptname);
				setdept.setDeptid(deptsid);
				deptlist.add(setdept);
				System.out.println(userdao.getdepartments().get(i).getDeptid());
			}
			model.put("deptnames", deptlist);
			//model.put("deptnames",professionList);
			//System.out.println(userdao.getdeptbyid(deptid).getDepartmentName());
			
			path="/admin/planHome";
		}
		
	
		return path;
	}
	
	@RequestMapping(value = "/admin/searchPlan.html")
	public String searchPlan(@RequestParam int planid, String ok, ModelMap model)
	{
		String path="/admin/searchHome";
		String btntype=ok;
		if(btntype.equals("VIEW")){
			//int planid= Integer.parseInt(departmentName);
			
			int sizeofcombiviaplanid= userdao.getflightplanbyid(planid).getComb().size();
			FlightPlanDetails fpobj = userdao.getflightplanbyid(planid);
			String planname=userdao.getflightplanbyid(planid).getName();
			//plan runway
			List<RunwayDetails> listofrunway = fpobj.getRunway();
			model.put("planrunwaydetails", listofrunway);
			
			//plan stage
			
			List<StageDetails> listofstage = fpobj.getStage();
			model.put("planstagedetails", listofstage);
			
			
			TempStorage storeForm = new TempStorage();
			List<TempStorage> temps = new ArrayList<>();
			//cells
			for(int i=0;i<sizeofcombiviaplanid;i++){
				TempStorage tmp = new TempStorage();

				//System.out.println("Runway: "+userdao.getflightplanbyid(planid).getComb().get(i).getRunway().getRName());
				if(userdao.getflightplanbyid(planid).getComb().get(i).isChker()==true){
				tmp.setCellid(userdao.getflightplanbyid(planid).getComb().get(i).getComid());
				tmp.setRunway(userdao.getflightplanbyid(planid).getComb().get(i).getRunway().getRName());
				tmp.setRunid(userdao.getflightplanbyid(planid).getComb().get(i).getRunway().getRid());
				tmp.setChkpt(userdao.getflightplanbyid(planid).getComb().get(i).getChkdt().getCName());
				tmp.setChkid(userdao.getflightplanbyid(planid).getComb().get(i).getChkdt().getCid());
				tmp.setSname(userdao.getflightplanbyid(planid).getComb().get(i).getStagedt().getSName());
				tmp.setSid(userdao.getflightplanbyid(planid).getComb().get(i).getStagedt().getSid());
				temps.add(tmp);
				}
			}
			model.put("storesForm",storeForm);
			model.put("cells", temps);
			model.put("flplanid", planid);
			
			path= "/admin/searchHome";
		}
		return path;
	}
	
	//AddStage
	@RequestMapping(value="/admin/addOptions.html",method=RequestMethod.GET)
	public String addOptions(@RequestParam String btn,int planid,  ModelMap models)
	{
		int sizeofstg=userdao.getStagedetails().size();//this will be more in number or equal with a particular plan
		List<StageDetails> liststg=new ArrayList<>();
		
			for(int i=0;i<sizeofstg;i++){
				StageDetails tmpstg= new StageDetails();
				tmpstg.setSid(userdao.getStagedetails().get(i).getSid());
				tmpstg.setSName(userdao.getStagedetails().get(i).getSName());
				liststg.add(tmpstg);
			}
			
		models.put("setofstg",liststg);
		StageDetails StageForm = new StageDetails();
		models.put("planid",planid);
		if(btn.equals("exist")){
			models.put("error","Stage already exist please select a new one or type one.");
		}
		if(btn.equals("edit")){
			models.put("error","Stage name is empty.");
		}
		models.put("StageForm", StageForm);
		models.put("user", new User());
		return "/admin/addOptions";
	}
	
	@RequestMapping(value="/admin/addOptions.html",method=RequestMethod.POST)
	public String addOptions(@ModelAttribute("StageForm") StageDetails stg,@RequestParam int planid, String SName, String add, ModelMap models)
	{
		String btntype=add;
		if(!SName.isEmpty()){
		if(btntype.equals("ADDStage"))
		{
			StageDetails stage =new StageDetails();
			stage.setSName(SName);
			FlightPlanDetails flplan = userdao.getflightplanbyid(planid);
			flplan.getStage().add(stage);
			userdao.saveFPDT(flplan);
		}
		}
		else
		{
			return "redirect:/admin/addOptions.html?btn=edit&planid="+planid;
		}
		//models.put("user", "");
		return "redirect:/admin/searchPlan.html?planid="+planid+"&ok=VIEW";
	}
	
	//edit stage
	@RequestMapping(value="/admin/editStage.html",method=RequestMethod.GET)
	public String editStage(@RequestParam int sid, int planid,  ModelMap models)
	{
		StageDetails stage = userdao.getstagebyid(sid);
		
		models.put("stage", stage);
		models.put("planid", planid);
		
		return "/admin/editStage";
	}
	
	@RequestMapping(value="/admin/editStage.html",method=RequestMethod.POST)
	public String editStage(@RequestParam String SName, int sid, int planid,  ModelMap models)
	{
		if(!SName.isEmpty()){
		
			StageDetails stage =new StageDetails();
			stage.setSid(sid);
			stage.setSName(SName);			
			userdao.saveStage(stage);
		}
		else
		{
			return "redirect:/admin/editStage.html?sid="+sid+"&planid="+planid;
		}
		//models.put("user", "");
		return "redirect:/admin/searchPlan.html?planid="+planid+"&ok=VIEW";
	}
	
	//Add Runway
	@RequestMapping(value="/admin/addRunway.html",method=RequestMethod.GET)
	public String addRunway(@RequestParam String btn,int planid,  ModelMap models)
	{
		
		//int planid=1;
		int sizeofrun=userdao.getRunwaydetails().size();//this will be more in number or equal with a particular plan
		List<RunwayDetails> listrun=new ArrayList<>();
		
			for(int i=0;i<sizeofrun;i++){
				RunwayDetails tmprun= new RunwayDetails();
				tmprun.setRid(userdao.getRunwaydetails().get(i).getRid());
				tmprun.setRName(userdao.getRunwaydetails().get(i).getRName());
				listrun.add(tmprun);
		
			
		}
			
			
		models.put("setofrunw",listrun);

		RunwayDetails RunwayForm = new RunwayDetails();
		models.put("planid",planid);
		if(btn.equals("exist")){
			models.put("error","Runway already exist please select a new one or type one.");
		}
		if(btn.equals("edit")){
			models.put("error","Runway is empty.");
		}
		models.put("RunwayForm", RunwayForm);
		models.put("user", new User());
		return "/admin/addRunway";
	}
	
	@RequestMapping(value="/admin/addRunway.html",method=RequestMethod.POST)
	public String addRunway(@ModelAttribute("RunwayForm") RunwayDetails run,@RequestParam int planid, String RName, String add)
	{
		
		
		FlightPlanDetails flplan = userdao.getflightplanbyid(planid);
			RunwayDetails runway = new RunwayDetails();
			if(!RName.isEmpty()){
				
			runway.setRName(RName);
			flplan.getRunway().add(runway);	
			userdao.saveFPDT(flplan);
			}
			else{
				return "redirect:addRunway.html?btn=edit&planid="+planid;
			}
			return "redirect:/admin/searchPlan.html?planid="+planid+"&ok=VIEW";
	}
	
	//edit runway
	@RequestMapping(value="/admin/editrunway.html",method=RequestMethod.GET)
	public String editrunway(@RequestParam int planid,ModelMap models){
		/*(@RequestParam int rid, int planid, ModelMap models)*/
		List<RunwayDetails> runway = userdao.getflightplanbyid(planid).getRunway();
		models.put("runw", runway);
		models.put("planid", planid);
		return "/admin/editRunway";
	}
	
	@RequestMapping(value="/admin/editrunway.html",method=RequestMethod.POST)
	public String editrunway(@RequestParam String RName, int rid, int planid, ModelMap models){
		
		RunwayDetails runway = new RunwayDetails();
		if(!RName.isEmpty()){
			
		runway.setRid(rid);
		runway.setRName(RName);
		userdao.saveRunway(runway);
		}
		else{
			return "redirect:editRunway.html?btn=edit&planid="+planid;
		}
		return "redirect:/admin/searchPlan.html?planid="+planid+"&ok=VIEW";
	}
	
	//Add Checkpoint
	@RequestMapping(value="/admin/addCheckpoint.html",method=RequestMethod.GET)
	public String addCheckpoint(@RequestParam String btn,int planid,  ModelMap models)
	{
		FlightPlanDetails fp = userdao.getflightplanbyid(planid);

		System.out.println("Entered add checkpoint get");
		List<StageDetails> tempstageways = fp.getStage();
		List<RunwayDetails> temprunways= fp.getRunway();
		
		if(btn.equals("errorcheckpoint")){
			models.put("error", "Checkpoint is empty");
		}
		else if(btn.equals("errorstgrun")){
			models.put("error", "Stage & Runway should have value");
		}
		models.put("stages", tempstageways);
		models.put("runways", temprunways);
		//int planid=1;
		ChkPtDetails ChkptnForm = new ChkPtDetails();
		models.put("planid",planid);
		models.put("option",btn);
		models.put("ChkptnForm", ChkptnForm);
		models.put("user", new User());
		return "/admin/checkPoints";
	}
	
	@RequestMapping(value="/admin/addCheckpoint.html",method=RequestMethod.POST)
	public String addCheckpoint(@RequestParam int planid, Integer stageid, Integer runwayid, String chkptn,ModelMap model)
	{
		if(stageid != null && runwayid != null){
			if(!chkptn.isEmpty()){
				ChkPtDetails chkpt = new ChkPtDetails();
				chkpt.setCName(chkptn);
				//userdao.saveChkptn(chkpt);
				
				
				
				Combination cell = new Combination();
				FlightPlanDetails flplan = userdao.getflightplanbyid(planid);
				RunwayDetails runid =userdao.getrunwaybyid(runwayid);
				StageDetails stage=userdao.getstagebyid(stageid);
				cell.setChkdt(chkpt);
				cell.setFlpd(flplan);
				cell.setRunway(runid);
				cell.setStagedt(stage);
				cell.setChker(true);
				chkpt.getComb().add(cell);
				userdao.saveCell(cell);
			}
			else{

				return "redirect:/admin/addCheckpoint.html?btn=errorcheckpoint&planid="+planid;
			}
			
		}
		else 
		{
			return "redirect:/admin/addCheckpoint.html?btn=errorstgrun&planid="+planid;
			
		}
		
		
		
		return "redirect:/admin/searchPlan.html?planid="+planid+"&ok=VIEW";
	}
	
	//Edit Checkpoint
	@RequestMapping(value="/admin/editCheckpoint.html",method=RequestMethod.GET)
	public String editCheckpoint(@RequestParam int chkid,int cellid, int stageid, int runwayid, int planid,  ModelMap models)
	{
		FlightPlanDetails fp = userdao.getflightplanbyid(planid);
		
		List<StageDetails> tempstageways = fp.getStage();
		List<RunwayDetails> temprunways= fp.getRunway();
		
		models.put("stages", tempstageways);
		models.put("runways", temprunways);
		ChkPtDetails ckt = userdao.getchkptnbyid(chkid);
		models.put("ckname", ckt.getCName());
		models.put("chkid",chkid);
		models.put("planid", planid);
		models.put("cellid", cellid);
		models.put("stage_id",stageid);
		models.put("runwayid", runwayid);
		return "/admin/editchkpt";
	}
	
	@RequestMapping(value="/admin/editCheckpoint.html",method=RequestMethod.POST)
	public String editCheckpoint(@RequestParam int chkid,int cellid, int stageid, int runwayid, int planid, String cname, ModelMap models)
	{
		StageDetails stagedt= new StageDetails();
		stagedt.setSid(stageid);
		RunwayDetails runway= new RunwayDetails();
		runway.setRid(runwayid);
		FlightPlanDetails flpd= new FlightPlanDetails();
		flpd.setId(planid);
		
		ChkPtDetails chkpt = new ChkPtDetails();
		chkpt.setCid(chkid);
		chkpt.setCName(cname);
		userdao.saveChkptn(chkpt);
		
		Combination cell = new Combination();
		cell.setComid(cellid);
		cell.setFlpd(flpd);
		cell.setChkdt(chkpt);
		cell.setRunway(runway);
		cell.setStagedt(stagedt);
		cell.setChker(true);
		userdao.saveCell(cell);
		return "redirect:/admin/searchPlan.html?planid="+planid+"&ok=VIEW";
	}
	
	//login	
	@RequestMapping(value="/gefpLogin.html",method=RequestMethod.GET)
	public String login(ModelMap models)
	{
		
		models.put("user", new User());
		return "/gefpLogin";
	}
	
	//logout
	@RequestMapping(value = "/logout.html")
	public String logout( HttpSession session,ModelMap model )
	{
	session.invalidate();
	model.put("erroruser", "You've been logged out successfully.");
	return "redirect:/gefpLogin.html";
	}

	//404
	@RequestMapping(value="/404.html",method=RequestMethod.GET)
	public String login()
	{
		
		return "/404";
	}
	
	
	
	@RequestMapping(value = "/admin/gefphome.html", method = RequestMethod.GET)
	public String planHome( ModelMap model)
	{
		
		model.put("username", new User());
		return "redirect:/admin/planHome";
	}
	@RequestMapping(value = "/admin/gefphome.html", method = RequestMethod.POST)
	public String planHome()
	{
		return "redirect:/admin/planHome";
	}
	
	//ADD PLAN
	@RequestMapping(value="/admin/addPlan.html")
	public String addPlan(@RequestParam int deptid,ModelMap models){
		
		int sizeofstage=userdao.getStagedetails().size();
		int sizeofrunway=userdao.getRunwaydetails().size();
		List<StageDetails> liststage = new ArrayList<>();
		List<RunwayDetails> listrunway = new ArrayList<>();
		for(int i=0;i<sizeofstage;i++){
		StageDetails stg= new StageDetails();
		
		stg.setSid(userdao.getStagedetails().get(i).getSid());
		stg.setSName(userdao.getStagedetails().get(i).getSName());
		liststage.add(stg);
		}
		for(int i=0;i<sizeofrunway;i++){
			RunwayDetails run= new RunwayDetails();
			
			run.setRid(userdao.getRunwaydetails().get(i).getRid());
			run.setRName(userdao.getRunwaydetails().get(i).getRName());
			listrunway.add(run);
			}
		models.put("stages", liststage);
		models.put("runways", listrunway);
		models.put("deptid", deptid);
		return "/admin/addPlan";
	}
	
	@RequestMapping("/admin/existStage.html")
	public String existStage(@RequestParam int planid, int sid,ModelMap model)
	{		
		FlightPlanDetails flp = userdao.getflightplanbyid(planid);
		StageDetails stg = userdao.getstagebyid(sid);
		
		flp.getStage().add(stg);
		userdao.saveFPDT(flp);
		
		
		
		return "redirect:/admin/searchPlan.html?planid="+planid+"&ok=VIEW";
		
	}
	
	//add existingrunway
	@RequestMapping("/admin/existRunway.html")
	public String existRunway(@RequestParam int planid, int rid,ModelMap model)
	{		
		FlightPlanDetails flp = userdao.getflightplanbyid(planid);
		RunwayDetails run = userdao.getrunwaybyid(rid);
		Boolean isexist=false;
		String plan="/admin/addRunway";
		List<RunwayDetails> listrunway = flp.getRunway();
		
		for (Iterator iterator = listrunway.iterator(); iterator.hasNext();) {
			RunwayDetails runs = (RunwayDetails) iterator.next();
			if(runs.getRid() == rid){
				isexist=true;
				break;
			}
		}
	
		
			if(isexist!=true){

				flp.getRunway().add(run);
				userdao.saveFPDT(flp);
				plan="redirect:/admin/searchPlan.html?planid="+planid+"&ok=VIEW";
			}
			else
			{
				model.put("errorrunway","Selected Runway exists already");
				plan="redirect:/admin/addRunway.html?planid="+planid+"&btn=exist";
			}
		
		return plan;
	}
	
		//add existingstage
		@RequestMapping("/admin/existStages.html")
		public String existStages(@RequestParam int planid, int sid,ModelMap model)
		{		
			FlightPlanDetails flp = userdao.getflightplanbyid(planid);
			StageDetails stg = userdao.getstagebyid(sid);
			Boolean isexist=false;
			String plan="/admin/addOptions";
			List<StageDetails> liststage = flp.getStage();
			
			for (Iterator iterator = liststage.iterator(); iterator.hasNext();) {
				StageDetails stgs = (StageDetails) iterator.next();
				if(stgs.getSid() == sid){
					isexist=true;
					break;
				}
			}
				
			
			
				if(isexist!=true){
				
					
					flp.getStage().add(stg);
					userdao.saveFPDT(flp);
					
					plan="redirect:/admin/searchPlan.html?planid="+planid+"&ok=VIEW";
				}
				else
				{
					
					plan="redirect:/admin/addOptions.html?planid="+planid+"&btn=exist";
				}
			
			return plan;
		}
		
	//ADD PLAN
	@RequestMapping(value="/admin/addPlan.html",method=RequestMethod.POST)
	public String addPlan(@RequestParam int deptid,String planname, ModelMap models){
		 
		
		if(!planname.isEmpty()){
		DepartmentDetails dpts=userdao.getdeptbyid(deptid);System.out.println("ADDPLAN DEPTID: "+deptid);
		List<DepartmentDetails> dpt = new ArrayList<DepartmentDetails>();
		dpt.add(dpts);
		FlightPlanDetails fpdt = new FlightPlanDetails();
		fpdt.setName(planname);
	//	fpdt.setStage(stg);
		fpdt.setDeptdetails(dpt);
		userdao.saveFPDT(fpdt);
		}
		else{
			models.put("errorplan", "plan name is empty");
		}
		return "redirect:/admin/viewSearchResult.html?ok=OK&deptid="+deptid;
		
	}
	
	//assign plan to dept
	@RequestMapping(value="/admin/defaultPlan",method=RequestMethod.GET)
	public String defaultPlan(@RequestParam int deptid,int planid,ModelMap model){
		FlightPlanDetails fp= userdao.getflightplanbyid(planid);
		DepartmentDetails dpt= userdao.getdeptbyid(deptid);
		dpt.setDeptid(deptid);
		dpt.setFlpid(fp);
		fp.setDeptdetail(dpt);
		userdao.saveDept(dpt);		
		
		return "redirect:/admin/planHome.html?";
		
	}
	
	//chkptn ajax
	@RequestMapping("/user/addchkptuser")
	public String addchkptuser(@RequestParam int chkptid, Authentication authentication,HttpServletRequest  reuqest){
		User users = (User) authentication.getPrincipal();
		
		System.out.println("ajax call "+chkptid);
		String uname="";
		User stu = null;
		Integer planid = null;
		Integer stuid = null;
		
			 uname = users.getUsername();
			 stu = userdao.getStudbyname(uname);
			 planid = userdao.getStudbyname(uname).getPlan().getId();
			 stuid = stu.getId();
	
		
				
		int sizeofchk = userdao.getStudbyname(uname).getChkpt().size();
		boolean ch = false;
		for(int i=0;i<sizeofchk;i++){
	
			int cck = userdao.getStudbyname(uname).getChkpt().get(i).getCid();
			if(chkptid==cck){
				//User stu = userdao.getStudbyname(uname);
				ch=true;
				break;
			}
		}
		
		if(ch==true){
			ChkPtDetails chk = userdao.getchkptnbyid(chkptid);
			stu.getChkpt().remove(chk);//add(chk);
			userdao.saveUser(stu);
			return "redirect:/user/viewPlan.html?stuid="+stuid+"&planid="+planid;
		}else{		
		
		List <ChkPtDetails> chkpt = userdao.getchkptkbyids(chkptid);
		List<User> user = userdao.getStuDdetailsbyunmae(uname);
		
		ChkPtDetails chk = userdao.getchkptnbyid(chkptid);
		
		stu.getChkpt().add(chk);
		userdao.saveUser(stu);
		
		return "redirect:/user/viewPlan.html?stuid="+stuid+"&planid="+planid;
		}
	}
	
	@RequestMapping("/advi/addchkptuser")
	public String addchkptuser(@RequestParam int chkptid,int uid,ModelMap model, Authentication authentication,HttpServletRequest  reuqest){
		
		User users = userdao.getuser(uid);
		System.out.println("ajax call "+chkptid);
		String uname="";
		User stu = null;
		Integer planid = null;
		Integer stuid = null;
		
			 uname = users.getUsername();
			 stu = userdao.getStudbyname(uname);
			 planid = userdao.getStudbyname(uname).getPlan().getId();
			 stuid = stu.getId();
	
		
				
		int sizeofchk = userdao.getStudbyname(uname).getChkpt().size();
		boolean ch = false;
		for(int i=0;i<sizeofchk;i++){
	
			int cck = userdao.getStudbyname(uname).getChkpt().get(i).getCid();
			if(chkptid==cck){
				//User stu = userdao.getStudbyname(uname);
				ch=true;
				break;
			}
		}
		
		if(ch==true){
			ChkPtDetails chk = userdao.getchkptnbyid(chkptid);
			stu.getChkpt().remove(chk);//add(chk);
			userdao.saveUser(stu);
			return "redirect:/advi/advisorPlan.html?stuid="+stuid+"&planid="+planid;
		}else{		
		
		List <ChkPtDetails> chkpt = userdao.getchkptkbyids(chkptid);
		List<User> user = userdao.getStuDdetailsbyunmae(uname);
		
		ChkPtDetails chk = userdao.getchkptnbyid(chkptid);
		
		stu.getChkpt().add(chk);
		userdao.saveUser(stu);
		
		return "redirect:/advi/advisorPlan.html?stuid="+stuid+"&planid="+planid;
		}
	}

	//search user
	@RequestMapping(value="/advi/advisor.html", method = RequestMethod.GET)
	public String adviosr(){
		
		return "/advi/advisor";
		
	}
	
	//common
	@RequestMapping(value="/common/home.html", method = RequestMethod.GET)
	public String commonHome(){
		
		System.out.println("common");
		return "/common/home";
	}
	
	@RequestMapping(value="/advi/advisor.html", method = RequestMethod.POST)
	public String adviosr(@RequestParam String term,ModelMap models){
		
		List <User> userlist = userdao.searchUsers(term);
		String path="/advi/advisor";
		if(userdao.searchUsers(term).size()!=0){
		models.addAttribute("us",userlist);
		path= "redirect:/advi/advisorPlan.html?stuid="+userlist.get(0).getId();
		}
		else models.put("error", "Sorry! no user found");
		
		return path;
	}
	
	@RequestMapping("/advi/autocomplete.html")
	public String autocomplete( @RequestParam String term, HttpServletResponse response )
	        throws JSONException, IOException{
		JSONArray jsonArray = new JSONArray();
        List<User> users = userdao.searchUsersByPrefix( term, 10 );
        for( User user : users )
        {
        	  Map<String, String> json = new HashMap<String, String>();
              json.put( "id", user.getId().toString() );
              json.put( "value", user.getName() );
              json.put( "label", user.getCin() + " " + user.getName() );
              jsonArray.put( json );
              System.out.println("autocompl: "+json);
        	
        }
        response.setContentType( "application/json" );
        jsonArray.write( response.getWriter() );
		return null;
		
	}
	
	@RequestMapping("/advi/autocompluser.html")
	public String autocompluser(@RequestParam int id, ModelMap models){
		User user = userdao.getuser(id);
		
		models.put("use", user);
		return "/advi/advisor";
	}

	//remove checkpoints
	@RequestMapping("/admin/removeCheckpoint.html")
	public String removeCheckpoint(@RequestParam int cellid,int planid){
		
		FlightPlanDetails listfp = userdao.getflightplanbyid(planid);
		List<Combination> listcom = listfp.getComb();
		for (Iterator iterator = listcom.iterator(); iterator.hasNext();) {
			Combination cob = (Combination) iterator.next();
			
			if(cob.getComid() == cellid){
				
				cob.setChker(false);
				userdao.saveCell(cob);
				break;
			}
		}
			
		return "redirect:/admin/searchPlan.html?planid="+planid+"&ok=VIEW";
	}
	
	//Reordering
	 @RequestMapping("/admin/reorderStage.html")
	 public String reorderStage( @RequestParam int sid, @RequestParam int planid, @RequestParam int newIndex, HttpServletResponse response )
		        throws IOException{
		 FlightPlanDetails fp = userdao.getflightplanbyid(planid);
		List<StageDetails> stgs = fp.getStage();
		for (Iterator iterator = stgs.iterator(); iterator.hasNext();) {
			StageDetails stg = (StageDetails) iterator.next();
			if(stg.getSid() == sid){
				stgs.remove(stg);
				break;
			}
		}
		 if(stgs != null){
			 stgs.add(newIndex,userdao.getstagebyid(sid));
			 userdao.saveFPDT(fp);
		 }
			 
	        response.setContentType( "text/plain" );
	        response.getWriter().print( "" );

	        return null;
	 }
	 
	 @RequestMapping("/admin/reorderRunway.html")
	 public String reorderRunway( @RequestParam int rid, @RequestParam int planid, @RequestParam int newIndex, HttpServletResponse response )
		        throws IOException{
		 
		 FlightPlanDetails fp = userdao.getflightplanbyid(planid);
			List<RunwayDetails> runs = fp.getRunway();
			for (Iterator iterator = runs.iterator(); iterator.hasNext();) {
				RunwayDetails run = (RunwayDetails) iterator.next();
				if(run.getRid() == rid){
					runs.remove(run);
					break;
				}
			}
			 if(runs != null){
				 runs.add(newIndex,userdao.getrunwaybyid(rid));
				 userdao.saveFPDT(fp);
			 }
		 
		 response.setContentType( "text/plain" );
	        response.getWriter().print( "" );

	        return null;
	 }
}