package service;

import java.util.List;

import bean.Employee;
import dao.EmployeeDao;

public class EmployeeService {

	public String storeEmployeeDetails(Employee emp) {
		if(emp.getSalary()<12000) {
			return "Salary must be > 12000";
		}else {
			EmployeeDao ed = new EmployeeDao();
			if(ed.storeEmployeeDetails(emp)>0) {
				return "Stored";
			}else {
				return "didn' store";
			}
		}
	}
	
	public String deleteRecord(int id) {
		EmployeeDao ed  = new EmployeeDao();
		if(ed.deleteEmployee(id)>0) {
			return "Record deleted";
		}else {
			return "Record not present";
		}
	}
	
	public List<Employee> getAllEmployee() {
		EmployeeDao ed = new EmployeeDao();
		return ed.retrieveAlEmployee();
	}
}
