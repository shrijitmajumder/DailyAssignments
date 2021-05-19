
public class BalanceInquiry extends Transaction {
	
	public BalanceInquiry(){
		super();
	}
	public BalanceInquiry(int accountNumber){
		super(accountNumber);
	}
	public void execute(double balance) {
		super.execute();
		System.out.println("Balance : "+balance);
	}

}
