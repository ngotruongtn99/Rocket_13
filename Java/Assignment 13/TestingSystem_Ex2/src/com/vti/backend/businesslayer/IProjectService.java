package com.vti.backend.businesslayer;

import java.sql.SQLException;

import com.vti.entity.Project;

public interface IProjectService {
	public Project getProjectByID(int id) throws ClassNotFoundException, SQLException;
}
