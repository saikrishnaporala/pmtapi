package com.pmt.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "team_uniq_id")
	private String teamUniqId;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Column(name = "teammembers")
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private Set<User> users;

	@Column(name = "teamavatar")
	private String teamavatar;

	@Column(name = "color")
	private String color;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamUniqId() {
		return teamUniqId;
	}

	public void setTeamUniqId(String teamUniqId) {
		this.teamUniqId = teamUniqId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getTeamavatar() {
		return teamavatar;
	}

	public void setTeamavatar(String teamavatar) {
		this.teamavatar = teamavatar;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamUniqId=" + teamUniqId + ", name=" + name + ", company=" + company + ", users="
				+ users + ", teamavatar=" + teamavatar + ", color=" + color + "]";
	}

	public Team(int id, String teamUniqId, String name, Company company, Set<User> users, String teamavatar,
			String color) {
		super();
		this.id = id;
		this.teamUniqId = teamUniqId;
		this.name = name;
		this.company = company;
		this.users = users;
		this.teamavatar = teamavatar;
		this.color = color;
	}

}
