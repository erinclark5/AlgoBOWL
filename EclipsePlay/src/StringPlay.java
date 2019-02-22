import java.awt.Point;

public class StringPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "C++ is cool";
		String string2 = "I love Java";
		String newString = string2.substring(7) + string.substring(3);
		System.out.println(newString);
		
		Point p = new Point(1, 1);
		Point q = new Point(1, 1);
		System.out.println("p is new Point at (1,1). q is new Point at (1,1).");
		System.out.println("p.equals(q) : " + p.equals(q));
		System.out.println("p == q : " + (p == q));
		
		System.out.println();
		String string3 = "String Test";
		String string4 = "string test";
		System.out.println("string3 = 'String Test' and string4 = 'string test'");
		System.out.println("string3.equals(string4) : " + string3.equals(string4));
		System.out.println("string 3.equalsIgnoreCase(string4) : " + string3.equalsIgnoreCase(string4));
	}

}
