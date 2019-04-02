package it.polito.tdp.alien;
	
import it.polito.tdp.alien.model.AlienDictionary;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//PATTERN MVC
			
			// creo un oggetto FXMLLoader
			                                  //devo aggiungere questo al costruttore
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Alien.fxml"));
			
			//utilizzo l'oggetto per il border pane
			
			BorderPane root = loader.load();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			//lo uso prima di visualizzare la scena per impostare il modello per il controller
			
			//creo il model
			AlienDictionary model = new AlienDictionary();
			
			//mi faccio dare il controller
			AlienController controller = loader.getController();
			//poi devo settare il model
			controller.setModel(model);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
