package com.softexploration.lab.ejbspring.transfer.service.cmn.impl;

import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferResponse;

public class MoneyTransferResponseImpl implements MoneyTransferResponse {

	private static final long serialVersionUID = -2949403098563155201L;

	private Double balance;

	public MoneyTransferResponseImpl(Double balance) {
		this.balance = balance;
	}

	public Double getBalance() {
		return balance;
	}

}
