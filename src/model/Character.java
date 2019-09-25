package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Character implements Serializable, Comparable<Character>{
	private String name;
	private String personality;
	private String creationDate;
	private double power;
	private Character next;
	private Character back;
	private Technique firstTech;
	
	
	public Character(String name, String personality, String creationDate, double power) {
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		this.next = null;
		this.back = null;
		this.firstTech = null;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPersonality() {
		return personality;
	}


	public void setPersonality(String personality) {
		this.personality = personality;
	}


	public String getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public double getPower() {
		return power;
	}


	public void setPower(double power) {
		this.power = power;
	}
	
	
	public Character getBack() {
		return back;
	}


	public void setBack(Character back) {
		this.back = back;
	}
	
	public Character getNext() {
		return next;
	}

	public void setNext(Character next) {
		this.next = next;
	}

	public Technique getFirstTech() {
		return firstTech;
	}


	public void setFirstTech(Technique firstTech) {
		this.firstTech = firstTech;
	}


	public void addTech(Technique ch) {
		boolean r = false;
		Technique auxCh = firstTech;
		if (firstTech==null) {
			firstTech = ch;
		} else { 
			while(auxCh.getNext()!=null) {
				
				if(auxCh.getName().equals(ch.getName())) {
					r = true;
				}else {
					auxCh = auxCh.getNext();
				}
			}
			if(!r) {
				ch.setNext(firstTech);
				firstTech = ch;
			}
			
		}		
	} 
	
	public void deleteTech(String s) {
		Technique aux = firstTech;
		boolean cent = false;
		while(!cent && aux!=null) {
			if(aux.getName().equals(s)) {
				firstTech = firstTech.getNext();
				cent = true;
			}else {
				while(!cent && aux.getNext()!=null) {
					if(aux.getNext().getName().equals(s)) {
						cent = true;
						if(aux.getNext().getNext()!=null) {
							aux.setNext(aux.getNext().getNext());
							
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
	
	public Technique searchByName(String n) {
		Technique aux = null;
		Technique first = firstTech;
		
		while(first != null) {
			if(first.getName().equalsIgnoreCase(n)) {
				aux = first;
			}
			first = first.getNext();
			
		}
		return aux;
	}

	@Override
	public int compareTo(Character c) {
		int i = name.compareTo(c.getName());
		return i;
	}

}
