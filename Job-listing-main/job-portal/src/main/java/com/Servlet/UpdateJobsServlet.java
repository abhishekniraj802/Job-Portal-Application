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
import com.entity.Jobs;

@WebServlet("/update")
public class UpdateJobsServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");
            String location = req.getParameter("location");
            String category = req.getParameter("category");
            String status = req.getParameter("status");
            String desc = req.getParameter("desc");
            
            Jobs j =new Jobs();
            j.setId(id);
            j.setTitle(title);
            j.setDescription(desc);
            j.setLoccation(location);
            j.setCategory(category);
            j.setStatus(status);
            
            HttpSession session = req.getSession();

            // Using the JobDAO to insert job data into the database
            JobDAO dao = new JobDAO(DBConnect.getConn());
            boolean f = dao.updateJob(j);  // Ensure this method is defined in JobDAO

            // Redirecting based on the result
            if (f) {
                session.setAttribute("succMsg", "Job updated  successfully.");
                resp.sendRedirect("View_jobs.jsp");
            } else {
                session.setAttribute("succMsg", "Something went wrong on the server.");
                resp.sendRedirect("View_jobs.jsp");
            }
            
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
