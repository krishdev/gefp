package gefp.web.validator;

import gefp.model.User;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

	
	@Override
	public boolean supports(Class<?> clazz) {
		// true if clazz is user or a subclass. 
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		

		
		User users = (User) target;

		
		 ValidationUtils.rejectIfEmptyOrWhitespace( errors, "email",
		            "error.field.required" );
		
		
		String password1 = users.	getPassword1();
        if( StringUtils.hasText( password1 ) )
        {
            if( password1.length() < 4 ){
            	  System.out.println("validatore length");
                errors.rejectValue( "password1", "error.users.password.short" );
              
            }
            if( !password1.equals( users.getPassword2() ) )
                errors.rejectValue( "password2", "error.users.password.notmatch" );
        }
		
	}

	
	
}
