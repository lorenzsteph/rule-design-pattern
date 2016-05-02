package it.design.pattern.rule.physical;

import org.springframework.stereotype.Service;

import it.design.pattern.rule.RulePhysical;

@Service
public class RuleName implements RulePhysical {

	public boolean executeRule() {
		return false;
		
	}

}
