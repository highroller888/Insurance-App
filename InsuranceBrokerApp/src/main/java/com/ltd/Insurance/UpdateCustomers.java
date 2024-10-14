/**package com.ltd.Insurance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/UpdateCustomers")
public class UpdateCustomers extends HttpServlet {
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from request
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Validate parameters (basic validation)
        if (id == null || name == null || email == null) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        // Create a new Customer object
        Customer updatedCustomer = new Customer(id, name, email);

        // Update the customer in the repository
        customerRepository.UpdateCustomers(updatedCustomer);

        // Redirect to customer list or details page
        response.sendRedirect("customerList.jsp"); // Adjust the redirect as necessary
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

@WebServlet("/UpdateCustomers")
public class UpdateCustomers extends HttpServlet {
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from request
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Validate parameters (basic validation)
        if (id == null || name == null || email == null || id.isEmpty() || name.isEmpty() || email.isEmpty()) {
            request.setAttribute("message", "All fields are required.");
            request.getRequestDispatcher("index.html").forward(request, response);
            return;
        }

        // Create a new Customer object
        Customer updatedCustomer = new Customer(id, name, email);

        // Update the customer in the repository
        boolean isUpdated = customerRepository.UpdateCustomers(updatedCustomer);

        // Prepare the message based on the update result
        String message;
        if (isUpdated) {
            message = "Customer with ID " + id + " updated successfully.";
        } else {
            message = "Failed to update customer with ID " + id + ".";
        }

        
        
        response.sendRedirect("UpdateCustomers.html?message=" + java.net.URLEncoder.encode(message, "UTF-8"));

    }
}
