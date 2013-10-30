package com.softexploration.lab.ejbspring.transfer.service.cmn.impl;

import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferRequest;

public class MoneyTransferRequestImpl implements MoneyTransferRequest {

	private static final long serialVersionUID = 1374492424533152653L;

	private Double amount;

	public MoneyTransferRequestImpl(Double amount) {
		this.amount = amount;
	}

	public Double getAmount() {
		return amount;
	}

}
