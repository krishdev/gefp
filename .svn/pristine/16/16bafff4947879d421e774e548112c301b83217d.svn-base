package gefp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Users")
public class User implements Serializable,UserDetails {
	
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger( User.class );
    
	@Id
    @GeneratedValue
	private Integer id;

	private String username;

	private String password;
	
	private String name;
	
	private String email;
	
	private Long phno;
	
	private String city;
	
	private String cin;
	
	  @Transient
	    String password1;
	  
	  @Transient
	    String password2;
	
	  @ElementCollection
	    @CollectionTable(name = "authorities",
	        joinColumns = @JoinColumn(name = "user_id"))
	    @Column(name = "role")
	    private Set<String> roles;

	/*private String roles;*/
	private boolean enabled;

	@ManyToOne(fetch=FetchType.LAZY)
	private DepartmentDetails major;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JoinTable(name = "user_chkpt",
     joinColumns = @JoinColumn(name = "userid"),
     inverseJoinColumns = @JoinColumn(name = "chkptid"))
	private List<ChkPtDetails> chkpt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private FlightPlanDetails plan;
	
	public User(){
		roles = new HashSet<String>();
	}
	
	 public User clone()
	    {
	        User user = null;
	        try
	        {
	            user = (User) super.clone();
	            user.roles = new HashSet<String>();
	            for( String role : roles )
	                user.roles.add( role );
	        }
	        catch( CloneNotSupportedException e )
	        {
	            logger.warn( "Clone user " + id + " failed." );
	        }

	        return user;
	    }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public DepartmentDetails getMajor() {
		return major;
	}

	public void setMajor(DepartmentDetails major) {
		this.major = major;
	}

	public FlightPlanDetails getPlan() {
		return plan;
	}

	public void setPlan(FlightPlanDetails plan) {
		this.plan = plan;
	}

	  public Set<String> getRoles()
	    {
	        return roles;
	    }

	    public void setRoles( Set<String> roles )
	    {
	        this.roles = roles;
	    }

	public List<ChkPtDetails> getChkpt() {
		return chkpt;
	}

	public void setChkpt(List<ChkPtDetails> chkpt) {
		this.chkpt = chkpt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for( String role : roles )
            authorities.add( new SimpleGrantedAuthority( role ) );
        return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	} 	
	
	 public boolean isFaculty()
	    {
	        for( String role : roles )
	            if( role.contains( "ROLE_ADVISOR" ) ) return true;

	        return roles.contains( "ROLE_ADVISOR" );
	    }
	 public boolean isAdmin()
	    {
	        for( String role : roles )
	            if( role.contains( "ROLE_ADMINISTRATOR" ) ) return true;

	        return roles.contains( "ROLE_ADMINISTRATOR" );
	    }
	 public boolean isStudent()
	    {
	        for( String role : roles )
	            if( role.contains( "ROLE_STUDENT" ) ) return true;

	        return roles.contains( "ROLE_STUDENT" );
	    }
	
}
