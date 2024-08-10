package lk.flex.greenHouse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.flex.greenHouse.Launcher;
import lk.flex.greenHouse.entity.SoilMoisture;
import lk.flex.greenHouse.entity.Temperature;
import lk.flex.greenHouse.repository.SoilMoistureRepository;
import lk.flex.greenHouse.repository.TemperatureRepository;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SoilMoistureFormController implements Initializable {
    public Button btnDaly;
    public Button btnMonthly;
    public Button btnWeekly;
    public Button btnHome;
    public Button btnHumidity;
    public Button btnTempeture;
    public Button btnWatersuply;
    public Button btnSunlight;
    public Button btnSetting;
    public Button btnEmploye;
    public TableView tblSoilMoisture;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colStatus;
    private SoilMoistureRepository soilMoistureRepository=new SoilMoistureRepository();


    public void btnDalyOnAction(ActionEvent actionEvent) {

    }

    public void btnMonthlyOnAction(ActionEvent actionEvent) {

    }

    public void btnWeeklyOnAction(ActionEvent actionEvent) {

    }

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

    public void btnSettingOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/view/humidty_form.fxml"));
        Stage window = (Stage)btnSetting.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));

    }

    public void btnEmployeOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("/view/humidty_form.fxml"));
        Stage window = (Stage)btnEmploye.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));

    }
    private void getAll()  {
        try {
            ObservableList<SoilMoisture> obList = FXCollections.observableArrayList();
            List<SoilMoisture> cusList = soilMoistureRepository.getAll();

            for (SoilMoisture soilMoisture : cusList) {
                obList.add(new SoilMoisture(
                        soilMoisture.getDate(),
                        soilMoisture.getTime(),
                        soilMoisture.getSoilMoistureStatus()

                ));
            }
            tblSoilMoisture.refresh();
            tblSoilMoisture.setItems(obList);
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
    private void setCellValueFactory() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("soilMoistureStatus"));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
        setCellValueFactory();
        tblSoilMoisture.refresh();
    }
}
