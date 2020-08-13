package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		double baseAmount = contract.getTotalValue() / months;
		for (int i = 1; i <= months; i++) {
			double simpleInterest = baseAmount + onlinePaymentService.interest(baseAmount, i);
			double paymentAmount = simpleInterest + onlinePaymentService.paymentFee(simpleInterest);
			Date payday = payday(contract.getDate(), i);
			contract.getInstallments().add(new Installment(payday, paymentAmount));
			
		}
	}
	private Date payday(Date date, int numberOfMonths) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, numberOfMonths);
		return cal.getTime();
	}
}
