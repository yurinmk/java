package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalServices {
	
	private Double pricePerDay;
	private Double pricePerHour;
	
	private TaxService taxService;

	public RentalServices(Double pricePerDay, Double pricePerHour, TaxService taxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long duration = carRental.getFinish().getTime() - carRental.getStart().getTime();
		double hours = (double) duration / 1000 / 60 / 60;
		double basicPayment;
		if(hours <= 12.0) {
			basicPayment = Math.ceil(hours) * this.pricePerHour;
		}else {
			basicPayment = Math.ceil(hours / 24) * this.pricePerDay;
		}
		double tax = this.taxService.tax(basicPayment);
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
}
