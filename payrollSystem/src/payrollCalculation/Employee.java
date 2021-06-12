package payrollCalculation;

public abstract class Employee{
	
	private String firstName;
	private String lastName;
	private String ssn;
	
	public Employee(String firstName, String lastName, String ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}
	
	public Employee() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String toString() {
		return String.format("%s %s \nSocial Security Number: %s", getFirstName(), getLastName(), getSsn());
		
	}
	
	public abstract double earnings();
	
}
