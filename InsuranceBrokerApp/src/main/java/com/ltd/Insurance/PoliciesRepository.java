package com.ltd.Insurance;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class PoliciesRepository {
	
	private static final String FILE_PATH = "D:/Courses/SEM III/J2EE/Project Workspace/Assignment1j2ee/src/main/webapp/WEB-INF/policies.json";
    private Gson gson = new Gson();

    /**
     * Reads all policies from the JSON file.
     * If the file doesn't exist, it returns an empty list.
     * 
     * @return A list of policies.
     * @throws IOException if an I/O error occurs.
     */
    private List<Policies> readPolicies() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();  // Return empty list if file does not exist
        }
        try (Reader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, new TypeToken<List<Policies>>(){}.getType());
        }
    }

    /**
     * Writes the list of policies to the JSON file.
     * 
     * @param policies A list of policies to be written to the file.
     * @throws IOException if an I/O error occurs.
     */
    private void writePolicies(List<Policies> policies) throws IOException {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(policies, writer);
        }
    }

    /**
     * Returns all the policies from the file.
     * 
     * @return A list of all policies.
     * @throws IOException if an I/O error occurs.
     */
    public List<Policies> getAllPolicies() throws IOException {
        return readPolicies();
    }

    /**
     * Adds a new policy to the file.
     * 
     * @param policy The policy to be added.
     * @throws IOException if an I/O error occurs.
     */
    public void addPolicy(Policies policy) throws IOException {
        List<Policies> policies = readPolicies();
        policies.add(policy);
        writePolicies(policies);
    }

    /**
     * Retrieves a policy by its ID.
     * 
     * @param policyId The ID of the policy to find.
     * @return The policy with the given ID, or null if not found.
     * @throws IOException if an I/O error occurs.
     */
    public Policies getPolicyById(String policyId) throws IOException {
        return readPolicies().stream()
                .filter(p -> p.getpolicyID().equals(policyId))
                .findFirst()
                .orElse(null);
    }

    /**
     * Updates an existing policy in the file.
     * 
     * @param updatedPolicy The policy with updated details.
     * @throws IOException if an I/O error occurs.
     */
    public void updatePolicy(Policies updatedPolicy) throws IOException {
        List<Policies> policies = readPolicies();
        for (Policies policy : policies) {
            if (policy.getpolicyID().equals(updatedPolicy.getpolicyID())) {
                policies.set(policies.indexOf(policy), updatedPolicy);
                break;
            }
        }
        writePolicies(policies);
    }

    /**
     * Deletes a policy from the file by its ID.
     * 
     * @param policyId The ID of the policy to delete.
     * @throws IOException if an I/O error occurs.
     */
    public void deletePolicy(String policyId) throws IOException {
        List<Policies> policies = readPolicies();
        policies.removeIf(p -> p.getpolicyID().equals(policyId));
        writePolicies(policies);
    }

}
