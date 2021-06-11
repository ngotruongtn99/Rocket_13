package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Group;
import com.vti.ultis.jdbcUltis;

public class GroupRepository implements IGroupRepository{
	private jdbcUltis jdbc;

	public GroupRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Group> getListGroup() throws ClassNotFoundException, SQLException {
			String sql = "SELECT * FROM `Group` ORDER BY GroupID ;";
			ResultSet resultSet = jdbc.executeQuery(sql);
			List<Group> list = new ArrayList<Group>();
			while (resultSet.next()) {
				Group group = new Group(resultSet.getInt("GroupID"), resultSet.getString("GroupName"));
				list.add(group);
			}
			jdbc.disConnection();
			return list;
	}
}	
	
		
	
	

