package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "aeycompany.com";
	
	
	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		// System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
		
		// Call a method asking for the department - return the department
		this.department = setDepartment();
		// System.out.println("Department: " + this.department);
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("\nYOUR PASSWORD IS: " + this.password);
		
		// Combine elements to generate an email
		email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		// System.out.println("Your email is: " + email);
	}
	
	
	// Ask for the department
	private String setDepartment() {
		System.out.print("New worker: " + firstName + ". DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if (deptChoice == 1) {
			return "sales";
		} else if (deptChoice == 2) {
			return "dev";
		} else if (deptChoice == 3) {
			return "acct";
		} else {
			return "";
		}
		
	}
	
	// Generate a random password
	/*
	 * Method description: 
	 * 1. Create a method that returns randomly created password, method wants you to tell it desired length of the password
	 * 2. Create a string containing allowed characters
	 * 3. We are creating an array of chars with length equal to one defined above
	 * 4. For every next element of array we choose a random char from the char array of passwords, save it to the password char.
	 * 5. Return new String based on char array "password".
	 */
	private String randomPassword (int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String (password);
	}
	
	// Set the mailbox capacity
	public void setMailboxCapacity (int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail (String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {
		return mailBoxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + "\n" +
				"COMPANY EMAIL: " + email + "\n" +
				"MAILBOX CAPACITY: " + mailBoxCapacity + "mb";
	}
}