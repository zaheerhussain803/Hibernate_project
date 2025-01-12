package org.Amazon_Jspider;

import java.util.Scanner;

import org.Amazon_Jspider.DAO.CustomerDAO;

public class App 
{Scanner scanner=new Scanner(System.in);
    public static void main( String[] args )
    {
    	Scanner scanner=new Scanner(System.in);
      CustomerDAO customerdao=new CustomerDAO();
      //customerdao.insertCustomerDetails();
    	//customerdao.updateCustomerPasswordByCustomerID(1,"zahh");
    	//System.out.println("updated password sucessfully");
    	//customerdao.deleteCustomerPasswordUsingCustomerId();
    boolean status = true;
      while (status) {
          System.out.println("Enter:");
          System.out.println("1. Register");
          System.out.println("2. Login");
          System.out.println("3. update password");
          System.out.println("4.delete account");
          System.out.println("5. update phno");
          System.out.println("6.details of user");
          

          switch (scanner.nextInt()) {
              case 1:
               customerdao.toSleep("---********REGISTRATION*********---");
               customerdao.insertCustomerDetails();
             
                  break;
              case 2:
                  customerdao.toSleep("--*********Login********--");
                  customerdao.userLogin();
                  
                  break;
              case 3:
                customerdao.toSleep("---******update password*******---");
                
               
                  break;
              case 4:
            	  customerdao.toSleep("**********delete account************");
            	  customerdao.deleteCustomerById(0);
            	  break;
            	  
              case 5:
            	 customerdao.updateMobileNumber(3,"9966352220");
            	  break;
            	  
              case 6:
            	  customerdao.toSleep("**********DETAILS OF USER************");
            	  customerdao.getCustomerDetailsbyCity();
            	  
              default:
                  customerdao.toSleep("invalid options");
          }
          
          if (scanner.next().equalsIgnoreCase("YES")) {
			
		}else {
			status=false;
			customerdao.toSleep("********** Thank you ***********");
		}
			
	
      }
      
    	
    }
}
