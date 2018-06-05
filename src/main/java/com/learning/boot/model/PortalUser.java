package com.learning.boot.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.sun.istack.NotNull;

import lombok.Data;

import java.util.Set;

@Entity
@Table(name="PortalUser")
public @Data class PortalUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PU_ID")
	private int portalUserID;
	@Column(name="PU_Login", unique = true)
	private String portalUserLogin;
	@Column(name="PU_FirstName")
	@NotNull
	private String portalUserFirstName;
	@Column(name="PU_LastName")
	@Size
	@NotNull
	private String portalUserLastName;
	@Column(name="PU_Email", unique = true)
	@Email
	@NotNull
	private String portalUserEmail;
	@Column(name="PU_Password")
	private String portalUserPassword;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PortalUser_Roles", joinColumns = @JoinColumn(name = "PUR_PU_ID"), inverseJoinColumns = @JoinColumn(name = "PUR_RO_ID"))
	private Set<Role> roles;
	@Transient
	public String portalUserPasswordConfirm;

}
