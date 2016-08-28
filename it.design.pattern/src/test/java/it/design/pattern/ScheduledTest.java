package it.design.pattern;

import org.apache.commons.lang3.StringUtils;
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

import it.design.pattern.scheduler.AsyncTaskExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigScheduled.class, loader = AnnotationConfigContextLoader.class)
public class ScheduledTest {

	private static final long RUN_TASK_EVERY_25_SEC = 25500l;

	private static final Logger log = LoggerFactory.getLogger(ScheduledTest.class);

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Autowired
	private AsyncTaskExecutor asyncTaskExecutor;

	@Test
	public void scheduledTest() throws Exception {
		log.debug("start test scheduledTest");
		Thread.sleep(RUN_TASK_EVERY_25_SEC);
		Assert.assertEquals(6, StringUtils.countMatches(systemOutRule.getLog(), "----------->>> ScheduledTask"));
		log.debug("end test scheduledTest");
	}

	@Test
	public void asyncTaskExecutorTest() throws Exception {
		log.debug("start test scheduledTest");
		int i = 1;
		while (i < 100) {
			asyncTaskExecutor.runTaskAsync(i);
			i++;
		}

		Assert.assertEquals(4, StringUtils.countMatches(systemOutRule.getLog(), ">>>>> runTaskAsync"));
	}

	@Test
	public void asyncTaskExecutorAllTest() throws Exception {
		log.debug("start test scheduledTest");
		int i = 1;
		while (i <= 100) {
			asyncTaskExecutor.runTaskAsync(i);
			i++;
		}
		Thread.sleep(RUN_TASK_EVERY_25_SEC);

		Assert.assertEquals(100, StringUtils.countMatches(systemOutRule.getLog().replace(">>>>> runTaskAsync: 0", ""), ">>>>> runTaskAsync"));
	}

}
