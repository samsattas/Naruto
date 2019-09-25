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
			if(clans.get(i).getName().equalsIgnoreCase(n)) {
				found = true;
				pos = i;
			}
		}
		return pos;
	}
	
	public long addClan(Clan c) {
		long start = System.nanoTime();
		boolean repeat = false;
		for(int i = 0; i<clans.size(); i++) {
			if(clans.get(i).compare(clans.get(i), c) == 0) {
				repeat = true;
			}
		}
		if(!repeat) {
			clans.add(c);
		}
		
		arrangeByName();
		long end = System.nanoTime();
		return (end - start);
	}

	public void deleteClan(String c) {
		clans.remove(findByName(c));
	}
	 
	public void arrangeByName() {
		
		Clan aux;
		for(int i = 0;i<clans.size();i++) {			
			for(int j = i+1; j<clans.size();j++) {				
				if(clans.get(j).getName().compareTo(clans.get(i).getName())<0) {
					aux = clans.get(i);
					clans.set(i, clans.get(j));
					clans.set(j, aux);
				}
			}
		}
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
