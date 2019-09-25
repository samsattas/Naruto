package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;
import model.Character;

class GameTest {
	Game game = new Game();
	
	void setupEscenario() {
		Clan c0 =new Clan("Uchiha");
		Clan c1 =new Clan("Uzumaki");
		Clan c2 =new Clan("Senju");
		Clan c3 =new Clan("Kaguya");
		
		game.addClan(c0);
		game.addClan(c1);
		game.addClan(c2);
		game.addClan(c3);
		
		Character ch = new Character("Sam", "Fun", "07/26/2000", 100);
		c2.setFirstCharacter(ch);
	}
	
	@Test
	void testAddClan() {
		Clan clan = new Clan("Uchiha");
		game.addClan(clan);
		
		assertTrue(game.getClans().get(0) != null);
	}
	
	@Test
	void testFindByName() {
		setupEscenario();
		int i = game.findByName("Senju");
		
		assertTrue(game.getClans().get(i).getFirstCharacter().getName().equalsIgnoreCase("Sam"));
	}

	@Test
	void testDeleteClan() {
		setupEscenario();
		game.deleteClan("Senju");
		
		assertTrue(game.getClans().size() == 3);
		assertTrue(game.findByName("Senju") == -1);
	}
	
	@Test
	void testArrangeByName() {
		setupEscenario();
		game.arrangeByName();
		
		assertEquals(game.getClans().get(0).getName(), "Kaguya");
		assertEquals(game.getClans().get(1).getName(), "Senju");
		assertEquals(game.getClans().get(2).getName(), "Uchiha");
		assertEquals(game.getClans().get(3).getName(), "Uzumaki");
	}
}
