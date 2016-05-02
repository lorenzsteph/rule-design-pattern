package it.design.pattern;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import it.design.pattern.rule.RuleJuridical;
import it.design.pattern.rule.RulePhysical;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class ChainOfResponsibilityTests {

	private static final Logger log = LoggerFactory.getLogger(ChainOfResponsibilityTests.class);

	@Autowired
	private List<RuleJuridical> ruleJuridical;

	@Autowired
	private List<RulePhysical> rulePhysical;

	@Test
	public void testRuleContext() throws Exception {
		log.debug("start test");
		Assert.assertEquals(3, rulePhysical.size());
		Assert.assertEquals(2, ruleJuridical.size());
	}

}
