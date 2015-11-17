package gefp.model.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gefp.model.dao.Checkptdao;
import gefp.model.FlightPlanDetails;
@Repository
public class CheckptdaoImp implements Checkptdao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public FlightPlanDetails getFlightplanfordept(Integer id){
		return entityManager.find(FlightPlanDetails.class, id);
	}
	
	@Override
	public List<FlightPlanDetails> getFlightplanfordepts(){
		
		return entityManager.createQuery("from flightplandetails order by id", FlightPlanDetails.class).getResultList();
	}
	
}
