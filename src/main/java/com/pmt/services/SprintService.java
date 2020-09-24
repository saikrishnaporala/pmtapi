package com.pmt.services;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Project;
import com.pmt.models.Sprint;
import com.pmt.models.dto.Sprint_dto;
import com.pmt.repos.ProjectRepo;
import com.pmt.repos.SprintRepo;

@Service
public class SprintService {

	@Autowired
	private SprintRepo repo;

	@Autowired
	private ProjectRepo prepo;

	@Autowired
	private EmployeeService empservice;

	@Autowired
	private ProjectService projectService;

	// fetching all projects
	public List<Sprint> getAllSprints() {
		List<Sprint> list = (List<Sprint>) repo.findAll();
		return list;
	}

	// fetching sprint by id
	public Sprint getSprint(UUID id) {
		return repo.getOne(id);
	}

	// inserting sprint
	public UUID CUSprint(Sprint_dto obj) {
		Sprint sprint = mappingDTO(obj);
		if (obj.getSprintid() == null) {
			sprint.setSprintDtCreated(new Date());
		} else {
			sprint.setSprintDtUpdated(new Date());
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
		sprint = repo.save(sprint);
		Project p = prepo.getOne(obj.getSprintProj());
		Set<Sprint> s = p.getSprint();
		s.add(sprint);
		prepo.save(p);
		return sprint.getSprintid();
	}

	private Sprint mappingDTO(Sprint_dto obj) {
		Sprint c1 = new Sprint();
		if (obj.getSprintid() != null) {
			c1 = this.getSprint(obj.getSprintid());
		}
		c1.setSprintName(obj.getSprintName());
		c1.setSprintStartDate(obj.getSprintStartDate());
		c1.setSprintEndDate(obj.getSprintEndDate());
		c1.setSprintStatus(obj.getSprintStatus());
		c1.setSprintIsactive(obj.getSprintIsactive());
		c1.setSprintProj(projectService.getProject(obj.getSprintProj()));
		c1.setSprintCreatedBy(empservice.getEmployee(obj.getSprintCreatedBy()));
		c1.setSprintDescr(obj.getSprintDescr());
		return c1;
	}

	// deleting all sprints
	public void deleteAllSprints() {
		repo.deleteAll();
	}

	// deleting sprint by id
	public UUID deleteSprintByID(UUID id) {
		repo.deleteById(id);
		UUID s = repo.getOne(id).getSprintid();
		if (s == null) {
			return null;
		} else {
			return s;
		}
	}

	// patching/updating sprint by id
	public void patchSprint(Sprint obj, UUID id) {
		if (id == obj.getSprintid()) {
			repo.save(obj);
		}
	}

	public List<Sprint> getAllSprintsByPID(UUID id) {
		System.out.println("pid: " + id);
		Project proj = new Project();
		proj.setId(id);
		List<Sprint> list = (List<Sprint>) repo.findBySprintProj(proj);
		// list.sort(Comparator.comparing(Sprint_dto::getSeq));
		return list;
	}
}
