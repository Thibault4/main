package application;
	

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application {
	
	private int w_width = 800;
	private int w_height = 800;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Map Carte1 = new Map("MaCarte", 54);			
			
			Label l1 = new Label("0,0");
			Label l2 = new Label("0,1");
			Label l3 = new Label("0,2");
			Label l4 = new Label("1,0");
			Label l5 = new Label("1, 2");
			
			l1.setStyle("-fx-border-color: black");
			l2.setStyle("-fx-border-color: black");
			l3.setStyle("-fx-border-color: black");
			
			Image sol = new Image("File:sol.jpg");
			Image perso = new Image("File:perso_de_dos.jpg");
			
			TilePane tile = new TilePane();
		    tile.setPrefColumns(1);
		    tile.setPrefSize(10, 10);
		    tile.setPrefRows(1);
		    for (int i = 0; i < ((w_width/10-2) * (w_height/10-2)); i++) {
		    	if(i != 3082) {
		    		tile.getChildren().add(new ImageView(sol));	
		    	}else {
		    		tile.getChildren().add(new ImageView(perso));
		    	}
		    }
		    
		    
		    

		    
			Scene scene = new Scene(tile,w_width,w_height);
			primaryStage.setTitle("Donjon du malheur");
			primaryStage.setMaxWidth(w_width);
			primaryStage.setMaxHeight(w_height);
			primaryStage.initStyle(StageStyle.UTILITY);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
