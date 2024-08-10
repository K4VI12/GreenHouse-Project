package lk.flex.greenHouse.controller;//import com.mysql.cj.protocol.Resultset;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PasswordFormController implements Initializable {

    public Text tmeadd;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public Button btnForgetPassword;
    public Button btnSingIn;
    public AnchorPane root;
    public CheckBox chckBxRemember;

    private boolean bool = true,boo = false;
    private String name = "1";
    @FXML
    private String password = "1";
    private int num = 2 ;
    private String sqlusername ;
    private String sqlpassword ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread() {
            public void run() {
                while(bool) {
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e){}
                    if((txtUserName.getText().equals("")||txtUserName.getText().equals(null))||(txtPassword.getText().equals("")||txtPassword.getText().equals(null))){
                        chckBxRemember.setSelected(false);
                        chckBxRemember.setDisable(true);
                        chckBxRemember.setDisable(true);
                    }else{
                        chckBxRemember.setDisable(false);
                        if(chckBxRemember.isSelected()==true){
                            btnSingIn.setDisable(false);
                        }else{
                            btnSingIn.setDisable(true);
                        }
                    }
                }
            }
        }.start();

    }

    public void setboo(boolean boo){
        boo = true;
    }

    public void keyPressed(KeyEvent keyEvent) {
    }

    public void mousePressed(MouseEvent mouseEvent) {
    }

//    public void checkPassword(){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String sql;
//            Statement statement;
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/green_house", "root", "1234");
//                sql = "SELECT * from password";
//                statement = con.createStatement();
//
//            ResultSet result = statement.executeQuery(sql);
//                if (result.next()) {
//                    System.out.println("ok");
//                    sqlusername = result.getString(1);
//                    sqlpassword = result.getString(2);
//                    System.out.println(sqlusername);
//                }
//
//                    if (sqlusername.equals(usernametxt.getText()) || sqlpassword.equals(passwordtxt.getText())) {
//                        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("third_form.fxml"));
//                        Stage window = (Stage) signinbtn.getScene().getWindow();
//                        window.setScene(new Scene(fxmlLoader, 1193, 666));
//                    } else {
//                        for (int i = num - 1; i < num; i++) {
//                            if (i != 4) {
//                                System.out.println(num);
//                                System.out.println("Manager");
//                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginwaring_form.fxml"));
//                                Parent root1 = null;
//                                try {
//                                    root1 = (Parent) fxmlLoader.load();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                                Stage stage = new Stage();
//                                stage.setScene(new Scene(root1));
//                                stage.initModality(Modality.WINDOW_MODAL);
//                                stage.show();
//                            } else {
//                                System.out.println("Disable mode");
//                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("warinngmassage2_form.fxml"));
//                                Parent root1 = null;
//                                try {
//                                    root1 = (Parent) fxmlLoader.load();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                                Stage stage = new Stage();
//                                stage.setScene(new Scene(root1));
//                                stage.initModality(Modality.WINDOW_MODAL);
//                                stage.show();
//                                System.out.println("Disable");
//                                usernametxt.setDisable(true);
//                                passwordtxt.setDisable(true);
//
//                                nowtimetxt.setVisible(true);
//                                tmeadd.setVisible(true);
//
//                                new Thread() {
//                                    public void run() {
//                                        try {
//                                            for (int v = 0; v < 61; v++) {
//                                                Thread.sleep(1500);
//                                                tmeadd.setText(" " + v);
//                                                if (v == 60) {
//                                                    num = 2;
//                                                    usernametxt.setDisable(false);
//                                                    passwordtxt.setDisable(false);
//                                                    nowtimetxt.setVisible(false);
//                                                    tmeadd.setVisible(false);
//                                                }
//                                            }
//
//                                        } catch (Exception e) {
//                                        }
//                                    }
//                                }.start();
//                            }
//                        }
//                        num++;
//                        usernametxt.setText("");
//                        passwordtxt.setText("");
//                    }
//                    System.out.println(sqlusername + "," + sqlpassword);
//                    //Serialport sr =  new Serialport();
//
//        } catch (ClassNotFoundException | SQLException | IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void btnForgetPasswordOnAction(ActionEvent actionEvent) {

    }

    public void btnSingInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dash_board_form.fxml"))));
        stage.setTitle("Owner Form");
        stage.centerOnScreen();
        stage.show();

    }
}
