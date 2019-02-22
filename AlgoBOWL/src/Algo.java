import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Algo {
	
	ArrayList<Integer> sums = new ArrayList<Integer>();
	ArrayList<Integer> inputs = new ArrayList<Integer>();
	
	
	public void readFile() {
		File file = new File("test.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		sums.add(1);
		int numInputs = scanner.nextInt();
		for(int i = 0; i < numInputs; i++) {
			inputs.add(scanner.nextInt());	
		}
	}
	
	public void doubleLargest(int i) {
		int currentValue = inputs.get(i);
		int largestSum = sums.get(sums.size()-1);
		while(2*largestSum <= currentValue) {
			sums.add(2*largestSum);
			//keep track
			//sort arry
			largestSum = sums.get(sums.size()-1);		
		}
	}
	
	public void findAdd(int curInput, int maxValue) {
		int valueNeeded = curInput - maxValue;
		if(sums.contains(valueNeeded)) {
			sums.add(maxValue + valueNeeded);
			//keep track
			//sort array
		}
		else {
			modifiedBinary(0, sums.size()-1, valueNeeded);
		}
	}
	
	public int modifiedBinary(int l, int r, int x) {
		int mid = 0;
		if(r > l) {
			mid = l + (r-l)/2;
			if(sums.get(mid) == x) {
				return sums.get(mid);
			}
			if(sums.get(mid) > x) {
				return modifiedBinary(l, mid-1, x);
			}
			if (sums.get(mid) < x && sums.get(mid+1) < x)
				return modifiedBinary(mid+1, r, x);
		}
		else 
			return 0;
		return 0;
			//return sums.get(l) + findAdd(x, sums.get(l));
	}
	
	
	public static void main(String[] args) {
		Algo a = new Algo();
		a.readFile();
		//look at the next value in the inputs array
		for(int i = 0; i < a.inputs.size(); i++) {
			if(2*a.sums.get(a.sums.size() - 1) <= a.inputs.get(i)) {
				a.doubleLargest(i);
			}
			if(a.sums.get(a.sums.size() - 1) != a.inputs.get(i)) {
				a.findAdd(a.inputs.get(i), a.sums.get(a.sums.size()-1));
			}
			
		}

			//double the max value of the sums array until that value is larger than the current input we are at
			//subtract max value from the current input if it is not equal to the value we are looking for
			//modified binary search to find the value we need that when added to the max value equals the current input
			//if no value is found, recursively binary search with next highest value that would not exceed
		
		
	}
	
	
}
