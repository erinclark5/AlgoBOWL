import java.math.BigDecimal;

public class ATM {
	private BankAccount bankAccount;
	
	public ATM() {
		bankAccount = new BankAccount(new BigDecimal(500));
	}
	
	public void handleTransactions(){
		try {
			bankAccount.withdraw(new BigDecimal(600));
		}catch(Exception e){
			System.out.println(e);
			System.out.println(e.getMessage());
		}
		try {
			bankAccount.quickWithdraw(new BigDecimal(600));
		} catch(Exception e){
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.handleTransactions();
	}
}
