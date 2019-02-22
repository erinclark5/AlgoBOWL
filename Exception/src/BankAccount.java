import java.math.BigDecimal;

public class BankAccount {
	private BigDecimal balance = new BigDecimal("0");
	
	public BankAccount(BigDecimal balance) {
		this.balance = balance;
	}
	
	public void withdraw(BigDecimal amountToWithdraw) throws NegativeBalanceException {
		if(amountToWithdraw.compareTo(balance) == 1) {
			throw new NegativeBalanceException(balance.subtract(amountToWithdraw));
		}
		else {
			balance = balance.subtract(amountToWithdraw);
		}
	}
	
	public void quickWithdraw(BigDecimal amountToWithdraw) throws NegativeBalanceException {
		if(amountToWithdraw.compareTo(balance) == 1) {
			throw new NegativeBalanceException();
		}
		else{
			balance = balance.subtract(amountToWithdraw);
		}
	}
}
