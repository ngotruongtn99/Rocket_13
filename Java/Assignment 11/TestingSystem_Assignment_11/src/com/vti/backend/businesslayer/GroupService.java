package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.GroupRepository;
import com.vti.entity.Group;

public class GroupService implements IGroupService{
	private GroupRepository groupRepository;

	public GroupService() throws FileNotFoundException, IOException {
		groupRepository = new GroupRepository();
	}

	@Override
	public List<Group> getListGroup() throws ClassNotFoundException, SQLException {
		
		return groupRepository.getListGroup();
	}
	
	
	
	
}
