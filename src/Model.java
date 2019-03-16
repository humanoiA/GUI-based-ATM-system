import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Model {

	public Model() {
		// TODO Auto-generated constructor stub
	}
	public String withdraw(String a,String amount) {
		String b = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://remotemysql.com/gR2fa7dl4U?autoReconnect=true&useSSL=false","gR2fa7dl4U","H8196rO3po");
			Statement stmt=con.createStatement();  
			ResultSet rs1=stmt.executeQuery("select * from banking where pin="+a);
			int bal = -1,id=1;
			if(rs1.next()) {
				bal=rs1.getInt(7);
				id=rs1.getInt(1);
			}
			if(bal==-1) {
				return "wrongpin";
			}
			BigInteger c = new BigInteger(amount);
			BigInteger lim = new BigInteger("40000");
			System.out.println(bal);
			if(c.compareTo(lim)==1)
				return "empty";
			else if(Integer.parseInt(amount)<=bal)
			{	
				if(Integer.parseInt(amount)%500==0)
				bal-=Integer.parseInt(amount);
				else 
					return "nomultiple";
			}
			else
				return "fundissue";
			b=String.valueOf(bal);
			System.out.println(bal);
			stmt.executeUpdate("update banking set balance="+bal+" where pin="+a);
			stmt.executeUpdate("insert into transactions(id,amount,portal,dateandtime,balance) values("+id+","+"-"+amount+","+"\'ATM\'"+","+"NOW()"+","+bal+")");
		//	ResultSet rs1=stmt.executeQuery("select * from banking where pin="+pin);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "yes";
	}
	public String name(String a) {
		String b="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://remotemysql.com/gR2fa7dl4U?autoReconnect=true&useSSL=false","gR2fa7dl4U","H8196rO3po");
			Statement stmt=con.createStatement();  
			ResultSet rs1=stmt.executeQuery("select * from banking where pin="+a);
			if(rs1.next()) {
				b=rs1.getString(5)+" "+rs1.getString(6);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(b);
		return b;
	}
	public String getbal(String a) {
		String b="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://remotemysql.com/gR2fa7dl4U?autoReconnect=true&useSSL=false","gR2fa7dl4U","H8196rO3po");
			Statement stmt=con.createStatement();  
			ResultSet rs1=stmt.executeQuery("select * from banking where pin="+a);
			int bal = -1;
			if(rs1.next()) {
				bal=rs1.getInt(7);
			}
			b=String.valueOf(bal);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(b);
		return b;
	}
	public String Phone(String a,String phone) {
		String phone2 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://remotemysql.com/gR2fa7dl4U?autoReconnect=true&useSSL=false","gR2fa7dl4U","H8196rO3po");
			Statement stmt=con.createStatement();  
			ResultSet rs1=stmt.executeQuery("select * from banking where pin="+a);
			int bal = -1;
			if(rs1.next()) {
				bal=rs1.getInt(7);		
			}
			if(bal==-1) {
				return "wrongpin";
			}
			BigInteger c = new BigInteger(phone);
			BigInteger lim = new BigInteger("10000000000");
			System.out.println(bal);
			if(c.compareTo(lim)==1)
				return "empty";
			//b=String.valueOf(bal);
			System.out.println(bal);
			stmt.executeUpdate("update banking set phone="+phone+" where pin="+a);//	ResultSet rs1=stmt.executeQuery("select * from banking where pin="+pin);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "yes";
	}
	public String Pin(String oldpin,String newpin) {
	String ac="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://remotemysql.com/gR2fa7dl4U?autoReconnect=true&useSSL=false","gR2fa7dl4U","H8196rO3po");
			Statement stmt=con.createStatement();  
			ResultSet rs1=stmt.executeQuery("select * from banking where pin="+oldpin);
			int bal = -1;
			if(rs1.next()) {
				bal=rs1.getInt(7);	
				ac=rs1.getString(3);
			}
			if(bal==-1) {
				return "wrongpin";
			}
			BigInteger c = new BigInteger(oldpin);
			BigInteger lim = new BigInteger("10000");
			System.out.println(bal);
			if(c.compareTo(lim)==1)
				return "empty";
			
			//b=String.valueOf(bal);
			System.out.println(bal);
			stmt.executeUpdate("update banking set pin="+newpin+" where accountnumber="+ac);//	ResultSet rs1=stmt.executeQuery("select * from banking where pin="+pin);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "yes";
	}
	public String fund(String a,String account,String amount) {
		String b = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://remotemysql.com/gR2fa7dl4U?autoReconnect=true&useSSL=false","gR2fa7dl4U","H8196rO3po");
			Statement stmt=con.createStatement();  
			BigInteger c = new BigInteger(account);
			BigInteger lim = new BigInteger("99999999999");
			//System.out.println(bal);
			if(c.compareTo(lim)==1)
				return "no";
			BigInteger d;
			BigInteger lim2;
			try {
				d = new BigInteger(amount);
				lim2 = new BigInteger("40000");
				if(d.compareTo(lim2)==1)
					return "excess";
			} catch (Exception e) {
				return "no";
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			}
			//System.out.println(bal);
			ResultSet rs1=stmt.executeQuery("select * from banking where accountnumber="+account);
			int bal = -1;
			String ac = "dumb";
			if(rs1.next()) {
				ac=rs1.getString(3);
				bal=rs1.getInt(7);	
			}
			System.out.println(ac);
			
			if(ac.equals("dumb")) {
				return "no";
			}
			ResultSet rs=stmt.executeQuery("select * from banking where pin="+a);
			if(rs.next()) {
				bal=rs.getInt(7);	
			}
			if(bal<Integer.parseInt(amount)) {
				return "nomultiple";
			}
					//	ResultSet rs1=stmt.executeQuery("select * from banking where pin="+pin);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "yes";
	}
	public String benficiarename(String a) {
		String b="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://remotemysql.com/gR2fa7dl4U?autoReconnect=true&useSSL=false","gR2fa7dl4U","H8196rO3po");
			Statement stmt=con.createStatement();  
			ResultSet rs1=stmt.executeQuery("select * from banking where accountnumber="+a);
			if(rs1.next()) {
				b=rs1.getString(5)+" "+rs1.getString(6);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(b);
		return b;
	}
	public void fundtransfer(String a,String account,String amount) {
	//	String b = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://remotemysql.com/gR2fa7dl4U?autoReconnect=true&useSSL=false","gR2fa7dl4U","H8196rO3po");
			Statement stmt=con.createStatement();  
			ResultSet rs1=stmt.executeQuery("select * from banking where accountnumber="+account);
			int bal1=0,bal2 =0,id1=0,id2=0;
			if(rs1.next()) {
				id2=rs1.getInt(1);
				bal2=rs1.getInt(7);	
			}
			ResultSet rs=stmt.executeQuery("select * from banking where pin="+a);
			if(rs.next()) {
				id1=rs.getInt(1);
				bal1=rs.getInt(7);
			}
			bal1-=Integer.parseInt(amount);
			bal2+=Integer.parseInt(amount);//	ResultSet rs1=stmt.executeQuery("select * from banking where pin="+pin);
			stmt.executeUpdate("update banking set balance="+bal1+" where pin="+a);
			stmt.executeUpdate("update banking set balance="+bal2+" where accountnumber="+account);
			stmt.executeUpdate("insert into transactions(id,amount,portal,dateandtime,balance) values("+id1+","+"-"+amount+","+"\'ATM\'"+","+"NOW()"+","+bal1+")");
			stmt.executeUpdate("insert into transactions(id,amount,portal,dateandtime,balance) values("+id2+","+"+"+amount+","+"\'ATM\'"+","+"NOW()"+","+bal2+")");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
