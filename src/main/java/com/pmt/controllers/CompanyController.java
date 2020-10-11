package com.pmt.controllers;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pmt.models.Company;
import com.pmt.models.dto.Company_dto;
import com.pmt.services.CompanyService;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/company")
public class CompanyController {

	static final Logger logger = LogManager.getLogger(CompanyController.class.getName());

	@Autowired
	private CompanyService companyService;

	// displaying list of all companys
	@GetMapping("/companies")
	public List<Company> getAllCompany() {
		return companyService.getAllCompanys();
	}

	// displaying company by id
	@GetMapping("/{companyName}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> getCompany(@PathVariable String companyName) {
		return new ResponseEntity<>(companyService.getCompanyByName(companyName), HttpStatus.CREATED);
	}

	// displaying company by id
	@GetMapping("/companies/{id}")
	public Company getCompany(@PathVariable UUID id) {
		return companyService.getCompany(id);
	}

	// inserting company
	@PostMapping("/compregister")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UUID> addCompanys(@ModelAttribute Company_dto company) throws IOException {
		return new ResponseEntity<>(companyService.addCompany(company), HttpStatus.CREATED);
	}

	// updating company by id
	@PutMapping("/companies/{id}")
	public void updateCompany(@RequestBody Company e, @PathVariable UUID id) {
		companyService.updateCompany(e, id);
	}

	// deleting all companys
	@DeleteMapping("/companies")
	public void deleteAllCompanys() {
		companyService.deleteAllCompanys();
	}

	// deleting company by id
	@DeleteMapping("companies/{id}")
	public void deleteCompanyByID(@RequestBody Company e, @PathVariable UUID id) {
		companyService.deleteCompanyByID(id);
	}

	// updating/ patching company by id
	@PatchMapping("companies/{id}")
	public void patchCompanyByID(@RequestBody Company e, @PathVariable UUID id) {
		companyService.patchCompany(e, id);
	}
}
