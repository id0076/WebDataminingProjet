package ensai.webdataminingProjet.implement;

import ensai.webdataminingProjet.interfaces.ElementI;

public class ElementChar implements ElementI {

	private final Character caractere;
	
	public ElementChar(char caractere) {
		this.caractere = caractere;
	}
	
	public String toString() {
		return caractere.toString();
	}
	
}
