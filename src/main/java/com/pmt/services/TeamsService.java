package com.pmt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.models.Team;
import com.pmt.repos.TeamsRepo;

@Service
public class TeamsService {

	@Autowired
	private TeamsRepo teamsRepository;

	// fetching all teams
	public List<Team> getAllTeams() {
		List<Team> teams = (List<Team>) teamsRepository.findAll();
		return teams;
	}

	// fetching teams by id
	public Optional<Team> getTeams(int id) {
		return teamsRepository.findById(id);
	}

	// inserting teams
	public void addTeams(Team c) {
		teamsRepository.save(c);
	}

	// updating teams by id
//	public void updateTeams(Team teams, int id) {
//		if (id == teams.get) {
//			teamsRepository.save(teams);
//		}
//	}

	// deleting all teams
	public void deleteAllTeams() {
		teamsRepository.deleteAll();
	}

	// deleting teams by id
	public void deleteTeamsByID(int id) {
		teamsRepository.deleteById(id);
	}

	// patching/updating teams by id
//	public void patchTeams(Team teams, int id) {
//		if (id == teams.getId()) {
//			teamsRepository.save(teams);
//		}
//	}
}
