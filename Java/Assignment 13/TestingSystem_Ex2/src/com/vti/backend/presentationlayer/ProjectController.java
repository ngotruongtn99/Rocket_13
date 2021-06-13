package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.businesslayer.IProjectService;
import com.vti.backend.businesslayer.ProjectService;
import com.vti.entity.Project;

public class ProjectController {
	private IProjectService projectService;
	
	public ProjectController() throws FileNotFoundException, IOException {
		projectService = new ProjectService();
	}
	
public Project getProjectByID(int id) throws ClassNotFoundException, SQLException {
		
		return projectService.getProjectByID(id);
	}
}
