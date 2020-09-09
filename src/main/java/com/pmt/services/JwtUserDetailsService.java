package com.pmt.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pmt.models.Employee;
import com.pmt.repos.EmployeeRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepo empDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Employee emp = empDao.findByUsername(username);
		if (emp == null) {
			throw new UsernameNotFoundException("User not found: " + username);
		}
		return new org.springframework.security.core.userdetails.User(emp.getUsername(), emp.getPassword(),
				new ArrayList<>());
	}

	public Employee loadUser(String username) throws UsernameNotFoundException {

		Employee emp = empDao.findByUsername(username);
		if (emp == null) {
			throw new UsernameNotFoundException("User not found: " + username);
		}
		return emp;
	}
}