package ui;

import java.util.Scanner;

import model.*;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		int select = 0;
		boolean exit = false;
		Scanner s = new Scanner(System.in);
		Main m = new Main();
		m.showMainMenu();
		
		do {
			exit = false;
			m.showGameMenu();//shows the menu to do the clans
			select = s.nextInt();
			if(select == 0) {
				System.out.println("Hasta la proxima.");
				exit = true;
			}else if(select == 1) {
				try {
					int i;
					for(i = 0; i < game.getClans().size();i++) {
						System.out.println(i + ") " + game.getClans().get(i).getName());
					}
					
					
					i = s.nextInt();
				}catch (NullPointerException e) {
					if(game.getClans().size()==0) {
						System.out.println("ERROR: no existe ningun clan");
					}else {
						System.out.println("ERROR: no existe el clan");
					}
				}
			}else if (select == 2) {
				try {
					System.out.println("Ingrese el nombre del Clan:");
					s.nextLine();
					String name = s.nextLine();
				
					Clan clan = new Clan(name);
					game.addClan(clan);
				}catch (NullPointerException e) {
					System.out.println("ERROR: Entrada no valida.");
				}
			}else if (select == 3) {
				
			}else if (select == 4) {
				
			}else {
				System.out.println("ERROR: Entrada no valida, intente de nuevo.");
			}
		} while(!exit);
		
		
	}
	
	public void showMainMenu() {
		System.out.println("#########################################################");
		System.out.println("################# B I E N V E N I D O ###################");
		System.out.println("############# HECHO POR: SAMUEL SATIZABAL ###############");
		System.out.println("#################### CHOZO COMPANY ######################");
		System.out.println("#########################################################\n");
		
		
	}
	
	public void showGameMenu() {
		System.out.println("Que desea hacer?:");
		System.out.println("1.Administrar Clanes");
		System.out.println("2.Aniadir Clan");
		System.out.println("3.Modificar Clan");
		System.out.println("4.Eliminar Clan");
		System.out.println("0.Salir");
	}
	
	public void showClanMenu() {
		
	}
	
	public void showCharacterMenu() {
		
	}
}
