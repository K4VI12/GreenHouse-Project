package lk.flex.greenHouse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.flex.greenHouse.Launcher;

import java.io.IOException;

public class HumidtyFormController {
    public Text humidityLvl;
    public Button btnHome;
    public Button btnHumidity;
    public Button btnTempeture;
    public Button btnWatersuply;
    public Button btnSunlight;
    public Button btnEmploye;
    public Button btnSetting;
    public Button btnReport;
    public Button btnSettings;

    public void settingOnAction(ActionEvent actionEvent) {
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

    public void reportOnAction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/humidity_status_form.fxml"));
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
    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"));
        Stage window = (Stage)btnHome.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));

    }

    public void btnHumidityOnAction(ActionEvent actionEvent) {


    }

    public void btnTempetureOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/view/tempareture_form.fxml"));
        Stage window = (Stage)btnTempeture.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));

    }

    public void btnWatersuplyOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/view/waterSpply_form.fxml"));
        Stage window = (Stage)btnWatersuply.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));

    }

    public void btnSunlightOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/view/soil_moisture_form.fxml"));
        Stage window = (Stage)btnSunlight.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));

    }

    public void btnEmployeOnAction(ActionEvent actionEvent) {

    }

    public void btnSettingOnAction(ActionEvent actionEvent) {

    }

    public void btnReportOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/humidity_status_form.fxml"));
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

    public void btnSettingsOnAction(ActionEvent actionEvent) throws IOException {
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


    public void initialize() {
        humidityLvl.setText(Launcher.firstword+"%");
    }
}
