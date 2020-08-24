package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Department;
import com.pmt.models.ResponseModel;
import com.pmt.repos.DeptRepo;

@Service
public class DepartmentService {

	@Autowired
	private DeptRepo repo;

	@Autowired
	private CompanyService companyService;

	// fetching all depts
	public List<Department> getAllDepartments() {
		List<Department> dept = (List<Department>) repo.findAll();
		return dept;
	}

	// fetching dept by id
	public Department getDepartment(UUID id) {
		return repo.getOne(id);
	}

	public Department CUDept(Department obj) {
		if (obj.getId() == null) {
			obj.setDtCreated(new Date());
		} else {
			obj.setDtUpdated(new Date());
		}
		repo.save(obj);
		return obj;
	}

	// deleting all depts
	public void deleteAllDepartments() {
		repo.deleteAll();
	}

	// deleting dept by id
	public ResponseModel deleteDepartmentByID(UUID id) {
		ResponseModel res = new ResponseModel();
		repo.deleteById(id);
		Optional<Department> dept = repo.findById(id);
		if (!dept.isPresent()) {
			res.setMessage("Deleted Successfully");
			res.setStatus(200);
		} else {
			res.setMessage("Failed to Delete. Try Again");
			res.setStatus(400);
		}
		return res;
	}

	// patching/updating dept by id
	public void patchDepartment(Department emp, UUID id) {
		if (id == emp.getId()) {
			repo.save(emp);
		}
	}
}
