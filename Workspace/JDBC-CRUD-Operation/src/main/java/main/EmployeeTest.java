package main;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import bean.Employee;
import service.EmployeeService;

public class EmployeeTest {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		EmployeeService es = new EmployeeService();
//		System.out.println("enter the id");
//		int id = sc.nextInt();
//		System.out.println("enter the name");
//		String name = sc.next();
//		System.out.println("enter the salary");
//		float salary = sc.nextFloat();
//		Employee emp = new Employee();
//		emp.setId(id);
//		emp.setName(name);
//		emp.setSalary(salary);
//		String res = es.storeEmployee(emp);
//		System.out.println(res);
		EmployeeService es = new EmployeeService();
		List<Employee> listOfemp = es.getAllEmployee();
		ListIterator<Employee> li = listOfemp.listIterator();
		while(li.hasNext()) {
			Employee emp = li.next();
			System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getSalary());
		}
	}

}
