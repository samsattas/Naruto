package model;

public class Character {
	private String name;
	private String personality;
	private String creationDate;
	private String power;
	private Technique technique;
	
	
	public Character(String name, String personality, String creationDate, String power, Technique technique) {
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		this.technique = technique;
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


	public String getPower() {
		return power;
	}


	public void setPower(String power) {
		this.power = power;
	}


	public Technique getTechnique() {
		return technique;
	}


	public void setTechnique(Technique technique) {
		this.technique = technique;
	}
	
	
}
