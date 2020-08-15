package com.pmt.repos;

import org.springframework.data.repository.CrudRepository;

import com.pmt.models.Team;

public interface TeamsRepo extends CrudRepository<Team, Integer> {

}
