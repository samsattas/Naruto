package test;

import static org.junit.jupiter.api.Assertions.*;
import model.*;
import model.Character;

import org.junit.jupiter.api.Test;

class CharacterTest {
	Character ch = new Character("Naruto", "Amistoso", "10/10/1960", 1000);
	
	void setupEscenario() {
		Technique t1 = new Technique("Rasengan", 1.5);
		Technique t2 = new Technique("Amaterasu", 3.2);
		Technique t3 = new Technique("Edo tensei", 0.1);
		Technique t4 = new Technique("Chidori", 1.4);
		
		ch.addTech(t1);
		ch.addTech(t2);
		ch.addTech(t3);
		ch.addTech(t4);
	}
	
	@Test
	void testAddTech() {
		Technique t = new Technique("Rasengan", 1.5);
		ch.addTech(t);
		
		assertTrue(ch.getFirstTech().getFactor() == 1.5);
		assertTrue(ch.getFirstTech().getName().equalsIgnoreCase("Rasengan"));
	}
	
	@Test
	void testDeleteTech(){
		setupEscenario();
		assertTrue(ch.getFirstTech().getName().equalsIgnoreCase("chidori"));	
		ch.deleteTech("chidori");
		assertTrue(ch.getFirstTech().getName().equalsIgnoreCase("Edo tensei"));
	}
	
	@Test
	void testSearchByName() {
		setupEscenario();
		Technique tech = ch.searchByName("amaterasu");
		
		assertEquals(tech.getFactor(), 3.2);
		assertEquals(tech.getNext().getName(), "Rasengan");
	}

}
