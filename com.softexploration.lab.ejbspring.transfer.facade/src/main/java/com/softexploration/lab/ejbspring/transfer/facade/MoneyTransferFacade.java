package com.softexploration.lab.ejbspring.transfer.facade;

import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferRequest;
import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferResponse;

/**
 * Money Transfer Facade.
 */
public interface MoneyTransferFacade {

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
