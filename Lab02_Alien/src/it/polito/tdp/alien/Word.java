package it.polito.tdp.alien;

public class Word {

	
	private String alienWord;
	private String translation;
	
	
	
	public Word(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}

/*
	public boolean equals(Object o) {
	
		Word altro = (Word) o;
		
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
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	
	
	
	
}
