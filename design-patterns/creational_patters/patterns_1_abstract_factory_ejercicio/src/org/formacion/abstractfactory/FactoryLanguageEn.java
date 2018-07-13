package org.formacion.abstractfactory;

public class FactoryLanguageEn implements AbstractFactory {

	@Override
	public Preguntas createPreguntas() {
		return new PreguntasEn();
	}

	@Override
	public Saludos createSaludos() {
		return new SaludosEn();
	}

}
