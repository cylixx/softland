package org.formacion.abstractfactory;

public class FactoryLanguageEs implements AbstractFactory {

	@Override
	public Preguntas createPreguntas() {
		return new PreguntasEs();
	}

	@Override
	public Saludos createSaludos() {
		return new SaludosEs();
	}

}
