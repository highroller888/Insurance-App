/**package com.ltd.Insurance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ListCustomers") // URL pattern for listing customers
public class ListCustomers extends HttpServlet {
    private CustomerRepository customerRepository;

    @Override
    public void init() throws ServletException {
        customerRepository = new CustomerRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerRepository.getAllCustomers();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Customer List</h1>");
        out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Email</th></tr>");
        
        for (Customer customer : customers) {
            out.println("<tr>");
            out.println("<td>" + customer.getId() + "</td>");
            out.println("<td>" + customer.getName() + "</td>");
            out.println("<td>" + customer.getEmail() + "</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
    }
}
**/

package com.ltd.Insurance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ListCustomers") // URL pattern for listing customers
public class ListCustomers extends HttpServlet {
    private CustomerRepository customerRepository;

    @Override
    public void init() throws ServletException {
        customerRepository = new CustomerRepository(); // Initialize the repository
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the updated list of customers from the repository
        List<Customer> customers = customerRepository.getAllCustomers();

        // Set response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Generate the customer list table
        out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Email</th></tr>");
        
        for (Customer customer : customers) {
            out.println("<tr>");
            out.println("<td>" + customer.getId() + "</td>");
            out.println("<td>" + customer.getName() + "</td>");
            out.println("<td>" + customer.getEmail() + "</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
    }
}
