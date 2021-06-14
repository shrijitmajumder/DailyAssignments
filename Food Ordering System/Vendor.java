package com.capgemini.food_ordering_system.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Vendor {
	static Connection con = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static int count = 10001;
	
	//Check table already created or not
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
	
	//Create table VENDOR_REGISTRATION
	public void createVendorTable() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			String createTable = "CREATE TABLE VENDOR(vendorid int PRIMARY KEY, vendorname VARCHAR2(50), vendoremail VARCHAR2(50), vendorpassword VARCHAR2(50), vendorPhoneNumber VARCHAR2(10))"; 
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
		
	}//Ending vendor reg
	
		//register vendor
		public void registerVendor(String name,String password ,String email, String phno) {
			int id = ++count;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
				
				String inserData = "INSERT INTO VENDOR VALUES(?,?,?,?,?)";
				pstmt = con.prepareStatement(inserData);
				pstmt.setInt(1, id);
				pstmt.setString(2,name);
				pstmt.setString(3,email);
				pstmt.setString(4,password);
				pstmt.setString(5,phno);
				int i = pstmt.executeUpdate();
				if(i!=0) {
					System.out.println("Registration completed.");
				}
				else {
					System.out.println("Registration failed.");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}//ending register vendor
		
		//login Vendor
		public boolean loginVendor(String email,String password) {
			boolean flag = false;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
				stmt = con.createStatement();
				rs = stmt.executeQuery("SELECT * FROM VENDOR");
				
				while(rs.next()) {
					if(String.valueOf(rs.getString(3)).equals(email) && String.valueOf(rs.getString(4)).equals(password)) {
						flag = true;
						break;
					}else {
						flag = false;
					}
				}
				
			} catch (SQLException | ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			if(flag == true)
				return flag;
			else 
				return flag;
		}//ending login Vendor
		
		public String takeName() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Vendor Name: ");
			return sc.nextLine();
		}
		
		public String takeEmail() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Vendor Email: ");
			return sc.nextLine();
		}
		
		public String takePassword() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Vendor Password: ");
			return sc.nextLine();
		}
		
		public String takePhoneNumber() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Phone Number: ");
			return sc.nextLine();
		}
		
}

