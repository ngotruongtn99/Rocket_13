package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.Project;
import com.vti.ultis.jdbcUltis;

public class ProjectRepository implements IProjectRepository{
	private jdbcUltis jdbc;
	
	public ProjectRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public Project getProjectByID(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Project WHERE ProjectID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			Project project = new Project(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			jdbc.disConnection();
			return project;
		} else {
			jdbc.disConnection();
			return null;
		}
		
	}
}
