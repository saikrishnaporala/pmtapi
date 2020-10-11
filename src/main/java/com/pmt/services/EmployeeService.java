package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pmt.models.Employee;
import com.pmt.models.Task;
import com.pmt.models.dto.Employee_dto;
import com.pmt.repos.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

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

	// inserting/updating employee
	public UUID CUEmployee(Employee_dto obj) {
		Employee emptemp = mappingDTO(obj);
		if (obj.getId() == null) {
			emptemp.setDtCreated(new Date());
		} else {
			emptemp.setDtUpdated(new Date());
		}
		MultipartFile m = obj.getPhoto();
		String s = m.getOriginalFilename();
		emptemp = repo.save(emptemp);
		if (m.getOriginalFilename() != null) {
			s = emptemp.getCompany().getId() + "/employee/" + emptemp.getId().toString();
			String fileName = imgl.storeFile(m, s);

			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/companyprofiles/" + s + "/").path(fileName).toUriString();
			emptemp.setPhoto(fileDownloadUri);
			repo.save(emptemp);
		}
		return emptemp.getId();
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

	private Employee mappingDTO(Employee_dto c) {
		Employee c1 = new Employee();
		if (c.getId() != null) {
			c1 = this.getEmployee(c.getId());
		}
		c1.setEmpid(c.getEmpid());
		c1.setGender(c.getGender());
		c1.setFirstName(c.getFirstName());
		c1.setLastName(c.getLastName());
		c1.setOfficialEmail(c.getOfficialEmail());
		c1.setPersonalEmail(c.getPersonalEmail());
		c1.setMob(c.getMob());
		c1.setRoleType(c.getRoleType());
		System.out.println("dept : " + c.getDept());
		c1.setDept(deptService.getDepartment(c.getDept()));
		c1.setDesignation(c.getDesignation());
		c1.setJoinDate(c.getJoinDate());
		c1.setEndDate(c.getEndDate());
		c1.setUsername(c.getUsername());
		c1.setPassword(bcryptEncoder.encode(c.getPassword()));
		c1.setSkypeId(c.getSkypeId());
		c1.setTwitterId(c.getTwitterId());
		c1.setLinkedinId(c.getLinkedinId());
		c1.setIsactive(c.getIsactive());
		c1.setIsAgree(c.getIsAgree());
		c1.setIsEmail(c.getIsEmail());
		c1.setAboutme(c.getAboutme());
		c1.setActDate(c.getActDate());
		c1.setBillingStartDate(c.getBillingStartDate());
		c1.setBillingEndDate(c.getBillingEndDate());
		c1.setDtLastLogin(c.getDtLastLogin());
		c1.setDtLastLogout(c.getDtLastLogout());
		System.out.println("company : " + c.getCompany());
		c1.setCompany(companyService.getComp(c.getCompany()));

		return c1;
	}

	public String getEmployee(String username) {
		Employee c = repo.findByUsername(username);
		if (c != null) {
			return "exist";
		} else {
			return "notexist";
		}
	}

	public int getMaxEmployee() {
		Integer e = repo.findMaxEmpId();
		return e;
	}

	public Set<Task> getAllTasksByEmployeeID(UUID id) {
		Set<Task> l = repo.findByTasks(id);
		return l;
	}
}
