package application;
	

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application {
	
	public final static int w_width = 1100;
	public final static int w_height = 950;
	public final static int tile_size = 50;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Player joueur = new Player("Thibault", 4, 314); //Initialisation du personnage 
			Map Carte1 = new Map("MaCarte");//Création de la map
			Carte1.addingPlayerOnMap(joueur);//ajout du personnage sur la carte
			TilePane terrain = new TilePane();//Création du terrain physique graphique
			terrain.setPrefSize(tile_size, tile_size);//définition de la taille d'une tuile
			terrain.getChildren().addAll(Carte1.generate(22, 348));//génération de la map sur le terrain graphique
			Scene scene = new Scene(terrain ,w_width,w_height);//génération de la scene
			//detection des entrées claviers
			scene.setOnKeyPressed(//détéction d'une appuye sur une touche clavier
					event -> {
						if(event.getCode() == KeyCode.UP) {//si la touche est fleche du haut
							joueur.moveForward();//avance le personnage
							terrain.getChildren().clear();//clear le terrain physique
							terrain.getChildren().addAll(Carte1.refresh());//actualise le terrain physique
							 
						}
						
						if(event.getCode() == KeyCode.RIGHT) {
							joueur.moveRight();
							terrain.getChildren().clear();
							terrain.getChildren().addAll(Carte1.refresh());
							 
						}
						
						if(event.getCode() == KeyCode.LEFT) {
							joueur.moveLeft();
							terrain.getChildren().clear();
							terrain.getChildren().addAll(Carte1.refresh());
						}
						
						if(event.getCode() == KeyCode.DOWN) {
							joueur.moveBackward();
							terrain.getChildren().clear();
							terrain.getChildren().addAll(Carte1.refresh());
						}
					}
					);
			
			primaryStage.setTitle("Donjon du malheur");//met le titre sur la fenetre
			//primaryStage.setMaxWidth(w_width);//définit la taille maximale de la fenetre
			//primaryStage.setMaxHeight(w_height);
			primaryStage.initStyle(StageStyle.DECORATED);//définit sa décoration
			primaryStage.setScene(scene);//charge la scene
			//primaryStage.setResizable(false);//desactive l'onglet grand ecran
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
