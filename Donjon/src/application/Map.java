package application;

public class Map {
	
	private String name;
	private int size;
	
	public Map(String name, int size) {
		this.name = name;
		this.size = size;
		System.out.println("Création d'une nouvelle carte " + name + " de taille " + size + " tuiles");
	}
	
	public void setTile(String pathImage, int heightPos, int widthPos) {
		
	}

}
