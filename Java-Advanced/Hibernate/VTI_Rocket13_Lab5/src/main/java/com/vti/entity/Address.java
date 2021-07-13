package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Address", catalog = "TestingSystem")
@Data
public class Address {

	@Column(name = "AddressID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "AddressName", length = 100, nullable = false, unique = true)
	private String name;
	
	@OneToOne(mappedBy = "address")
	private DetailDepartment department;
}
