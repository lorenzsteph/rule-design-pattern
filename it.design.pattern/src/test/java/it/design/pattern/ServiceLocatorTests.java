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

import it.design.pattern.factory.ParserService;
import it.design.pattern.factory.ParserType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigFactory.class, loader = AnnotationConfigContextLoader.class)
public class ServiceLocatorTests {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Autowired
	private ParserService parserService;

	@Test
	public void testParserFactory() {
		parserService.doParse("Srilekha", ParserType.JSON);
		Assert.assertTrue(systemOutRule.getLog().contains("JsonParser.parse::Srilekha"));
		parserService.doParse("Srilekha", ParserType.XML);
		Assert.assertTrue(systemOutRule.getLog().contains("XmlParser.parse::Srilekha"));
	}

}
