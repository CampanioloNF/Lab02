package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	
	private List <Word> dictionary;
	
	public AlienDictionary() {
		
		this.dictionary = new ArrayList<Word>();
		
	}
	
	public void addWord(String alienWord , String translation ) {
		
		Word nuova = new Word (alienWord, null);
		
		if(this.dictionary.contains(nuova)) {
			
			int pos = this.dictionary.indexOf(nuova);
			Word w = this.dictionary.get(pos);
			w.setTranslation(translation);
			
		}
		
		else
			this.dictionary.add(new Word(alienWord, translation));
			
		
	}
	
	public String translateWord(String alienWord ) {
		
		Word nuova = new Word (alienWord, null);
		
        if(this.dictionary.contains(nuova)) {
			
			int pos = this.dictionary.indexOf(nuova);
			Word w = this.dictionary.get(pos);
			return w.getTranslation();
			
		}
		
		else
		    return "Nessuna parola trovata";
	}
	
}