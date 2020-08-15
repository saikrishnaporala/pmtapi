package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pmt.models.User;
import com.pmt.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	// fetching all users
	public List<User> getAllUsers() {
		List<User> emps = (List<User>) userRepository.findAll();
		return emps;
	}

	// fetching user by id
	public Optional<User> getUser(UUID id) {
		return userRepository.findById(id);
	}

	// inserting user
	public UUID addUser(User c, UUID comp) {
		System.out.println("username : " + c.getUsername());
		System.out.println("pswd : " + c.getPassword());
		c.setCompany(companyService.getComp(comp));
		c.setPassword(bcryptEncoder.encode(c.getPassword()));
		Date dtCreated = new Date();
		c.setDtCreated(dtCreated);
		userRepository.save(c);
		return c.getId();
	}

	// updating user by id
	public void updateUser(User user, UUID id) {
		if (id == user.getId()) {
			Date dtUpdated = new Date();
			user.setDtUpdated(dtUpdated);
			userRepository.save(user);
		}
	}

	// deleting all users
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	// deleting user by id
	public void deleteUserByID(UUID id) {
		userRepository.deleteById(id);
	}

	// patching/updating user by id
	public void patchUser(User emp, UUID id) {
		if (id == emp.getId()) {
			userRepository.save(emp);
		}
	}
}
