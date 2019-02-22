import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Collections {
	
	//Author - Erin Clark
	//With Treemap - the map is printed out with the values in alphabetical order
	//With Map - compiler error: 'cannot instantiate the type Map<String, String>'. 
		//Map is an interface and cannot be instantiated - TreeMap and HashMap are implementations of the Map interface

	private Map<String, String> mapCourses;
	
	public Collections() {
		mapCourses = new HashMap<String, String>();
	}
	
	public void getCourses() {
		Scanner in  = new Scanner(System.in);
		String name = "";
		String course = "";
		do {
			System.out.println("Enter a name or Q to quit: ");
			name = in.next();
			if(!(name.equalsIgnoreCase("Q"))) {
				System.out.println("Enter a course: ");
				course = in.next();
				mapCourses.put(name, course);
			}
		} while (!(name.equalsIgnoreCase("Q")));
	}
	
	public void printCourses() {
		for(Map.Entry<String, String> entry : mapCourses.entrySet()) {
			System.out.println(entry.getKey() + " likes " + entry.getValue());
		}
		
	}
	
	public static void main(String[] args) {
		Collections c  = new Collections();
		c.getCourses();
		c.printCourses();
	}
}
