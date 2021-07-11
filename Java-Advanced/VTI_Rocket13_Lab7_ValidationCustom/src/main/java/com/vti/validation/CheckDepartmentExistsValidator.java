package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vti.datalayer.DepartmentRepository;

public class CheckDepartmentExistsValidator implements ConstraintValidator<CheckDepartmentExists, Integer>{

	private DepartmentRepository depRepository;
	
	public void intialize	(CheckDepartmentExists constraintAnnotation) {
		depRepository  = new DepartmentRepository();
	}
	@Override
	public boolean isValid(Integer depID, ConstraintValidatorContext context) {
		boolean flag = depRepository.isDepartmentExistsById((short) depID.intValue());

		return flag;
	}
	
}
