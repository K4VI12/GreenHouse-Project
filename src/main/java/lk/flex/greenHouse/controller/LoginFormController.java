package lk.flex.greenHouse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.flex.greenHouse.entity.Hiumidity;
import lk.flex.greenHouse.repository.HiumidityRepository;

import java.io.IOException;

public class LoginFormController  {


    public Button btnOwnerLogin;
    public Button btnEmployeeLogin;
    public AnchorPane root;


    public void btnOwnerLoginOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/password_form.fxml"))));
        stage.setTitle("Owner Form");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnEmployeeLoginOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/password_form.fxml"))));
        stage.setTitle("Owner Form");
        stage.centerOnScreen();
        stage.show();

//        Hiumidity customer = getCustomer();
//        HiumidityRepository customerRepository = new HiumidityRepository();
//        int saveCusId = customerRepository.saveCustomer(customer);
//        System.out.println(saveCusId);

    }
    private  Hiumidity getCustomer() {
        Hiumidity hiumidity=new Hiumidity();
        hiumidity.setDate("12/9/2023");
        hiumidity.setTime("8");
        hiumidity.setHumidityStatus("80");

        return hiumidity;

    }
}
