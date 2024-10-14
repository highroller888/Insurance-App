/**package com.ltd.Insurance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteCustomers")
public class DeleteCustomers extends HttpServlet {
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the customer ID from the request
        String id = request.getParameter("id");

        // Validate the ID
        if (id == null || id.isEmpty()) {
            request.setAttribute("error", "Customer ID is required.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        // Delete the customer from the repository
        customerRepository.DeleteCustomers(id);

        // Redirect to customer list or a confirmation page
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

@WebServlet("/DeleteCustomers")
public class DeleteCustomers extends HttpServlet {
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the customer ID from the request
        String id = request.getParameter("id");

        // Validate the ID
        if (id == null || id.isEmpty()) {
            request.setAttribute("message", "Customer ID is required.");
            request.getRequestDispatcher("index.html").forward(request, response);
            return;
        }

        boolean isDeleted = customerRepository.DeleteCustomers(id);

        // Prepare the message based on the deletion result
        String message;
        if (isDeleted) {
            message = "Customer with ID " + id + " deleted successfully.";
        } else {
            message = "Failed to delete customer with ID " + id + ".";
        }

        // Set the message as a request attribute and forward back to the HTML page
        response.sendRedirect("DeleteCustomers.html?message=" + java.net.URLEncoder.encode(message, "UTF-8"));
    }
}

