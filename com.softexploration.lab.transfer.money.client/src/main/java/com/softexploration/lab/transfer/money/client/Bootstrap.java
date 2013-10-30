package com.softexploration.lab.transfer.money.client;

public class Bootstrap {

	public static void main(String[] args) {

		new Thread(new MoneyTransferRequest(100.56)).start();
		new Thread(new MoneyTransferResponse()).start();

		new Thread(new MoneyTransferRequest(null)).start();
		new Thread(new MoneyTransferResponse()).start();
	}

}
