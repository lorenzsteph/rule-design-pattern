package it.design.pattern.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParserService {

	private static final Logger log = LoggerFactory.getLogger(ParserService.class);

	@Autowired
	private ParserFactory parserFactory;

	public void doParse(String parseString, ParserType parseType) {
		Parser parser = parserFactory.getParser(parseType);
		log.debug("ParserService.doParse.." + parser);
		parser.parse(parseString);
	}
}
