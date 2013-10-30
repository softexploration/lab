package com.softexploration.lab.ejbspring.transfer.webapp.locator.impl;

import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

import com.softexploration.lab.ejbspring.transfer.facade.MoneyTransferFacade;
import com.softexploration.lab.ejbspring.transfer.webapp.locator.MoneyTransferFacadeLocator;

import org.springframework.web.context.support.WebApplicationContextUtils;

public class DefaultMoneyTransferFacadeLocator implements MoneyTransferFacadeLocator {

	private ServletContext servletContext;

	private final List<String> facadesNames = Arrays.asList(new String[] { "ejb-spring",
			"spring-slejb", "spring-sfejb", "spring-singletonejb" });

	public DefaultMoneyTransferFacadeLocator(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public List<String> getFacadesNames() {
		return facadesNames;
	}

	public MoneyTransferFacade locate(String facadeName) {
		String finalFacadeName = facadeName.trim().toLowerCase();
		if (facadesNames.contains(finalFacadeName)) {
			if ("ejb-spring".equals(finalFacadeName)) {
				try {
					Context ctx = new InitialContext();
					MoneyTransferFacade ret = (MoneyTransferFacade) ctx
							.lookup("java:comp/env/ejb/EJBMoneyTransferFacade");
					return ret;
				} catch (NamingException e) {
					e.printStackTrace();
				}
			} else if ("spring-slejb".equals(finalFacadeName)) {
				return locateSpringMoneyTransferFacade("spring-slejbMoneyTransferFacade");
			} else if ("spring-sfejb".equals(finalFacadeName)) {
				return locateSpringMoneyTransferFacade("spring-sfejbMoneyTransferFacade");
			} else if ("spring-singletonejb".equals(finalFacadeName)) {
				return locateSpringMoneyTransferFacade("spring-singletonejbMoneyTransferFacade");
			}
		}
		return null;
	}

	private MoneyTransferFacade locateSpringMoneyTransferFacade(String beanName) {
		return WebApplicationContextUtils.getWebApplicationContext(servletContext).getBean(beanName,
				MoneyTransferFacade.class);
	}

}