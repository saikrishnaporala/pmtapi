package com.pmt.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Task;

public interface TaskRepo extends JpaRepository<Task, UUID> {

}
