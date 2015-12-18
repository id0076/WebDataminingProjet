package indexFichierInverse1.interfaces;

import java.util.List;

public interface IndexLigneI extends Comparable<IndexLigneI> {
	
	public List<DocumentI> getListDocument();
	public int getFrequence();
	public ElementI getElement();
	
	public void addDocument(DocumentI document);

}
