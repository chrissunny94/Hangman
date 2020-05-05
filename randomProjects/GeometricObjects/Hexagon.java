import java.util.*;
import java.lang.*;
import java.io.*;

public class Hexagon extends GeometricObject  {
   
    //Height is the total height of the Hexagon , ie distance between any two opposite corners
	private  double height;
	//Width is the lenght between any two opposite sides
	private double width;
	//Side is the length of the side of the hexagon 
	private double side;
    //This stores the sides of the Hexagon
    public double x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6;
    //
	public Rectangle rect1 , rect2;


	


	

	public  Hexagon(double x1 , double y1 , double x2 , double y2 , double x3 , double y3 , double x4 ,double y4 , double x5 ,double y5 ,double x6 , double y6){
        
         this.x1 = x1;
         this.y1 = y1;
         this.x2 = x2;
         this.y2 = y2;
         this.x3 = x3;
         this.y3 = y3;
         this.x4 = x4;
         this.y4 = y4;

	   	rect1 = new Rectangle(x1,y1,x2,y2,x4,y4,x5,y5);
	   	rect2 = new Rectangle(x6,y6,x1,y1,x3,y3,x4,y4);
        
        // If the two Rectangles that form  the Hexagon has equal Height& width and same Center then this will form a Hexagon
	   	if (rect1.checkRect()==1 && rect2.checkRect()==1 && rect1.getHeight()==rect2.getHeight() && rect1.getWidth()==rect2.getWidth() ){
	   		 if (rect1.centerX == rect2.centerX  && rect1.centerY == rect2.centerY ){
	   		System.out.println("Valid Hexagon coordinates");
	   		this.side = rect1.getHeight();}
	   	}

	   	else System.out.println("InValid Hexagon coordinates");



	   	this.width  = 2* Math.cos(30) * this.side;
	   	this.height = this.side + 2* Math.sin(30) * this.side;
		
	}

	

	public  double getWidthHex(){
		return this.width;

	}

	public  double getHeightHex(){
		return this.height;
	}

	/** Return area */
  public double getArea() {return 9 * Math.pow(3 , .5) * Math.pow(this.side , 2); }

  /** Return perimeter */
  public double getPerimeter() {return 6 * this.side;}

  public double Distance(double x1 ,double y1 ,double x2,double y2){
		double X = Math.pow( x1 - x2 ,2);
		double Y = Math.pow( y1 - y2 ,2);
		return Math.sqrt(X+Y);

	}




	



  public void getInfo(){
  	System.out.println("x1=" + x1 + ",y1=" + y1);
  	System.out.println("x2=" + x2 + ",y2=" + y2);
  	System.out.println("x3=" + x3 + ",y3=" + y3);
  	System.out.println("x4=" + x4 + ",y4=" + y4);
  	System.out.println("x5=" + x5 + ",y5=" + y5);
  	System.out.println("x6=" + x6 + ",y6=" + y6);
  	System.out.println("Height=" + getHeightHex());
  	System.out.println("Width =" + getWidthHex());
  	System.out.println("Area=" + getArea());
  	System.out.println("Perimeter=" + getPerimeter());
  }



	

}


