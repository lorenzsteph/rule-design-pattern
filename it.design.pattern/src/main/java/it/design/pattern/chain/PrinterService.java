package it.design.pattern.chain;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Service;

import it.design.pattern.chain.rule.RuleJuridical;
import it.design.pattern.chain.rule.RulePattern;
import it.design.pattern.chain.rule.RulePhysical;
import it.design.pattern.chain.rule.model.Customer;

@Service
@Scope("prototype")
public class PrinterService {

	private static final Logger log = LoggerFactory.getLogger(PrinterService.class);

	@PostConstruct
	public void init() {
		log.info("order list rule");
		Collections.sort(ruleJuridicalList, AnnotationAwareOrderComparator.INSTANCE);
		Collections.sort(rulePhysicalList, AnnotationAwareOrderComparator.INSTANCE);
	}

	@Autowired
	private List<RuleJuridical> ruleJuridicalList;

	@Autowired
	private List<RulePhysical> rulePhysicalList;

	public void printJuridicalInfo(Customer customer) {
		String customerInfo = "JuridicalInfo : ";
		for (RuleJuridical ruleJuridical : ruleJuridicalList) {
			customerInfo += ruleJuridical.executeRule(customer);
		}
		log.info(customerInfo);
	}

	public void printPhysicalInfo(Customer customer) {
		String customerInfo = "PhysicalInfo : ";
		for (RulePhysical rulePhysical : rulePhysicalList) {
			customerInfo += rulePhysical.executeRule(customer);
		}
		log.info(customerInfo);
	}

	public void printInfo(List<RulePattern> rulePatternList, Customer customer) {
		String customerInfo = "CustomerInfo : ";
		for (RulePattern rulePattern : rulePatternList) {
			customerInfo += rulePattern.executeRule(customer);
		}
		log.info(customerInfo);
	}

}