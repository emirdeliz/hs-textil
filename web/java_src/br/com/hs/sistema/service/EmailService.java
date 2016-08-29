package br.com.hs.sistema.service;

import br.com.hs.model.entity.Material;

public interface EmailService {
	
	void enviaEmailFornecedor(Material m)throws Exception;
	
	void enviaEmail(String destinatarios, String assunto, String mensagem) throws Exception;  
}
