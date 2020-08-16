package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Department;
import com.pmt.repos.DeptRepo;

@Service
public class DepartmentService {

	@Autowired
	private DeptRepo deptRepository;

	@Autowired
	private CompanyService companyService;

	// fetching all depts
	public List<Department> getAllDepartments() {
		List<Department> dept = (List<Department>) deptRepository.findAll();
		return dept;
	}

	// fetching dept by id
	public Department getDepartment(UUID id) {
		return deptRepository.getOne(id);
	}

	// inserting dept
	public UUID addDepartment(Department c, UUID comp) {
		System.out.println("deptname : " + c.getDeptName());
		c.setCompany(companyService.getComp(comp));
		Date dtCreated = new Date();
		c.setDtCreated(dtCreated);
		deptRepository.save(c);
		return c.getId();
	}

	// updating dept by id
	public void updateDepartment(Department dept, UUID id) {
		if (id == dept.getId()) {
			Date dtUpdated = new Date();
			dept.setDtUpdated(dtUpdated);
			deptRepository.save(dept);
		}
	}

	// deleting all depts
	public void deleteAllDepartments() {
		deptRepository.deleteAll();
	}

	// deleting dept by id
	public void deleteDepartmentByID(UUID id) {
		deptRepository.deleteById(id);
	}

	// patching/updating dept by id
	public void patchDepartment(Department emp, UUID id) {
		if (id == emp.getId()) {
			deptRepository.save(emp);
		}
	}
}
