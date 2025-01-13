package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.entity.User;
import com.dao.UserDAO;


@WebServlet("/add_user")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String name = req.getParameter("name");
			String qualification = req.getParameter("qualification");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			UserDAO dao = new UserDAO(DBConnect.getConn());
			
			User u =  new User(name , qualification, email, password,"User");
			boolean f = dao.addUser(u);
			
			HttpSession session = req.getSession();
			if(f) {
				session.setAttribute("succMsg", "registration SuccessFully");
				resp.sendRedirect("signup.jsp");
				
			}else {
				session.setAttribute("succMsg", "Something wrong on the server");
				resp.sendRedirect("signup.jsp");
			}
		}catch( Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

