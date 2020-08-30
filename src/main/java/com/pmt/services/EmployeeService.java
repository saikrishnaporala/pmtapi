package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pmt.models.Employee;
import com.pmt.models.Employee_dto;
import com.pmt.repos.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private DepartmentService deptService;

	@Autowired
	private FileStorageService imgl;

	// fetching all employees
	public List<Employee> getAllEmployees() {
		List<Employee> emps = (List<Employee>) repo.findAll();
		return emps;
	}

	// fetching employee by id
	public Employee getEmployee(UUID id) {
		return repo.getOne(id);
	}

	// inserting employee
	public UUID addEmployee(Employee_dto obj) {
		MultipartFile m = obj.getPhoto();
		String s = m.getOriginalFilename();
		Employee c1 = mappingDTO(obj, s);
		c1.setDtCreated(new Date());
		Employee res = repo.save(c1);
		s = "employee/" + res.getId().toString();
		String fileName = imgl.storeFile(m, s);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/companyprofiles/" + s + "/").path(fileName).toUriString();
		res.setPhoto(fileDownloadUri);
		repo.save(res);
		// ImageUpload fu = new ImageUpload();
		// result = fu.uploadFile(m, s);
		// System.out.println(result);
		return res.getId();
	}

	// updating employee by id
	public void updateEmployee(Employee user, UUID id) {
		System.out.println(user.getId());
		System.out.println(id);
		if (id.equals(user.getId())) {
			user.setDtUpdated(new Date());
			repo.save(user);
		}
	}

	// deleting all employees
	public void deleteAllEmployees() {
		repo.deleteAll();
	}

	// deleting employee by id
	public void deleteEmployeeByID(UUID id) {
		repo.deleteById(id);
	}

	// patching/updating employee by id
	public void patchEmployee(Employee obj, UUID id) {
		if (id == obj.getId()) {
			repo.save(obj);
		}
	}

	private Employee mappingDTO(Employee_dto c, String result) {
		Employee c1 = new Employee();
		c1.setEmpid(c.getEmpid());
		c1.setFirstName(c.getFirstName());
		c1.setLastName(c.getLastName());
		c1.setOfficialEmail(c.getOfficialEmail());
		c1.setPersonalEmail(c.getPersonalEmail());
		c1.setMob(c.getMob());
		c1.setRoleType(c.getRoleType());
		c1.setDesignation(c.getDesignation());
		c1.setJoinDate(c.getJoinDate());
		c1.setEndDate(c.getEndDate());
		c1.setSkypeId(c.getSkypeId());
		c1.setTwitterId(c.getTwitterId());
		c1.setLinkedinId(c.getLinkedinId());
		c1.setIsactive(c.getIsactive());
		c1.setIsAgree(c.getIsAgree());
		c1.setIsEmail(c.getIsEmail());
		c1.setAboutme(c.getAboutme());
		c1.setDtCreated(c.getDtCreated());
		c1.setDtUpdated(c.getDtUpdated());
		c1.setCompany(c.getCompany());
		c1.setUser(c.getUser());
		c1.setDept(c.getDept());
		c1.setProj(c.getProj());
		c1.setProjects(c.getProjects());
		c1.setTasks(c.getTasks());
		return c1;
	}

	public String getEmployee(int empid) {
		Employee c = repo.findByEmpid(empid);
		if (c != null) {
			return "exist";
		} else {
			return "notexist";
		}
	}
}
