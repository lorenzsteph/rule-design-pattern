package it.design.pattern.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskExecutorBean implements AsyncTaskExecutor {

	private static final Logger log = LoggerFactory.getLogger(AsyncTaskExecutorBean.class);

	private static final long RUN_TASK_EVERY_0_5_SEC = 500l;
	
	@Async
	@Override
	public void runTaskAsync(int i) {
		log.info(">>>>> runTaskAsync: " + i);
		try {
			Thread.sleep(RUN_TASK_EVERY_0_5_SEC);
		} catch (InterruptedException e) {
			log.error("generic error!",e);
		}
	}
}
