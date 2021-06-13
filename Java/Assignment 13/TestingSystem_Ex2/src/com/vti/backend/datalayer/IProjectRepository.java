package com.vti.backend.datalayer;

import java.sql.SQLException;

import com.vti.entity.Project;

public interface IProjectRepository {
	public Project getProjectByID(int id) throws ClassNotFoundException, SQLException;
}
