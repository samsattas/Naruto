package model;

import java.io.Serializable;
import java.util.Comparator;

public class Clan implements Serializable, Comparator<Clan>{
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
	
	public Character searchByName(String n) {
		Character aux = null;
		Character first = firstCharacter;
		
		while(first != null) {
			if(first.getName().equals(n)) {
				aux = first;
			}
			first = first.getNext();
			
		}
		return aux;
	}
	
	public void addCh(Character ch) {
		boolean r = false;
		Character aux = firstCharacter;
		if(firstCharacter == null) {
			firstCharacter = ch;
		}else {
			while(aux!=null) {
				if(aux.getName().equalsIgnoreCase(ch.getName())) {
					r = true;
				}else {
					aux = aux.getNext();
				}
				
			}
			
			if(!r) {
				
				ch.setNext(firstCharacter);
				firstCharacter.setBack(ch);
				firstCharacter = ch;
			}
		}
	}
 
	public void deleteCharacter(String s) {
		Character aux = firstCharacter;
		boolean cent = false;
		while(!cent && aux!=null) {
			if(aux.getName().equals(s)) {
				firstCharacter = firstCharacter.getNext();
				cent = true;
			}else {
				while(!cent && aux.getNext()!=null) {
					if(aux.getNext().getName().equals(s)) {
						cent = true;
						if(aux.getNext().getNext()!=null) {
							aux.setNext(aux.getNext().getNext());
							aux.getNext().setBack(aux);
						}else {
							aux.setNext(null);
						}
					}else {
						aux = aux.getNext();
					}
				}
			}
		}
	}

	@Override
	public int compare(Clan c1, Clan c2) {
		int i = c1.getName().compareTo(c2.getName());
		return i;
	}
}//end
