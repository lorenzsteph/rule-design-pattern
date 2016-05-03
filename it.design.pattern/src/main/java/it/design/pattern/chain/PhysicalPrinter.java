package it.design.pattern.chain;

import org.springframework.beans.factory.annotation.Autowired;

import it.design.pattern.chain.rule.model.Customer;

public class PhysicalPrinter implements Printer {

	@Autowired
	private PrinterService chainOfResponsibilityService;

	@Override
	public void print(Customer customer) {
		chainOfResponsibilityService.printPhysicalInfo(customer);

	}
}
