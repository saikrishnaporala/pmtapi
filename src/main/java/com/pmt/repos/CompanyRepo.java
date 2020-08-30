package com.pmt.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmt.models.Company;

public interface CompanyRepo extends JpaRepository<Company, UUID> {

	public Company findByCompanyName(String companyName);
}
