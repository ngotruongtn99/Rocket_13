package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Position;
import com.vti.ultis.jdbcUltis;

public class PositionRepository implements IPositionRepository {
private jdbcUltis jdbc;
	
	public PositionRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	@Override
	public Position getPositionById(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Position WHERE PositionID = ? ;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Position pos = new Position(resultSet.getInt(1),resultSet.getString(2));
			jdbc.disConnection();
			return pos;
		} else {
			jdbc.disConnection();
			return null;
		}
	}

	@Override
	public List<Position> getListPosition() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Position ;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Position> list = new ArrayList<Position>();
		while (resultSet.next()) {
			Position pos = new Position(resultSet.getInt(1), resultSet.getString(2));
			list.add(pos);
		}
		jdbc.disConnection();
		return list;
	}

}
