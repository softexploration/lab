package com.softexploration.lab.ejbspring.transfer.service;

import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferRequest;
import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferResponse;

/**
 * Business service to operate on money.
 */
public interface MoneyTransferService {

	/**
	 * Transfer money based on <code>request</code> data.
	 * 
	 * @param request
	 * @return operation response
	 */
	MoneyTransferResponse transfer(MoneyTransferRequest request);

	/**
	 * Get current available balance.
	 */
	Double getBalance();
}
