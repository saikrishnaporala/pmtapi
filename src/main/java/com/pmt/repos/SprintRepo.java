package com.pmt.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Sprint;

public interface SprintRepo extends JpaRepository<Sprint, UUID> {

}
