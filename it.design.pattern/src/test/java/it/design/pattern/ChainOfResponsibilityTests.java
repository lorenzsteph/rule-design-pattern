package it.design.pattern;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import it.design.pattern.rule.RuleJuridical;
import it.design.pattern.rule.RulePattern;
import it.design.pattern.rule.RulePhysical;
import it.design.pattern.rule.model.Customer;
import it.design.pattern.rule.model.TypeCustomer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class ChainOfResponsibilityTests {

	private static final Logger log = LoggerFactory.getLogger(ChainOfResponsibilityTests.class);

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Autowired
	private List<RuleJuridical> ruleJuridical;

	@Autowired
	private List<RulePhysical> rulePhysical;

	@Autowired
	private List<RulePattern> ruleList;

	@Autowired
	private ChainOfResponsibilityService chainOfResponsibilityService;

	@Test
	public void testRulePhysicalContext() {
		log.debug("start Rule Physical Context");
		Assert.assertEquals(3, rulePhysical.size());
	}

	@Test
	public void testRuleJuridicalContext() {
		log.debug("start Rule Juridical Context");
		Assert.assertEquals(2, ruleJuridical.size());
	}

	@Test
	public void testRuleContext() {
		log.debug("start Rule Context");
		Assert.assertEquals(5, ruleList.size());
	}

	@Test
	public void testRuleOrder() {
		log.debug("start Rule Order");
		Assert.assertEquals("RuleName", rulePhysical.get(0).getClass().getSimpleName());
		Assert.assertEquals("RuleSurname", rulePhysical.get(1).getClass().getSimpleName());
		Assert.assertEquals("RuleFiscalCode", rulePhysical.get(2).getClass().getSimpleName());

		Assert.assertEquals("RuleBusinessName", ruleJuridical.get(0).getClass().getSimpleName());
		Assert.assertEquals("RuleVatNumber", ruleJuridical.get(1).getClass().getSimpleName());
	}

	@Test
	public void testPrintInfoJuridical() {
		Customer customer = initCustomer(TypeCustomer.JURIDICAL);

		chainOfResponsibilityService.printJuridicalInfo(customer);
		Assert.assertTrue(
				systemOutRule.getLog().contains("JuridicalInfo : ---> Business Name Value---> Vat Number Value"));
	}

	@Test
	public void testPrintInfoPhysical() {
		Customer customer = initCustomer(TypeCustomer.PHYSICAL);

		chainOfResponsibilityService.printPhysicalInfo(customer);
		Assert.assertTrue(systemOutRule.getLog()
				.contains("PhysicalInfo : ---> Name Value---> Surname Value---> FiscalCode Value"));
	}

	private Customer initCustomer(TypeCustomer typeCustomer) {
		Customer customer = new Customer();
		customer.setBusinessName("Business Name Value");
		customer.setVatNumber("Vat Number Value");

		customer.setName("Name Value");
		customer.setSurname("Surname Value");
		customer.setFiscalCode("FiscalCode Value");

		customer.setTypeCustomer(typeCustomer);
		return customer;
	}
	
}
