package com.pmt.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Activity;

public interface ActivityRepo extends JpaRepository<Activity, UUID> {

}
