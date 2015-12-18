package indexFichierInverse1.implement;

import java.util.ArrayList;
import java.util.List;

import indexFichierInverse1.interfaces.DocumentI;
import indexFichierInverse1.interfaces.ElementI;
import indexFichierInverse1.interfaces.IndexLigneI;

public class IndexLigne implements IndexLigneI {
	
	private final ElementI element;
	private int frequence = 0;
	private List<DocumentI> listeDocument = new ArrayList<DocumentI>();

	public IndexLigne(ElementI element) {
		this.element = element;
	}

	@Override
	public List<DocumentI> getListDocument() {
		return listeDocument;
	}

	@Override
	public int getFrequence() {
		return frequence;
	}

	@Override
	public ElementI getElement() {
		return element;
	}

	@Override
	public int compareTo(IndexLigneI o) {
		return o.getFrequence() - frequence;
	}

	@Override
	public void addDocument(DocumentI document) {
		if(!listeDocument.contains(document)) {
			listeDocument.add(document);			
		}
		frequence++;
	}

	@Override
	public String toString() {
		String documentString = new String();
		for(DocumentI document : listeDocument) {
			documentString += document.toString() + " ";
		}
		return "[" + element.toString() + " " + frequence + " [ " + documentString + "]]";
	}

}
