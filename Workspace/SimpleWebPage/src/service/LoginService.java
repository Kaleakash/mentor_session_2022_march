package service;

import bean.Login;
import dao.LoginDao;
// pure business logic 
public class LoginService {

	public String createAccount(Login ll) {
		LoginDao ld = new LoginDao();
		if(ld.createAccount(ll)>0) {
			return "Account created successfully";
		}else {
			return "Account didn't create";
		}
	}
	
	public String checkUser(Login ll) {
		LoginDao ld = new LoginDao();
		if(ld.checkLogin(ll)>0) {
			return "success";
		}else {
			return "failure";
		}
	}
}
