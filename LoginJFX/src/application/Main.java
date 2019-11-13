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
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	Stage stage;

	@FXML
	Label logoLabel;

	@Override
	public void start(Stage myStage) throws Exception {

		stage = myStage;

		// VentanaPrincipal();
		homepage();

	}

	public void homepage() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
			AnchorPane pane;
			pane = loader.load();
			Scene scene = new Scene(pane);
			//scene.getStylesheets().addAll(getClass().getResource("application.css").toExternalForm());			
			stage.setTitle("Homepage.fxml");
			stage.setScene(scene);
			stage.setMinHeight(700);
			stage.setMinWidth(700);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

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

	public void closeStage() {
		stage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
