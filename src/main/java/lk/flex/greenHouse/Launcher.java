package lk.flex.greenHouse;

import com.fazecast.jSerialComm.SerialPort;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.flex.greenHouse.config.SessionFactoryConfig;
import lk.flex.greenHouse.entity.Hiumidity;
import lk.flex.greenHouse.repository.HiumidityRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Launcher extends Application {
    private static final int TIMEOUT_WRITE_BLOCKING = 2000;
    public static String firstword;
    public static String thirdword;
    public static String secondword;
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/login_form.fxml")));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Login Form");
        primaryStage.centerOnScreen();
        primaryStage.show();

        SerialPort sp =  SerialPort.getCommPort("COM5" +
                " ");
        sp.setComPortParameters(9600,8,1,0);
        sp.setComPortTimeouts(TIMEOUT_WRITE_BLOCKING,2000,0);

        if(sp.openPort()){
            System.out.println("open serial");

        }else{
            System.out.println("port not opened ");
            return;
        }
        InputStream inputStream = sp.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);


        BufferedReader reader = new BufferedReader(inputStreamReader);

        new Thread(() -> {
            while (true) {
                try {
                    String line = reader.readLine();

                    if (line != null) {
                        String humidityValue = line.substring(line.indexOf(":") + 1).trim();

                        String sentence = humidityValue;
                        String[] words = sentence.split("\\s+");
                        firstword = words[0];
                        secondword = words[1];
                        thirdword = words[2];
                        System.out.println(firstword);
                        System.out.println(secondword);
                        System.out.println(thirdword);

//                            txtHumidy.setText(firstword+"%");
//                            txtTemper.setText(secondword);
//                            txtSoilt.setText(Math.abs(Integer.parseInt(thirdword))+"%");

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    public String setHumidityStatus(){
    return firstword;
    }
    public String setTemperatureStatus(){
        return secondword;
    }
    public String setSoilMoistureStatus(){
        return thirdword;
    }

}
