//Created by Chris Thaliath , 29/Oct/2015(2:43AM)
import java.util.*;
import java.lang.*;


public  class Mypoint extends Rectangle {

	private double x , y;

	public Mypoint(double x , double y){
		this.x = x;
		this.y = y;

	}

	

	

	public double Distance(double x1 ,double y1 ,double x2,double y2){
		double X = Math.pow( x1 - x2 ,2);
		double Y = Math.pow( y1 - y2 ,2);
		return Math.sqrt(X+Y);

	}
}