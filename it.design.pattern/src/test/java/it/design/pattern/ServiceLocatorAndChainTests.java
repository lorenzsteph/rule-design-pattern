package it.design.pattern;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import it.design.pattern.chain.ChainOfResponsabilityService;
import it.design.pattern.chain.rule.model.Customer;
import it.design.pattern.chain.rule.model.TypeCustomer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigFactoryChain.class, loader = AnnotationConfigContextLoader.class)
public class ServiceLocatorAndChainTests {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Autowired
	private ChainOfResponsabilityService chainOfResponsabilityService;

	@Test
	public void testPrintInfoJuridical() {
		Customer customer = initCustomer(TypeCustomer.JURIDICAL);

		chainOfResponsabilityService.printInfo(customer);
		Assert.assertTrue(systemOutRule.getLog().contains("CustomerInfo : ---> Business Name Value---> Vat Number Value"));
	}

	@Test
	public void testPrintInfoPhysical() {
		Customer customer = initCustomer(TypeCustomer.PHYSICAL);

		chainOfResponsabilityService.printInfo(customer);
		Assert.assertTrue(systemOutRule.getLog().contains("CustomerInfo : ---> Name Value---> Surname Value---> FiscalCode Value"));
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
