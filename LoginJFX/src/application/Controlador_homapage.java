package application;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Controlador_homapage {

	@FXML
	private AnchorPane opacityPane, drawerPane;//drawerPane es el id que le doy al menu lateral que se despliega y el opacityPane es el que hace que cuando el menu sale, se oscureca lo demas.

	@FXML
	private Pane pane1, pane2, pane3, pane4;

	@FXML
	private ImageView drawerImage;//Es la imagen para abrir el menu

	public void initialize() {//Esto es lo primero que hago

		opacityPane.setVisible(false);//Pongo en falso el opacityPane para que no sea visible

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.1), drawerPane);//Esto saca el menu lateral fuera
		translateTransition.setByX(-200);
		translateTransition.play();

		pane1.setStyle("-fx-background-image: url('application/5.jpg')");//Cargamos las imagenes del carrusel con sus panes
		pane2.setStyle("-fx-background-image: url('application/6.jpg')");
		pane3.setStyle("-fx-background-image: url('application/7.jpg')");
		pane4.setStyle("-fx-background-image: url('application/8.jpg')");

		Animation();//Animation esta abajo y es esactamente lo mismo que el carrusel de login

		drawerImage.setOnMouseClicked(event -> {//Cuando clicko en la imagen del menu, comienzo un evento

			opacityPane.setVisible(true);//Lo primero es que hago visible el opacityPane

			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), opacityPane);//Hago visible el opacityPane para que quede mas oscuro
			fadeTransition1.setFromValue(0);
			fadeTransition1.setToValue(0.3);
			fadeTransition1.play();

			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), drawerPane);//Y saco el menu lateral(200)
			translateTransition1.setByX(200);
			translateTransition1.play();
		});

		opacityPane.setOnMouseClicked(event -> {//Esto sirve para que clickando fuera del menu, se me cierre el menu y el opacityPane se le quite la opacidad

			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), opacityPane);
			fadeTransition1.setFromValue(0.3);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();

			fadeTransition1.setOnFinished(event1 -> {
				opacityPane.setVisible(false);
			});//Aqui cierro el evento1

			TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), drawerPane);
			translateTransition1.setByX(-200);
			translateTransition1.play();
		});//Aqui cierro el event

	}

	public void Animation() {

		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), pane4);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();

		fadeTransition.setOnFinished(event -> {
			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3), pane3);
			fadeTransition1.setFromValue(1);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();

			fadeTransition1.setOnFinished(event1 -> {

				FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3), pane2);
				fadeTransition2.setFromValue(1);
				fadeTransition2.setToValue(0);
				fadeTransition2.play();

				fadeTransition2.setOnFinished(event2 -> {

					FadeTransition fadeTransition00 = new FadeTransition(Duration.seconds(3), pane2);
					fadeTransition00.setFromValue(0);
					fadeTransition00.setToValue(1);
					fadeTransition00.play();

					fadeTransition00.setOnFinished(event3 -> {
						FadeTransition fadeTransition11 = new FadeTransition(Duration.seconds(3), pane3);
						fadeTransition11.setFromValue(0);
						fadeTransition11.setToValue(1);
						fadeTransition11.play();

						fadeTransition11.setOnFinished(event4 -> {
							FadeTransition fadeTransition22 = new FadeTransition(Duration.seconds(3), pane4);
							fadeTransition22.setFromValue(0);
							fadeTransition22.setToValue(1);
							fadeTransition22.play();

							fadeTransition22.setOnFinished(event5 -> {
								Animation();
							});
						});

					});
				});

			});

		});

	}

}

