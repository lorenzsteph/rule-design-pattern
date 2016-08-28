package it.design.pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("it.design.pattern.scheduler")
@EnableScheduling
public class AppConfigScheduled {

}
