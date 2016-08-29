package br.com.hs.sistema.service.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Fornecedor;
import br.com.hs.model.entity.Material;
import br.com.hs.sistema.constant.Email;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.service.EmailService;
import br.com.hs.sistema.service.FornecedorService;

@Service
@RemotingDestination(value="emailService")
public class EmailServiceImpl implements EmailService {
	
	private static String EMITENTE = "emirdeliz@ibest.com.br";	
	
	private static String SENHA = "261989";

	@Autowired
	private FornecedorService fornecedorService;

	public void enviaEmailFornecedor(Material m) throws Exception {		
		List<Fornecedor> fornecedores = this.fornecedorService.buscarPorMaterial(m);
		for (Fornecedor f : fornecedores) {
			String assunto = Email.ASSUNTO_FORNECEDOR_TEMPLATE;
			String msg = Email.MSG_FORNECEDOR_TEMPLATE
				.replaceAll("(?:_material_)", m.getNome())
				.replaceAll("(?:_usuario_)", f.getUsuario())
				.replaceAll("(?:_senha_)", f.getSenha());		
			String email = f.getEmail();
			if(email.equals(""))
				continue;
			this.enviaEmail(email, assunto, msg);
		}	
	}

	public void enviaEmail(String destinatarios, String assunto, String msg)throws Exception {
		
		logger.info("Preparing and sending e-mail...");
		logger.info("Recipient : " + destinatarios);
		logger.info("Subject: "    + assunto);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.ibest.com.br");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(EMITENTE, SENHA);
					}
				});	
						
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(EMITENTE));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatarios));
		message.setSubject(assunto);
		message.setContent(msg, "text/html; charset=ISO-8859-1");
		Transport.send(message);	
		
		logger.info("E-mail successfully sent!");		
	}
}
