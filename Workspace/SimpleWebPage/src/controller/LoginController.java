package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Login;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession hs = request.getSession();
		Login ll = new Login();
		ll.setEmailid(emailId);
		ll.setPassword(password);
		LoginService ls = new LoginService();
		String result = ls.checkUser(ll);
		RequestDispatcher rd1 = request.getRequestDispatcher("Dashboard");
		RequestDispatcher rd2 = request.getRequestDispatcher("index.jsp");
		if(result.equals("success")) {
			hs.setAttribute("user", ll.getEmailid());
			rd1.forward(request, response);
		}else {
			pw.println("Failure try once again");
			rd2.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		Login ll = new Login();
		ll.setEmailid(emailId);
		ll.setPassword(password);
		LoginService ls = new LoginService();
		String result = ls.createAccount(ll);
		pw.print(result);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	}

}
