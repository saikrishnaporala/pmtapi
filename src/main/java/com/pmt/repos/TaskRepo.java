package com.pmt.repos;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Project;
import com.pmt.models.Sprint;
import com.pmt.models.Task;

public interface TaskRepo extends JpaRepository<Task, UUID> {

	List<Task> findByTaskProj(Project proj);

	List<Task> findByTaskSprint(Sprint sprint);
}
