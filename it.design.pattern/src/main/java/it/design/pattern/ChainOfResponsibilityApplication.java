package it.design.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ChainOfResponsibilityApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ChainOfResponsibilityApplication.class);

	@Override
	public void run(String... args) {
		log.info("********** TODO ");
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ChainOfResponsibilityApplication.class, args);

	}
}
