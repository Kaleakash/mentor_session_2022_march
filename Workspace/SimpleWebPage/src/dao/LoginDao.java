package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Login;

public class LoginDao {

	
	public int createAccount(Login ll) {
		try {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
				session.save(ll);
		tran.commit();
		return 1;
		}catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	public int checkLogin(Login ll) {
		try {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("select l from Login l where l.emailid = :a and l.password = :b");
		qry.setParameter("a", ll.getEmailid());
		qry.setParameter("b", ll.getPassword());
		int leng = qry.list().size();
		//System.out.println(leng);
		return leng;
		}catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
}
