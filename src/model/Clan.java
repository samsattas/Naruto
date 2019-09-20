package model;

import java.io.Serializable;

public class Clan implements Serializable{
	private String name;
	private Character firstCharacter;
	
	public Clan(String name) {
		this.name = name;
		this.firstCharacter = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getFirstCharacter() {
		return firstCharacter;
	}

	public void setFirstCharacter(Character firstCharacter) {
		this.firstCharacter = firstCharacter;
	}

	public void addCh(Character ch) {
		boolean r = false;
		Character auxCh = firstCharacter;
		if (firstCharacter==null) {
			firstCharacter = ch;
		} else {
			while(firstCharacter.getNext()!=null) {
				
				if(auxCh.getName().equals(ch.getName())) {
					r = true;
				}else {
					auxCh = auxCh.getNext();
				}
			}
			if(!r) {
				ch.setNext(firstCharacter);
				firstCharacter = ch;
			}
			
		}		
	}
}
