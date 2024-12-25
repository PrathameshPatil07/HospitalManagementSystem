package com.example.HospitalManagementSystem.Dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.HospitalManagementSystem.Entity.Hospital;

import jakarta.websocket.Session;

@Repository
public class HospitalDao {
	private static final String url = "jdbc:mysql://localhost:3306/demo";
	private static final String username = "root";
	private static final String password = "Patil@123";
	public static Connection con=null;
	public static PreparedStatement pstmt=null;
//	Session session = null;
//	@Autowired
//	Config config;

	public static Connection getDbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public ArrayList<Hospital> getalldata() {
		System.out.println("In DAO");
		ArrayList<Hospital>h=new ArrayList<Hospital>();
		String sql="select * from hospital";
		
		try {
			pstmt = getDbConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name=rs.getString(2);
				String city = rs.getString(3);
				
				h.add(new Hospital(id, name, city));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return h;
	}
	
	public void addHospital(Hospital h) {
		System.out.println(h);
		String sql="insert into hospital values(?,?,?)";
		try {
			pstmt = getDbConnection().prepareStatement(sql);
			
			pstmt.setInt(1, h.getId());
			pstmt.setString(2, h.getName());
			pstmt.setString(3, h.getCity());
			
			pstmt.executeUpdate();
			
			System.err.println("Done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteHospital(Hospital h) {
		String sql="delete from hospital where id=?";
		try {
			pstmt=getDbConnection().prepareStatement(sql);
			pstmt.setInt(1, h.getId());
			pstmt.executeUpdate();
			System.out.println("Hospital deleted");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
