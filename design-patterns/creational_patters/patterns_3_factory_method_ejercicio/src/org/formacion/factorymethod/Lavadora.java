package org.formacion.factorymethod;

public abstract class Lavadora {

	protected boolean tieneTambor;
	protected boolean tieneMandos;
	protected String  tipoCarga;
	
	public void ponerTambor() {
		tieneTambor = true;
	}
	
	public void ponerMandos() {
		tieneMandos = true;
	}

}
