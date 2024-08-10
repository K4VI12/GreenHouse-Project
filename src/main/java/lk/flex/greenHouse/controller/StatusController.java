package lk.flex.greenHouse.controller;

import com.fazecast.jSerialComm.SerialPort;
import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

public class StatusController implements Initializable {
    private static final int TIMEOUT_WRITE_BLOCKING = 2000;
    private String setHumidityStatus;
    private String setTemperatureStatus;
    private String setSoilMoistureStatus;


    public void initialize(URL location, ResourceBundle resources) {
        SerialPort sp = SerialPort.getCommPort("COM4");
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(TIMEOUT_WRITE_BLOCKING, 2000, 0);

        if (sp.openPort()) {
            System.out.println("open serial");

        } else {
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
                        setHumidityStatus = words[0];
                        setTemperatureStatus = words[1];
                        setSoilMoistureStatus = words[2];
                        System.out.println(setHumidityStatus);
                        System.out.println(setTemperatureStatus);
                        System.out.println(setSoilMoistureStatus);


                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
//    public String setHumidityStatus(){
//        return firstword;
//    }
//    public String setTemperatureStatus(){
//        return secondword;
//    }
//    public String setSoilMoistureStatus(){
//        return thirdword;
//    }


    public StatusController() {
    }

    public StatusController(String setHumidityStatus, String setTemperatureStatus, String setSoilMoistureStatus) {
        this.setHumidityStatus = setHumidityStatus;
        this.setTemperatureStatus = setTemperatureStatus;
        this.setSoilMoistureStatus = setSoilMoistureStatus;
    }

    public String getSetHumidityStatus() {
        return setHumidityStatus;
    }

    public void setSetHumidityStatus(String setHumidityStatus) {
        this.setHumidityStatus = setHumidityStatus;
    }

    public String getSetTemperatureStatus() {
        return setTemperatureStatus;
    }

    public void setSetTemperatureStatus(String setTemperatureStatus) {
        this.setTemperatureStatus = setTemperatureStatus;
    }

    public String getSetSoilMoistureStatus() {
        return setSoilMoistureStatus;
    }

    public void setSetSoilMoistureStatus(String setSoilMoistureStatus) {
        this.setSoilMoistureStatus = setSoilMoistureStatus;
    }
}
