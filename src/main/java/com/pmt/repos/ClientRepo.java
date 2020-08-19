package com.pmt.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Client;

public interface ClientRepo extends JpaRepository<Client, UUID> {

}
