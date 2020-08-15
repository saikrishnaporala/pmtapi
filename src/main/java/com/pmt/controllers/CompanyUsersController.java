package com.pmt.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmt.models.CompanyUsers;
import com.pmt.services.CompanyUsersService;

@RestController
@RequestMapping("/companyusers")
public class CompanyUsersController {

	static final Logger logger = LogManager.getLogger(CompanyUsersController.class.getName());

	@Autowired
	private CompanyUsersService companyusersService;

	// displaying list of all companys
	@GetMapping("/companyusers")
	public List<CompanyUsers> getAllCompany() {
		return companyusersService.getAllCompanyUsers();
	}

	// displaying company by id
	@GetMapping("/companyusers/{id}")
	public Optional<CompanyUsers> getCompanyUser(@PathVariable int id) {
		return companyusersService.getCompanyUser(id);
	}

	// inserting company
	@PostMapping("/companyusers")
	public void addCompanyUser(@RequestBody CompanyUsers compuser) {
		companyusersService.addCompanyUser(compuser);
	}

	// updating company by id
	@PutMapping("/companyusers/{id}")
	public void updateCompanyUser(@RequestBody CompanyUsers e, @PathVariable int id) {
		companyusersService.updateCompanyUser(e, id);
	}

	// deleting all companys
	@DeleteMapping("/companyusers")
	public void deleteAllCompanyUsers() {
		companyusersService.deleteAllCompanyUsers();
	}

	// deleting company by id
	@DeleteMapping("companyusers/{id}")
	public void deleteCompanyUserByID(@RequestBody CompanyUsers e, @PathVariable int id) {
		companyusersService.deleteCompanyUserByID(id);
	}

	// updating/ patching company by id
	@PatchMapping("companyusers/{id}")
	public void patchCompanyUserByID(@RequestBody CompanyUsers e, @PathVariable int id) {
		companyusersService.patchCompanyUser(e, id);
	}
}
