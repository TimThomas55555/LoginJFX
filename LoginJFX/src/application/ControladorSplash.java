package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class ControladorSplash {

	@FXML
	ImageView logoLabel;

	@FXML
	Pane spinnerPane;

	@FXML
	AnchorPane rootPane;

	@FXML
	Label helloLabel;

	@FXML
	Label nameLabel;
	
	public void initialize() {//Es lo que primero aparecera, y en este caso son las transiciones
		//TENEMOS TODOS LOS ELEMENTOS FUERA DE LA PANTALLA(900,-900) PARA QUE DESPUES APAREZCAN
		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.1), logoLabel);//esta es nuestra imagen con el logo
		translateTransition.setByX(900);//Set by x es derecha/izquierda pero setby y es de arriba a abajo
		translateTransition.play();

		TranslateTransition translateTransition0 = new TranslateTransition(Duration.seconds(0.1), nameLabel);//son id para mover concretamente ese elemento
		translateTransition0.setByX(-900);
		translateTransition0.play();

		TranslateTransition translateTransition00 = new TranslateTransition(Duration.seconds(0.1), helloLabel);//son id para mover concretamente ese elemento
		translateTransition00.setByX(900);
		translateTransition00.play();

		translateTransition.setOnFinished(event -> {
			//AQUI EMPEZAMOS A HACER QUE APAREZCAN LOS ELEMENTOS QUE TENIAMOS FUERA
			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), logoLabel);//son id para mover concretamente ese elemento
			translateTransition1.setByX(-900);//Translate transition mueve las cosas de posicion
			translateTransition1.play();

//			translateTransition1.setOnFinished(event1 -> {
			ScaleTransition st = new ScaleTransition(Duration.seconds(0.5), logoLabel);//Modifica la escala con el ScaleTransition
			st.setByX(1);
			st.setByY(1);
			st.setCycleCount(2);
			st.setAutoReverse(true);
			st.play();

			st.setOnFinished(event1 -> {

				nameLabel.setVisible(true);

				TranslateTransition translateTransition11 = new TranslateTransition(Duration.seconds(1), nameLabel);
				translateTransition11.setByX(+900);
				translateTransition11.play();

				translateTransition11.setOnFinished(event2 -> {

					helloLabel.setVisible(true);
					TranslateTransition translateTransition111 = new TranslateTransition(Duration.seconds(1), helloLabel);
					translateTransition111.setByX(-900);
					translateTransition111.play();

					translateTransition111.setOnFinished(event3 -> {
						spinnerPane.setVisible(true);

						FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), spinnerPane);//Este simpelmente parpadea
						fadeTransition.setFromValue(0);
						fadeTransition.setToValue(1);
						fadeTransition.play();

						fadeTransition.setOnFinished(event4 -> {

							FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), rootPane);//AHora le quito la opacidad para que aparezca la siguiente pantalla
							fadeTransition1.setFromValue(1);
							fadeTransition1.setToValue(0.1);
							fadeTransition1.play();

							fadeTransition1.setOnFinished(event5 -> {
								cerrarVentana();
								abrirWizard();//LLamo a la funcion que esta arriba, en este caso, para cargar el wizard
							});

						});

					});

				});
			});

		});
	}

	public void abrirWizard() {
		try {
			// Load the fxml file and create a new stage for the popup.
			FXMLLoader loader = new FXMLLoader();//Es la misma que en controlador, pero hace alguna cosa mas.
			loader.setLocation(Main.class.getResource("Wizard.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage homeStage = new Stage();
			homeStage.setTitle("Main Menu");//Pongo un titulo a la ventana de pa página
			Scene scene = new Scene(page);
			homeStage.setScene(scene);
			homeStage.initStyle(StageStyle.UNDECORATED);
			homeStage.show();
			System.out.println("second stage ok");//Y un mensage personalizado para saber si carga bien o no las cosas

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("second stage ko");
		}
	}
	

	public void cerrarVentana() {
		Stage thisStage = (Stage) rootPane.getScene().getWindow();
		thisStage.close();
		
	}
	

}
