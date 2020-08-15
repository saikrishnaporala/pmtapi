package com.pmt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Workspace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "spaceavatar")
	private String spaceavatar;

	@Column(name = "color")
	private String color;

	@Column(name = "authstat")
	private byte authstat;

	@Column(name = "isactive")
	private byte isactive;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpaceavatar() {
		return spaceavatar;
	}

	public void setSpaceavatar(String spaceavatar) {
		this.spaceavatar = spaceavatar;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public byte getAuthstat() {
		return authstat;
	}

	public void setAuthstat(byte authstat) {
		this.authstat = authstat;
	}

	public byte getIsactive() {
		return isactive;
	}

	public void setIsactive(byte isactive) {
		this.isactive = isactive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Workspace [id=" + id + ", name=" + name + ", spaceavatar=" + spaceavatar + ", color=" + color
				+ ", authstat=" + authstat + ", isactive=" + isactive + ", user=" + user + "]";
	}

	public Workspace(int id, String name, String spaceavatar, String color, byte authstat, byte isactive, User user) {
		super();
		this.id = id;
		this.name = name;
		this.spaceavatar = spaceavatar;
		this.color = color;
		this.authstat = authstat;
		this.isactive = isactive;
		this.user = user;
	}

}
