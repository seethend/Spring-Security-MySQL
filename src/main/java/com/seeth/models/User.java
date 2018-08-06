package com.seeth.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "newusers")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	@Column(name = "active")
	private int active;
	@Column(name = "email")
	private String email;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns= @JoinColumn(name="user_id"))
	private Set<Role> roles;
	
	public User() {
	
	}
	
	public User(User user) {
		this.id = user.getId();
		this.active = user.getActive();
		this.email = user.getEmail();
		this.last_name = user.getLast_name();
		this.name = user.getName();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", active=" + active + ", email=" + email
				+ ", last_name=" + last_name + ", name=" + name + ", password="
				+ password + ", roles=" + roles + "]";
	}
	
}
