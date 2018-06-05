package com.learning.boot.model;

import javax.persistence.*;

import com.sun.istack.NotNull;

import lombok.Data;

import java.util.Set;

@Entity
@Table(name="Role")
public @Data class Role{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RO_ID")
	private int roleID;
	@Column(name="RO_Name")
	@NotNull
	private String roleName;
}
