package jpa.test;

import org.junit.Assert;
import jpa.dao.StudentDAO;
import jpa.service.StudentService;

class TestGetStudentByEmail {
	
	private static StudentDAO service = null;
	
	
	@org.junit.jupiter.api.Test
    void  getStudentByEmail(){
        service = new StudentService();
        Assert.assertFalse(service.validateStudent("aiannitti7@is.gd"," "));
        Assert.assertTrue(service.validateStudent("aiannitti7@is.gd","TWP4hf5j"));
   
        
    }

}
