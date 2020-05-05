import java.util.*;
import java.lang.*;
import java.io.*;

public class Rectangle extends GeometricObject {

	private  double width;
	private double height;
	public double x1,y1,x2,y2,x3,y3,x4,y4;

	public double centerX ,centerY;


	


	

	public  Rectangle(double x1 , double y1 , double x2 , double y2 , double x3 , double y3 , double x4 ,double y4){

	   	double width1,width2,height1,height2;
	   	
	   	width1 = Distance(x1,y1,x2,y2);
	   	width2 = Distance(x3,y3,x4,y4);
	   	height1 = Distance(x1,y1,x4,y4);
	   	height2 = Distance(x2,y2,x3,y3);
        this.width=0;
        this.height=0;
        //Finding the center of the Rectangle
        this.centerX = (this.x1 + this . x2 + this.x3 + this.x4)/4;
		this.centerX = (this.y1 + this . y2 + this.y3 + this.y4)/4;

	   	if (width1==width2)
	   		this.width=width1;
	   	else System.out.println("Error , not a Rectangle because (the widths not equal)");
	   	
	   	if(height1==height2)
	   		this.height=height1;
	   	else System.out.println("Error , not a Rectangle because (the heights not equal)");
		
	}

    
	public int checkRect(){
		if (this.width!=0 && this.height!=0 )
			return 1;
		else return 0;

	}

   

	public  double getWidth(){
		return this.width;

	}

	public  double getHeight(){
		return this.height;
	}

	/** Return area */
  public double getArea() {return width * height; }

  /** Return perimeter */
  public double getPerimeter() {return 2 * (width + height);}

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
  	System.out.println("Height=" + getHeight());
  	System.out.println("Width =" + getWidth());
  	System.out.println("Area=" + getArea());
  	System.out.println("Perimeter=" + getPerimeter());
  }



	

}


