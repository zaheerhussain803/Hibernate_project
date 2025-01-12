package org.Amazon_Jspider.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.amazon_JSP.Entities.User;

import java.util.List;
import java.util.Scanner;

public class CustomerDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Amazon_Jspider");
    private final Scanner sc = new Scanner(System.in);

    // Simulate typing effect
    public void toSleep(String value) {
        for (int i = 0; i < value.length(); i++) {
            System.out.print(value.charAt(i));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    // Insert customer details
    public void insertCustomerDetails() {
        System.out.println("Enter Customer ID:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.println("Enter Customer Name:");
        String name = sc.nextLine();
        System.out.println("Enter Email:");
        String email = sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();
        System.out.println("Enter City:");
        String city = sc.nextLine();
        System.out.println("Enter Mobile Number:");
        String mobileNumber = sc.nextLine();

        User user = new User(id, name, email, password, city, mobileNumber);

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(user);

        transaction.commit();
        em.close();

        System.out.println("Customer details inserted successfully!");
    }

    // Update customer password by ID
    public void updateCustomerPasswordByCustomerID(int customerID, String newPassword) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        User customer = em.find(User.class, customerID);
        if (customer != null) {
            customer.setPassword(newPassword);
            System.out.println("Password updated successfully for customer ID: " + customerID);
        } else {
            System.out.println("Customer with ID " + customerID + " not found.");
        }

        transaction.commit();
        em.close();
    }

    // Delete customer by ID
    public void deleteCustomerById(int customerID) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        User customer = em.find(User.class, customerID);
        if (customer != null) {
            em.remove(customer);
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("No customer found with ID: " + customerID);
        }

        transaction.commit();
        em.close();
    }

    // Update customer password by mobile number
    public void updateCustomerPasswordByMobileNumber() {
        System.out.println("Enter your Mobile Number:");
        String mobileNumber = sc.next();

        System.out.println("Enter your new Password:");
        String newPassword = sc.next();

        while (true) {
            System.out.println("Confirm your Password:");
            String confirmPassword = sc.next();

            if (newPassword.equals(confirmPassword)) {
                EntityManager em = emf.createEntityManager();
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();

                String updateQuery = "UPDATE User u SET u.password = :password WHERE u.mobileNumber = :mobileNumber";
                Query query = em.createQuery(updateQuery);
                query.setParameter("password", newPassword);
                query.setParameter("mobileNumber", mobileNumber);

                int rowsUpdated = query.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Password updated successfully.");
                } else {
                    System.out.println("No customer found with the provided mobile number.");
                }

                transaction.commit();
                em.close();
                break;
            } else {
                System.out.println("Passwords do not match. Please try again.");
            }
       
        }
        
       
    }
    
    public void userLogin() {
    	
    	System.out.println("enter customer emailID");
    	String email=sc.next();
    	System.out.println("enter password Password");
    	String password=sc.next();
    	String select=
    			"select user from User user where user.email=?1 and user.password=?2";
    	EntityManagerFactory entitymanagerfactory=
    			Persistence.createEntityManagerFactory("Amazon_Jspider");
    	EntityManager entitymanager=entitymanagerfactory.createEntityManager();
    	
    	EntityTransaction transaction = entitymanager.getTransaction();
    	transaction.begin();
    	Query query =entitymanager.createQuery(select);
    	
    	
    	
    	query.setParameter(1, email);
    	query.setParameter(2, password);
    	try {
    		User user=(User)query.getSingleResult();
    		System.out.println("Login successfull");
    	}
    	
    	catch (Exception e) {
    		System.out.println("Invalid email id and password!");
			
		}
    	
    
    	
    }
	//write a program to print the details of the customer by using customer address!
	
    public void getCustomerDetailsbyCity() {
        System.out.println("Enter customer address (city):");
        String city = sc.next();
        
        // Correct query with parameter
        String select = "select user from User user where user.city = ?1";
        
        // Create the EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Amazon_Jspider");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        
        try {
            // Create the query
            Query query = entityManager.createQuery(select);
            
            // Set the city parameter
            query.setParameter(1, city);
            
            // Execute the query and retrieve the results
            List<User> customers = query.getResultList();

            // Check if the result list is empty
            if (customers.isEmpty()) {
                System.out.println("No customers found in city: " + city);
            } else {
                System.out.println("Customer details for city: " + city);
                for (User user : customers) {
                    System.out.println(user);
                }
            }
            
            // Commit the transaction
            transaction.commit();
            
        } catch (Exception e) {
            // Handle exceptions
            System.out.println("Error retrieving customer details: " + e.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            // Close the EntityManager
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    	
    	
    
    
    public void updateMobileNumber(int customerID, String newMobileNumber) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        User customer = em.find(User.class, customerID);
        if (customer != null) {
            customer.setMobileNumber(newMobileNumber);
            System.out.println("Mobile number updated successfully for customer ID: " + customerID);
        } else {
            System.out.println("Customer with ID " + customerID + " not found.");
        }

        transaction.commit();
        em.close();
    }
}
    	
    	
    	
    	
    	
  

