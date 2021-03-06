package service;

import java.util.List;
import java.util.ListIterator;

import bean.Employee;
import dao.EmployeeDao;

// business logic. 
public class EmployeeService {

	
	public String storeEmployee(Employee emp) {
		if(emp.getSalary()<12000) {
			return "Salary must be > 12000";		// simple condition. it can more 
		}else {
			EmployeeDao ed = new EmployeeDao();
			if(ed.storeEmployeeRecord(emp)>0) {
				return "Stored";
			}else {
				return "didn't store";
			}
		}
	}
	
	public List<Employee> getAllEmployee() {
		EmployeeDao ed = new EmployeeDao();
		List<Employee> listOfEmp = ed.retrieveRecord();
		ListIterator<Employee> li = listOfEmp.listIterator();
		while(li.hasNext()) {
			Employee emp = li.next();
			emp.setSalary(emp.getSalary()+500);
		}
		
		return listOfEmp;
	}
}
