package com.pmt.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pmt.models.Company;
import com.pmt.models.Company_dto;
import com.pmt.repos.CompanyRepo;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepo companyRepository;

	@Autowired
	private FileStorageService imgl;

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
	public UUID addCompany(Company_dto c) throws IOException {
		MultipartFile m = c.getLogo();
		String s = m.getOriginalFilename();
		Company c1 = mappingDTO(c, s);
		c1.setCreated(new Date());
		Company res = companyRepository.save(c1);
		s = res.getId().toString();
		String fileName = imgl.storeFile(m, s);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/companyprofiles/" + s + "/").path(fileName).toUriString();
		res.setLogo(fileDownloadUri);
		companyRepository.save(res);
		// ImageUpload fu = new ImageUpload();
		// result = fu.uploadFile(m, s);
		// System.out.println(result);
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

	private Company mappingDTO(Company_dto c, String result) {
		Company c1 = new Company();
		c1.setCompanyName(c.getCompanyName());
		c1.setContactPerson(c.getContactPerson());
		c1.setLogo(result);
		c1.setAddress1(c.getAddress1());
		c1.setAddress2(c.getAddress2());
		c1.setCity(c.getCity());
		c1.setState(c.getState());
		c1.setCountry(c.getCountry());
		c1.setZip(c.getZip());
		c1.setPhone(c.getPhone());
		c1.setFax(c.getFax());
		c1.setEmail(c.getEmail());
		c1.setWebsite(c.getWebsite());
		c1.setLegalStatus(c.getLegalStatus());
		c1.setEstdYear(c.getEstdYear());
		c1.setEmpcount(c.getEmpcount());
		c1.setAccessempcount(c.getAccessempcount());
		c1.setBusinessType(c.getBusinessType());
		c1.setAboutme(c.getAboutme());
		c1.setIsActive(c.getIsActive());
		c1.setCreated(c.getCreated());
		c1.setModified(c.getModified());
		return c1;
	}

	public String getCompanyByName(String companyName) {
		Company c = companyRepository.findByCompanyName(companyName);
		if (c != null) {
			return "exist";
		} else {
			return "notexist";
		}

	}
}
