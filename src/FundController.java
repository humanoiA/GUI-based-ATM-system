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

public class FundController implements Initializable {
	@FXML
	private Label name; 
	@FXML
	private TextField accountnumber;
	@FXML
	private Label notice;
	@FXML
	private TextField amount;
	static String accountnum,fund;
	public FundController() {
		// TODO Auto-generated constructor stub
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
	@FXML
	public void checkandpass(ActionEvent event) {
		accountnum=accountnumber.getText();
		fund=amount.getText();
		System.out.println("input----"+accountnum+"------");
		if(accountnum.trim().isEmpty())
		{
			notice.setText("Enter a valid account");		
		}
		else {
			//System.out.println(new Controller().pin());
		if(new Model().fund(new Controller().pin(), accountnum,fund).equals("yes")) {
			Parent alpha;
			try {
				alpha = FXMLLoader.load(getClass().getResource("FundScreen2.fxml"));
				Scene beta = new Scene(alpha);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.setScene(beta);
				window.show();
			} 
			catch (Exception e) {
				notice.setText("Enter a valid hmmm");			}
		}
			
		else if(new Model().fund(new Controller().pin(), accountnum,fund).equals("no")) {
	    	notice.setText("Invalid Credentials");
		}
		else if(new Model().fund(new Controller().pin(), accountnum,fund).equals("nomultiple")) {
			 notice.setText("Enough fund not available");
		}
		else if(new Model().fund(new Controller().pin(), accountnum,fund).equals("excess")) {
			notice.setText("Enter amount less than 40000");
		 }
	}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		name.setText(new Controller().push());
		accountnumber.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            accountnumber.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		}); 
		amount.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		            amount.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		}); 
	}
	public String beneficiaryname() {
		return new Model().benficiarename(accountnum);
		
		
	}
	public String cr() {
		return fund;
	}
	public String anum() {
		return accountnum;
	}

}
