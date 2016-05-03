package it.design.pattern;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Service;

import it.design.pattern.rule.RuleJuridical;
import it.design.pattern.rule.RulePhysical;
import it.design.pattern.rule.model.Customer;

@Service
@Scope("prototype")
public class ChainOfResponsibilityService {

	private static final Logger log = LoggerFactory.getLogger(ChainOfResponsibilityService.class);

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

	public void printInfo(Customer customer) {
		String customerInfo = "CustomerInfo : ";

		log.info(customerInfo);
	}

}