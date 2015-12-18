package indexFichierInverse1;

import java.io.File;

import indexFichierInverse1.implement.Document;
import indexFichierInverse1.implement.Element;
import indexFichierInverse1.implement.Index;
import indexFichierInverse1.implement.IndexLigne;
import indexFichierInverse1.interfaces.*;

public class Factory {

	public static DocumentI createDocument(File fichier) {
		return new Document(fichier);
	}
	
	public static ElementI createElement(String mot) {
		return new Element(mot);
	}
	
	public static IndexLigneI createIndexLigne(ElementI element) {
		return new IndexLigne(element);
	}
	
	public static IndexI createIndex() {
		return new Index();
	}

}
