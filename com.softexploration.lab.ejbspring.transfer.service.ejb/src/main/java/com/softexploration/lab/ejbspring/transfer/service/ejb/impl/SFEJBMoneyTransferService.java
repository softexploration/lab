package com.softexploration.lab.ejbspring.transfer.service.ejb.impl;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateful;

import com.softexploration.lab.ejbspring.transfer.service.MoneyTransferService;
import com.softexploration.lab.ejbspring.transfer.service.impl.BaseMoneyTransferService;

/**
 * Stateful EJB implementation of <code>MoneyTransferService</code>.
 */
@Local(MoneyTransferService.class)
@Stateful(name = "SFEJBMoneyTransferService", mappedName = "ejb/SFEJBMoneyTransferService")
public class SFEJBMoneyTransferService extends BaseMoneyTransferService {

	@Override
	@Resource(name = "initialBalance")
	public void setBalance(Double balance) {
		super.setBalance(balance);
	}
}
