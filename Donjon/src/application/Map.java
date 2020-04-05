package application;


import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Map{
	
	
	private String name;
	private ArrayList<Node> MetaData = new ArrayList<Node>();
	Player joueur;
	
	public Map(String name) {
		this.name = name;
		System.out.println("Création d'une nouvelle carte " + name);
	}
	
	public ArrayList<Node> generate(int beginPos, int endPos) {
		
		clearMetaData(MetaData);
		
	    int deb_ligne = beginPos;
	    boolean a = false;
	    
	    int WallBeginPosition = beginPos + 3;
	    int WallFinishPosition = beginPos + 32 - 5;
	    
	    int LeftPositionWalls = 0;
	    int RightPositionWalls = 0;
	    
	    String selectedWall = "mur1.jpg";
	    
	    
	    		
	    
	    /*for (int i = 0; i < ((Main.w_width/Main.tile_size-1) * (Main.w_height/Main.tile_size-1)); i++) {
	    	MetaData.add(new Label("["+i+"]"));
	    }*/
	    for (int i = 0; i < ((Main.w_width/Main.tile_size-1) * ((Main.w_height-150)/Main.tile_size-1)); i++) { //-1 car on commence a 0 
	    	if(i >= beginPos && i <= endPos) {
	    		
	    		if(i == LeftPositionWalls) { //detection de la création d'un mur vertical du coté gauche
	    			WallBeginPosition = i; 
	    			WallFinishPosition = i+27;
	    		}
	    		
	    		if(i == LeftPositionWalls +1) { //change la forme du mur pour remplir l'interieur du carre
	    			if(i > endPos - 30) {
	    				selectedWall = "mur1.jpg";
	    			}else {
	    				selectedWall = "mur2.jpg";
	    			}
	    		}
	    		
	    		if(i == RightPositionWalls) { //detection de la création d'un mur vertical du coté droit
	    			WallBeginPosition = i; 
	    			WallFinishPosition = i;
	    			selectedWall = "mur1.jpg";
	    		}
	    		
	    		if(a) {
	    			deb_ligne = i;
	    			a = false;
	    		}
	    		
	    		
	    		if(i == joueur.getPosition() && joueur.isAlive()) {
	    			MetaData.add(new ImageView(new Image("File:perso_de_dos.png")));
	    		}else if(i >= WallBeginPosition && i <= WallFinishPosition) { //premiere ligne au top
	    			MetaData.add(new ImageView(new Image("File:"+selectedWall)));
	    			if(selectedWall.equalsIgnoreCase("mur1.jpg")) {
	    				joueur.wallsMap[i] = i;
	    			}
	    		}
	    		
	    		
	    		
	    		if(i < WallBeginPosition || i > WallFinishPosition) {
	    			MetaData.add(new ImageView(new Image("File:lave.jpg")));
	    			joueur.lavaMap[i] = i;
	    		}
	    		
	    		if(i == deb_ligne + 30) {
	    			LeftPositionWalls = CalculateLeftWallsPosition(i);
	    			RightPositionWalls = CalculateRightWallsPosition(i);
	    			deb_ligne = i +1;
	    			a = true;
	    		}
	    		
	    		
	    		
	    	}else {
	    		joueur.lavaMap[i] = i;
	    		MetaData.add(new ImageView(new Image("File:lave.jpg")));
	    	}
	    }
	    
	    return MetaData;
	 }
	
	
	
	
	public int CalculateLeftWallsPosition(int i) {
		return i+4;
	}
	
	public int CalculateRightWallsPosition(int i) {
		return i+28;
	}
	
	public void addingPlayerOnMap(Player joueur) {
		this.joueur = joueur;
	}
	
	public ArrayList<Node> clearMetaData(ArrayList<Node> metaDataArray) {
		metaDataArray.clear();
		return metaDataArray;
	}
	
}


