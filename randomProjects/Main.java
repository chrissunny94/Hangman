import java.util.*;
import java.io.*;
import java.lang.*;

class Test {
		static double cost=3;

	public static void main(String args[]) {
	
		int option;
		
		int position;
		int choice;
		
		Scanner in = new Scanner(System.in);
		
		double x1,y1,x2,y2,x3,y3,x4,y4;
		ArrayList<GeometricObjects> list = new ArrayList<GeometricObjects>();
		
		
		
		do {
			System.out.println("1. Create Rectangle \n2. Cost to Colour \n ");
			option = in.nextInt();
			
			switch(option) {
				case 1:
					System.out.println("Enter the x coordinate of Point 1");
			x1 = in.nextDouble();
			System.out.println("Enter the y coordinate of Point 1");
			y1 = in.nextDouble();
			System.out.println("Enter the x coordinate of Point 2");
			x2 = in.nextDouble();
			System.out.println("Enter the y coordinate of Point 2");
			y2 = in.nextDouble();
			System.out.println("Enter the x coordinate of Point 3");
			x3 = in.nextDouble();
			System.out.println("Enter the y coordinate of Point 3");
			y3 = in.nextDouble();
			System.out.println("Enter the x coordinate of Point 4");
			x4 = in.nextDouble();
			System.out.println("Enter the y coordinate of Point 4");
			y4 = in.nextDouble();
					list.add(new Rectangle(x1,y1,x2,y2,x3,y3,x4,y4));
					break;
				case 2:
					
					System.out.println("enter the position");
					position = in.nextInt();
					System.out.println("the cost to colou rectangle at pos " + position + " = " + comprehensiveCost(list, position));
					break;
			}
			
			System.out.println("1. to continue \n 0. to exit");
			choice = in.nextInt();
		}while (choice != 0);
		
		
		 
		
	}
	public static double  comprehensiveCost(ArrayList<GeometricObjects> list, int position ) {
			return ((Colourable)(list.get(position))).costToColour(cost);
			}
		
}
