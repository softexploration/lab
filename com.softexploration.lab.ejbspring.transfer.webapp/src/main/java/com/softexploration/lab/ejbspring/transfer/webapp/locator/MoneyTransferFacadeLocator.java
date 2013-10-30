package com.softexploration.lab.ejbspring.transfer.webapp.locator;

import java.util.List;

import com.softexploration.lab.ejbspring.transfer.facade.MoneyTransferFacade;

/**
 * Locator for <code>MoneyTransferFacade<code> implementations.
 */
public interface MoneyTransferFacadeLocator {

	/**
	 * Get all available facades names.
	 * 
	 * @return
	 */
	List<String> getFacadesNames();

	/**
	 * Locate facade implementation for <code>facadeName</code>.
	 * 
	 * @return facade implementation for <code>facadeName</code>
	 */
	MoneyTransferFacade locate(String facadeName);
}
