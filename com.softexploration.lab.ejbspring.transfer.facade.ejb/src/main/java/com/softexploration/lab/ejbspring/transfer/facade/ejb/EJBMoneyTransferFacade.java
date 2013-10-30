package com.softexploration.lab.ejbspring.transfer.facade.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import com.softexploration.lab.ejbspring.transfer.facade.MoneyTransferFacade;
import com.softexploration.lab.ejbspring.transfer.service.MoneyTransferService;
import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferRequest;
import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 * EJB implementation of <code>MoneyTransferFacade</code> which uses internally
 * spring service.
 */
@Stateless
@Local(MoneyTransferFacade.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class EJBMoneyTransferFacade implements MoneyTransferFacade {

	@Autowired()
	private MoneyTransferService moneyTransferService;

	public MoneyTransferResponse transfer(MoneyTransferRequest request) {
		return moneyTransferService.transfer(request);
	}

	public Double getBalance() {
		return moneyTransferService.getBalance();
	}

}
