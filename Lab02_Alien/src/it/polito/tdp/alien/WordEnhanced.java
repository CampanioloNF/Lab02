package it.polito.tdp.alien;

import java.util.HashSet;
import java.util.Set;

public class WordEnhanced {

	
	private String alienWord;
	private String translation;
	private Set <String> translations;
	
	
	public WordEnhanced(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
		this.translations = new HashSet<String>();
		this.translations.add(translation);
	}

/*
	public boolean equals(Object o) {
	
		WordEnhanced altro = (WordEnhanced) o;
		
		if(altro.alienWord.compareTo(this.alienWord)==0)
			return true;
		else
			return false;
		
		
	}

*/
	
	
	
	public void setTranslation(String translation) {
		this.translation = translation;
	}


	public String getAlienWord() {
		return alienWord;
	}


	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}


	public String getTranslation() {
		return translation;
	}


	public void addTranslation(String translation) {
	
		this.translations.add(translation);
		
	}


	@Override
	public String toString() {
		
		String s ="";
		
		for(String st : this.translations) {
			s+=st+" \\ ";
		}

		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	
	
	
	
	
}
