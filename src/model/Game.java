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
	
	public int findByName(String n) {
		int pos = -1;
		boolean found = false;
		for(int i=0; i<clans.size() && !found;i++) {
			if(clans.get(i).getName().equals(n)) {
				found = true;
				pos = i;
			}
		}
		return pos;
	}
	
	public void addClan(Clan c) {
		boolean repeat = false;
		for(int i = 0; i<clans.size(); i++) {
			if(clans.get(i).getName().equals(c.getName())) {
				repeat = true;
			}
		}
		if(!repeat) {
			clans.add(c);
		}
	}

	public void deleteClan(int c) {
		clans.remove(c);
	}
	
	
	public void addCharacterToClan() {
		boolean r = false;
		
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

			} catch (IOException e) {
				e.printStackTrace();
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

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
