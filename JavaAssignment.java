import java.util.ArrayList;
import java.util.Collection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
         EmployeeDetails employee1 = new EmployeeDetails("vikas",50000,"Hdfc",true,false);
         EmployeeDetails employee2 = new EmployeeDetails("vishal",50000,"Hdfc",true,true);
         employee1.start();
         employee2.start();
	}

}
interface DassaultSystemes {
	Salary work(EmployeeDetails x,Tax y);
}

class EmployeeDetails extends Thread implements DassaultSystemes{
	
	private String employeeName;
	private int employeeSalary;
	private String bankName;
	private Boolean houseLoan;
	private Boolean mutualFundInvestment;
	private ArrayList employeeLogList = new ArrayList(); 
	
	
	public EmployeeDetails(String employeeName, int employeeSalary, String bankName,Boolean houseLoan,Boolean mutualFundInvestment) {
		super();
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.bankName = bankName;
		this.houseLoan = houseLoan;
		this.mutualFundInvestment = mutualFundInvestment;
	}


	public Salary work(EmployeeDetails details,Tax tax){
		
		Salary salary = new Salary(details.employeeSalary,details.employeeSalary);
		int totalSalaryAfterTax = salary.getSalaryAfterTax();
		if(!details.houseLoan) {
			totalSalaryAfterTax -= tax.HouseLoanTax;
		}
		if(!details.mutualFundInvestment) {
			totalSalaryAfterTax -= tax.MutualFundsTax;
		}
		salary.setSalaryAfterTax(totalSalaryAfterTax);
		
		return salary;
	}
	
	public void run() {
		
		Tax tax = new Tax();
		for(int i=1;i<=21;i++) {
			System.out.println(this.employeeName+" is Working on "+i+" working day");
			String str  =i + " day log";
			employeeLogList.add(str);
			try {
				Thread.sleep(500); 
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		Salary s=work(this,tax);
		try {
		String str1 = this.employeeName+".txt";
		FileOutputStream fileOutputStream = new FileOutputStream(str1, true);
		String str = "salary credited ="+s.getSalaryAfterTax();
		byte array[] = str.getBytes(); //converts the string into a byte array
		fileOutputStream.write(array);
		fileOutputStream.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println(s.getSalaryAfterTax()+"is Credited");
		
		
	}
}
class Tax{
	public final int HouseLoanTax = 2000;
	public final int MutualFundsTax = 1500;
}
class Salary{
	private int totalSalary;
	private int salaryAfterTax;
	Salary(){
		
	}
	Salary(int totalSalary,int salaryAfterTax){
		this.totalSalary = totalSalary;
		this.salaryAfterTax = salaryAfterTax;
	}
	public int getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}
	public int getSalaryAfterTax() {
		return salaryAfterTax;
	}
	public void setSalaryAfterTax(int salaryAfterTax) {
		this.salaryAfterTax = salaryAfterTax;
	}
	
}