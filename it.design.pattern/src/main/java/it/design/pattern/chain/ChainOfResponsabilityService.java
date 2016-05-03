package it.design.pattern.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.design.pattern.chain.rule.model.Customer;

@Service
public class ChainOfResponsabilityService {

	private static final Logger log = LoggerFactory.getLogger(ChainOfResponsabilityService.class);

	@Autowired
	private ChainOfResponsabilityFactory factory;

	public void printInfo(Customer customer) {
		Printer printer = factory.getRuleType(customer.getTypeCustomer());
		log.debug("ChainOfResponsabilityService.printInfo.." + printer);

		printer.print(customer);
	}
}
