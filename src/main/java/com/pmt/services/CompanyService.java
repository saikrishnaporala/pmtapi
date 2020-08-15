package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Company;
import com.pmt.repos.CompanyRepo;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepo companyRepository;

	// fetching all companys
	public List<Company> getAllCompanys() {
		List<Company> emps = (List<Company>) companyRepository.findAll();
		return emps;
	}

	public Company getComp(UUID uuid) {
		Company comp = companyRepository.getOne(uuid);
		return comp;
	}

	// fetching company by id
	public Company getCompany(UUID id) {
		Company comp = companyRepository.getOne(id);
		System.out.println(comp.getId());
		return comp;
	}

	// inserting company
	public UUID addCompany(Company c) {
		Company res = companyRepository.save(c);
		Date dtCreated = new Date();
		c.setCreated(dtCreated);
		return res.getId();
	}

	// updating company by id
	public void updateCompany(Company company, UUID id) {
		if (id == company.getId()) {
			companyRepository.save(company);
		}
	}

	// deleting all companys
	public void deleteAllCompanys() {
		companyRepository.deleteAll();
	}

	// deleting company by id
	public void deleteCompanyByID(UUID id) {
		companyRepository.deleteById(id);
	}

	// patching/updating company by id
	public void patchCompany(Company emp, UUID id) {
		if (id == emp.getId()) {
			companyRepository.save(emp);
		}
	}
}
