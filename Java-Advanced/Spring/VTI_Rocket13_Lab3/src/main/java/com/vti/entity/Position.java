package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vti.entity.Enum.PositionName;
import com.vti.entity.Enum.PositionNameConvert;

import lombok.Data;

@Entity
@Table(name = "Position", catalog = "TestingSystem")
@Data
public class Position implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "PositionName", nullable = false, unique = true)
	@Convert(converter = PositionNameConvert.class)
	private PositionName name;
	
	
	@OneToMany(mappedBy = "position", fetch = FetchType.EAGER)
	List<Account> accounts;
}
