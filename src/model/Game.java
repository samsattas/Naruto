package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Game {
	
	private ArrayList<Clan> clans;
	
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


public static void Guarda(String nombreArchivo) throws Exception {
		

//		File archivo = new File(nombreArchivo);
//		if (archivo.exists()) {
//			// El archivo existe: se debe recuperar de allí el estado del modelo del mundo
//			try {
//				FileInputStream fs = new FileInputStream(archivo);
//				ObjectInputStream ois = new ObjectInputStream(fs);
//				Clan estu = (Clan) ois.readObject();
//				Clan estu2 = (Clan) ois.readObject();
//				System.out.println("Código: " + estu.getName());
//				System.out.println("Código: " + estu2.getName());
//				ois.close();
//				System.out.println("Archivo fue cargado ... ");
//			} catch (Exception e) {
//				// Se atrapan en este bloque todos los tipos de excepción
//				System.out.println("Error ... ");
//
//			}
//		} else {
//			// El archivo no existe: es la primera vez que se ejecuta el programa
//			try {
//				
//				FileOutputStream fo = new FileOutputStream(archivo);
//				ObjectOutputStream oos = new ObjectOutputStream(fo);
//				
//				for(int i = 0; i<clans.size();i++) {
//					
//				}
//				oos.writeObject(est);
//				oos.writeObject(est1);
//
//				oos.close();
//
//				System.out.println("Archivo fue creado ... ");
//			} catch (IOException e) {
//				System.out.println("Error ... ");
//			}
//		}
	}
}
