package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	
	private List <WordEnhanced> dictionary;
	
	public AlienDictionary() {
		
		this.dictionary = new ArrayList<WordEnhanced>();
		
	}
	
	public void addWord(String alienWord , String translation ) {
		
		WordEnhanced nuova = new WordEnhanced (alienWord, null);
		
		if(this.dictionary.contains(nuova)) {
			
			int pos = this.dictionary.indexOf(nuova);
			WordEnhanced w = this.dictionary.get(pos);
			w.addTranslation(translation);
			
		}
		
		else
			this.dictionary.add(new WordEnhanced(alienWord, translation));
			
		
	}
	
	public String translateWord(String alienWord ) {
		
		WordEnhanced nuova = new WordEnhanced (alienWord, null);
		
        if(this.dictionary.contains(nuova)) {
			
			int pos = this.dictionary.indexOf(nuova);
			WordEnhanced w = this.dictionary.get(pos);
			return w.toString();
			
		}
		
		else
		    return "Nessuna parola trovata";
	}
	
}