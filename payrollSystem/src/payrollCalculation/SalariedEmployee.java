package payrollCalculation;

public class SalariedEmployee extends Employee{
	
	private double weeklySalary;
	
	
	public SalariedEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SalariedEmployee(String firstName, String lastName, String ssn, double weeklySalary) {
		super(firstName, lastName, ssn);
		setWeeklySalary(weeklySalary);
		// TODO Auto-generated constructor stub
	}


	public double getWeeklySalary() {
		return weeklySalary;
	}


	public void setWeeklySalary(double weeklySalary) {
		
		if (weeklySalary>=0.0)
			{
				this.weeklySalary = weeklySalary;
			}
		else 
			{
				throw new IllegalArgumentException
				("Weekly Salary Must Not be Negative");
			}
	}


	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return getWeeklySalary();
	}
	
	public String toString() {
		return String.format("Saleried employee %s\n%s: $%.2f", super.toString(),"weekly salary", getWeeklySalary() );
	}

}
