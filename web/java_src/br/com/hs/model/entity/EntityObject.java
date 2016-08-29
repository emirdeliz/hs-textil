package br.com.hs.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityObject implements Serializable{
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	
	protected Integer oid = 0;

	@Id
	@GeneratedValue
	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}	
	
}
