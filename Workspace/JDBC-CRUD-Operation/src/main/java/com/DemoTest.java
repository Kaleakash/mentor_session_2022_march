package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DemoTest {

	public static void main(String[] args) {
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");			// MySQL 
			Class.forName("oracle.jdbc.driver.OracleDriver");		// Oracle 
			System.out.println("Driver loaded...");
	//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db123", "root", "root@123");	// MySQL
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "scott", "tiger");	//Oracle 
		System.out.println("Connnected...");
		Scanner sc = new Scanner(System.in);
		//Statement stmt = con.createStatement();
//		PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");
//		System.out.println("Enter the id");
//		int id = sc.nextInt();
//		pstmt.setInt(1, id);
//		System.out.println("Enter the name");
//		String name = sc.next();
//		pstmt.setString(2, name);
//		System.out.println("Enter the salary");
//		float salary = sc.nextFloat();
//		pstmt.setFloat(3, salary);
//		int res = pstmt.executeUpdate();
//		if(res>0) {
//			System.out.println("Record inserted...");
//		}
		// Retrieve record using preparedstatement 
		PreparedStatement pstmt = con.prepareStatement("select * from employee where name like ?");
		System.out.println("plz enter the name");
		String name = sc.next();
			pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println("Id is "+rs.getInt("id")+" Name is "+rs.getString("name")+" Salary is  "+rs.getFloat("salary"));		
		}
		// insert query 
//		int res = stmt.executeUpdate("insert into employee values(4,'Ramesh',35000)");
//		if(res>0) {
//			System.out.println("Record inserted...");
//		}
		// delete query 
//		int res = stmt.executeUpdate("delete from employee where id = 1");
//		if(res>0) {
//			System.out.println("record deleted");
//		}else {
//			System.out.println("Record not present");
//		}
		// update query 
//		int res = stmt.executeUpdate("update employee set salary = 45000 where id =2");
//		if(res>0) {
//			System.out.println("record updated");
//		}else {
//			System.out.println("Record not present");
//		}
//		ResultSet rs= stmt.executeQuery("select * from employee");
//		while(rs.next()) {
//		//System.out.println("Id is "+rs.getInt(1)+" Name is "+rs.getString(2)+" Salary is  "+rs.getFloat(3));
//	System.out.println("Id is "+rs.getInt("id")+" Name is "+rs.getString("name")+" Salary is  "+rs.getFloat("salary"));
//		}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
