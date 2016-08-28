package it.design.pattern;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigScheduled.class, loader = AnnotationConfigContextLoader.class)
public class ScheduledTest {

	private static final long RUN_TASK_EVERY_25_SEC = 25500l;

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Test
	public void scheduledTest() throws Exception {
		Thread.sleep(RUN_TASK_EVERY_25_SEC);
		Assert.assertEquals(5, StringUtils.countMatches(systemOutRule.getLog(), "----------->>> ScheduledTask"));
	}

}
