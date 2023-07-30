package project.itss.group11.itss.controller;


import javafx.event.ActionEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseController extends ChangeSceneControllers {

    protected Logger logger = LogManager.getLogger(this.getClass());
    public void onUserTemplate(ActionEvent event) {
        changeScene("UserTemplate.fxml");
    }

    public void onManagermentTemplate(ActionEvent event) {
        changeScene("ManagementTemplate.fxml");
    }

    public void onHRMTemplate(ActionEvent event) {
        changeScene("HRMTemplate.fxml");
    }

    public void onLogout(ActionEvent event){
        changeScene("Login.fxml");
    }
}
