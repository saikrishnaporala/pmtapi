package com.pmt.repos;

import java.util.Optional;

import com.pmt.models.Employee;

public interface UserAuthenticationService {

	/**
	 * Logs in with the given {@code username} and {@code password}.
	 *
	 * @param username
	 * @param password
	 * @return an {@link Optional} of a user when login succeeds
	 */
	Optional<String> login(String username, String password);

	/**
	 * Finds a user by its dao-key.
	 *
	 * @param token user dao key
	 * @return
	 */
	Optional<Employee> findByToken(String token);

	/**
	 * Logs out the given input {@code user}.
	 *
	 * @param user the user to logout
	 */
	void logout(Employee emp);
}
