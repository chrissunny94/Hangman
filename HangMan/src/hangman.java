import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 * Created by stuxnet-il on 17/11/15.
 */
public class hangman extends JFrame {

    public static void main(String[] args)
    {
        JFrame MainFrame = new JFrame("hangman");
        MainFrame.setSize(1000, 1000);
        MainFrame.setLayout(new CardLayout());
        JCanvas canvas = new JCanvas();
        canvas.setSize(100,100);
        MainFrame.add(canvas);
        canvas.setVisible(true);
        MainFrame.setVisible(true);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel ControlPanel = new JPanel();
        ControlPanel.setLayout(new GridLayout(3,3));
        ControlPanel.setSize(50,50);
        //Reset Button CLEARS THE SCREEN
        JButton MIRROR = new JButton("MIRROR");
        MIRROR.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("\n\nBFS PRESSED!");
            }
        });
        ControlPanel.add(MIRROR);
        System.out.println("  Added  NodeRESET button to ControlPanel");
        MainFrame.add(ControlPanel);


        int x = canvas.getWidth() / 2;
        int y = canvas.getHeight() / 2;
        System.out.println(" x = " +x + ",y = " +y);
        Point p = new Point(490,450);
        x = p.x;
        y = p.y;
        Point center = new Point(x ,y + 50);


        hangman man = new hangman(p,center);
        hangman head = new hangman(new Point(x,y-50),man.p);
        hangman Leftleg = new hangman(new Point(x-50,y+50),man.p);
        hangman Rightleg = new hangman(new Point(x+50 , y - 50 ),man.p);

        hangman LeftFoot = new hangman(new Point(x+250,y+100),Leftleg.p);
        hangman RightFoot = new hangman(new Point(x-250,y-100),Rightleg.p);


        man.radius = 200;
        man.size_of_object = 40;
        Leftleg.radius= 100;
        LeftFoot.radius = 50;
        Rightleg.radius = 100;
        RightFoot.radius = 50;
        head.radius = 75;

        man.push(Leftleg);
        man.push(Rightleg);
        man.push(head);
        Leftleg.push(LeftFoot);
        Rightleg.push(RightFoot);
        LeftFoot.push(head);
        RightFoot.push(head);

        man.center = head.p;
        man.update_position(Math.toRadians(90) , canvas);
        man.center = center;




        int i=0;
        boolean flag = true;
            while (true){
                canvas.startBuffer();
                canvas.clear();
                canvas.drawLine(center.x,center.y, man.p.x , man.p.y);
                man.radar(canvas,center.x,center.y,100,50,900);
                //LeftFoot.radar(canvas,LeftFoot.p.x,LeftFoot.p.y,100,2,50);
                //RightFoot.radar(canvas,RightFoot.p.x,RightFoot.p.y,50,10,100);
                //head.radar(canvas,head.p.x,head.p.y,100,30,500);
                canvas.setColor(Color.BLUE);
                man.REPAINT(canvas);
                man.update_position(Math.toRadians(10) , canvas);
                man.REPAINT(canvas);
                canvas.endBuffer();
                canvas.sleep(30);
                //man.mirror(0,250);
            }


    }


    public static boolean LogicChange(boolean a){
        if (a)
            return false;
        else return true;
    }



    public void radar(JCanvas canvas , int x , int y , int number , int width , int maxradius){
        int radius=0;
        for (int i =0 ; i< number ; i++){
            canvas.setColor(Color.getHSBColor(2*i,2*i*i,2*i*i*i));
            radius = radius + width;
            if (radius>maxradius)
                break;
            canvas.drawOval(x-radius/2,y-radius/2 , radius,radius);
        }
    }






/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Point p;
    public Point center;
    public double angle;
    public double radius; //Point Center to Point p
    public int size_of_object = 20;
    public hangman[] list_of_entities = new hangman[20];
    public int number_of_entities=0;



    public hangman(Point p , Point center){
        this.p = p;
        this.angle = Math.atan( (center.getY()-p.getY()) / (center.getX()-p.getX()) );
        this.angle = Math.toRadians(this.angle);
        System.out.println();

        this.center = center;
        this.radius = distance(this.center, this.p);


    }

//    public double update_angle(double angle){
//        if (this.angle >  )
//    }

    public void REPAINT(JCanvas canvas){
        fillcircle(this.p ,canvas);
        canvas.setColor(Color.BLACK);
        int i, size = this.number_of_entities;
        for (i =0 ; i<size ; i++) {

            this.list_of_entities[i].update_position(this.angle ,canvas);
            //drawline(this.center,this.list_of_entities[i].p , canvas);
            drawline(this.p,this.list_of_entities[i].p , canvas);
            drawline(this.center,this.p , canvas);
            this.list_of_entities[i].REPAINT(canvas);
            canvas.setColor(Color.ORANGE);

        }

        return;
    }


    public void drawline(Point a , Point b , JCanvas canvas){
        canvas.drawLine(a.x,a.y,b.x,b.y);

    }


    public void fillcircle(Point p ,JCanvas canvas){
        canvas.fillOval( (int)p.getX()-this.size_of_object/2, (int)p.getY()-this.size_of_object/2 ,this.size_of_object , this.size_of_object);
    }

    public void update_position( double angle , JCanvas canvas){
        this.angle = Math.toDegrees(this.angle);
        this.angle= this.angle - angle;
        this.angle = Math.toRadians(this.angle);

        System.out.println("Angle=" + Math.toDegrees(this.angle));
        System.out.println("Radius=" + this.radius);
        this.p.x = this.center.x + (int)(this.radius*Math.cos(this.angle));
        this.p.y = this.center.y + (int)(this.radius*Math.sin(this.angle));
        System.out.println("Point=" + this.p);

        int i = 0 , size = this.number_of_entities;
        for(i = 0 ; i < size ; i++){

            this.REPAINT(canvas);
            double angle_entity = getAngle(this.list_of_entities[i]);
            double angle2 = angle + angle_entity;
            this.list_of_entities[i].update_position( angle2,canvas );


        }
        return;
    }

    public double getAngle(hangman a){
         double angle = a.angle;
        return angle;
    }

    public double distance(hangman a , hangman b){
        int x1 = a.p.x;
        int y1 = a.p.y;
        int x2 = b.p.x;
        int y2 = b.p.y;

        return Math.pow( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) , .5 );
    }

    public double distance(Point a , Point b){
        int x1 = a.x;
        int y1 = a.y;
        int x2 = b.x;
        int y2 = b.y;

        return Math.pow( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) , .5 );
    }

    public void push(hangman n){
        this.list_of_entities[this.number_of_entities] = n;
        this.number_of_entities ++;
    }

    public void mirror(int x , int y){
        this.p.x = this.p.x + (2*(this.p.x - x));
        this.p.y = this.p.y + (2*(this.p.y - y));
    }



}
