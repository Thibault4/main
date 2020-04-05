package application;


public class Player {
	
	private String name;
	private int level;
	private int position;
	private int health = 100;
	private boolean alive = true;
	public int[] wallsMap = new int[Main.w_height * 2];
	public int[] lavaMap = new int[Main.w_height * 2];
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
		if(canMove(-31)) {
			position -= 31;
		}
	}
	
	public void moveBackward() {
		if(canMove(+31)) {
			position += 31;
		}
	}
	
	public void moveLeft() {
		if(canMove(-1)) {
			position -= 1;
		}
	}
	
	public void moveRight() {
		if(canMove(+1)) {
			position += 1;
		}
	}
	
	public void removeHealth(int damage) {
		health -= damage;
		if(health <= 0) {
			health = 0;
			System.out.println("Game over");
			alive = false;
		}
	}
	
	public boolean canMove(int movementValue) {
		for (int i = 0; i < wallsMap.length; i++) {
			if(position + movementValue == wallsMap[i]) {
				return false;
			}
		}
		
		for (int i = 0; i < lavaMap.length; i++) {
			if(position + movementValue == lavaMap[i]) {
				removeHealth(100);
				System.out.println("Le joueur est tombé dans la lave");
				return false;
			}
		}
		
		return true;
	}
	
	public void setWallsMap(int wallsMap[]) {
		this.wallsMap = wallsMap;
	}
	
	public void setLavaMap(int lavaMap[]) {
		this.lavaMap = lavaMap;
	}
	
	public boolean isAlive() {
		return alive;
	}

	
	

}
