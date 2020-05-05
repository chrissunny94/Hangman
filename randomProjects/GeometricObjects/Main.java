import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
		

	public static void main(String args[]) {
	
		int option;
		
		int position;
		int choice;
		int count = 0;
		
		Scanner in = new Scanner(System.in);
		
		double x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6;
		ArrayList<GeometricObject> list = new ArrayList<GeometricObject>();

		
		
		
		do {
			System.out.println("\n\n1. Create Rectangle \n2. Hexagon \n 3. Max Area of Two Objects(Prints list of objects)");
			option = in.nextInt();
			
			switch(option) {
				case 1:
						System.out.println("Enter  x  Point 1");
							x1 = in.nextDouble();
						System.out.println("Enter  y  Point 1");
							y1 = in.nextDouble();
						System.out.println("Enter  x  Point 2");
							x2 = in.nextDouble();
						System.out.println("Enter  y  Point 2");
							y2 = in.nextDouble();
						System.out.println("Enter  x Point 3");
							x3 = in.nextDouble();
						System.out.println("Enter  y Point 3");
							y3 = in.nextDouble();
						System.out.println("Enter  x Point 4");
							x4 = in.nextDouble();
						System.out.println("Enter  y Point 4");
							y4 = in.nextDouble();
					list.add(new Rectangle(x1,y1,x2,y2,x3,y3,x4,y4));
					count++;
					break;
				case 2:
					
						System.out.println("Enter  x  Point 1");
							x1 = in.nextDouble();
						System.out.println("Enter  y  Point 1");
							y1 = in.nextDouble();
						System.out.println("Enter  x  Point 2");
							x2 = in.nextDouble();
						System.out.println("Enter  y  Point 2");
							y2 = in.nextDouble();
						System.out.println("Enter  x Point 3");
							x3 = in.nextDouble();
						System.out.println("Enter  y Point 3");
							y3 = in.nextDouble();
						System.out.println("Enter  x Point 4");
							x4 = in.nextDouble();
						System.out.println("Enter  y Point 4");
							y4 = in.nextDouble();
						System.out.println("Enter  x Point 5");
							x5 = in.nextDouble();
						System.out.println("Enter  y Point 5");
							y5 = in.nextDouble();
						System.out.println("Enter  x Point 6");
							x6 = in.nextDouble();
						System.out.println("Enter  y Point 6");
							y6 = in.nextDouble();
					list.add(new Hexagon(x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6));
					count++;
					break;
				case 3:
					printList(list , count );
					 int position1 = in.nextInt();
					 int position2 = in.nextInt();
					//max(list , position1 , position2);
					 break;
			}
			
			System.out.println("1.\n\n to continue \n 0. to exit");
			choice = in.nextInt();
		}while (choice != 0);
		
		
		 
		
	}

   public static void printList(ArrayList<GeometricObject> list , int  count ){
   	 for (int i = 0 ; i < count ; i++)
   	 	list.get(i).getInfo();


   }


	


	

		
}
