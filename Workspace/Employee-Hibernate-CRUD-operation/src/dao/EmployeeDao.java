package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Employee;

public class EmployeeDao {

	
	public int storeEmployeeDetails(Employee emp) {
		try {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");	
			SessionFactory sf= con.buildSessionFactory();// equal to Connection con;
			Session session = sf.openSession();// equal to Statement or PreparedStatement
			Transaction tran = session.getTransaction();
			tran.begin();
								session.save(emp);
			tran.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public int deleteEmployee(int id) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");	
		SessionFactory sf= con.buildSessionFactory();// equal to Connection con;
		Session session = sf.openSession();// equal to Statement or PreparedStatement
		Transaction tran = session.getTransaction();
		
		Employee emp= session.get(Employee.class, id);
		if(emp==null) {
			return 0;
		}else {
			tran.begin();
					session.delete(emp);
			tran.commit();
			return 1;
		}
		
	}
	
	public int updateEmployee(int id, float salary) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");	
		SessionFactory sf= con.buildSessionFactory();// equal to Connection con;
		Session session = sf.openSession();// equal to Statement or PreparedStatement
		Transaction tran = session.getTransaction();
		
		Employee emp= session.get(Employee.class, id);
		if(emp==null) {
			return 0;
		}else {
			tran.begin();
					emp.setSalary(salary);
					session.update(emp);
			tran.commit();
			return 1;
		}
		
	}
	
	public List<Employee> retrieveAlEmployee() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");	
		SessionFactory sf= con.buildSessionFactory();// equal to Connection con;
		Session session = sf.openSession();// equal to Statement or PreparedStatement
		Query qry = session.createQuery("select e from Employee e");
		//Query qry = session.createQuery("select e from Employee e where e.id= :empId");
		//qry.setParameter("empId", 2);
		return qry.list();		// directly we will get list of All Employee 
		
	}
	
}
