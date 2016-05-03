package it.design.pattern;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.design.pattern.chain.ChainOfResponsabilityFactory;
import it.design.pattern.chain.JuridicalPrinter;
import it.design.pattern.chain.PhysicalPrinter;

@Configuration
@ComponentScan("it.design.pattern.chain")
public class AppConfigFactoryChain {
	@Bean
	public FactoryBean<?> serviceLocatorFactoryBean() {
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		factoryBean.setServiceLocatorInterface(ChainOfResponsabilityFactory.class);
		return factoryBean;
	}

	@Bean(name = "physicalPrinter")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PhysicalPrinter physicalPrinter() {
		return new PhysicalPrinter();
	}

	@Bean(name = "juridicalPrinter")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public JuridicalPrinter juridicalPrinter() {
		return new JuridicalPrinter();
	}

}
