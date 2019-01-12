import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MiniController implements Initializable {

	@FXML
	private Label name;
	@FXML
	private TableView<ModelTable> table;
	@FXML
	private TableColumn<ModelTable, String> col_tra;
	@FXML
	private TableColumn<ModelTable, String> col_amount;
	@FXML
	private TableColumn<ModelTable, String> col_portal;
	@FXML
	private TableColumn<ModelTable, String> col_time;
	@FXML
	private TableColumn<ModelTable, String> col_bal;
	
	public MiniController() {
		// TODO Auto-generated constructor stub
	}
	ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
	

	@FXML
	public void Home(ActionEvent event) {
		Parent alpha;
		try {
			alpha = FXMLLoader.load(getClass().getResource("UIFront.fxml"));
			Scene beta = new Scene(alpha);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(beta);
			window.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		name.setText("Welcome,"+new Controller().push() +". Below is your Mini Statement.");
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://sql12.freemysqlhosting.net/sql12273806?autoReconnect=true&useSSL=false","sql12273806","je4N38nbVu");
			Statement stmt=con.createStatement();
			ResultSet rs1=stmt.executeQuery("select * from transactions where id="+new Controller().push4());
			while(rs1.next()) {
				oblist.add(new ModelTable(String.valueOf(rs1.getInt(1)), rs1.getString(3), rs1.getString(4), String.valueOf(rs1.getTimestamp(5)), String.valueOf(rs1.getInt(6))));
				System.out.println(String.valueOf(rs1.getInt(1))+" .. "+String.valueOf(rs1.getTimestamp(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		col_tra.setCellValueFactory(new PropertyValueFactory<>("Transactionid"));
		col_amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
		col_portal.setCellValueFactory(new PropertyValueFactory<>("Portal"));
		col_time.setCellValueFactory(new PropertyValueFactory<>("Dateandtime"));
		col_bal.setCellValueFactory(new PropertyValueFactory<>("Balance"));
		table.setItems(oblist);

	}

}
