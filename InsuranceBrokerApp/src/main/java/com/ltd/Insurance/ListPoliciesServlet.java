package com.ltd.Insurance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ListPoliciesServlet")
public class ListPoliciesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PoliciesRepository policiesRepository;

    @Override
    public void init() throws ServletException {
        policiesRepository = new PoliciesRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String policyID = request.getParameter("policyID");

        String message;
        Policies policy = policiesRepository.getPolicyById(policyID);
        if (policy != null) {
            message = "Policy Details: Policy ID: " + policy.getpolicyID() + 
                      ", Customer ID: " + policy.getCustomerID() +
                      ", Broker ID: " + policy.getBrokerID() + 
                      ", Policy Type: " + policy.getPolicyType();
        } else {
            message = "Policy not found!";
        }

        // Redirect back to ListPolicies.html with the message
        response.sendRedirect("ListPolicies.html?message=" + java.net.URLEncoder.encode(message, "UTF-8"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Delegate POST requests to GET for simplicity
    }
}