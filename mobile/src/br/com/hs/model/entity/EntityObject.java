package br.com.hs.model.entity;

import java.io.Serializable;

public class EntityObject implements Serializable{
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	
	protected Integer oid = 0;
	
	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}	
	
}
