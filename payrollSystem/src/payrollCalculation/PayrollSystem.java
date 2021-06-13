package payrollCalculation;

public class PayrollSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SalariedEmployee salariedEmployee= new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee= new HourlyEmployee("Earl", "Kambech", "222-22-2222", 16.75, 40);
		CommissionEmployee commissionEmployee= new CommissionEmployee("Carl", "Benedict", "333-33-3333", 20000, 0.1);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000.00, 0.04, 300.00 );  
		
		System.out.printf( "%s\n%s: $%,.2f\n\n",
				salariedEmployee, "earned", salariedEmployee.earnings() );
		
		System.out.printf( "%s\n%s: $%,.2f\n\n",
				hourlyEmployee, "earned", hourlyEmployee.earnings() );
		
		System.out.printf( "%s\n%s: $%,.2f\n\n",
				commissionEmployee, "earned", commissionEmployee.earnings() );
		
		System.out.printf( "%s\n%s: $%,.2f\n\n",
				basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings() );
		
		
		Employee[] employees= new Employee[4];
		         employees[ 0 ] = salariedEmployee;          
		         employees[ 1 ] = hourlyEmployee;            
		         employees[ 2 ] = commissionEmployee;        
		         employees[ 3 ] = basePlusCommissionEmployee;
		         
		         for (Employee currentEmployee: employees)
		         {
		        	 System.out.println(currentEmployee);
		         
		         
		         // determine whether element is a BasePlusCommissionEmployee
		         if ( currentEmployee instanceof BasePlusCommissionEmployee )
		         {

		        	 BasePlusCommissionEmployee employee =( BasePlusCommissionEmployee) currentEmployee;
     		         employee.setBaseSalary( 1.10 * employee.getBaseSalary() );
     		         System.out.printf("new base salary with 10%% increase is: $%,.2f\n",
     		         employee.getBaseSalary() );
		         } 
		         System.out.printf("earned $%,.2f\n\n", currentEmployee.earnings() );
        		} 

	}

}
