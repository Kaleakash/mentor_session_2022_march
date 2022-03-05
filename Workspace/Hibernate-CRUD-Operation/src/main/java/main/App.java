package main;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import bean.Employee;
import service.EmployeeService;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeService es = new EmployeeService();
//		// insert Query 
//		Employee emp = new Employee();
//		
//		System.out.println("Enter the id");
//		int id = sc.nextInt();
//		emp.setId(id);
//		System.out.println("Enter the name");
//		String name = sc.next();
//		emp.setName(name);
//		System.out.println("Enter the salary");
//		float salary = sc.nextFloat();
//		emp.setSalary(salary);
//		String res = es.storeEmployeeDetails(emp);
//		System.out.println(res);
		// delete Query 
//		System.out.println("Enter the id to delete the records");
//		int id = sc.nextInt();
//		String res = es.deleteRecord(id);
//		System.out.println(res);
		List<Employee> listOfEmp = es.getAllEmployee();
		ListIterator<Employee> li = listOfEmp.listIterator();
		while(li.hasNext()) {
			Employee emp = li.next();
			System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getSalary());
		}
	}

}
