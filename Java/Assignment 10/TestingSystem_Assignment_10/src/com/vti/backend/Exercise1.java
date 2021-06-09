package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.ultis.ScannerUltis;
import com.vti.ultis.jdbcUltis;

public class Exercise1 {
	private jdbcUltis jdbc;
	
	public Exercise1() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	public void Question1() throws ClassNotFoundException, SQLException {
		System.out.println("Test kết nối");
		jdbc.connnectionTestting();
	}
	
	public void Question2() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM position;";
		ResultSet posResult = jdbc.executeQuery(sql);
		System.out.println("Thông tin Position đang có trên hệ thống: ");
		String leftAlignFormat = "| %-6d | %-21s |%n";

		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | PositionName          |%n");
		System.out.format("+--------+-----------------------+%n");
		while (posResult.next()) {
			System.out.format(leftAlignFormat, posResult.getInt(1), posResult.getString(2));
		}
		System.out.format("+--------+-----------------------+%n");
	}
	
	public void Question3() throws ClassNotFoundException, SQLException {
		System.out.println("Tạo Position mới: ");
		String sql = "INSERT INTO position (PositionName) VALUES (?);";
		PreparedStatement insertStatement = jdbc.createPrepareStatement(sql);
		System.out.println("Chọn Positon cần tạo 1.Dev, 2.Test, 3.Scrum Master, 4.PM: ");
		String name = getName();
		insertStatement.setString(1, name);
		if (insertStatement.executeUpdate() == 1) {
			System.out.println("Tạo thành công");
			Question2();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}

	}

	private String getName() {
		while (true) {
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				return "Dev";
				
			case 2:
				return "Test";
				
			case 3:
				return "Scrum Master";
				
			case 4:
				return "PM";

			default:
				System.out.println("Nhập lại");
				break;
			}
			
		}
		
	}
	
	public void Question4() throws ClassNotFoundException, SQLException {
		System.out.println("Update  tên của Position");
		System.out.println("Danh sách Position: ");
		Question2();
		System.out.println("Chọn ID cần Update");
		int id = ScannerUltis.inputIntPositive();
		System.out.println("Chọn tên cần Update: 1.Dev, 2.Test, 3.Scrum Master, 4.PM ");
		String newName = getName();
		String sql = "UPDATE position SET positionName = ? WHERE (PositionID = ?);";
		PreparedStatement updateStatement = jdbc.createPrepareStatement(sql);
		updateStatement.setString(1, newName);
		updateStatement.setInt(2, id);
		if (updateStatement.executeUpdate() == 1) {
			System.out.println("Update thành công");
			Question2();
		} else {
			System.out.println("Có lỗi xảy ra");
		}
	}
	
	public void Question5() throws ClassNotFoundException, SQLException {
		System.out.println("Delete Position ");
		System.out.println("Danh sách Position:");
		Question2();
		System.out.println("Chọn ID muốn Delete");
		int id = ScannerUltis.inputIntPositive();
		String sql = "DELETE FROM position WHERE (PositionID = ?);";
		PreparedStatement deleteStatement = jdbc.createPrepareStatement(sql);
		deleteStatement.setInt(1, id);
		if (deleteStatement.executeUpdate() == 1 ) {
			System.out.println("Xóa thành công");
			Question2();
		} else {
			System.out.println("Xóa không thành công");
			Question2();
		}
	}

}
	

