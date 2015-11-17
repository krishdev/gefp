package gefp.web.validator;

import gefp.model.FlightPlanDetails;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class PlanValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return FlightPlanDetails.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		FlightPlanDetails fpg = new FlightPlanDetails();

		if(! StringUtils.hasText(fpg.getName()))
		{
			 errors.rejectValue("name", "error.name");
		}
		
	}

}
