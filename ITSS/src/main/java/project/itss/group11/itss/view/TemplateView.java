package project.itss.group11.itss.view;

import project.itss.group11.itss.controller.ImportFileChamCongController;
import project.itss.group11.itss.controller.TemplateController;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

//public class TemplateView extends Application{
//	// root node of the scene
//	private Parent root;
//	// use to load fxml to root
//	private FXMLLoader rootFxmlLoader;
//	private Scene scene = new Scene(new Button("dummy node"));
//	private Stage stage;
//	
//	// workspace
//	AnchorPane mainWorkspaceAnchorPane;
//	
//	public void start(Stage stage) throws IOException {
//		init(new QLNSController());
//		this.stage = stage;
//		
//		
//		showHome();
//	}
//	
//	public void init(TemplateController myController) {
//		rootFxmlLoader = new FXMLLoader(getClass().getResource("template.fxml"));
//		rootFxmlLoader.setController(myController);
//		try {
//			root = rootFxmlLoader.load();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("template.css").toExternalForm());
//		// init workspace
//		mainWorkspaceAnchorPane = (AnchorPane)(scene.lookup("#mainWorkspaceAnchorPane"));
//	}
//	
//	public void showHome() throws IOException{
//		stage.setTitle("Phần mềm chấm công 4.0");
//		stage.setScene(scene);
//		stage.show();		
//		// Query node de edit giao dien (optional)
////		MenuButton notification = (MenuButton)(scene.lookup("#notification"));
////		System.out.print(notification);
////		notification.setText("Hello");
////		Image bellIcon = new Image(getClass().getResourceAsStream("bell.png"));
////      ImageView bellView = new ImageView(bellIcon);
////      notification.setGraphic(bellView);
////      notification.setText("🔔");
//	}
//	
//	public void addOptionButtons(String... btnNames) {
//		VBox mainOptionVBox = (VBox)(scene.lookup("#mainOptionVBox"));
//		for (String btnName : btnNames) {
//			Button btn = createOptionButton(btnName);
//			mainOptionVBox.getChildren().add(btn);
//		}
//	}
//	
//	public Button createOptionButton(String option) {
//		Button btn = new Button();
//		btn.setTextAlignment(TextAlignment.CENTER);
//		btn.setWrapText(true);
//		btn.setMinSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
//		btn.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
//		btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//		btn.setText(option);
//		return btn;
//	}
//	
//	public static void main(String [] args) {
//		launch(args);
//	}
//}

// Tat ca cac view can implement TemplateView
// Implement nhu nao thi xem QLNSView
public interface TemplateView {
	public void init();
	public Button createOptionButton(String option);
	public void addOptionButtons(String... btnNames);
}