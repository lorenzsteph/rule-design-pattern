package it.design.pattern.chain.rule.juridical;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import it.design.pattern.chain.rule.RuleJuridical;
import it.design.pattern.chain.rule.model.Customer;

@Service
@Order(2)
public class RuleVatNumber implements RuleJuridical {

	private static final Logger log = LoggerFactory.getLogger(RuleVatNumber.class);

	public String executeRule(Customer customer) {
		log.debug("---> RuleVatNumber");
		return "---> " + customer.getVatNumber();

	}

}
