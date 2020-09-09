package com.pmt.jwttoken;

import java.io.Serializable;
import java.util.UUID;

public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final UUID empid;
	private final UUID compid;
	private final String deptid;

	public JwtResponse(String jwttoken, UUID empid, UUID compid, String deptid) {
		this.jwttoken = jwttoken;
		this.empid = empid;
		this.compid = compid;
		this.deptid = deptid;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public UUID getEmpid() {
		return this.empid;
	}

	public UUID getCompid() {
		return this.compid;
	}

	public String getDeptid() {
		return this.deptid;
	}
}