package com.creative.model;

public class Pricing {
	private int pricingId;
	private int interestId;
	private String payType;
	private int amount;

	public int getPricingId() {
		return pricingId;
	}

	public void setPricingId(int pricingId) {
		this.pricingId = pricingId;
	}

	public int getInterestId() {
		return interestId;
	}

	public void setInterestId(int interestId) {
		this.interestId = interestId;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}