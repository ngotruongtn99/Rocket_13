package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Department;

public class DepartmentSpecification implements Specification<Department> {

	private String field;
	private String operator;
	private String value;

	public DepartmentSpecification(String field, String operator, String value) {
		super();
		this.field = field;
		this.operator = operator;
		this.value = value;
	}

	@Override
	public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		
		if (operator.equalsIgnoreCase("LIKE")) {
			if (field.equalsIgnoreCase("department.name")) {
				return builder.like(root.get("department").get("name"), "%" + value.toString() + "%");
			}else {
				return builder.like(root.get(field), "%" + value.toString() + "%");
			}
		}
		return null;
	}

	

}
