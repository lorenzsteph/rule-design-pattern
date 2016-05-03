package it.design.pattern;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.design.pattern.factory.JsonParser;
import it.design.pattern.factory.ParserFactory;
import it.design.pattern.factory.XmlParser;

@Configuration
@ComponentScan
public class AppConfigFactory {
	@Bean
	public FactoryBean<?> serviceLocatorFactoryBean() {
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		factoryBean.setServiceLocatorInterface(ParserFactory.class);
		return factoryBean;
	}

	@Bean(name = "jsonParser")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public JsonParser jsonParser() {
		return new JsonParser();
	}

	@Bean(name = "xmlParser")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public XmlParser xmlParser() {
		return new XmlParser();
	}
}
