package it.design.pattern.chain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import it.design.pattern.chain.rule.RuleJuridical;
import it.design.pattern.chain.rule.RulePattern;
import it.design.pattern.chain.rule.model.Customer;

public class JuridicalPrinter implements Printer {

	private static final Logger log = LoggerFactory.getLogger(JuridicalPrinter.class);

	@PostConstruct
	public void init() {
		log.info("order list rule");
		Collections.sort(ruleJuridicalList, AnnotationAwareOrderComparator.INSTANCE);
	}

	@Autowired
	private PrinterService chainOfResponsibilityService;

	@Autowired
	private List<RuleJuridical> ruleJuridicalList;

	@Override
	public void print(Customer customer) {
		List<RulePattern> ruleList = new ArrayList<RulePattern>();
		for (RuleJuridical ruleJuridical : ruleJuridicalList) {
			ruleList.add(ruleJuridical);
		}
		chainOfResponsibilityService.printInfo(ruleList, customer);
	}

}
