import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OutputAlgo {
	

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
			//sort array
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

			findClosest(valueNeeded);
		}
	}


	public int findClosest(int target) {
		int n = sums.size()-1;
		if(target <= sums.get(0)) return sums.get(0);
		if(target >= sums.get(n-1)) return sums.get(n-1);

		int i = 0, j = n, mid = 0;
		
		while(i < j) {
			mid = (i+j)/2;
			if(sums.get(mid) == target)
				return sums.get(mid);
			if(target < sums.get(mid)) {
				if(mid > 0 && target > sums.get(mid-1)) {
					return getClosest(sums.get(mid-1), sums.get(mid), target);
				}
				j = mid;
			}
			else {
				if(mid < n-1 && target < sums.get(mid + 1)) {
					return getClosest(sums.get(mid), sums.get(mid+1), target);
				}
				i = mid + 1;
			}
		}
		return sums.get(mid);
	}

	public static int getClosest(int val1, int val2,  
			int target) 
	{ 
			return val1;         
	} 


	public static void main(String[] args) {
		OutputAlgo a = new OutputAlgo();
		//a.readFile();
		//look at the next value in the inputs array
		/*for(int i = 0; i < a.inputs.size(); i++) {
			if(2*a.sums.get(a.sums.size() - 1) <= a.inputs.get(i)) {
				a.doubleLargest(i);
			}
			if(a.sums.get(a.sums.size() - 1) != a.inputs.get(i)) {
				a.findAdd(a.inputs.get(i), a.sums.get(a.sums.size()-1));
			}

		}*/
		a.sums.add(2);
		a.sums.add(5);
		System.out.println(a.findClosest(4));
	}


}

