package jpa.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO{
	EntityManagerFactory emfactory=null;
	EntityManager entitymanager = null;
	Query query= null;

	@Override
	public List<Course>  getAllCourses() {
		// TODO Auto-generated method stub
		
		try {
		
		emfactory = Persistence.createEntityManagerFactory("SMS");
        entitymanager = emfactory.createEntityManager( );
        query= entitymanager.createQuery("Select e From Course e");
        
        @SuppressWarnings("unchecked")
		List <Course> getAllCourses = query.getResultList();
        
        for (Course c: getAllCourses) {
        	c.getcId();
        	c.getcName();
        	c.getcInstructorName();
        	return getAllCourses;
        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		
        return null;
        
	}
	
}
