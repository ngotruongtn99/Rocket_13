package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.datalayer.IProjectRepository;
import com.vti.backend.datalayer.ProjectRepository;
import com.vti.entity.Project;

public class ProjectService implements IProjectService{
	private IProjectRepository projectRepository;
	
	public ProjectService() throws FileNotFoundException, IOException {
		projectRepository = new ProjectRepository();
	}

	@Override
	public Project getProjectByID(int id) throws ClassNotFoundException, SQLException {
		
		return projectRepository.getProjectByID(id);
	}
	
}
