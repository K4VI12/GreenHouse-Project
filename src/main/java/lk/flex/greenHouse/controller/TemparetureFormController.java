package lk.flex.greenHouse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.flex.greenHouse.Launcher;

import java.io.IOException;

public class TemparetureFormController {
    public Button btnHome;
    public Button btnHumidity;
    public Button btnTempeture;
    public Button btnWatersuply;
    public Button btnEmploye;
    public Text txtTemper;
    public Button btnSunlight;
    public Button btnReport;
    public Button btnSettings;
    public AnchorPane root;


    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"))));
        stage.setTitle("Owner Form");
        stage.centerOnScreen();
        stage.show();

    }

    public void btnHumidityOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/humidty_form.fxml"))));
        stage.setTitle("Owner Form");
        stage.centerOnScreen();
        stage.show();

    }

    public void btnWatersuplyOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/waterSpply_form.fxml"))));
        stage.setTitle("Owner Form");
        stage.centerOnScreen();
        stage.show();

    }

    public void btnSunlightOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/soil_moisture_form.fxml"))));
        stage.setTitle("Owner Form");
        stage.centerOnScreen();
        stage.show();

    }

    public void btnEmployeOnAction(ActionEvent actionEvent) {

    }

    public void btnReportOnAction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/temprature_status_form.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void btnSettingsOnAction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/humidity_settings_form.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    }

    public void btnTempetureOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/tempareture_form.fxml"))));
        stage.setTitle("Owner Form");
        stage.centerOnScreen();
        stage.show();

    }

    public void initialize() {
        txtTemper.setText(Launcher.secondword+"%");
    }
}
