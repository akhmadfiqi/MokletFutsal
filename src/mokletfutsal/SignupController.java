package mokletfutsal;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class SignupController implements Initializable {

    @FXML
    private TextField alamats;
    @FXML
    private TextField posisis;
    @FXML
    private TextField ttls;
    @FXML
    private TextField kelass;
    @FXML
    private TextField namas;
    @FXML
    private JFXButton daftars;

    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        konek DB = new konek();
        DB.config();
        con = DB.con;
        stat = DB.stm;
    }    
    @FXML
    void daftar(ActionEvent event) throws SQLException {
      String alamat=alamats.getText();
      String posisi=posisis.getText();
      String ttl=ttls.getText();
      String kelas=kelass.getText();
      String nama=namas.getText();
      int i = stat.executeUpdate("INSERT INTO data(nama,kelas,ttl,alamat,posisi) VALUES('"+nama+"','"+kelas+"','"+ttl+"','"+alamat+"','"+posisi+"')");
      if(i == 1){
        System.out.println("berhasil!");
        JOptionPane.showMessageDialog(null, "berhasil daftar!");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Tekan YES untuk Mendaftaraftar LAGI dan Tekn NO unuk Menuju List Peserta", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES){
            JOptionPane.showMessageDialog(null, "Silahkan isi Formulir Peserta !");
        }else if(alert.getResult() == ButtonType.NO){
            try {
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
            
            } catch (IOException e) {
                System.out.println("Failed to create new Window." + e);
            }  
        }
        
      }
      
    }
    @FXML
    void kels(ActionEvent event) {
try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("welcome.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Futsal");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
        }
    }