package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Position;

public interface IPositionRepository {
	public List<Position> getListPosition() throws ClassNotFoundException, SQLException;
	
	public Position getPosById(int id) throws ClassNotFoundException, SQLException;
}
