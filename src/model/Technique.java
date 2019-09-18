package model;

import java.io.Serializable;

public class Technique implements Serializable{
	private String name;
	private double factor;
	private Technique next;
	private Technique back;
	
	public Technique(String name, double factor) {
		this.name = name;
		this.factor = factor;
		this.next =null;
		this.back = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public Technique getNext() {
		return next;
	}

	public void setNext(Technique next) {
		this.next = next;
	}

	public Technique getBack() {
		return back;
	}

	public void setBack(Technique back) {
		this.back = back;
	}
	
	
}
