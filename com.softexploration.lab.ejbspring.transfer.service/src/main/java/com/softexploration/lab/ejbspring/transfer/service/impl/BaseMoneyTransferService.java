package com.softexploration.lab.ejbspring.transfer.service.impl;

import com.softexploration.lab.ejbspring.transfer.service.MoneyTransferService;
import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferRequest;
import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferResponse;
import com.softexploration.lab.ejbspring.transfer.service.cmn.impl.MoneyTransferResponseImpl;

/**
 * Base implementation of <code>MoneyTransferService</code>.
 */
public class BaseMoneyTransferService implements MoneyTransferService {

	private Double balance;

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getBalance() {
		return balance;
	}

	public MoneyTransferResponse transfer(MoneyTransferRequest request) {
		balance = balance - request.getAmount();
		return new MoneyTransferResponseImpl(balance);
	}

}
