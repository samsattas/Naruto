package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Character implements Serializable{
	private String name;
	private String personality;
	private String creationDate;
	private double power;
	private Character next;
	private Technique firstTech;
	
	
	public Character(String name, String personality, String creationDate, double power) {
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		this.next = null;
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


	public void addTechnique(Technique t) {
		if (firstTech==null) {
			firstTech = t;
		}else {
			Technique aux = firstTech;
			Technique auxNext = firstTech.getNext();
			boolean cent = false;
			while(!cent) {
				if(auxNext != null) {
					if(aux.getFactor()<=t.getFactor() && auxNext.getFactor()>t.getFactor()) {
						t.setNext(auxNext);
						t.setBack(aux);
						auxNext.setBack(t);
						aux.setNext(t);
						cent = true;
					}else {
						auxNext = auxNext.getNext();
						aux = aux.getNext();
					}
				}else {
					if(t.getFactor()>aux.getFactor()) {
						aux.setNext(t);
						t.setBack(aux);
						cent = true;
					}else {
						aux.setBack(t);
						t.setNext(aux);
						firstTech = t;
						cent = true;
					}
				}
			}
		}
		
	}
}
