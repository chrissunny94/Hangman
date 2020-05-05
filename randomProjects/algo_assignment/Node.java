package algo_assignment;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Color;


/**
 * Created by stuxnet-il on 7/11/15.
 */
public class super Node  {
    //This could be linked to another hash table
    //That hash table will store the info corresponding to a Node in a DataBase

    private int value;
    private int x , y;


    //Node will be constructed on the basis on the value that the user enters
    //x , y values which the getPoint fuunction in java will return
    //Radius of the Node in the GUI
    public Node(int value , int x , int y  ){
        this.value = value;
        this.x = x;
        this.y = y;
        this.draw_circle();
        Node_hash( x , y , this );
    }

    private void Node_hash( int x , int y , Node n){
        Hash( x , y , n  );

    }







}
