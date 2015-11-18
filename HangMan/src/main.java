import javax.swing.*;
import java.awt.*;

/**
 * Created by stuxnet-il on 17/11/15.
 */
public class main{


    public static void main(String[] args) {
        JFrame MainFrame = new JFrame("HangMan");
        MainFrame.setSize(500, 1000);
        MainFrame.setLayout(new GridLayout(1,2 ,10,10));
        JCanvas canvas = new JCanvas();
        Point p = new Point(300,300);
        Point center = new Point(300,100);
        hangman man = new hangman(p,center);
        man.REPAINT(canvas);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.add(canvas);
        canvas.setVisible(true);



    }





        }
