package indexFichierInverse1;

import java.io.File;

import indexFichierInverse1.interfaces.IndexI;
import indexFichierInverse1.interfaces.IndexLigneI;

public class Main {

	public static void main(String[] args) {
		
		long start;
		long stop;
		
		IndexI index = Factory.createIndex();
		start = System.currentTimeMillis();
		File dossier = new File("/home/david/Documents/ENSAI/WebDataMinig/Data");
		for(File fichier :dossier.listFiles()) {
			if(fichier.canRead() & fichier.isFile()) {
				index.addDocument(Factory.createDocument(fichier));
			}
		}
		stop = System.currentTimeMillis();
		System.out.println("Index créé");
		System.out.println((stop - start) + " ms\n");
		
		start = System.currentTimeMillis();
		IndexLigneI indexLigne = index.recherche(Factory.createElement("et"));
		stop = System.currentTimeMillis();
		System.out.println(indexLigne);
		System.out.println((stop - start) + " ms");
		
	}

}
