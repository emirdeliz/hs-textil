package br.com.hs.sistema.controller;

import flex.messaging.FlexContext;
import flex.messaging.FlexSession;

public class SessionManager {
	private FlexSession mySession;

	public SessionManager() {
		mySession = FlexContext.getFlexSession();
		if (mySession.getAttribute("myCounter") == null) {
			mySession.setAttribute("myCounter", new Integer(1));
		}

		if (mySession.getAttribute("userName") == null) {
			mySession.setAttribute("userName", "Sujit Reddy G");
		}
	}

	public String getUserName() {
		String userName = null;
		userName = (String) mySession.getAttribute("userName");
		return userName;
	}

	public void increaseCounter() {
		Integer i = (Integer) mySession.getAttribute("myCounter");
		i = i + 1;
		mySession.setAttribute("myCounter", i);
	}

	public int getCounter() {
		int counter = 0;
		Integer i = (Integer) mySession.getAttribute("myCounter");
		counter = i.intValue();
		return counter;
	}
}
