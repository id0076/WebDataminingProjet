package indexFichierInverse1.implement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import indexFichierInverse1.Factory;
import indexFichierInverse1.interfaces.DocumentI;
import indexFichierInverse1.interfaces.ElementI;

public class Document implements DocumentI {
	
	String chemin;
	List<ElementI> listeElement = new ArrayList<ElementI>();

	public Document(File fichier) {
		this.chemin = fichier.getName();
		if(fichier.canRead()) {
			Scanner scanner;
			try {
				scanner = new Scanner(new FileReader(fichier));
				while (scanner.hasNext()) {
				     String mot = scanner.next();
				     listeElement.add(Factory.createElement(mot));
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				System.out.println("[ERROR] Fichier " + chemin + " introuvable.");
			}
		}
		
	}
	
	public String toString() {
		return chemin;
	}

	@Override
	public List<ElementI> getListElement() {
		return listeElement;
	}

}
