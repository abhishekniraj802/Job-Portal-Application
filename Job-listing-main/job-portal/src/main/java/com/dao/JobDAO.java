package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Correctly import the Jobs class
import com.entity.Jobs;

public class JobDAO {

    private Connection conn;

    public JobDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean addJobs(Jobs j) {
        boolean f = false;

        try {
            // Correct SQL query with appropriate number of placeholders
            String sql = "INSERT INTO jobs (title, description, category, status, location, pdate) VALUES (?, ?, ?, ?, ?, NOW())";
            PreparedStatement ps = conn.prepareStatement(sql);

            // Setting values for the placeholders
            ps.setString(1, j.getTitle());
            ps.setString(2, j.getDescription());
            ps.setString(3, j.getCategory());
            ps.setString(4, j.getStatus());
            ps.setString(5, j.getLoccation());  // Corrected the method name

            // Execute the update and check if a record was inserted
            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;  
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return f; // Return the result from within the method
    }

    public List<Jobs> getAllJobs() {  // Corrected method name
        List<Jobs> list = new ArrayList<>();
        Jobs j = null;

        try {
            String sql = "SELECT * FROM jobs ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                j = new Jobs();
                j.setId(rs.getInt(1));
                j.setTitle(rs.getString(2));
                j.setDescription(rs.getString(3));
                j.setCategory(rs.getString(4));
                j.setStatus(rs.getString(5));
                j.setLoccation(rs.getString(6));  // Corrected method name
                j.setPdate(rs.getString(7));  // Removed unnecessary concatenation
                list.add(j);
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return list;
    }

    public Jobs getJobById(int id) {  // Corrected method name
        Jobs j = null;

        try {
            String sql = "SELECT * FROM jobs WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                j = new Jobs();
                j.setId(rs.getInt(1));
                j.setTitle(rs.getString(2));
                j.setDescription(rs.getString(3));
                j.setCategory(rs.getString(4));
                j.setStatus(rs.getString(5));
                j.setLoccation(rs.getString(6));  // Corrected method name
                j.setPdate(rs.getString(7));  // Removed unnecessary concatenation
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return j;
    }

    public boolean updateJob(Jobs j) {
        boolean f = false;

        try {
            // Correct SQL query with appropriate number of placeholders
            String sql = "UPDATE jobs SET title=?, description=?, category=?, status=?, location=? WHERE id=?"; 
            PreparedStatement ps = conn.prepareStatement(sql);

            // Setting values for the placeholders
            ps.setString(1, j.getTitle());
            ps.setString(2, j.getDescription());
            ps.setString(3, j.getCategory());
            ps.setString(4, j.getStatus());
            ps.setString(5, j.getLoccation());  // Corrected method name
            ps.setInt(6, j.getId());

            // Execute the update and check if a record was updated
            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;  
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return f;
    }
    
    
    public boolean deleteJobs(int id)
    {
    	boolean f = false;
    	try {
    		
    		String sql ="delete  from jobs where id=?";
    		PreparedStatement ps=conn.prepareStatement(sql);
    		ps.setInt(1, id);
    		
    		int i=ps.executeUpdate();
    		if( i == 1) {
    			f = true;
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();    		
    	}
    			return f;
    }
}
