import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class NegativeBalanceException extends Exception {
	
	private BigDecimal negativeBalance = new BigDecimal("0");
	private static NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
	
	public NegativeBalanceException() {
		super("Error: negative balance");
	}
	
	public NegativeBalanceException(BigDecimal amount) {
		super("Amount exceeds balance by " + defaultFormat.format(amount) + ".");
		negativeBalance = amount;
		try {
			PrintWriter out = new PrintWriter("logfile.txt");
			out.println("Amount exceeds balance by " + defaultFormat.format(amount));
			out.close();
		} catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
	
	@Override
	public String toString() {
		return "Balance of " + defaultFormat.format(negativeBalance) + " not allowed";
	}
}
