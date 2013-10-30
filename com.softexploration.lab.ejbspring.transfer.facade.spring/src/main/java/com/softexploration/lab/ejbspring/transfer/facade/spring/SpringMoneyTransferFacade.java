package com.softexploration.lab.ejbspring.transfer.facade.spring;

import org.springframework.stereotype.Component;

import com.softexploration.lab.ejbspring.transfer.facade.MoneyTransferFacade;
import com.softexploration.lab.ejbspring.transfer.service.MoneyTransferService;
import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferRequest;
import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferResponse;

/**
 * Spring implementation of <code>MoneyTransferFacade</code> which uses
 * internally EJB service.
 */
@Component
public class SpringMoneyTransferFacade implements MoneyTransferFacade {

	private MoneyTransferService moneyTransferService;

	public void setMoneyTransferService(MoneyTransferService moneyTransferService) {
		this.moneyTransferService = moneyTransferService;
	}

	public MoneyTransferResponse transfer(MoneyTransferRequest request) {
		return moneyTransferService.transfer(request);
	}

	public Double getBalance() {
		return moneyTransferService.getBalance();
	}

}
