package application;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ControladorWizard {

	@FXML
	private AnchorPane pane1;

	@FXML
	private AnchorPane pane2;

	@FXML
	private AnchorPane pane3;

	@FXML
	private AnchorPane pane4;
	
	@FXML
	private Label countlabel;
	
	@FXML
	AnchorPane rootPane;
	
	public void initialize() {//Iniciamos con 3 paneles fuera, y 1 dentro
		translateAnimation(0.1, pane2, 800);
		translateAnimation(0.1, pane3, 800);
		translateAnimation(0.1, pane4, 800);
	}
	


	public void translateAnimation(double duration, Node node, double byX) {//Hace una funcion pasandole parametros, para sacar los paneles iniciales(hay 4).Lo unico que hace es tener las 3 imagenes fuera

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}



	int showSlide = 0;//Me defino una variable int, para controlar que pase de una pagina a otra. Tengo dos botones, uno hacia delante y otro hacia atras

	@FXML
	void nextAction() {//Este es el boton que avanza

		if (showSlide == 0) {
			translateAnimation(0.5, pane2, -800);
			showSlide++; // showSlide=1
			countlabel.setText("2/4");
		} else if (showSlide == 1) {

			translateAnimation(0.5, pane3, -800);
			showSlide++; // showSlide=2
			countlabel.setText("3/4");
			
		} else if (showSlide == 2) {

			translateAnimation(0.5, pane4, -800);
			showSlide++; // showSlide=3
			countlabel.setText("4/4");

		} else {
			System.out.println("No more slides");
		}

	}

	@FXML
	void backAction() {//Este es el boton que retrocede

		if (showSlide == 0) {
			System.out.println("No more slides");
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 800);
			showSlide--; // showSlide=0
			countlabel.setText("1/4");
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 800);
			showSlide--; // showSlide=1
			countlabel.setText("2/4");
		} else if (showSlide == 3) {
			translateAnimation(0.5, pane4, 800);
			showSlide--; // showSlide=2
			countlabel.setText("3/4");
		}

	}
	
	@FXML
	public void showLogin() {//Show login es un boton que su id es showLogin
		
		try {
			cerrarVentana();//Lo primero que hace es cerrar ventana
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("peachLogin.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage homeStage = new Stage();
			homeStage.setTitle("Main Menu");
			Scene scene = new Scene(page);
			homeStage.setScene(scene);
			homeStage.initStyle(StageStyle.UNDECORATED);
			homeStage.show();
			System.out.println("second stage ok");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("second stage ko");
		}
	}
	
	@FXML
	public void cerrarVentana() {
		Stage thisStage = (Stage) rootPane.getScene().getWindow();
		thisStage.close();
		
	}

}

