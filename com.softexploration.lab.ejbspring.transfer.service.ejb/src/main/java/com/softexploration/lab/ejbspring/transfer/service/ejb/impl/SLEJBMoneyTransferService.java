package com.softexploration.lab.ejbspring.transfer.service.ejb.impl;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.softexploration.lab.ejbspring.transfer.service.MoneyTransferService;
import com.softexploration.lab.ejbspring.transfer.service.impl.BaseMoneyTransferService;

/**
 * Stateless EJB implementation of <code>MoneyTransferService</code>.
 */
@Local(MoneyTransferService.class)
@Stateless(name = "SLEJBMoneyTransferService", mappedName = "ejb/SLEJBMoneyTransferService")
public class SLEJBMoneyTransferService extends BaseMoneyTransferService {

	@Override
	@Resource(name = "initialBalance")
	public void setBalance(Double balance) {
		super.setBalance(balance);
	}
}
