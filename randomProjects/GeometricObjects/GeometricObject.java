import java.util.*;
import java.lang.*;


public abstract class GeometricObject  {

	private  double Area;
	private double Perimeter;
	
	

	public abstract double getArea();

	public abstract double getPerimeter();

	public abstract void getInfo();

	public static void max(ArrayList<GeometricObject> list , int position1 , int position2){

		if ( list.get(position1).getArea() > list.get(position2).getArea() )
			System.out.println("Object 1 has bigger Area");
		else if ( list.get(position1).getArea() < list.get(position2).getArea() )
			System.out.println("Object 2 has bigger Area");
		else 
			System.out.println("Object 2 Area = Object 1 Area");

	}
	
}


