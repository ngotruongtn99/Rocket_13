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
	public List<Position> getListPosition() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Position;";
		ResultSet resultSet = jdbc.executeQuery(sql);

		List<Position> listPositions = new ArrayList<Position>();
		while (resultSet.next()) {
			Position pos = new Position(resultSet.getInt(1), resultSet.getString(2));
			listPositions.add(pos);
		}
		jdbc.disConnection();
		return listPositions;
	}
	
	@Override
	public Position getPosById(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM position WHERE PositionID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet result = preStatement.executeQuery();
		if (result.next()) {
			Position pos = new Position(result.getInt(1), result.getString(2));
			return pos;
		} else {
			jdbc.disConnection();
			return null;
		}
	}
}
