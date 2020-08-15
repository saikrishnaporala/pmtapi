package com.pmt.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.User;

public interface UserRepo extends JpaRepository<User, UUID> {

	User findByUsername(String username);

}
