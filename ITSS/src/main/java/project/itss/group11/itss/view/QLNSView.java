package project.itss.group11.itss.view;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import project.itss.group11.itss.controller.ImportFileChamCongController;
import project.itss.group11.itss.controller.TemplateController;
import project.itss.group11.itss.model.LogInfor;
import project.itss.group11.itss.model.PreviewFileChamCongTableRowModel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

// Tao view khac: copy y het class nay ve, chi can doc huong dan -----------huong dan----------- o duoi

//------------------- sua ten class (vd OfficeView) -------------------------------
public class QLNSView extends Application implements TemplateView{
	private Scene scene = new Scene(new Button("dummy node"));
	private Stage stage;
	
	private TemplateController templateController = new TemplateController(this);
	
//------------- Them controller cua minh -----------------	
	private ImportFileChamCongController importFileChamCongController = new ImportFileChamCongController(this);
	
	//workspace (la phan pane trống ben phai)
	AnchorPane mainWorkspaceAnchorPane;
	
	
	
	public void start(Stage stage) throws IOException {
		init();
		this.stage = stage;	
		showHome();
		// init workspace
		mainWorkspaceAnchorPane = (AnchorPane)(scene.lookup("#mainWorkspaceAnchorPane"));
//----------------  Add button chon chuc nang, button ten "hello world" se co id = "hello-world" --------------------
		addOptionButtons("Thông tin chấm công của tôi", "Xem thông tin chấm công chi tiết của nhân viên", "Xem thông tin chấm công tổng hợp của nhân viên", "Xem yêu cầu chỉnh sửa chấm công", "Import file chấm công");

//---------------------------- Query button de add listener ---------------------------
		Button importOptionButton = (Button)(scene.lookup("#Import-file-chấm-công"));
		importOptionButton.setOnMouseClicked(event -> {
			File file = showFileChooser();
			importFileChamCongController.handleCsvInput(file);
			showImportFileChamCongWorkspace();
			importFileChamCongController.handleShowTable();
		});
		
//---------- Add node vao workspace:  ---------------
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("node.fxml"));
//		fxmlLoader.setController(controller);
//		node = fxmlLoader.load();
//		AnchorPane.setTopAnchor(node, 0.0);
//		AnchorPane.setBottomAnchor(node, 0.0);
//		AnchorPane.setRightAnchor(node, 0.0);
//		AnchorPane.setLeftAnchor(node, 0.0);
//		mainWorkspaceAnchorPane.getChildren().clear();
//		mainWorkspaceAnchorPane.getChildren().add(node);
//		mainWorkspaceAnchorPane.applyCss();
//		mainWorkspaceAnchorPane.layout();
//		node.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
//		node.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
	}
	
	public void init() {
		FXMLLoader rootFxmlLoader = new FXMLLoader(getClass().getResource("template.fxml"));
		rootFxmlLoader.setController(templateController);
		Parent root = null;
		try {
			root = rootFxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("template.css").toExternalForm());
	}
	
	public void showHome() throws IOException{
		stage.setTitle("Phần mềm chấm công 4.0");
		stage.setScene(scene);
		stage.show();		
	}
	
	public Button createOptionButton(String option) {
		Button btn = new Button();
		btn.setTextAlignment(TextAlignment.CENTER);
		btn.setWrapText(true);
		btn.setMinSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		btn.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		btn.setMaxSize(Double.MAX_VALUE, 130);
		btn.setText(option);
		option = option.replaceAll(" ", "-");   
		btn.setId(option);
		return btn;
	}
	
	public void addOptionButtons(String... btnNames) {
		VBox mainOptionVBox = (VBox)(scene.lookup("#mainOptionVBox"));
		for (String btnName : btnNames) {
			Button btn = createOptionButton(btnName);
			VBox.setVgrow(btn, Priority.ALWAYS);
			mainOptionVBox.getChildren().add(btn);
		}
	}
	
	public File showFileChooser(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Chon file cham cong");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("File cham cong","*.csv"));
		File file = fileChooser.showOpenDialog(stage);
		return file;	
	}
	
	public void showImportFileChamCongWorkspace() {
		System.out.println("Show workspace");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("importFileChamCongWorkspace.fxml"));
		VBox workspaceVbox = null;
		try {
			workspaceVbox = fxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// init workspace
		AnchorPane.setTopAnchor(workspaceVbox, 0.0);
		AnchorPane.setBottomAnchor(workspaceVbox, 0.0);
		AnchorPane.setRightAnchor(workspaceVbox, 0.0);
		AnchorPane.setLeftAnchor(workspaceVbox, 0.0);
		mainWorkspaceAnchorPane.getChildren().clear();
		mainWorkspaceAnchorPane.getChildren().add(workspaceVbox);
		
		// cai dat listener cho chon file khac button
		Button chooseAnotherFileButton = (Button)(mainWorkspaceAnchorPane.lookup("#chooseAnotherFileButton"));
		chooseAnotherFileButton.setOnMouseClicked(event ->{
			System.out.println("Choose another file");
			File file = showFileChooser();
			importFileChamCongController.handleCsvInput(file);
			showImportFileChamCongWorkspace();
			importFileChamCongController.handleShowTable();
		});
		System.out.println("Showed workspace");
	}
	
	public void showTable(ObservableList<PreviewFileChamCongTableRowModel> tableRows, ArrayList<Boolean> isDuplicate) {
		System.out.println("Show table");
		System.out.println("Table contains " + tableRows.size() + " row(s)");
		mainWorkspaceAnchorPane.applyCss();
		mainWorkspaceAnchorPane.layout();
		TableView<PreviewFileChamCongTableRowModel> table = (TableView<PreviewFileChamCongTableRowModel>)(mainWorkspaceAnchorPane.lookup("#importFileChamCongTable"));
		
		TableColumn idColumn = table.getColumns().get(0);
		TableColumn timeColumn = table.getColumns().get(1);
		TableColumn deviceColumn = table.getColumns().get(2);
		TableColumn selectColumn = table.getColumns().get(3);
		idColumn.setCellValueFactory(new PropertyValueFactory<PreviewFileChamCongTableRowModel, Integer>("id"));
		timeColumn.setCellValueFactory(new PropertyValueFactory<PreviewFileChamCongTableRowModel, LocalDateTime>("timestamp"));
		deviceColumn.setCellValueFactory(new PropertyValueFactory<PreviewFileChamCongTableRowModel, Integer>("device"));
		selectColumn.setCellValueFactory(new PropertyValueFactory<PreviewFileChamCongTableRowModel, CheckBox>("selectCheckBox"));
		
		table.setItems(tableRows);
		for(int i=0; i< table.getItems().size(); i++) {
			if(isDuplicate.get(i)) {
				CheckBox checkBox = table.getItems().get(i).getSelectCheckBox();
				checkBox.setDisable(true);
				checkBox.setText("Disable");
				
			}
		}
		
		// cai dat listener cho sellect all checkbox
		CheckBox selectAllCheckBox = (CheckBox)(mainWorkspaceAnchorPane.lookup("#selectAllCheckBox"));	
		selectAllCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				ObservableList<PreviewFileChamCongTableRowModel> rows = table.getItems();
				if(selectAllCheckBox.isSelected()) {
					for(PreviewFileChamCongTableRowModel row: rows) {
						if(row.getSelectCheckBox().isDisabled())
							continue;
						row.getSelectCheckBox().setSelected(true);
					}
				}else {
					for(PreviewFileChamCongTableRowModel row: rows) {
						row.getSelectCheckBox().setSelected(false);
					}
				}
				
			}
		});;
		
		// cai dat listener import button
		Button importButton = (Button)(mainWorkspaceAnchorPane.lookup("#importButton"));
		importButton.setOnMouseClicked(event -> {
			ArrayList<Boolean> writeToDBList = new ArrayList<Boolean>();
			for(int i=0; i< table.getItems().size(); i++) {
				CheckBox checkBox = table.getItems().get(i).getSelectCheckBox();
				if(checkBox.isSelected()) {
					System.out.println(i);
					writeToDBList.add(true);
				}else
					writeToDBList.add(false);
			}
			Boolean isSuccess = importFileChamCongController.handleImport(writeToDBList);
			if(isSuccess) {
				// Chuyen toi man hinh thong bao thanh cong
				VBox vbox = new VBox();
				vbox.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
				vbox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				Label label = new Label("Successfully Imported!");
				vbox.getChildren().add(label);
				vbox.setAlignment(Pos.CENTER);
				AnchorPane.setTopAnchor(vbox, 0.0);
				AnchorPane.setBottomAnchor(vbox, 0.0);
				AnchorPane.setRightAnchor(vbox, 0.0);
				AnchorPane.setLeftAnchor(vbox, 0.0);
				mainWorkspaceAnchorPane.getChildren().clear();
				mainWorkspaceAnchorPane.getChildren().add(vbox);
				mainWorkspaceAnchorPane.applyCss();
				mainWorkspaceAnchorPane.layout();
			}
		});
		
		System.out.println("Showed table");
	}
	
	public static void main(String [] args) {
		launch(args);
	}
}
