package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.JobDAO;

@WebServlet("/delete")
public class DeleteJobServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			int id =Integer.parseInt(req.getParameter("id"));
			
			JobDAO dao=new JobDAO(DBConnect.getConn());
			boolean f= dao.deleteJobs(id);
			
			 HttpSession session = req.getSession();

	            if (f) {
	                session.setAttribute("succMsg", "Job deleted   successfully.");
	                resp.sendRedirect("View_jobs.jsp");
	            } else {
	                session.setAttribute("succMsg", "Something went wrong on the server.");
	                resp.sendRedirect("View_jobs.jsp");
	            }
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
