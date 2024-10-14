package com.ltd.Insurance;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static final String FILE_PATH = "D:/Courses/SEM III/J2EE/Project Workspace/Assignment1j2ee/src/main/webapp/WEB-INF/customers.json";
    private List<Customer> customers;
    private Gson gson;

    public CustomerRepository() {
        gson = new Gson();
        loadCustomers();
    }

    private void loadCustomers() {
        try {
            if (Files.exists(Paths.get(FILE_PATH))) {
                Reader reader = new FileReader(FILE_PATH);
                customers = gson.fromJson(reader, new TypeToken<List<Customer>>() {}.getType());
                reader.close();
            } else {
                customers = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            customers = new ArrayList<>();
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveCustomers();
    }

    private void saveCustomers() {
        try {
            Writer writer = new FileWriter(FILE_PATH);
            gson.toJson(customers, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
    
    
    public boolean UpdateCustomers(Customer customer) {
    	boolean updated = false;
        for (int i = 0; i < customers.size(); i++) {
        	updated = false;
            if (customers.get(i).getId().equals(customer.getId())) 
            {
                customers.set(i, customer);
                saveCustomers();
                updated = true;
            }
        }
        return updated;
    }

    public boolean DeleteCustomers(String id) {
        boolean removed = customers.removeIf(c -> c.getId().equals(id));
        saveCustomers();
        return removed; 
    }
}
