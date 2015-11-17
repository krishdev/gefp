package gefp.model;

import javax.servlet.http.HttpServletRequest;

import gefp.model.User;
import gefp.security.SecurityUtils;
public class DefaultUrls {
	  public String homeUrl( HttpServletRequest request )
	    {
	        return SecurityUtils.isAuthenticated() ? userHomeUrl( request )
	            : anonymousHomeUrl( request );
	    }

	    public String userHomeUrl( HttpServletRequest request )
	    {
	    	User user = SecurityUtils.getUser();
	        if( user.isFaculty() ) return "/user/author";
			return null;
	    	
	    }
	    
	    public String anonymousHomeUrl( HttpServletRequest request )
	    {
			return null;
	    	
	    }
}
