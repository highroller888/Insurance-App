package com.ltd.Insurance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UpdatePoliciesServlet
 */
@WebServlet("/UpdatePoliciesServlet")
public class UpdatePoliciesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
        Policies policy = policiesRepository.getPolicyById(policyID);
        if (policy != null) {
            policy.setCustomerID(customerID);
            policy.setBrokerID(brokerID);
            policy.setPolicyType(policyType);
            policiesRepository.updatePolicy(policy);
            message = "Policy updated successfully!";
        } else {
            message = "Policy not found!";
        }

        // Redirect back to the HTML page with a message
        response.sendRedirect("UpdatePolicies.html?message=" + java.net.URLEncoder.encode(message, "UTF-8"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
