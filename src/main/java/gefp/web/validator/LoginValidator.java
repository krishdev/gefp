package gefp.web.validator;

import gefp.model.User;
import gefp.model.dao.StuDdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator{

@Autowired
StuDdao userdao;

@Override
public boolean supports(Class<?> clazz) {
	// true if clazz is user or a subclass. 
	return User.class.isAssignableFrom(clazz);
}

@Override
public void validate(Object target, Errors errors) {

	
	User users = (User) target;
	if(! StringUtils.hasText(users.getUsername()))
	{
		 errors.rejectValue("username", "error.username");
	}
	
	if(StringUtils.isEmpty(users.getPassword()))
	{
		 errors.rejectValue("password", "error.password");
	}
	
}
}
