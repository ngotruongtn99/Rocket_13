package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;


@Entity
@Table(name = "Account", catalog = "TestingSystem")
@Data
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "Email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "Username", length = 50, nullable = false, unique = true)
	private String username;
	
	@Column(name = "Fullname", length = 50, nullable = false)
	private String fullname;
	
	@ManyToOne
	@JoinColumn(name = "DepartmentID", nullable = false)
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "PositionID", nullable = false)
	private Position position;
	
	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	
	@Column(name = "password", length = 800)
	private String password;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "`status`", nullable = false)
	private AccountStatus status = AccountStatus.NOT_ACTIVE;
	
	@Column(name = "PathImage", length = 50, unique = true, updatable = true)
	private String PathImage;

	@OneToMany(mappedBy = "creator")
	private List<Department> createdDepartment;
}
