package br.com.hs.sistema.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import br.com.hs.model.entity.Cliente;
import br.com.hs.model.entity.Promocao;
import br.com.hs.sistema.constant.Email;
import br.com.hs.sistema.constant.TipoPromocao;
import br.com.hs.sistema.controller.logger;
import br.com.hs.sistema.repository.PromocaoDao;
import br.com.hs.sistema.service.ClienteService;
import br.com.hs.sistema.service.EmailService;
import br.com.hs.sistema.service.PromocaoService;
import br.com.hs.sistema.utils.TwitterUtils;

@Service
@RemotingDestination(value = "promocaoService")
public class PromocaoServiceImpl implements PromocaoService {

	@Autowired
	private PromocaoDao repository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ClienteService clienteService;

	public Promocao buscarPorId(Serializable oid) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List entity Promocao by id: " + oid);
			return this.repository.buscarPorId(Promocao.class, oid);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while querying data: " + e);
			throw e;
		}
	}

	public List<Promocao> buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("List All entity: Promocao");
			return this.repository.buscarTodos(Promocao.class);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while all query data: " + e);
			throw e;
		}
	}

	public void deletar(Promocao entity) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Delete a new entity: " + entity);
			this.repository.deletar(entity);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("An error occurred while deleting item: " + e);
			throw e;
		}
	}

	public Promocao salvar(Promocao entity) throws Exception {
		// TODO Auto-generated method stub
		try {
			logger.info("Save a new entity: " + entity);
			logger.info((entity.getOid() > 0 ? "updating" : "saving"));
			logger.info("Discounted preparing shipping");					
			logger.info("Message: " + entity.getDescricao());
			logger.info("Type: '" + entity.getTipo() + "' 0 All | 1 Twitter | 2 E-mail");
			
			if (entity.getTipo() == TipoPromocao.EMAIL) {
				List<Cliente> list = this.clienteService.buscarTodos();				
				String msg = Email.MSG_CLIENTE_TEMPLATE.replace("_msg_", entity.getDescricao());
				String ass = Email.ASSUNTO_CLIENTE_TEMPLATE;
				for (Cliente cliente : list) {
					this.emailService.enviaEmail(cliente.getEmail(), ass, msg);
				}				
			} else if(entity.getTipo() == TipoPromocao.TWITTER){
				String msg = entity.getDescricao();
				TwitterUtils.tweet(msg);
			}else{
				List<Cliente> list = this.clienteService.buscarTodos();
				String twt = entity.getDescricao();
				String msg = Email.MSG_CLIENTE_TEMPLATE.replace("_msg_", entity.getDescricao());
				String ass = Email.ASSUNTO_CLIENTE_TEMPLATE;
				for (Cliente cliente : list) {
					this.emailService.enviaEmail(cliente.getEmail(), ass, msg);
				}
				TwitterUtils.tweet(twt);
			}			
			return entity.getOid()>0?repository.atualizar(entity):repository.salvar(entity);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("An error occurred while: "	+ (entity.getOid() > 0 ? "updating" : "saving") + " item:"+ e);			
			throw e;
		}
	}

}
