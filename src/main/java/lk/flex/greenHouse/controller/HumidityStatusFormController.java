package lk.flex.greenHouse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.flex.greenHouse.entity.Hiumidity;
import lk.flex.greenHouse.repository.HiumidityRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HumidityStatusFormController implements Initializable {
    public TableView tblHumidity;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colStatus;

    private HiumidityRepository hiumidityRepository=new HiumidityRepository();

    private void getAll()  {

        try {
            ObservableList<Hiumidity> obList = FXCollections.observableArrayList();
            List<Hiumidity> cusList = hiumidityRepository.getAll();

            for (Hiumidity hiumidity : cusList) {
                obList.add(new Hiumidity(
//                        room.getRoomTypeId(),
//                        room.getType(),
//                        room.getKey_money(),
//                        room.getQty()
                        hiumidity.getDate(),
                        hiumidity.getTime(),
                        hiumidity.getHumidityStatus()

                ));
            }
            tblHumidity.refresh();
            tblHumidity.setItems(obList);
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
    private void setCellValueFactory() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("humidityStatus"));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
        setCellValueFactory();
        tblHumidity.refresh();
    }
}
