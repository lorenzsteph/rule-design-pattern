package it.design.pattern.chain.rule.model;

public enum TypeCustomer {
	PHYSICAL("physicalPrinter"), JURIDICAL("juridicalPrinter");

	private final String value;

	TypeCustomer(String input) {
		this.value = input;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}