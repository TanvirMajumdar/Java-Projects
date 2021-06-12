package payrollCalculation;

public class HourlyEmployee extends Employee{
	
	private double hours;
	private double wage;
	
	
	public HourlyEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public HourlyEmployee(String firstName, String lastName, String ssn, double hours, double wage) {
		super(firstName, lastName, ssn);
		setHours(hours);
		setWage(wage);
		// TODO Auto-generated constructor stub
	}



	public double getHours() {
		return hours;
	}



	public void setHours(double hours) {
		
		if(hours<0.0 && hours>168)
		{
			throw new IllegalArgumentException("Hour must be less than 168 hours and greater than 0!");
		}
		else 
		{
			this.hours = hours;
		}
	}



	public double getWage() {
		return wage;
	}



	public void setWage(double wage) {
		
		if (wage<0.0)
		{
			throw new IllegalArgumentException("Wage must not be negative");
		}
		else 
		{
			this.wage = wage;
		}
	}



	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		if (getHours()<40.0)
		{
			return getHours()*getWage();
		}
		else
		{
			return getWage()*40+(getHours()-40)*getWage()*1.5;
		}
	}
	
	public String toString()                                              
	{                                                                     
		return String.format( "hourly employee: %s\n%s: $%,.2f; %s: %,.2f",
				super.toString(), "hourly wage" , getWage(),
		"hours worked", getHours() );
	}

}
