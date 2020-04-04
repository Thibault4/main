package application;
	

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application {
	
	public final static int w_width = 800;
	public final static int w_height = 800;
	public final static int tile_size = 25;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Player joueur = new Player("Thibault", 4, (681-3-17-30)); //Initialisation du personnage 
			Map Carte1 = new Map("MaCarte", 54);//Création de la map
			Carte1.addingPlayerOnMap(joueur);//ajout du personnage sur la carte
			TilePane terrain = new TilePane();//Création du terrain physique graphique
			terrain.setPrefSize(tile_size, tile_size);//définition de la taille d'une tuile
			terrain.getChildren().addAll(Carte1.generate(93, 896));//génération de la map sur le terrain graphique
			Scene scene = new Scene(terrain ,w_width,w_height);//génération de la scene
			//detection des entrées claviers
			scene.setOnKeyPressed(//détéction d'une appuye sur une touche clavier
					event -> {
						if(event.getCode() == KeyCode.UP) {//si la touche est fleche du haut
							System.out.println("Détéction UP");
							joueur.moveForward();//avance le personnage
							terrain.getChildren().clear();//clear le terrain physique
							terrain.getChildren().addAll(Carte1.generate(93, 896));//actualise le terrain physique
							 
						}
						
						if(event.getCode() == KeyCode.RIGHT) {
							System.out.println("Détéction Right");
							joueur.moveRight();
							terrain.getChildren().clear();
							terrain.getChildren().addAll(Carte1.generate(93, 896));
							 
						}
						
						if(event.getCode() == KeyCode.LEFT) {
							System.out.println("Détéction Left");
							joueur.moveLeft();
							terrain.getChildren().clear();
							terrain.getChildren().addAll(Carte1.generate(93, 896));
						}
						
						if(event.getCode() == KeyCode.DOWN) {
							System.out.println("Détéction Left");
							joueur.moveBackward();
							terrain.getChildren().clear();
							terrain.getChildren().addAll(Carte1.generate(93, 896));
						}
					}
					);
			
			primaryStage.setTitle("Donjon du malheur");//met le titre sur la fenetre
			primaryStage.setMaxWidth(w_width);//définit la taille maximale de la fenetre
			//primaryStage.setMaxHeight(w_height);
			primaryStage.initStyle(StageStyle.DECORATED);//définit sa décoration
			primaryStage.setScene(scene);//charge la scene
			primaryStage.setResizable(false);//desactive l'onglet grand ecran
			primaryStage.show();//affiche la scene
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/*REDEMARRAGE
	  
	  System.out.println( "Restarting app!" );
	  primaryStage.close();
	  Platform.runLater( () -> new Main().start( new Stage() ) );
	 */
	
	/*UPDATER*/
	/*Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
            Runnable updater = new Runnable() {

                @Override
                public void run() {
                    terrain = Carte1.generate(93, 681);
                }
            };

            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }

                // UI update is run on the Application thread
                Platform.runLater(updater);
            }
        }

    });
    // don't let thread prevent JVM shutdown
    thread.setDaemon(true);
    thread.start();*/
	
	
}
