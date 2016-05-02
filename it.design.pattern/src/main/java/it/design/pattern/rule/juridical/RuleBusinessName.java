package it.design.pattern.rule.juridical;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import it.design.pattern.rule.RulePattern;
import it.design.pattern.rule.RuleJuridical;
import it.design.pattern.rule.model.Customer;

@Service
@Order(1)
public class RuleBusinessName implements RuleJuridical,RulePattern {

	private static final Logger log = LoggerFactory.getLogger(RuleBusinessName.class);

	public String executeRule(Customer customer) {
		log.debug("---> RuleBusinessName");
		return "---> " + customer.getBusinessName();

	}

}
