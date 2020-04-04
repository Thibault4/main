package application;


public class Player {
	
	private String name;
	private int level;
	private int position;
	private int health = 100;
	//Inventory inventory;
	
	public Player(String name, int position) {
		this(name, 1, position);
	}
	
	public Player(String name, int level, int position) {
		this.name = name;
		this.level = level;
		this.position = position;
	}
	
	public int getPosition() {//Récupération de la position du joueur
		return position;
	}
	
	public void moveForward() {//Fonction de déplacement avec leurs valeurs
		position -= 31;
	}
	
	public void moveBackward() {
		position += 31;
	}
	
	public void moveLeft() {
		position -= 1;
	}
	
	public void moveRight() {
		position += 1;
	}
	
	public void removeHealth(int damage) {
		health -= damage;
	}

	
	

}
