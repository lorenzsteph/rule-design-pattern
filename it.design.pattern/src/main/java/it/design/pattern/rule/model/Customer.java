package it.design.pattern.rule.model;

public class Customer {

	private String name;
	private String surname;
	private String fiscalCode;
	private String businessName;
	private String vatNumber;

	private TypeCustomer typeCustomer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public TypeCustomer getTypeCustomer() {
		return typeCustomer;
	}

	public void setTypeCustomer(TypeCustomer typeCustomer) {
		this.typeCustomer = typeCustomer;
	}

}
