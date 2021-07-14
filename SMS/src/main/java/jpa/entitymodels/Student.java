package jpa.entitymodels;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@Column(name="email", nullable=false, length=50)
	private String sEmail;
	@Column(name="studentname", nullable=false, length=50)
	private String sName;
	@Column(name="password", nullable=false, length=50)
	private String sPassword;
	
	
	@OneToMany(targetEntity= Course.class)
	@JoinTable(name = "Student_Course")
	private List<Course> sCourses;
	
	public Student(String sEmail, String sName, String sPassword, List<Course> sCourses) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPassword = sPassword;
		this.sCourses=sCourses;
	}

	public Student() {
		super();
		sEmail = "null@gmail.com";
		sName = "Student Name";
		sPassword = "Password";
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}
}
