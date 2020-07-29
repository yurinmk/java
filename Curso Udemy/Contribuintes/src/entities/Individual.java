package entities;

public class Individual extends TaxPayer{
	
	private Double healthExpenditures;
	
	public Individual() {
	
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	@Override
	public double tax() {
		double temp = 0.0;
		if(anualIncome < 20000.00){
			temp += anualIncome * 0.15;
		}else {
			temp += anualIncome * 0.25;
		}
		if(healthExpenditures != 0) {
			temp -= healthExpenditures * 0.50;
		}
		return temp;
	}

}
