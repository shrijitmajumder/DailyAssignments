package com.capgemini.food_ordering_system.model;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Item {
	
	static Connection con = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static int count = 0;
	
	
	
	public boolean tableExists(String tableName, Connection conn) throws SQLException {
	    boolean found = false;
	    DatabaseMetaData databaseMetaData = conn.getMetaData();
	    ResultSet rs = databaseMetaData.getTables(null, null, tableName, null);
	    while (rs.next()) {
	        String name = rs.getString("TABLE_NAME");
	        if (tableName.equals(name)) {
	            found = true;
	            break;
	        }
	    }

	    return found;
	}
	
	
	//Create table item
	public void createItemTable() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			
			String createTable = "CREATE TABLE ITEM(itemid int PRIMARY KEY, itemname VARCHAR2(50), itemprice number(5,2))"; 
			stmt = con.createStatement();
			int i = stmt.executeUpdate(createTable);
					
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	//register item
	public void addItem(String name,double price) {
		int id = ++count;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			
			String insertData = "INSERT INTO ITEM VALUES(?,?,?)";
			pstmt = con.prepareStatement(insertData);
			pstmt.setInt(1, id);
			pstmt.setString(2,name);
			pstmt.setDouble(3, price);
			int i = pstmt.executeUpdate();
			if(i!=0) {
				System.out.println("Item added.");
			}
			else {
				System.out.println("Item addition failed.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public String takeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Item Name: ");
		return sc.nextLine();
	}
	
	public double takePrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Item Price: ");
		return sc.nextDouble();
	}

}
