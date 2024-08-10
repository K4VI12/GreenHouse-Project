package lk.flex.greenHouse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.flex.greenHouse.entity.Temperature;
import lk.flex.greenHouse.repository.TemperatureRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TempratureStatusFormController implements Initializable{
    public TableView tblTemperature;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colClinate;

    private TemperatureRepository temperatureRepository=new TemperatureRepository();

    private void getAll()  {

        try {
            ObservableList<Temperature> obList = FXCollections.observableArrayList();
            List<Temperature> cusList = temperatureRepository.getAll();

            for (Temperature temperature : cusList) {
                obList.add(new Temperature(
                        temperature.getDate(),
                        temperature.getTime(),
                        temperature.getTemperatureStatus()

                ));
            }
            tblTemperature.refresh();
            tblTemperature.setItems(obList);
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
    private void setCellValueFactory() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colClinate.setCellValueFactory(new PropertyValueFactory<>("temperatureStatus"));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
        setCellValueFactory();
        tblTemperature.refresh();
    }
}
