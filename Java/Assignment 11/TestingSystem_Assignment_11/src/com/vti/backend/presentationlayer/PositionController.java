package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IPositionService;
import com.vti.backend.businesslayer.PositionService;
import com.vti.entity.Position;

public class PositionController {
	private IPositionService positionService;
	
	public PositionController() throws FileNotFoundException, IOException {
		positionService = new PositionService();
	}
	
	
	public List<Position> getListPosition() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return positionService.getListPosition();
	}

	
	public Position getPositionById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return positionService.getPositionById(id);
	}
}
