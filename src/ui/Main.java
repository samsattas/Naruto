package ui;

import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.*;
import model.Character;


public class Main {
	public static void main(String[] args) throws Exception {
		Game game = new Game();
		game.read();
		int select = 0;
		boolean exit = false;
		Scanner s = new Scanner(System.in);
		Main m = new Main();
		m.showMainMenu();
		
		do {
			
			m.showGameMenu();//shows the menu to do the clans
			select = s.nextInt();
			
			if(select == 0) {
				System.out.println("Hasta la proxima.");
				game.write();
				exit = true;
				
			}else if(select == 1) {//administrate clans
				try {
					System.out.println("Seleccione el Clan:");
					int i;
					for(i = 0; i < game.getClans().size();i++) {
						System.out.println(i + ") " + game.getClans().get(i).getName());
					}
					
					try {
						i = s.nextInt();
						do {
							System.out.println("[Clan: " + game.getClans().get(i).getName() + "]");
							m.showClanMenu();//shows the menu to do characters
							
							select = s.nextInt();
							if(select == 0) {
								exit = true;
							} else if(select == 1) {//administrate Character
								s.nextLine();
								System.out.println("Ingrese el nombre del personaje que va a administrar:");								
								String cha = s.nextLine();
								Character auxCh = game.getClans().get(i).searchByName(cha);
								if(auxCh == null) {
									System.out.println("El personaje ingresado no existe.");
								}else {
								 
									do {
										System.out.println("[Personaje: " + auxCh.getName() + "]");
										m.showCharacterMenu();
										select = s.nextInt();
										if(select == 0) {
											exit = true;
										}else if(select == 1) {
											Technique te = auxCh.getFirstTech();
											while(te!=null) {
												System.out.println("[ Nombre:" + te.getName() + ", Puntaje: " + (te.getFactor()*auxCh.getPower()) + "]");
												te = te.getNext();
											}
										}else if(select == 2) {
											s.nextLine();
											System.out.println("Ingrese el nombre de la Tecnica:");
											String name = s.nextLine();
											
											System.out.println("Ingrese el factor de la Tecnica:");
											double factor = s.nextDouble();
											
											Technique te = new Technique(name, factor);
											auxCh.addTech(te);
										}else if(select == 3) {
											s.nextLine();
											System.out.println("Ingrese el nombre de la Tecnica a actualizar:");
											try {
												String up = s.nextLine();
												Technique tech = auxCh.searchByName(up);
												
												System.out.println("Ingrese el nuevo nombre de la tecnica:");
												tech.setName(s.nextLine());
												
												System.out.println("Ingrese el nuevo factor de la tecnica:");
												tech.setFactor(s.nextDouble());
											}catch(NullPointerException e) {
												System.out.println("ERROR: no existe el personaje");
											}catch(InputMismatchException e) {
												
											}
										}else if(select == 4) {
											s.nextLine();
											System.out.println("Ingrese el nombre de la Tecnica a eliminar:");
											try {
												String del = s.nextLine();
												auxCh.deleteTech(del);
											}catch(NullPointerException e) {
												System.out.println("ERROR: no existe el personaje");
											}
										}
									}while(!exit);
								}
								
								exit = false;
							} else if(select == 2) {//add character
								s.nextLine();
								System.out.println("Ingrese el nombre del presonaje:");
								String name = s.nextLine();
								
								System.out.println("Ingrese la personalidad del personaje:");
								String per = s.nextLine();
								
								System.out.println("Ingrese la fecha de creacion del personaje:");
								String date = s.nextLine();
								
								System.out.println("Ingrese el poder del personaje:");
								double power = s.nextDouble();
								
								Character ch = new Character(name, per, date, power);
								game.getClans().get(i).addCh(ch);
								
							} else if(select == 3) {//update character
								try {
									System.out.println("Ingrese el nombre del Personaje a Actualizar ");
									s.nextLine();
									String n = s.nextLine();
									Character aux = game.getClans().get(i).searchByName(n);
									
									System.out.println("Ingrese el nuevo nombre del Personaje:");
									String name = s.nextLine();
									aux.setName(name);
									
									System.out.println("Ingrese la nueva personalidad del Personaje:");
									String per = s.nextLine();
									aux.setPersonality(per);
									
									System.out.println("Ingrese la nueva fecha de creacion del Personaje");
									String date = s.nextLine();
									aux.setCreationDate(date);
									
									System.out.println("Ingrese el nuevo poder del Personaje");
									double pow = s.nextDouble();
									aux.setPower(pow);
								}catch(NullPointerException e) {
									System.out.println("ERROR: no existe el personaje");
								}
							} else if(select == 4) {
								try {
									System.out.println("Ingrese el nombre del Personaje a eliminar:");
									s.nextLine();
									String del = s.nextLine();
									game.getClans().get(i).deleteCharacter(del);
								}catch(NullPointerException e) {
									System.out.println("ERROR: el personaje ingresado no existe.");
								}
							} else {
								System.out.println("ERROR: Entrada no valida.");
							}
						}while(!exit);
					}catch(InputMismatchException e) {
						System.out.println("ERROR: Entrada no valida.");
					}
				}catch (NullPointerException e) {
					System.out.println("ERROR: No existe ningun clan");
				}catch (IndexOutOfBoundsException e) {
					System.out.println("ERROR: No existe el clan ingresado");
				}catch(InputMismatchException e) {
					System.out.println("ERROR: Entrada no valida");
				}
				exit = false;
			}else if (select == 2) {//register clans
				try {
					System.out.println("Ingrese el nombre del Clan:");
					s.nextLine();
					String name = s.nextLine();
				
					Clan clan = new Clan(name);
					game.addClan(clan);
					System.out.println(game.addClan(clan));
					
				}catch (NullPointerException e) {
					System.out.println("ERROR: Entrada no valida.");
				}
			}else if (select == 3) {//update clan
				System.out.println("Seleccione el clan que desea actualizar:");
				int i;
				for(i = 0; i < game.getClans().size();i++) {
					System.out.println(i + ") " + game.getClans().get(i).getName());
				}
				
				
				i = s.nextInt();
				
				System.out.println("Ingrese el nuevo nombre del clan:");
				s.nextLine();
				game.getClans().get(i).setName(s.nextLine());
			}else if (select == 4) {//delete clan
				try {
					s.nextLine();
					System.out.println("Ingrese el nombre del clan que desea eliminar");
					String toFind = s.nextLine();
					 
					game.deleteClan(toFind);
					System.out.println("Se ha eliminado exitosamente.");
				}catch(NullPointerException e) {
					System.out.println("ERROR: No existe el clan ingresado");
				}
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
		System.out.println(" _______________________________________________");
		System.out.println("|              Que desea hacer?:                |");
		System.out.println("|_______________________________________________|");
		System.out.println("|1.Administrar Clanes                           |");
		System.out.println("|2.Aniadir Clan                                 |");
		System.out.println("|3.Actualizar Clan                              |");
		System.out.println("|4.Eliminar Clan                                |");
		System.out.println("|0.Salir                                        |");
		System.out.println("|_______________________________________________|");
	}
	
	public void showClanMenu() {
		System.out.println(" _______________________________________________");
		System.out.println("|              Que desea hacer?:                |");
		System.out.println("|_______________________________________________|");
		System.out.println("|1.Administrar Personajes                       |");
		System.out.println("|2.Aniadir Personaje                            |");
		System.out.println("|3.Actualizar Personaje                         |");
		System.out.println("|4.Eliminar Personaje                           |");
		System.out.println("|0.Regresar                                     |");
		System.out.println("|_______________________________________________|");
	}
	
	public void showCharacterMenu() {
		System.out.println(" _______________________________________________");
		System.out.println("|              Que desea hacer?:                |");
		System.out.println("|_______________________________________________|");
		System.out.println("|1.Ver Tecnicas                                 |");
		System.out.println("|2.Aniadir Tecnica                              |");
		System.out.println("|3.Actualizar Tecnica                           |");
		System.out.println("|4.Eliminar Tecnica                             |");
		System.out.println("|0.Regresar                                     |");
		System.out.println("|_______________________________________________|");
	}
}
