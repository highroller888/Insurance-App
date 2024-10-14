package com.ltd.Insurance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeletePoliciesServlet
 */
@WebServlet("/DeletePoliciesServlet")
public class DeletePoliciesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PoliciesRepository policiesRepository;

    @Override
    public void init() throws ServletException {
        policiesRepository = new PoliciesRepository();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String policyID = request.getParameter("policyID");

        String message;
        Policies policy = policiesRepository.getPolicyById(policyID);
        if (policy != null) {
            policiesRepository.deletePolicy(policyID);
            message = "Policy deleted successfully!";
        } else {
            message = "Policy not found!";
        }

        // Redirect back to the HTML page with a message
        response.sendRedirect("DeletePolicies.html?message=" + java.net.URLEncoder.encode(message, "UTF-8"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}