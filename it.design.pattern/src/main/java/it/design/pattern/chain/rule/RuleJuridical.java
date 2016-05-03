package it.design.pattern.chain.rule;

import it.design.pattern.chain.rule.model.Customer;

public interface RuleJuridical {
	
	public String executeRule(Customer customer);
	
}
