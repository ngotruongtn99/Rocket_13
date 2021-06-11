package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Position;

public interface IPositionService {
	public List<Position> getListPosition() throws ClassNotFoundException, SQLException;

	public Position getPositionById(int id) throws ClassNotFoundException, SQLException;

}
