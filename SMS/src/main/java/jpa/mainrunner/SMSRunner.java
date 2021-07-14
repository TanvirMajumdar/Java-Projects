package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;
import jpa.entitymodels.Course;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {
	
	static Scanner scanner=new Scanner(System.in);
	static StudentService studentService=new StudentService();
	static CourseService courseService=new CourseService();
	static String email;
	
	
	public static void main(String[] args) {
		
		System.out.println("Are you a student? Please enter 1 to login or 2 to logout: ");
		
		//User input for login or logout
		int input = scanner.nextInt();
		
		switch(input) {		
		case 1:
			if (studentLogin()==true) {
				registerMenu();
		    }
		     break;
	    case 2:
		System.out.println("Goodbye!");
		break;
		
		default:
			System.out.println("Wrong selection!");
		}
	
		
	}

	public static boolean studentLogin() {
		// TODO Auto-generated method stub
		
			
		scanner.nextLine();
		System.out.println("Enter your email: ");
		//user input for email
		String emailInput = scanner.next();
		email=emailInput;
		System.out.println("Enter your password: ");
		//user input for password
		String passwordInput = scanner.next();
		if(studentService.validateStudent(emailInput, passwordInput)==true) {
			System.out.println("You are successfully logged in!");
			studentCourses();
			return true;
		};
		
		System.out.println("User Validation failed. GoodBye!");
				
		return false;
	
	}
	
	public static void registerMenu() {
		
		System.out.println("Please enter 1 if you want to register for a course? Or enter 2 for logout: ");
		
		//User input for register a course or logout
		int input1 = scanner.nextInt();
		switch(input1) {		
		case 1:
			System.out.printf("%10s%50S%50s\n", "ID", "Course", "Instructor");
			List <Course> allCourses= courseService.getAllCourses();
			
			for (Course c: allCourses) { 
				System.out.printf("%10s%50S%50s\n", c.getcId(), c.getcName(), c.getcInstructorName());
			}
			
			System.out.println("Which Course you want to add? Select between 1 to "+ allCourses.size());
			
			int input2 = scanner.nextInt();

			System.out.println("Your selection is : " +input2);
			if (input2<=courseService.getAllCourses().size()) {
				studentService.registerStudentToCourse(email, input2);
				studentCourses();
				System.out.println("You are succesfully logged out!");
			break;
			}
			else {
				System.out.println("Wrong selection! Select a valid course id!");
				break;
			}
			
			
		case 2:
			System.out.println("You are succesfully logged out!");
			break;
			
		default:
				System.out.println("Wrong selection!");
		}
	}
		
		public static void studentCourses() {
		List <Course> studentClasses= studentService.getStudentCourses(email);
		
		if (studentClasses.isEmpty()==true) {
			System.out.println("You have not registered to any class yet!");
			}
		else {
		
		System.out.println("Your classes: ");
		System.out.printf("%10s%50S%50s\n", "ID", "Course", "Instructor");
		
		for (Course c: studentClasses) { 
			System.out.printf("%10s%50S%50s\n", c.getcId(), c.getcName(), c.getcInstructorName());
		}
		}
		
		}
		

}
