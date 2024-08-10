package lk.flex.greenHouse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class WaterSpplyFormController {
    public Button btnHome;
    public Button btnHumidity;
    public Button btnTempeture;
    public Button btnWatersuply;
    public Button btnSunlight;
    public Button btnSetting;
    public Button btnEmploye;
    public Button btnReport;
    public Button btnWaterSuplySettings;
    public TableView tblWaterSuply;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colSprincurse;
    public TableColumn colHisturesline;


    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"));
        Stage window = (Stage)btnHome.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));

    }

    public void btnHumidityOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/view/humidty_form.fxml"));
        Stage window = (Stage)btnHumidity.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));

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

    public void btnSettingOnAction(ActionEvent actionEvent) {

    }

    public void btnEmployeOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/view/logout_form.fxml"));
        Stage window = (Stage)btnEmploye.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));

    }

    public void btnReportOnAction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/waterlevel_status_form.fxml"));
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

    public void btnWaterSuplySettingsOnAction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/watersupply_settings_form.fxml"));
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
}
