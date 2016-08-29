package br.com.hs.sistema.controller;

import java.util.Date;

import flex.messaging.FlexSession;
import flex.messaging.FlexSessionListener;
import flex.messaging.client.FlexClient;
import flex.messaging.client.FlexClientListener;
import flex.messaging.config.ConfigMap;
import flex.messaging.services.AbstractBootstrapService;

public class ControleUsuario extends AbstractBootstrapService
	implements FlexSessionListener, FlexClientListener {
	
	@Override
	public void sessionCreated(FlexSession session) {
		System.out.println("Sessão criada: " + new Date().toString());
		session.addSessionDestroyedListener(this);
	}

	@Override
	public void sessionDestroyed(FlexSession session) {
		System.out.println("Sessão destruida: " + new Date().toString());			
	}

	@Override
	public void clientCreated(FlexClient client) {
		client.addClientDestroyedListener(this);
		
	}
	
	@Override
	public void clientDestroyed(FlexClient client) {	
		System.out.println("FlexClient destruido: " + client.getId() + " " + new Date().toString());
		
	}

	@Override
	public void initialize(String arg0, ConfigMap arg1) {
		 System.out.println("BootstrapService is initializing... " + new Date().toString());
	     ControleUsuario listener = new ControleUsuario();
	     FlexSession.addSessionCreatedListener(listener);
	     FlexClient.addClientCreatedListener(listener);
	}

	@Override
	public void start() {
		
		
	}

	@Override
	public void stop() {
		
	}

}

