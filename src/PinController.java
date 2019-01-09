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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PinController implements Initializable {

	@FXML
	private Label name; 
	@FXML
	private PasswordField pin1,pin2;
	@FXML
	private Label notice;
	public PinController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	public void PinChange(ActionEvent event) {
		//	try {
		/*	amount.setOnKeyTyped(e -> {
	            char input = e.getCharacter().charAt(0);
	            if (Character.isDigit(input) != true) {
	                e.consume();
	                amount.setText(null);
	            }
	        });*/
			String a=pin1.getText();
			String b=pin2.getText();
			System.out.println("input----"+a+"------");
			if(a.trim().isEmpty()||b.trim().isEmpty())
			{
				notice.setText("Enter a valid Pin");		
			}
			else if(!a.equals(b)) {
				notice.setText("Pin does not match.");	
			}
			else {
			if(new Model().Pin(new Controller().pin(), a).equals("yes")) {
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
				
			else if(new Model().Pin(new Controller().pin(), a).equals("empty")) {
				notice.setText("Enter a valid Pin");
			 }
		}
		}
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
		// TODO Auto-generated method stub
		name.setText(new Controller().push());
		pin1.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            pin1.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		}); 
		pin2.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            pin2.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		}); 
	}

}
