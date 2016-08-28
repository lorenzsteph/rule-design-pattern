package it.design.pattern.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
	private static final long RUN_TASK_EVERY_5_SEC = 5000l;
	
	@Scheduled(fixedDelay = RUN_TASK_EVERY_5_SEC)
	public void startScheduledTask() {
		log.info("----------->>> ScheduledTask");

	}
}
