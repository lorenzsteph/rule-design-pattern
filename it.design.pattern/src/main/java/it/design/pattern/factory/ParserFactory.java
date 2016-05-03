package it.design.pattern.factory;

public interface ParserFactory {
	public Parser getParser(ParserType parserType);
}
