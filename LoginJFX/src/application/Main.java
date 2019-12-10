package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
/**
 * Aplicacion de JavaFX que se inicia con un Splash, seguida de un Wizard con una breve ayuda al usuario, continuando con un Login, para dar paso a un Homepage
 * @author david
 * @see ControladorSplash
 * @see ControladorWizard
 * @see Controlador
 * @see Controlador_homapage
 */
public class Main extends Application {
	Stage stage;//Siempre carga la primera pagina que deseo mostrar, para ello me defino en stage para poder abrirla


	@Override
	public void start(Stage myStage) throws Exception {//esto es lo primero que me va a cargar, parecido a innitialize

		stage = myStage;//Me creo un nuevo stage

		VentanaPrincipal();


	}
	
	private void VentanaPrincipal() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("Splash.fxml"));
			AnchorPane myPane = loader.load();
			Scene scene = new Scene(myPane);

			// adding Google fonts
			// scene.getStylesheets().add("https://fonts.googleapis.com/css?family=McLaren");

			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void closeStage() {//Cierra el stage
		stage.close();
	}

	public static void main(String[] args) {//Hola que ase???
		launch(args);
	}
	

}
