package com.ltd.Insurance;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/CreatePoliciesServlet")
public class CreatePoliciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private PoliciesRepository policiesRepository;

    @Override
    public void init() throws ServletException {
        policiesRepository = new PoliciesRepository();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String policyID = request.getParameter("policyID");
        String customerID = request.getParameter("customerID");
        String brokerID = request.getParameter("brokerID");
        String policyType = request.getParameter("policyType");

        String message;
        if (policyID != null && customerID != null && policyType != null) {
            Policies newPolicy = new Policies(policyID, customerID, brokerID, policyType);
            policiesRepository.addPolicy(newPolicy);
            message = "Policy created successfully!";
        } else {
            message = "Failed to create policy. Please provide policyID, customerID, and policyType.";
        }

        // Redirect to the HTML page with a message
        response.sendRedirect("CreatePolicies.html?message=" + java.net.URLEncoder.encode(message, "UTF-8"));
    }

}
