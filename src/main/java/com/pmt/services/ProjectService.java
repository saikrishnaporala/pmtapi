package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Employee;
import com.pmt.models.Project;
import com.pmt.models.dto.Project_dto;
import com.pmt.repos.EmployeeRepo;
import com.pmt.repos.ProjectRepo;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepo repo;

	@Autowired(required = true)
	private EmployeeRepo erepo;

	@Autowired
	private EmployeeService empservice;

	@Autowired
	private CompanyService companyService;

	// fetching all projects
	public List<Project> getAllProjects() {
		List<Project> emps = (List<Project>) repo.findAll();
		return emps;
	}

	// fetching project by id
	public Project getProject(UUID id) {
		return repo.getOne(id);
	}

	// inserting/updating project
	public UUID CUProject(Project_dto obj) {
		Project proj = mappingDTO(obj);
		if (obj.getId() == null) {
			proj.setDtCreated(new Date());
		} else {
			proj.setDtUpdated(new Date());
		}

		/*
		 * MultipartFile m = obj.getPhoto(); String s = m.getOriginalFilename(); proj =
		 * repo.save(proj); if (m.getOriginalFilename() != null) { s =
		 * proj.getCompany().getId() + "/employee/" + proj.getId().toString(); String
		 * fileName = imgl.storeFile(m, s);
		 * 
		 * String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		 * .path("/companyprofiles/" + s + "/").path(fileName).toUriString();
		 * proj.setPhoto(fileDownloadUri); repo.save(proj); }
		 */
		proj = repo.save(proj);
		for (UUID emp : obj.getEmployees()) {
			Employee e = empservice.getEmployee(emp);
			Set<Project> s = e.getProjects();
			s.add(proj);
			erepo.save(e);
		}
		Employee e = empservice.getEmployee(obj.getProjCreatedBy());
		Set<Project> s = e.getProjCreatedBy();
		s.add(proj);
		erepo.save(e);
		return proj.getId();
	}

	private Project mappingDTO(Project_dto obj) {
		Project c1 = new Project();
		if (obj.getId() != null) {
			c1 = this.getProject(obj.getId());
		}
		c1.setProjName(obj.getProjName());
		c1.setClient(obj.getClient());
		c1.setProjStartDate(obj.getProjStartDate());
		c1.setProjEndDate(obj.getProjEndDate());
		c1.setProjPriority(obj.getProjPriority());
		c1.setProjDescr(obj.getProjDescr());
		c1.setProjSkills(obj.getProjSkills());
		c1.setProjTools(obj.getProjTools());
		c1.setProjStatus(obj.getProjStatus());
		c1.setProjIsactive(obj.getProjIsactive());
		c1.setCompany(companyService.getComp(obj.getCompany()));
		c1.setProjCreatedBy(empservice.getEmployee(obj.getProjCreatedBy()));
		Set<Employee> employees = obj.getEmployees().stream().map(u -> erepo.getOne(u)).collect(Collectors.toSet());
		c1.setEmployees(employees);
		return c1;
	}

	// deleting all projects
	public void deleteAllProjects() {
		repo.deleteAll();
	}

	// deleting project by id
	public UUID deleteProjectByID(UUID id) {
		Project p = repo.getOne(id);
		for (Employee emp : p.getEmployees()) {
			Employee e = erepo.getOne(emp.getId());
			System.out.println("employee : " + e.getId());
			Set<Project> s = e.getProjects();
			s.remove(p);
			e.setProjects(s);
			erepo.save(e);
		}
		Employee e = p.getProjCreatedBy();
		Set<Project> s = e.getProjCreatedBy();
		s.remove(p);
		erepo.save(e);
		repo.deleteById(id);
		UUID pid = repo.getOne(id).getId();
		if (pid == null) {
			return null;
		} else {
			return pid;
		}
	}

	// patching/updating project by id
	public void patchProject(Project emp, UUID id) {
		if (id == emp.getId()) {
			repo.save(emp);
		}
	}

	public List<Project> getAllProjectsByEmp(UUID empid) {
		Employee e = empservice.getEmployee(empid);
		List<Project> projs = (List<Project>) repo.findByProjCreatedBy(e);
		return projs;
	}
}
