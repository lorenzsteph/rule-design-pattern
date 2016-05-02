package it.design.pattern;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import it.design.pattern.rule.RuleJuridical;
import it.design.pattern.rule.RulePhysical;

@Service
@Scope("prototype")
public class ChainOfResponsibilityService {

	private static final Logger log = LoggerFactory.getLogger(ChainOfResponsibilityService.class);

	@Autowired
	private List<RuleJuridical> ruleJuridical;
	
	@Autowired
	private List<RulePhysical> rulePhysical;
	
	
	
}