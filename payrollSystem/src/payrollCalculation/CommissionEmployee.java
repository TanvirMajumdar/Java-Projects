package payrollCalculation;

public class CommissionEmployee extends Employee{
	
	private double grossSales;
	private double commissionRate;


	public CommissionEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommissionEmployee(String firstName, String lastName, String ssn, double grossSales, double commissionRate) {
		super(firstName, lastName, ssn);
		setGrossSales(grossSales);
		setCommissionRate(commissionRate);
		// TODO Auto-generated constructor stub
	}
	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		
		if(grossSales>=0.0) {
			this.grossSales = grossSales;
		}
		else {
			throw new IllegalArgumentException("Gross Sales must not be negative");
		}
		
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		
		  if ( commissionRate > 0.0 && commissionRate < 1.0 )
		  {  
			this.commissionRate = commissionRate;
		  }
	       else
	       {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
	       }
	}


	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return grossSales*commissionRate;
	}
	
	public String toString() {
		return String.format("Commission Employee %s %s: $%.2f; %s:$%.2f",super.toString(), "gross sales", getGrossSales(),"commission rate", getCommissionRate() );
	};

}
