package com.pmt.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Department;

public interface DeptRepo extends JpaRepository<Department, UUID> {

}
