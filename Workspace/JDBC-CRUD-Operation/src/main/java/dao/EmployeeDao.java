package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;

public class EmployeeDao {

	
	public int storeEmployeeRecord(Employee emp) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");			// MySQL 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db123", "root", "root@123");	
		PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");
		pstmt.setInt(1, emp.getId());
		pstmt.setString(2, emp.getName());
		pstmt.setFloat(3, emp.getSalary());
		return pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return 0;
	}
	
	public List<Employee> retrieveRecord() {
		List<Employee> listOfEmp = new ArrayList<>();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");			// MySQL 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db123", "root", "root@123");	
		PreparedStatement pstmt = con.prepareStatement("select * from employee");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getFloat(3));
			listOfEmp.add(emp);
		}
		return listOfEmp;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}
}
