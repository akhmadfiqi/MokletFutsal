package mokletfutsal;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class anggotaController implements Initializable {

    @FXML
    private TableView<tabelanggota> tabel;

    @FXML
    private TableColumn<tabelanggota, String> namalist;

    @FXML
    private TableColumn<tabelanggota, String> kelaslist;

    @FXML
    private TableColumn<tabelanggota, String> lahirlist;

    @FXML
    private TableColumn<tabelanggota, String> alamatlist;

    @FXML
    private TableColumn<tabelanggota, String> posisilist;

    @FXML
    private JFXButton keluarl;

    @FXML
    private JFXButton updatel;
    
    private ObservableList<tabelanggota> data;
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    @FXML
    private JFXButton hps;
    
    @FXML
    void kell(ActionEvent event) {
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        konek DB = new konek();
        DB.config();
        con = DB.con;
        stat = DB.stm;
    }    
    @FXML
    void upl(ActionEvent event) {
        try {
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = stat.executeQuery("SELECT * FROM data");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new tabelanggota(rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6)));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        namalist.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kelaslist.setCellValueFactory(new PropertyValueFactory<>("kelas"));
        lahirlist.setCellValueFactory(new PropertyValueFactory<>("lahir"));
        alamatlist.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        posisilist.setCellValueFactory(new PropertyValueFactory<>("posisi"));
        
        tabel.setItems(data);
        
    }
    
}