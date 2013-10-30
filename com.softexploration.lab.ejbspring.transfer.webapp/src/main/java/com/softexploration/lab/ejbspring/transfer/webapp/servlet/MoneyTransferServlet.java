package com.softexploration.lab.ejbspring.transfer.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softexploration.lab.ejbspring.transfer.facade.MoneyTransferFacade;
import com.softexploration.lab.ejbspring.transfer.service.cmn.MoneyTransferResponse;
import com.softexploration.lab.ejbspring.transfer.service.cmn.impl.MoneyTransferRequestImpl;
import com.softexploration.lab.ejbspring.transfer.webapp.locator.MoneyTransferFacadeLocator;
import com.softexploration.lab.ejbspring.transfer.webapp.locator.impl.DefaultMoneyTransferFacadeLocator;

import org.springframework.util.StringUtils;

/**
 * Servlet which executes money transfer for given <code>facade</code> and
 * <code>amount</code>.<br/>
 * Following parameters must be set in GET request to perform a transfer:
 * <ul>
 * <li>facade - facade name to use</li>
 * <li>amount - amount to transfer</li>
 * </ul>
 */
public class MoneyTransferServlet extends HttpServlet {

	private static final long serialVersionUID = 8516718404268772237L;

	private MoneyTransferFacadeLocator moneyTransferFacadeLocator;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		moneyTransferFacadeLocator = new DefaultMoneyTransferFacadeLocator(getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (StringUtils.isEmpty(request.getParameter("facade"))
				|| StringUtils.isEmpty(request.getParameter("amount"))) {
			response.getWriter().println("facade and amount are required");
			return;
		}

		MoneyTransferFacade moneyTransferFacade = moneyTransferFacadeLocator.locate(request
				.getParameter("facade"));
		if (moneyTransferFacade == null) {
			response.getWriter().println(
					"Facade: " + moneyTransferFacadeLocator.getFacadesNames() + "?");
			return;
		}

		Double amount = Double.parseDouble(request.getParameter("amount"));
		response.getWriter().println("current balance: " + moneyTransferFacade.getBalance());
		response.getWriter().println("amount to transfer: " + amount);
		response.getWriter().println("transferring...");
		MoneyTransferResponse transferResponse = moneyTransferFacade
				.transfer(new MoneyTransferRequestImpl(amount));
		response.getWriter().println("transfer finished");
		response.getWriter().println("current balance: " + transferResponse.getBalance());
	}
}
