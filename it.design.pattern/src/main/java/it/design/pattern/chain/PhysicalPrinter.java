package it.design.pattern.chain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.design.pattern.chain.rule.RulePattern;
import it.design.pattern.chain.rule.RulePhysical;
import it.design.pattern.chain.rule.model.Customer;

public class PhysicalPrinter implements Printer {

	@Autowired
	private PrinterService chainOfResponsibilityService;

	@Autowired
	private List<RulePhysical> rulePhysicalList;

	@Override
	public void print(Customer customer) {
		List<RulePattern> ruleList = new ArrayList<RulePattern>();
		for (RulePhysical rulePhysical : rulePhysicalList) {
			ruleList.add(rulePhysical);
		}
		chainOfResponsibilityService.printInfo(ruleList, customer);
	}
}
