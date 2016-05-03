package it.design.pattern.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonParser implements Parser {

	private static final Logger log = LoggerFactory.getLogger(JsonParser.class);

	@Override
	public void parse(String str) {
		log.debug("JsonParser.parse::" + str);
	}
}
