package payrollCalculation;

public class BasePlusCommissionEmployee extends CommissionEmployee{
	
	private double baseSalary;

	public BasePlusCommissionEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BasePlusCommissionEmployee(String firstName, String lastName, String ssn, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, ssn, grossSales, commissionRate);
		// TODO Auto-generated constructor stub
		setBaseSalary(baseSalary);
	}


	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		
		if (baseSalary>=0.0)
		{
			this.baseSalary = baseSalary;
		}
		else
		{
			throw new IllegalArgumentException("Base Salary must not be negative");
		}
			
	}

	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return super.earnings()+baseSalary;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s %s %s: $%.2f","base-salaried", super.toString(), "base salary", getBaseSalary());
	}
		
}
