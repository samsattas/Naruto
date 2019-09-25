package test;

import static org.junit.jupiter.api.Assertions.*;
import model.*;
import model.Character;

import org.junit.jupiter.api.Test;

class ClanTest {
	Clan clan = new Clan("Uzumaki");
	
	void setupEscenario0() {
		Character ch1 = new Character("Sam", "Pacifico", "07/26/2000", 100);
		Character ch2 = new Character("Naruto", "Amigable", "09/12/2009", 10000);
		Character ch3 = new Character("Sasuke", "Agresivo", "07/10/2003", 9999);
		Character ch4 = new Character("Kakashi", "Tranquilo", "12/31/1990", 2738);
		
		clan.addCh(ch1);
		clan.addCh(ch2);
		clan.addCh(ch3);
		clan.addCh(ch4);
	}
	
	@Test
	void testSearchByName() {
		setupEscenario0();
		Character aux = clan.searchByName("Naruto");
		
		assertEquals(aux.getPower(), 10000);
	}

	@Test
	void testAddCh() {
		
		Character ch = new Character("Naruto", "Amigable", "09/12/2009", 10000);
		Character ch1 = new Character("Sam", "Pacifico", "07/26/2000", 100);
		
		clan.addCh(ch1);
		clan.addCh(ch);
		
		assertTrue(clan.getFirstCharacter().getNext().getName().equals("Sam"));
		assertTrue(clan.getFirstCharacter().getName().equals("Naruto"));
	}
	
	@Test
	void testDeleteClan() {
		setupEscenario0();
		clan.deleteCharacter("Naruto");
		
		Character c = clan.getFirstCharacter();
		while(c!=null) {
			if(c.getName().equalsIgnoreCase("Naruto")) {
				fail();
			}else {
				c = c.getNext();
			}
		}
	}
}
