package project.itss.group11.itss.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.itss.group11.itss.HelloApplication;
import project.itss.group11.itss.Until.ConnectionPool;
import project.itss.group11.itss.Until.Constant;
import project.itss.group11.itss.model.Employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserTemplateController extends BaseController implements Initializable {

    @FXML
    private Button timekeepingRequestBtn;

    @FXML
    private Button timekeepingViewBtn;

    @FXML
    private Label id ;

    @FXML
    private Text name;

    private Employee user;


    @FXML
    void selectRequestingToEditTimekeepingScreen(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.user = Constant.employee;
        id.setText(String.valueOf(user.getID()));
        name.setText(user.getName());
    }

    @FXML
    void selectViewingTimekeepingScreen(ActionEvent event) {
        try {
            changeScene("staff/XemTQNV.fxml");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error at selectViewingTimekeepingScreen function at UserTemplateController");
        }
    }

    public Employee getUser() {
        return user;
    }

}