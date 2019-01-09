
public class ModelTable {
	String transactionid;
	String amount,portal;
	String balance;
	String dateandtime;

	public ModelTable(String transactionid,String amount,String portal,String dateandtime,String balance) {
		// TODO Auto-generated constructor stub
		 this.transactionid=transactionid;
		 this.amount=amount;
		 this.portal=portal;
		 this.dateandtime=dateandtime;
		 this.balance=balance;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPortal() {
		return portal;
	}

	public void setPortal(String portal) {
		this.portal = portal;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getDateandtime() {
		return dateandtime;
	}

	public void setDateandtime(String dateandtime) {
		this.dateandtime = dateandtime;
	}
}