package indexFichierInverse1.implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import indexFichierInverse1.Factory;
import indexFichierInverse1.interfaces.DocumentI;
import indexFichierInverse1.interfaces.ElementI;
import indexFichierInverse1.interfaces.IndexI;
import indexFichierInverse1.interfaces.IndexLigneI;

public class Index implements IndexI {
	
	List<IndexLigneI> index = new ArrayList<IndexLigneI>();
	
	private void addElement(ElementI element, DocumentI document) {
		Iterator<IndexLigneI> i = index.iterator();
		boolean inserted = false;
		while(!inserted & i.hasNext()) {
			IndexLigneI indexLigne = i.next();
			if(indexLigne.getElement().equals(element)) {
				indexLigne.addDocument(document);
				inserted = true;
			}
		}
		if(!inserted) {
			IndexLigneI indexLigne = Factory.createIndexLigne(element);
			indexLigne.addDocument(document);
			index.add(indexLigne);
		}
	}

	@Override
	public void addDocument(DocumentI document) {
		List<ElementI> listElement = document.getListElement();
		for(ElementI element : listElement) {
			addElement(element, document);
		}
		Collections.sort(index);
	}

	@Override
	public String toString() {
		String indexString = new String();
		Iterator<IndexLigneI> i = index.iterator();
		while(i.hasNext()) {
			indexString += i.next().toString() + "\n";
		}
		return indexString;
	}

	@Override
	public IndexLigneI recherche(ElementI element) {
		Iterator<IndexLigneI> i = index.iterator();
		while(i.hasNext()) {
			IndexLigneI indexLigne = i.next();
			if(indexLigne.getElement().equals(element)) {
				return indexLigne;
			}
		}
		return null;
	}

}
