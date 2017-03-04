package com.amandaprettypizza.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.amandaprettypizza.domain.Authorities;
import com.amandaprettypizza.domain.Customer;

public class CustomUserDetails extends Customer implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7803088404140286554L;

	public CustomUserDetails() {}
		
	
	public CustomUserDetails(Customer customer) {
		// TODO Auto-generated constructor stub
		super(customer);
	}

	@Override
	public Set<Authorities> getAuthorities() {
		// TODO Auto-generated method stub
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getEmailAddress();
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

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
