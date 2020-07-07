package entities;

public class OutsoucerdEmployee extends Employee{
	
	private Double additionalCharge;
	
	public OutsoucerdEmployee() {
	}

	public OutsoucerdEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}

	public Double getAdditionalCharge() {
		return additionalCharge;
	}

	public void setAdditionalCharge(Double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}
	

	@Override
	public String toString() {
		return super.toString() + "OutsoucerdEmployee [additionalCharge=" + additionalCharge + "]";
	}

	@Override
	public Double payment() {
		return 	super.payment() + this.additionalCharge * 1.1;
	}
	
	

}
