import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	
	@FXML
	private TextField txt;
	@FXML
	private Label lbl;
	@FXML 
	private PasswordField pin;
	@FXML
	private Button FundTransfer;
	@FXML
	private Button Withdraw;
	@FXML
	private Button MiniStatement;
	@FXML
	private Button CheckBal;
	@FXML
	private Button ChangePin;
	@FXML
	private Button ChangePhone;
	@FXML
	private Label Name;
	@FXML
	private Label notice;
	
	static String name,input,phone;
	static int id;
	public Controller() {
	}
	@FXML
	private void FundLogin(ActionEvent event) {
		Parent alpha;
		try {
			alpha = FXMLLoader.load(getClass().getResource("FundLogin.fxml"));
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
	private void Withdraw(ActionEvent event) {
		Parent alpha;
		try {
			alpha = FXMLLoader.load(getClass().getResource("WithdrawUI.fxml"));
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
	private void MiniLogin(ActionEvent event) {
		Parent alpha;
		try {
			alpha = FXMLLoader.load(getClass().getResource("MiniStatementLogin.fxml"));
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
	private void CheckBalLogin(ActionEvent event) {
		Parent alpha;
		try {
			alpha = FXMLLoader.load(getClass().getResource("CheckBalLogin.fxml"));
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
	private void pinCheckBal(ActionEvent event) {
		Parent alpha;
		try {
		/*	pin.setOnKeyTyped(e -> {
	            char input = e.getCharacter().charAt(0);
	            if (Character.isDigit(input) != true) {
	                e.consume();
	            }
	        });*/
			 input = pin.getText();
			 
			 if(input.trim().isEmpty())
				{
					notice.setText("Enter a valid pin");		
				}
				else {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/mithu?autoReconnect=true&useSSL=false","root","polkadot");
							Statement stmt=con.createStatement();  
							ResultSet rs1=stmt.executeQuery("select * from banking where pin="+input);
							int bal = -1;
							if(rs1.next()) {
								bal=rs1.getInt(7);
				
							}
							if(bal==-1) {
								notice.setText("Wrong Pin");
							}
							else {
								System.out.println(input);
								name= new Model().name(input);
								System.out.println(name);
								alpha = FXMLLoader.load(getClass().getResource("BalanceFinal.fxml"));
								Scene beta = new Scene(alpha);
								Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
								window.setScene(beta);
								window.show();
								//Name.setText(name);
								
							}
						}
						catch (Exception e) {
							// TODO: handle exception
						}
			//new WithdrawController().getName(name);
		} }catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@FXML
	private void pinCheckMini(ActionEvent event) {
		Parent alpha;
		try {
		/*	pin.setOnKeyTyped(e -> {
	            char input = e.getCharacter().charAt(0);
	            if (Character.isDigit(input) != true) {
	                e.consume();
	            }
	        });*/
			 input = pin.getText();
			 
			 if(input.trim().isEmpty())
				{
					notice.setText("Enter a valid pin");		
				}
				else {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/mithu?autoReconnect=true&useSSL=false","root","polkadot");
							Statement stmt=con.createStatement();  
							ResultSet rs1=stmt.executeQuery("select * from banking where pin="+input);
							int bal = -1;
							if(rs1.next()) {
								id=rs1.getInt(1);
								bal=rs1.getInt(7);
				
							}
							if(bal==-1) {
								notice.setText("Wrong Pin");
							}
							else {
								System.out.println(input);
								name= new Model().name(input);
								System.out.println(name);
								alpha = FXMLLoader.load(getClass().getResource("MiniStatementFinal.fxml"));
								Scene beta = new Scene(alpha);
								Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
								window.setScene(beta);
								window.show();
								//Name.setText(name);
								
							}
						}
						catch (Exception e) {
							// TODO: handle exception
						}
			//new WithdrawController().getName(name);
		} }catch (Exception e) {
			// TODO: handle exception
		}
	}
	@FXML
	private void pinCheckPhone(ActionEvent event) {
		Parent alpha;
		try {
		/*	pin.setOnKeyTyped(e -> {
	            char input = e.getCharacter().charAt(0);
	            if (Character.isDigit(input) != true) {
	                e.consume();
	            }
	        });*/
			 input = pin.getText();
			 
			 if(input.trim().isEmpty())
				{
					notice.setText("Enter a valid pin");		
				}
				else {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/mithu?autoReconnect=true&useSSL=false","root","polkadot");
							Statement stmt=con.createStatement();  
							ResultSet rs1=stmt.executeQuery("select * from banking where pin="+input);
							int bal = -1;
							if(rs1.next()) {
								bal=rs1.getInt(7);
								phone=rs1.getString(8);
							}
							if(bal==-1) {
								notice.setText("Wrong Pin");
							}
							else {
								System.out.println(input);
								name= new Model().name(input);
								System.out.println(name);
								alpha = FXMLLoader.load(getClass().getResource("PhoneChange.fxml"));
								Scene beta = new Scene(alpha);
								Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
								window.setScene(beta);
								window.show();
								//Name.setText(name);
								
							}
						}
						catch (Exception e) {
							// TODO: handle exception
						}
			//new WithdrawController().getName(name);
		} }catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	private void pinCheckPin(ActionEvent event) {
		Parent alpha;
		try {
		/*	pin.setOnKeyTyped(e -> {
	            char input = e.getCharacter().charAt(0);
	            if (Character.isDigit(input) != true) {
	                e.consume();
	            }
	        });*/
			 input = pin.getText();
			 
			 if(input.trim().isEmpty())
				{
					notice.setText("Enter a valid pin");		
				}
				else {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/mithu?autoReconnect=true&useSSL=false","root","polkadot");
							Statement stmt=con.createStatement();  
							ResultSet rs1=stmt.executeQuery("select * from banking where pin="+input);
							int bal = -1;
							if(rs1.next()) {
								bal=rs1.getInt(7);
								//phone=rs1.getString(8);
							}
							if(bal==-1) {
								notice.setText("Wrong Pin");
							}
							else {
								System.out.println(input);
								name= new Model().name(input);
								System.out.println(name);
								alpha = FXMLLoader.load(getClass().getResource("PinChange.fxml"));
								Scene beta = new Scene(alpha);
								Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
								window.setScene(beta);
								window.show();
								//Name.setText(name);
								
							}
						}
						catch (Exception e) {
							// TODO: handle exception
						}
			//new WithdrawController().getName(name);
		} }catch (Exception e) {
			// TODO: handle exception
		}
	}
	@FXML
	private void ChangePinLogin(ActionEvent event) {
		Parent alpha;
		try {
			alpha = FXMLLoader.load(getClass().getResource("ChangePinLogin.fxml"));
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
	private void ChangePhone(ActionEvent event) {
		Parent alpha;
		try {
			alpha = FXMLLoader.load(getClass().getResource("ChangePhoneLogin.fxml"));
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
	private void pinCheckWithdraw(ActionEvent event) {
		Parent alpha;
		try {
			 input = pin.getText();
			 if(input.trim().isEmpty())
				{
					notice.setText("Enter a valid pin");		
				}
				else {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/mithu?autoReconnect=true&useSSL=false","root","polkadot");
							Statement stmt=con.createStatement();  
							ResultSet rs1=stmt.executeQuery("select * from banking where pin="+input);
							int bal = -1;
							if(rs1.next()) {
								bal=rs1.getInt(7);
				
							}
							if(bal==-1) {
								notice.setText("Wrong Pin");
							}
							else {
								System.out.println(input);
								name= new Model().name(input);
								System.out.println(name);
								alpha = FXMLLoader.load(getClass().getResource("WithdrawLogin.fxml"));
								Scene beta = new Scene(alpha);
								Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
								window.setScene(beta);
								window.show();
								//Name.setText(name);
								
							}
						}
						catch (Exception e) {
							// TODO: handle exception
						}
			//new WithdrawController().getName(name);
		} }catch (Exception e) {
			// TODO: handle exception
		}
	}
	@FXML
	private void pinCheckFund(ActionEvent event) {
		Parent alpha;
		try {
			 input = pin.getText();
			 if(input.trim().isEmpty())
				{
					notice.setText("Enter a valid pin");		
				}
				else {
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/mithu?autoReconnect=true&useSSL=false","root","polkadot");
							Statement stmt=con.createStatement();  
							ResultSet rs1=stmt.executeQuery("select * from banking where pin="+input);
							int bal = -1;
							if(rs1.next()) {
								bal=rs1.getInt(7);
				
							}
							if(bal==-1) {
								notice.setText("Wrong Pin");
							}
							else {
								System.out.println(input);
								name= new Model().name(input);
								System.out.println(name);
								alpha = FXMLLoader.load(getClass().getResource("FundScreen1.fxml"));
								Scene beta = new Scene(alpha);
								Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
								window.setScene(beta);
								window.show();
								//Name.setText(name);
							}
						}
						catch (Exception e) {
							// TODO: handle exception
						}
			//new WithdrawController().getName(name);
		} }catch (Exception e) {
			// TODO: handle exception
		}
	}
	@FXML
	public String push() {
		return name;
		
	}
	@FXML
	public String push3() {
		return phone;
		
	}
	public int push4() {
		System.out.println(id);
		return id;
		
	}
	public String pin() {
		System.out.println(pin);
		return input;
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
	private void push2(ActionEvent event) {
		try {
			String input = pin.getText();
			String a= new Model().name(input);
			Name.setText(a);
			System.out.println(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
