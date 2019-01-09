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

public class WithdrawController implements Initializable {
	@FXML
	private Label name; 
	@FXML
	private TextField amount;
	@FXML
	private Label notice;
	public WithdrawController() {
		// TODO Auto-generated constructor stub
	}
		
	public void CashFlow(ActionEvent event) {
	//	try {
	/*	amount.setOnKeyTyped(e -> {
            char input = e.getCharacter().charAt(0);
            if (Character.isDigit(input) != true) {
                e.consume();
                amount.setText(null);
            }
        });*/
		String a=amount.getText();
		System.out.println("input----"+a+"------");
		if(a.trim().isEmpty())
		{
			notice.setText("Enter a valid amount");		
		}
		else {
			System.out.println(new Controller().pin());
		if(new Model().withdraw(new Controller().pin(), a).equals("yes")) {
			Parent alpha;
			try {
				alpha = FXMLLoader.load(getClass().getResource("WithdrawFinal.fxml"));
				Scene beta = new Scene(alpha);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				window.setScene(beta);
				window.show();
			} 
			catch (Exception e) {
				notice.setText("Enter a valid amount");			}
		}
			
		else if(new Model().withdraw(new Controller().pin(), a).equals("fundissue")) {
	    	notice.setText("Enough Fund Not Available");
		}
		else if(new Model().withdraw(new Controller().pin(), a).equals("nomultiple")) {
			 notice.setText("Enter amount in multiple of Five Hundred");
		}
		else if(new Model().withdraw(new Controller().pin(), a).equals("empty")) {
			notice.setText("Enter amount less than 40000");
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
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		name.setText(new Controller().push());
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

}
