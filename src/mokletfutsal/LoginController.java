package mokletfutsal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {

    @FXML
    private JFXButton loginl;
    @FXML
    private JFXTextField usernamel;
    @FXML
    private JFXPasswordField passwordl;
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    konek DB = new konek();
        DB.config();
        con = DB.con;
        stat = DB.stm;
    } 
     @FXML
    void login(ActionEvent event) {
    try {
            sql = "SELECT * FROM admin WHERE username='"+usernamel.getText()+"' AND password='"+passwordl.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(usernamel.getText().equals(rs.getString("username")) && passwordl.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "berhasil login!");
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Tekan YES untuk Menuju Daftar dan Tekan NO unuk Menuju List Anggota", ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();

                    if(alert.getResult() == ButtonType.YES){
                        // Hide this current window (if this is what you want)
                        ((Node)(event.getSource())).getScene().getWindow().hide();

                        // Load the new fxml
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("signup.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());

                        // Create new stage (window), then set the new Scene
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("Futsal");
                        stage.show();
                    }else if(alert.getResult() == ButtonType.NO){
                        // Hide this current window (if this is what you want)
                        ((Node)(event.getSource())).getScene().getWindow().hide();

                        // Load the new fxml
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("listanggota.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());

                        // Create new stage (window), then set the new Scene
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("Futsal");
                        stage.show();
                    }
                        
                }
            }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
