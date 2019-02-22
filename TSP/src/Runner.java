import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;


public class Runner {
	
	public static void main(String[] args) {
		Runner r = new Runner();
		r.start();

	}
	
	private void start() {
		File file = new File("Input.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		ArrayList<Point> points = new ArrayList<Point>();
		
		/*int n = 4;
		for(int i = 0; i < n*2; i++) {
			int rand1 = (int)(Math.random()*100)+1;
			int rand2 = (int)(Math.random()*100)+1;
			points.add(new Point(rand1, rand2));
		}*/
		
		int numPoints = scanner.nextInt();
		for(int i = 0; i < numPoints; i++) {
			points.add(new Point(scanner.nextInt(), scanner.nextInt()));
		}
		
		//nearestNeighbor(points);
		
		exhaustiveOptimal(points);
	}
	
	public void nearestNeighbor(ArrayList<Point> points) { //O(n^2)
		long startTime = System.nanoTime();
		ArrayList<Point> visited = new ArrayList<Point>(); 
		Point first = points.get(0);
		visited.add(first);
		points.remove(first);
		Point start = first;
		Point temp = null;
		double testDistance;
		double sum = 0;
		while(points.size() > 0){
			double distance = Double.MAX_VALUE; 
			for(int i = 0; i < points.size(); i++) { 
				Point test = points.get(i);
				testDistance = Point.distance(start.getX(), start.getY(), test.getX(), test.getY());
				if(testDistance < distance) {
					distance = testDistance;
					temp = test;
				}
			}
			sum += distance;
			start = temp;
			visited.add(start);
			points.remove(start);			
		}
		sum += Point.distance(first.getX(), first.getY(), visited.get(visited.size()-1).getX(), visited.get(visited.size()-1).getY());
		visited.add(first);
		NumberFormat formatter = new DecimalFormat("#0.000");     
		System.out.println(formatter.format(sum));
		for(Point p : visited) { 
			System.out.println((int)p.getX() + " " + (int)p.getY());
		}
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Runtime: " + totalTime);
	}
	
	public void exhaustiveOptimal(ArrayList<Point> points) {
		long startTime = System.nanoTime();
		ArrayList<Point> tempPoints = new ArrayList<Point>();
		
		for(Point p : points) {
			tempPoints.add(p);
		}
		permute(tempPoints, 0); //O(n!)
		ArrayList<Point> optimalPath = new ArrayList<Point>();
		double distance = Double.MAX_VALUE;
		for(ArrayList<Point> list : permutations) { //O(n)
			double testDistance = 0;
			for(int i = 0; i < list.size()-1; i++) { //O(n)
				testDistance += Point.distance(list.get(i).getX(), list.get(i).getY(), list.get(i+1).getX(), list.get(i+1).getY());	
			}
			testDistance += Point.distance(list.get(0).getX(), list.get(0).getY(), list.get(list.size()-1).getX(), list.get(list.size()-1).getY());
			if(testDistance < distance) {
				distance = testDistance;
				optimalPath = list;
			}
		}
		
		NumberFormat formatter = new DecimalFormat("#0.000");     
		System.out.println(formatter.format(distance));
		optimalPath.add(optimalPath.get(0));
		for(Point p : optimalPath) { //O(n)
			System.out.println((int)p.getX() + " " + (int)p.getY());
		}		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Runtime: " + totalTime);
	}
	
	ArrayList<ArrayList<Point>> permutations = new ArrayList<ArrayList<Point>>();
	
	public void permute(ArrayList<Point> points, int k) {
		for(int i = k; i < points.size(); i++) {			
			Collections.swap(points, i, k);
			permute(points, k+1);
			Collections.swap(points, k, i);
		}
		if(k == points.size() - 1) {
			ArrayList<Point> tempPoint = new ArrayList<Point>();
			for(Point p : points) {
				Point temp = new Point();
				temp.setLocation(p.getX(), p.getY());
				tempPoint.add(temp);
			}
			permutations.add(tempPoint);
		}
	}

}
