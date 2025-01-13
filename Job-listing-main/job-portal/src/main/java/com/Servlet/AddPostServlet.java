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

@SuppressWarnings("serial")
@WebServlet("/add_job")
public class AddPostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // Getting form data from the request
            String title = req.getParameter("title");
            String location = req.getParameter("location");
            String category = req.getParameter("category");
            String status = req.getParameter("status");
            String desc = req.getParameter("desc");

            // Creating an instance of the jobs class and setting data
            Jobs j = new Jobs();
            j.setTitle(title);
            j.setDescription(desc);
            // Fixing the typo in the method name
            j.setLoccation(location);
            j.setStatus(status);
            j.setCategory(category);

            // Creating a session
            HttpSession session = req.getSession();

            // Using the JobDAO to insert job data into the database
            JobDAO dao = new JobDAO(DBConnect.getConn());
            boolean f = dao.addJobs(j);  // Ensure this method is defined in JobDAO

            // Redirecting based on the result
            if (f) {
                session.setAttribute("succMsg", "Job posted successfully.");
                resp.sendRedirect("add_job.jsp");
            } else {
                session.setAttribute("succMsg", "Something went wrong on the server.");
                resp.sendRedirect("add_job.jsp");
            }

        } catch (Exception e) {
            // Logging the error and redirecting to the error page
            e.printStackTrace();
            req.getSession().setAttribute("errorMsg", "Internal server error: " + e.getMessage());
            resp.sendRedirect("error.jsp");
        }
    }
}
