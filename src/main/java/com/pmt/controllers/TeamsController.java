package com.pmt.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmt.models.Team;
import com.pmt.services.TeamsService;

@RestController
@RequestMapping("/teams")
public class TeamsController {

	static final Logger logger = LogManager.getLogger(TeamsController.class.getName());

	@Autowired
	private TeamsService teamsService;

	// displaying list of all teams
	@GetMapping("/teams")
	public List<Team> getAllCompany() {
		return teamsService.getAllTeams();
	}

	// displaying teams by id
	@GetMapping("/teams/{id}")
	public Optional<Team> getTeams(@PathVariable int id) {
		return teamsService.getTeams(id);
	}

	// inserting teams
	@PostMapping("/teams")
	public void addTeams(@RequestBody Team teams) {
		teamsService.addTeams(teams);
	}

	// updating teams by id
//	@PutMapping("/teams/{id}")
//	public void updateTeams(@RequestBody Team e, @PathVariable int id) {
//		teamsService.updateTeams(e, id);
//	}

	// deleting all teams
	@DeleteMapping("/teams")
	public void deleteAllTeams() {
		teamsService.deleteAllTeams();
	}

	// deleting teams by id
	@DeleteMapping("teams/{id}")
	public void deleteTeamsByID(@RequestBody Team e, @PathVariable int id) {
		teamsService.deleteTeamsByID(id);
	}

	// updating/ patching teams by id
//	@PatchMapping("teams/{id}")
//	public void patchTeamsByID(@RequestBody Team e, @PathVariable int id) {
//		teamsService.patchTeams(e, id);
//	}
}
