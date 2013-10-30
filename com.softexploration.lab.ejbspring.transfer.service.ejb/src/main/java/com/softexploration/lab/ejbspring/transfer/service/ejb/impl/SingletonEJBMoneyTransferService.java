package com.softexploration.lab.ejbspring.transfer.service.ejb.impl;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Singleton;

import com.softexploration.lab.ejbspring.transfer.service.MoneyTransferService;
import com.softexploration.lab.ejbspring.transfer.service.impl.BaseMoneyTransferService;

/**
 * Singleton EJB implementation of <code>MoneyTransferService</code>.
 */
@Local(MoneyTransferService.class)
@Singleton(name = "SingletonEJBMoneyTransferService", mappedName = "ejb/SingletonEJBMoneyTransferService")
public class SingletonEJBMoneyTransferService extends BaseMoneyTransferService {

	@Override
	@Resource(name = "initialBalance")
	public void setBalance(Double balance) {
		super.setBalance(balance);
	}
}
