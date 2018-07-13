package org.formacion.prototype;

import java.util.Arrays;
import java.util.List;

public class Hamburguesa {

	public enum Carne { VACUNO, POLLO }
	public enum Size { MEDIO, GRANDE, EXTRA_GRANDE }
	public enum Extra { CEBOLLA, QUESO, MAYONESA, PEPINO, HUEVO }
	public enum Pan { NORMAL, CON_SEMILLAS }
	
	private final Carne carne;
	private final Size size;
	private final Pan pan;
	private final List<Extra> extras;
	
	// --- constructor general
	
	public Hamburguesa(Carne carne, Size size, Pan pan, Extra ... extras) {
		this.carne = carne;
		this.size = size;
		this.pan = pan;
		this.extras = Arrays.asList(extras);
	}

	// -- accesos / modificaciones
	
	
	public Carne getCarne() {
		return carne;
	}

	public Size getSize() {
		return size;
	}

	public Pan getPan() {
		return pan;
	}

	public List<Extra> getExtras() {
		return extras;
	}

}
