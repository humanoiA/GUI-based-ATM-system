import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PhoneController implements Initializable{

	@FXML
	private Label name; 
	@FXML
	private TextField phone;
	@FXML
	private Label notice;
	@FXML
	private Label oldnum;
	public PhoneController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	public void PhoneChange(ActionEvent event) {
		//	try {
		/*	amount.setOnKeyTyped(e -> {
	            char input = e.getCharacter().charAt(0);
	            if (Character.isDigit(input) != true) {
	                e.consume();
	                amount.setText(null);
	            }
	        });*/
			String a=phone.getText();
			System.out.println("input----"+a+"------");
			if(a.trim().isEmpty())
			{
				notice.setText("Enter a valid Number");		
			}
			else {
			if(new Model().Phone(new Controller().pin(), a).equals("yes")) {
				Parent alpha;
				try {
					alpha = FXMLLoader.load(getClass().getResource("PhoneSuccess.fxml"));
					Scene beta = new Scene(alpha);
					Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
					window.setScene(beta);
					window.show();
				} 
				catch (Exception e) {
					notice.setText("Enter a valid number");			}
			}
				
			else if(new Model().Phone(new Controller().pin(), a).equals("empty")) {
				notice.setText("Enter a valid Number");
			 }
		}
		}
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
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		name.setText(new Controller().push());
		oldnum.setText(new Controller().push3());
		phone.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            phone.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		}); 
	}

}
