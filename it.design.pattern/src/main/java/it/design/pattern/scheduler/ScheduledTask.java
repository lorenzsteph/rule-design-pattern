package it.design.pattern.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

	private static final long RUN_TASK_EVERY_5_SEC = 5000l;
	private static final long DELAY_RUN_TASK_SEC = 450l;

	@Autowired
	private AsyncTaskExecutor asyncTaskExecutor;

	@Scheduled(fixedRate = RUN_TASK_EVERY_5_SEC, initialDelay = DELAY_RUN_TASK_SEC)
	public void startScheduledTask() {
		log.info("----------->>> ScheduledTask");
		asyncTaskExecutor.runTaskAsync(0);
	}

}
