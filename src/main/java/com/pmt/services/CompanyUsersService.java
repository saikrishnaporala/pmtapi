package com.pmt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.CompanyUsers;
import com.pmt.repos.CompanyUsersRepo;

@Service
public class CompanyUsersService {

	@Autowired
	private CompanyUsersRepo companyusersRepository;

	// fetching all company users
	public List<CompanyUsers> getAllCompanyUsers() {
		List<CompanyUsers> compusers = (List<CompanyUsers>) companyusersRepository.findAll();
		return compusers;
	}

	// fetching company user by id
	public Optional<CompanyUsers> getCompanyUser(int id) {
		return companyusersRepository.findById(id);
	}

	// inserting company user
	public void addCompanyUser(CompanyUsers c) {
		companyusersRepository.save(c);
	}

	// updating company User by id
	public void updateCompanyUser(CompanyUsers companyuser, int id) {
		if (id == companyuser.getId()) {
			companyusersRepository.save(companyuser);
		}
	}

	// deleting all company users
	public void deleteAllCompanyUsers() {
		companyusersRepository.deleteAll();
	}

	// deleting company user by id
	public void deleteCompanyUserByID(int id) {
		companyusersRepository.deleteById(id);
	}

	// patching/updating company user by id
	public void patchCompanyUser(CompanyUsers compusers, int id) {
		if (id == compusers.getId()) {
			companyusersRepository.save(compusers);
		}
	}
}
