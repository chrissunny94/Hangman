/**
 * Created by stuxnet-il on 10/11/15.
 */

import java.math.*;
public class Physics {
    //Velocity Tangential

    public double V;
    public double Vx;
    public double Vy;
    //X and Y coordinate
    public double X;
    public double Y;
    public  double time;
    public double k;

    public double initial_angle;
    public double current_angle;
    public double g;
    public double radius;




    public Physics(double X , double Y , double g  , double radius, double initial_angle ){
        this.X = X;
        this.Y = Y;
        this.g = g;
        this.radius = radius;
        this.initial_angle = initial_angle;
        this.current_angle = initial_angle;
        this.V = Math.sqrt(2 * g * radius * (1 - Math.sin(initial_angle)));

    }

    //Returns the velocity along X axis
    public double getVx(){
        return this.V * Math.sin(this.current_angle);
    }
    //Returns the Velocity along Y axis
    public double getVy(){
        return this.V * Math.cos(this.current_angle);
    }
    //Returns the X coordinate
    public double get_X(){
        return this.X;
    }
    //Returns the Y coordinate

    public double get_Y(){
        return this.Y;
    }

    public void update(double time){
        this.time = 1;
        this.k = 1;

        this.current_angle = (this.initial_angle)*Math.sqrt(this.k * (this.g) / (this.radius) ) * (this.time);

        System.out.println("Angle = " + this.current_angle);


        this.Vx = this.V * Math.sin ( this.current_angle );
        this.Vy = this.V * Math.cos ( this.current_angle );

        System.out.println( "Vx = " + this.Vx );
        System.out.println( "Vy = " + this.Vy );

        System.out.println("V = " + Math.pow(this.Vx + this.Vy , 2));

        this.X = this.X + this.Vx * this.time;
        this.Y = this.Y + this.Vy * this.time;
    }








}
