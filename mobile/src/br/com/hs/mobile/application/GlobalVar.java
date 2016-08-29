package br.com.hs.mobile.application;

import br.com.hs.model.entity.Representante;
import android.app.Application;

public class GlobalVar extends Application {

	private Representante representante;

	public Representante getUsuario() {
		return representante;
	}

	public void setUsuario(Representante representante) {
		this.representante = representante;
	}
	
	private static GlobalVar instance;
	
	static {
        instance = new GlobalVar();
    }

    private GlobalVar() {
    }

    public static GlobalVar getInstance() {
        return GlobalVar.instance;
    }
}
