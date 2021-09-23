package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToolbar;

import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SampleController implements Initializable {

	@FXML
	private JFXToolbar toolBar;

	private JFXNodesList toolBarListener() {
		JFXNodesList nodesList = new JFXNodesList();

		nodesList.setRotate(270);
		nodesList.setSpacing(30);
		
		MaterialIconView icon = new MaterialIconView(MaterialIcon.HOME);
		icon.getStyleClass().add("icon-fill");
		MaterialIconView icon2 = new MaterialIconView(MaterialIcon.PERSON_ADD);
		icon2.getStyleClass().add("icon-fill");
		MaterialIconView icon3 = new MaterialIconView(MaterialIcon.MESSAGE);
		icon3.getStyleClass().add("icon-fill");
		MaterialIconView icon4 = new MaterialIconView(MaterialIcon.SETTINGS);
		icon4.getStyleClass().add("icon-fill");

		JFXButton button = new JFXButton(null);
		JFXButton button2 = new JFXButton(null);
		JFXButton button3 = new JFXButton(null);
		JFXButton button4 = new JFXButton(null);

		button.setGraphic(icon);
		button.getStyleClass().addAll("animated-option-button");
		button2.setGraphic(icon2);
		button2.getStyleClass().addAll("animated-option-button");
		button3.setGraphic(icon3);
		button3.getStyleClass().addAll("animated-option-button");
		button4.setGraphic(icon4);
		button4.getStyleClass().addAll("animated-option-button");
		button4.setOnAction(e->{
			try {
				VBox root = (VBox)FXMLLoader.load(getClass().getResource("/application/settings/Settings.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.initStyle(StageStyle.UTILITY);
				stage.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		nodesList.addAnimatedNode(button);
		nodesList.addAnimatedNode(button2);
		nodesList.addAnimatedNode(button3);
		nodesList.addAnimatedNode(button4);

		return nodesList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toolBar.setLeft(toolBarListener());
		
		toolBar.setRight(searchBtn());
	}

	private JFXNodesList searchBtn() {
		JFXTextField search = new JFXTextField();
		search.setPromptText("Search");
		
		VBox vBox = new VBox();
		vBox.getChildren().add(search);
		vBox.getStyleClass().addAll("searchBox","search-bar-font-size");
		vBox.setAlignment(Pos.CENTER);
		
		JFXNodesList nodesList = new JFXNodesList();
		nodesList.setRotate(90);
		nodesList.setSpacing(70);
		
		MaterialIconView searchIcon = new MaterialIconView(MaterialIcon.SEARCH);
		searchIcon.getStyleClass().add("icon-fill");
		
		JFXButton searchBtn = new JFXButton();
		searchBtn.setGraphic(searchIcon);
		searchBtn.getStyleClass().add("animated-option-button");
		
		nodesList.addAnimatedNode(searchBtn);
		nodesList.addAnimatedNode(vBox);
		return nodesList;
	}
}
