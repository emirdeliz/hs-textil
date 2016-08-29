package br.com.hs.sistema.teste;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.hs.model.entity.Fornecedor;
import br.com.hs.model.entity.Material;
import br.com.hs.sistema.constant.Email;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.service.EmailService;
import br.com.hs.sistema.service.FornecedorService;
import br.com.hs.sistema.service.MaterialService;
import br.com.hs.sistema.utils.TwitterUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="applicationContext.xml")
public class TesteIntegracao {
	
	@Autowired 
    private FornecedorService fornecedorService;
	
	@Autowired 
    private MaterialService materialService;
	
	@Autowired
	private EmailService emailService;
	
	@Test
	public void testeEmail()throws Exception{
		
		logger.info("Initializing test E-mail");
		
		List<Material> lMaterial = this.materialService.buscarTodos();
		List<Fornecedor> lFornecedor = this.fornecedorService.buscarPorMaterial(lMaterial.get(2));	
		
		String dest = lFornecedor.get(0).getEmail();
		String assunto = Email.ASSUNTO_FORNECEDOR_TEMPLATE;
		String msg =  Email.MSG_FORNECEDOR_TEMPLATE
			.replaceAll("(?:_material_)", lMaterial.get(0).getNome())
			.replaceAll("(?:_usuario_)", lFornecedor.get(0).getUsuario())
			.replaceAll("(?:_senha_)", lFornecedor.get(0).getSenha());		
			
		this.emailService.enviaEmail(dest, assunto, msg);				
		logger.info("End test E-mail");	
	}
	
	@Test
	public void testeTwitter()throws Exception{
		TwitterUtils.tweet("Teste integracao twitter");
	}
}
