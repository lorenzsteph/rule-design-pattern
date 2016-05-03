package it.design.pattern.chain;

import it.design.pattern.chain.rule.model.TypeCustomer;

public interface ChainOfResponsabilityFactory {
	public Printer getRuleType(TypeCustomer type);

}
