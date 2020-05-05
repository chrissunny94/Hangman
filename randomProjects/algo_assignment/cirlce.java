package algo_assignment;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Created by stuxnet-il on 7/11/15.
 */
public class cirlce extends JFrame {
    private int x ;
    private int y ;
    protected  Node n;
    private int radius;

    //Circle will be constructed with
    //x & y coordinate from getPoint Function interfacing with mouse input
    //
    public cirlce (int x, int y, Node n  ){
        this.x = x;
        this.y = y;
        this.n = n;



    }



    private void draw_circle(){
        super.paint(g);

    }



    public void paint(Graphics g)
    {


        g.drawOval( this.x , this. y , this.x + this.radius , this.y + this.radius );
    }






}
