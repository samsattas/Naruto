package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Game {
	
	private ArrayList<Clan> clans = new ArrayList<Clan>();
	
	public Game() {
		
	}
	
	public ArrayList<Clan> getClans() {
		return clans;
	}

	public void setClans(ArrayList<Clan> clans) {
		this.clans = clans;
	}
	
	public void addClan(Clan c) {
		clans.add(c);
	}


	public void read() throws Exception {
		File archivo = new File("./data/data.dat");
		if (archivo.exists()) {
			
			try {
				FileInputStream fs = new FileInputStream(archivo);
				ObjectInputStream ois = new ObjectInputStream(fs);
				
				ArrayList<Clan> auxClan = (ArrayList<Clan>) ois.readObject();
				clans = auxClan;
				
				ois.close();
				fs.close();
				System.out.println("Archivo fue cargado ... ");
			} catch (Exception e) {
				// Se atrapan en este bloque todos los tipos de excepción
				System.out.println("Error ... ");

			}
		}
	}
	
	public void write(){
		File archivo = new File("./data/data.dat");
		
		try {
			
			FileOutputStream fo = new FileOutputStream(archivo);
			ObjectOutputStream oos = new ObjectOutputStream(fo);				
			
			oos.writeObject(clans);

			oos.close();
			fo.close();

			System.out.println("Archivo fue creado ... ");
		} catch (FileNotFoundException e){
			System.out.println("Error File... ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
