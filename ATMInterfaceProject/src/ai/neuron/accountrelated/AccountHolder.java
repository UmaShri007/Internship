package ai.neuron.accountrelated;

public class AccountHolder {

	private String userName;
	private String userId;
	private String userPin;
	
	private Account account;
	
	public AccountHolder() {}

	public AccountHolder(String uname,String uid, String upin,Account accnt) {
		
		this.userName = uname;
		this.userId = uid;
		this.userPin = upin;
		this.account = accnt;
	}

	AccountHolder ah1 = new AccountHolder("Sachin","34001", "1947",account);

	public static boolean validateUser(String id, String pin) {
		
		if ("34001".equals(id) && "1947".equals(pin)) {
			System.out.println("**************\nLogin Successful!!\n**************");
			System.out.println("Enter your choice::");
			System.out.println();
			
		} 
		else {
			System.out.println("Incorrect Pin!!Try Again");
			return false;
		}
		return true;
	}

}
