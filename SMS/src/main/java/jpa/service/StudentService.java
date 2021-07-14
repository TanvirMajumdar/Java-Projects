package jpa.service;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO{
	
	EntityManagerFactory emfactory = null;
    EntityManager entitymanager = null;
    Query query= null;

	@Override
	public List <Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		try{
			emfactory = Persistence.createEntityManagerFactory("SMS");
	        entitymanager = emfactory.createEntityManager( );
	        query= entitymanager.createQuery("Select e From Student e");
	        
	        @SuppressWarnings("unchecked")
			List <Student> getAllStudents = query.getResultList();
	        
	        for (Student s: getAllStudents) {
	        	s.getsEmail();
	        	s.getsName();
	        	s.getsPassword();
			}
	        return getAllStudents;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
			entitymanager.close();
			emfactory.close();
			
        	return null;
	}
	
	@Override
	public Student getStudentByEmail(String sEmail) {
		
		List<Student> courseList= getAllStudents();
		
		Iterator<Student> it = courseList.iterator();
		  while(it.hasNext())
		  {
			 Student email = it.next();
		     if(email.getsEmail().equals(sEmail))
		     {
		    	 break;
		     }
		  }

		  return (Student) it;
		  
		  }
		  
	
	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		List<Student> list= getAllStudents();
		
		Iterator<Student> it = list.iterator();
		  while(it.hasNext())
		  {
			 Student info = it.next();
		     if((info.getsEmail().equals(sEmail))&&(info.getsPassword().equals(sPassword)))
		     {
		    	 return true;
		     }
		  }
		return false;
		
		
	}
	
	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		emfactory = Persistence.createEntityManagerFactory("SMS");
        entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        
		Student student=entitymanager.find(Student.class, sEmail);
		Course course=entitymanager.find(Course.class,cId);
		for (Course c : student.getsCourses()) {
			if (c.getcId()==cId) {
				System.out.println("You have already taken this course");
				entitymanager.close();
				emfactory.close();
				return;
			}

		}
 		student.getsCourses().add(course);
		System.out.println("You succefully added the course: "+ cId);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
 
	}
	
	
	
	@Override
	public List <Course> getStudentCourses(String sEmail) {
		emfactory = Persistence.createEntityManagerFactory("SMS");
        entitymanager = emfactory.createEntityManager( );
        
        Student student=entitymanager.find(Student.class, sEmail);
		List<Course> courses=student.getsCourses();
		
		entitymanager.close();
		emfactory.close();
		
		return courses;
		

	}
		
		
}


