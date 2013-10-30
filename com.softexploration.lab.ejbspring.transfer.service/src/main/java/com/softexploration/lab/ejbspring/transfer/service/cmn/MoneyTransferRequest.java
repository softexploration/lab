package com.softexploration.lab.ejbspring.transfer.service.cmn;

import java.io.Serializable;

/**
 * Request to money transfer
 */
public interface MoneyTransferRequest extends Serializable {

	/**
	 * Get an amount to transfer
	 * 
	 * @return amount
	 */
	Double getAmount();
}
