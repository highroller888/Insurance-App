/**package com.ltd.Insurance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/AddCustomers") // Ensure this matches your URL pattern
public class AddCustomers extends HttpServlet {
    private CustomerRepository customerRepository;

    @Override
    public void init() throws ServletException {
        customerRepository = new CustomerRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if (id != null && name != null && email != null) {
            Customer customer = new Customer(id, name, email);
            customerRepository.addCustomer(customer);
            response.getWriter().write("Customer added successfully!");
        } else {
            response.getWriter().write("Failed to add customer. Please provide id, name, and email.");
        }
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

@WebServlet("/AddCustomers")
public class AddCustomers extends HttpServlet {
    private CustomerRepository customerRepository;

    @Override
    public void init() throws ServletException {
        customerRepository = new CustomerRepository();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        String message;
        if (id != null && name != null && email != null) {
            Customer customer = new Customer(id, name, email);
            customerRepository.addCustomer(customer);
            message = "Customer added successfully!";
        } else {
            message = "Failed to add customer. Please provide id, name, and email.";
        }

        // Redirect to the HTML page with a message
        response.sendRedirect("AddCustomers.html?message=" + java.net.URLEncoder.encode(message, "UTF-8"));
    }
}

