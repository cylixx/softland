package org.formacion.abstractfactory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMultiIdiomaSolution {

	@Test
	public void test_es() {
		AbstractFactory languageEs = new FactoryLanguageEs();
		
		assertEquals("¿qué hora es?", languageEs.createPreguntas().preguntaHora() );
		assertEquals("¿qué tiempo hace?", languageEs.createPreguntas().preguntaTiempo() );
		
		assertEquals("buenos días", languageEs.createSaludos().buenosDias());
		assertEquals("buenas tardes", languageEs.createSaludos().buenasTardes());
	}
	
	@Test
	public void test_en() {
		AbstractFactory languageEn = new FactoryLanguageEn();
		
		assertEquals("what time is it?", languageEn.createPreguntas().preguntaHora() );
		assertEquals("how is the weather?", languageEn.createPreguntas().preguntaTiempo() );
		
		assertEquals("good morning", languageEn.createSaludos().buenosDias());
		assertEquals("good afternoon", languageEn.createSaludos().buenasTardes());
	}
}
