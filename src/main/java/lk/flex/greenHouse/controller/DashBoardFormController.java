package lk.flex.greenHouse.controller;

import com.fazecast.jSerialComm.SerialPort;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.flex.greenHouse.Launcher;
import lk.flex.greenHouse.entity.Hiumidity;
import lk.flex.greenHouse.entity.SoilMoisture;
import lk.flex.greenHouse.entity.Temperature;
import lk.flex.greenHouse.repository.HiumidityRepository;
import lk.flex.greenHouse.repository.SoilMoistureRepository;
import lk.flex.greenHouse.repository.TemperatureRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {
    public Button btnHome;
    public Button btnHumidity;
    public Button btnTempeture;
    public Button btnwaterSuply;
    public Button btnSunlight;
    public Button btnSetting;
    public Button btnEmployee;
    public Text txtTime;
    public Text txtDate;
    public Text txtYear;
    public AnchorPane root;
    public Text txtHumidy;
    public Text txtSoilt;
    public Text txtTemper;
    private String humi;
    char a;
    char b;


    private boolean bool = true;
    public String time,date,year;
    public String nowwhether;
    public javafx.scene.control.Button homebtn;
    public javafx.scene.control.Button humiditybtn;
    public javafx.scene.control.Button tempeturebtn;
    public javafx.scene.control.Button watersuplybtn;
    public javafx.scene.control.Button sunlightbtn;
    public javafx.scene.control.Button settingbtn;
    public javafx.scene.control.Button employebtn;

//    private static final int TIMEOUT_WRITE_BLOCKING = 2000;
//    public String firstword;
//    public String thirdword;
//    public String secondword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        new Thread() {
            public void run() {
                while(bool) {
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e){}
                    Date currentDate = new Date();
                    SimpleDateFormat clockFormat = new SimpleDateFormat("h:mm:s a");
                    time = (clockFormat.format(currentDate));
                    txtTime.setText(time);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE ");
                    date = (dateFormat.format(currentDate));
                    txtDate.setText(date);

                    SimpleDateFormat yearFormat = new SimpleDateFormat("MMMM dd,yyyy");
                    year = (yearFormat.format(currentDate));
                    txtYear.setText(year);

                    txtHumidy.setText(Launcher.firstword+"%");
                    txtTemper.setText(Launcher.secondword);
                    txtSoilt.setText(Launcher.thirdword+"%");

                    String i = time;
                    String[] words = time.split("\\s+");
                    String firstword = words[0];
                    String secondword = words[1];

                    char[] chars=firstword.toCharArray();
                    char a=firstword.charAt(chars.length-2);
                    char b=firstword.charAt(chars.length-1);
                    char c=firstword.charAt(chars.length-4);
                    char d=firstword.charAt(chars.length-5);
//                    System.out.println(a);
//                    System.out.println(b);
//                    System.out.println(c);
//                    System.out.println(d);

                        if (a=='2' && b=='1'  && d=='0' && c=='0'){
                            //humidity status save
                            Hiumidity customer = getHiumidity();
                            HiumidityRepository customerRepository = new HiumidityRepository();
                            customerRepository.save(customer);

                            //temperature save
                            Temperature temperature=getTemperature();
                            TemperatureRepository temperatureRepository=new TemperatureRepository();
                            temperatureRepository.save(temperature);

                            //soilmoisture save
                            SoilMoisture soilMoisture=getSoilMoisture();
                            SoilMoistureRepository soilMoistureRepository=new SoilMoistureRepository();
                            soilMoistureRepository.save(soilMoisture);
                            System.out.println("complete");
                        }
                }
            }
        }.start();

//        new Thread() {
//            public void run() {
//                while(bool) {
//                    try {
//                        Thread.sleep(1000);
//                    }catch(Exception e){}
//                    nowwhether = sunlightwhether.getText();
//                    if(nowwhether.equals("Mid")){
//                        sunlightnew.setVisible(false);
//                        raincloud.setVisible(true);
//                    }else{
//                        raincloud.setVisible(false);
//                        sunlightnew.setVisible(true);
//                    }
//                }
//            }
//        }.start();

//        SerialPort sp =  SerialPort.getCommPort("COM4");
//        sp.setComPortParameters(9600,8,1,0);
//        sp.setComPortTimeouts(TIMEOUT_WRITE_BLOCKING,2000,0);
//
//        if(sp.openPort()){
//            System.out.println("open serial");
//
//        }else{
//            System.out.println("port not opened ");
//            return;
//        }
//        InputStream inputStream = sp.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//
//
//        BufferedReader reader = new BufferedReader(inputStreamReader);
//
//        new Thread(() -> {
//            while (true) {
//                try {
//                    String line = reader.readLine();
//
//                    if (line != null) {
//                        String humidityValue = line.substring(line.indexOf(":") + 1).trim();
//
//                        String sentence = humidityValue;
//                        String[] words = sentence.split("\\s+");
//                        firstword = words[0];
//                        secondword = words[1];
//                        thirdword = words[2];
//                        System.out.println(firstword);
//                        System.out.println(secondword);
//                        System.out.println(thirdword);
//
//                        txtHumidy.setText(firstword+"%");
//                        txtTemper.setText(secondword);
//                        txtSoilt.setText(Math.abs(Integer.parseInt(thirdword))+"%");
//
//                    }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }).start();

//        StatusController statusController=new StatusController();
//
//        String huminity=statusController.getSetHumidityStatus();
//        String temperature=statusController.getSetTemperatureStatus();
//        String soil=statusController.getSetSoilMoistureStatus();
//
//        txtHumidy.setText(huminity+"%");
//        txtTemper.setText(temperature);
//        txtSoilt.setText(Math.abs(Integer.parseInt(soil))+"%");

       // if()


    }
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

    public void btnTempetureOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/tempareture_form.fxml"))));
        stage.setTitle("Owner Form");
        stage.centerOnScreen();
        stage.show();

    }

    public void btnwaterSuplyOnAction(ActionEvent actionEvent) throws IOException {
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

    public void btnSettingOnAction(ActionEvent actionEvent) throws IOException {
//        Stage stage = (Stage) root.getScene().getWindow();
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/third_form.fxml"))));
//        stage.setTitle("Owner Form");
//        stage.centerOnScreen();
//        stage.show();

    }

    public void btnEmployeeOnAction(ActionEvent actionEvent) {

    }
    private Hiumidity  getHiumidity() {
        Hiumidity hiumidity=new Hiumidity();
        hiumidity.setDate(txtYear.getText());
        hiumidity.setTime(txtTime.getText());
        hiumidity.setHumidityStatus(txtHumidy.getText());

        return hiumidity;

    }
    private Temperature getTemperature() {
        Temperature temperature=new Temperature();
        temperature.setDate(txtYear.getText());
        temperature.setTime(txtTime.getText());
        temperature.setTemperatureStatus(txtTemper.getText());

        return temperature;

    }
    private SoilMoisture getSoilMoisture() {
        SoilMoisture soilMoisture=new SoilMoisture();
        soilMoisture.setDate(txtYear.getText());
        soilMoisture.setTime(txtTime.getText());
        soilMoisture.setSoilMoistureStatus(txtSoilt.getText());

        return soilMoisture;

    }



}
