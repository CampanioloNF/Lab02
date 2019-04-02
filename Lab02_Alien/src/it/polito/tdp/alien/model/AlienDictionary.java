package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.alien.WordEnhanced;

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

	public String parolaMisteriosa(String s, int pos) {
	    
		List <WordEnhanced> mistery = new ArrayList <WordEnhanced>();
		
		String presa = s.substring(0, pos) + s.substring(pos+1);	
		
		for(WordEnhanced w : this.dictionary) {
			
			String alien = w.getAlienWord();
			
			String cercata = alien.substring(0, pos) + alien.substring(pos+1);
			
			if(presa.equals(cercata))
				mistery.add(w);
			
		}
		
		String ris="";
		
	    for(WordEnhanced w : mistery) {
	    	ris+=this.translateWord(w.getAlienWord());
	    }
		
		return ris;
	}
	
}