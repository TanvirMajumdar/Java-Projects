package payrollCalculation;

public class PayrollSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SalariedEmployee salariedEmployee= new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee= new HourlyEmployee("Earl", "Kambech", "222-222-2222", 16.75, 40);
		
		System.out.printf( "%s\n%s: $%,.2f\n\n",
				salariedEmployee, "earned", salariedEmployee.earnings() );
		
		System.out.printf( "%s\n%s: $%,.2f\n\n",
				hourlyEmployee, "earned", hourlyEmployee.earnings() );

	}

}
