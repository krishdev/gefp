
package gefp.model.dao;

import gefp.model.Combination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "UserDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StuDTest extends AbstractTransactionalTestNGSpringContextTests{

	
	@Autowired
	StuDdao studdao;
	
	@Autowired
	Checkptdao chkdao;
	
	@Autowired
	Combintaiondao combdao;
	
	@Test
	public void getStuDdetail()
	{
		System.out.println("Test Case 1");
		System.out.println("Students:" + studdao.getStudbyname("jdoe1").getUsername() + " and " + studdao.getStudbyname("jdoe2").getUsername());
		System.out.println("are present");
		System.out.println( studdao.getStuDdetail(1001).getUsername().equalsIgnoreCase("jdoe1"));
		
			
		assert studdao.getStudbyname("jdoe1").getUsername().equalsIgnoreCase("jdoe1");
		assert studdao.getStudbyname("jdoe2").getUsername().equalsIgnoreCase("jdoe2");
	}
	
	@Test
	public void getstudetailifchk(){
		//Showing the checkpoints
		int chkplan = studdao.getStudbyname("jdoe1").getPlan().getComb().size();
		int size = studdao.getStudbyname("jdoe1").getChkpt().size();
		System.out.println("Total checkpoints present for Jdoe1: "+chkplan+" Number of checkpoints checked for Jdoe1: "+size);
		for(int i=0;i<size;i++){
			
			System.out.println("Checkpoint which is checked is:  " + studdao.getStudbyname("jdoe1").getChkpt().get(i).getCName());
		}
		//test case
		assert studdao.getstudetailifchk("jdoe1").get(0).getChkpt().size()==1;
	}
	
	@Test
	public void getStuDdetailCheckpointforjdoe2()
	{
		
		assert studdao.getstudetailifchk("jdoe2").get(0).getChkpt().size() == studdao.getstudetailifchk("jdoe2").get(0).getPlan().getComb().size();
		
		
	}

}