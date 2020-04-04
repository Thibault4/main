package application;


import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Map{
	
	Player joueur = new Player(null, 0, 0);
	
	private String name;
	private int size;
	private ArrayList<Node> MetaData = new ArrayList<Node>();
	
	public Map(String name, int size) {
		this.name = name;
		this.size = size;
		System.out.println("Création d'une nouvelle carte " + name + " de taille " + size + " tuiles");
	}
	
	public ArrayList<Node> generate(int beginPos, int endPos) {
		
		clearMetaData(MetaData);
		
		System.out.println("Position du joueur : "  + joueur.getPosition());
		System.out.println("Lancement de generate");
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
	    for (int i = 0; i < ((Main.w_width/Main.tile_size-1) * (Main.w_height/Main.tile_size-1)); i++) { //-1 car on commence a 0 
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
	    		
	    		
	    		
	    		if(i >= WallBeginPosition && i <= WallFinishPosition && i != joueur.getPosition()) { //premiere ligne au top
	    			MetaData.add(new ImageView(new Image("File:"+selectedWall)));
	    		}else if(i == joueur.getPosition()) {
	    			System.out.println("Apparition du personnage en position : " + i);
	    			MetaData.add(new ImageView(new Image("File:perso_de_dos.png")));
	    		}
	    		
	    		
	    		
	    		if(i < WallBeginPosition || i > WallFinishPosition) {
	    			MetaData.add(new ImageView(new Image("File:lave.jpg")));
	    		}
	    		
	    		if(i == deb_ligne + 30) {
	    			LeftPositionWalls = CalculateLeftWallsPosition(i);
	    			RightPositionWalls = CalculateRightWallsPosition(i);
	    			deb_ligne = i +1;
	    			a = true;
	    		}
	    		
	    		
	    		
	    	}else {
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


