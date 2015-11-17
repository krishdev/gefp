package gefp.model.dao.jpa;

import gefp.model.Combination;
import gefp.model.FlightPlanDetails;
import gefp.model.User;
import gefp.model.dao.Combintaiondao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
@Repository
public class CombinationdaoImp implements Combintaiondao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Combination getcombinationid(Integer id){
		return entityManager.find(Combination.class, id);
	}
	
	@Override
	public List<Combination> getsizeofcombinationsforusers(User name){
		System.out.println("Getting the toltal size");
		return entityManager.createQuery("from Combination where user ="+name.getId(), Combination.class).getResultList();	

	}
	
	/*@Override
	public List<FlightPlanDetails> getsizeofflightplan(User name){
		System.out.println("Getting the Plan size");
		return entityManager.createQuery("from Combination where user ="+name.getId(), FlightPlanDetails.class).getResultList();	

	}*/
	
	@Override
	public List<Combination> getcombinationids(User name){
		System.out.println(name.getId());
	return entityManager.createQuery("from Combination where user ="+name.getId()+"and chker =TRUE", Combination.class).getResultList();	
	}
	
	@Override
	public List<Combination> getcombinationidsfor2nduser(User name){
		System.out.println(name.getId());
		return entityManager.createQuery("from Combination where user ="+name.getId()+"and chker =TRUE", Combination.class).getResultList();	
		
	}
}
