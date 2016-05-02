package it.design.pattern.rule.juridical;

import org.springframework.stereotype.Service;

import it.design.pattern.rule.RuleJuridical;

@Service
public class RuleVatNumber implements RuleJuridical {

	public boolean executeRule() {
		return false;
		
	}

}
