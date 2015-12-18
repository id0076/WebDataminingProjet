package indexFichierInverse1.implement;

import indexFichierInverse1.interfaces.ElementI;

public class Element implements ElementI {

	private final String mot;
	
	public Element(String mot) {
		this.mot = mot;
	}
	
	public String toString() {
		return mot;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ElementI) {
			Element element = (Element) obj;
			return mot.equals(element.mot);
		}
		return false;
	}

}
