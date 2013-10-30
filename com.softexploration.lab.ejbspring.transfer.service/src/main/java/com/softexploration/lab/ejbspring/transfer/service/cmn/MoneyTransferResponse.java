package com.softexploration.lab.ejbspring.transfer.service.cmn;

import java.io.Serializable;

/**
 * Money transfer response
 */
public interface MoneyTransferResponse extends Serializable {

	/**
	 * Get available balance after operation
	 * 
	 * @return balance after operation
	 */
	Double getBalance();
}
