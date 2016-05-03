package it.design.pattern.chain;

import org.springframework.beans.factory.annotation.Autowired;

import it.design.pattern.chain.rule.model.Customer;

public class JuridicalPrinter implements Printer {

	@Autowired
	private PrinterService chainOfResponsibilityService;

	@Override
	public void print(Customer customer) {
		chainOfResponsibilityService.printJuridicalInfo(customer);

	}

}
