package gefp.model.dao;
import gefp.model.FlightPlanDetails;
import gefp.model.Combination;

import java.util.List;
public interface Checkptdao {

	FlightPlanDetails getFlightplanfordept (Integer id);
	List<FlightPlanDetails> getFlightplanfordepts();
	
}
