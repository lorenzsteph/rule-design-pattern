package it.design.pattern.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlParser implements Parser {

	private static final Logger log = LoggerFactory.getLogger(XmlParser.class);

	@Override
	public void parse(String str) {
		log.debug("XmlParser.parse::" + str);
	}
}
