package it.design.pattern.rule.physical;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import it.design.pattern.rule.RulePattern;
import it.design.pattern.rule.RulePhysical;
import it.design.pattern.rule.model.Customer;

@Service
@Order(1)
public class RuleName implements RulePhysical,RulePattern {

	private static final Logger log = LoggerFactory.getLogger(RuleName.class);

	public String executeRule(Customer customer) {
		log.debug("---> RuleName");
		return "---> " + customer.getName();

	}

}
