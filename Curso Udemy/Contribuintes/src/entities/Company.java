package entities;

public class Company extends TaxPayer{

	private int numberOfEmployees;
	
	public Company() {
	
	}

	public Company(String name, Double anualIncome, int numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public int getNumberOfEmpoyees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmpoyees(int numberOfEmpoyees) {
		this.numberOfEmployees = numberOfEmpoyees;
	}
	
	@Override
	public double tax() {
		double temp = 0.0;
		if(numberOfEmployees <= 10) {
			temp += anualIncome * 0.16;
		}else {
			temp += anualIncome * 0.14;
		}
		return temp;
	}
	
	
}
