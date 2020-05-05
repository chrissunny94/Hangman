import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.awt.*;
import javax.swing.*;

public class JPanelTest extends JFrame  {

    public static void main(String[] args)  {
        System.out.println("Decalred the variables ");
        final int DRAW_EDGE_TRIGGER = 0;
        int i =1 , j;
        int x0=0 , y0=0 ;
        System.out.println("Created JEvent");
        final JEventQueue events = new JEventQueue();
        final Node root = new Node(250,300,0);
        System.out.println("Making the first node  as ROOT,root.value= "+root.value);
        ////////////////////////////////////////////////////////////////
        System.out.println("Flow of program ....INIT.....");
        System.out.println("Created a list of nodes with size zero");
        ////////////////////////////////////////////////////////////////
        final Node[] list = new Node[100];
        System.out.println("1.Created a MainFrame");
        //////////////////////////////////////////////////////////////
        JFrame MainFrame = new JFrame();
        System.out.println(" MainFrame setsize(500.1000) , GridLayout ");
        MainFrame.setSize(500, 1000);
        MainFrame.setLayout(new GridLayout(1,2 ,10,10));
        ////////////////////////////////////////////////////////////////
        System.out.println("2.Created a Canvas");
        final JCanvas canvas = new JCanvas();
        System.out.println("Adding the label to the canvas");
        canvas.add(new JLabel("Graphs"));
        root.print(canvas);
        //Control Panel///////////////////////////////////////////////////////////////////
        JPanel control = new JPanel();
        control.setLayout(new GridLayout(5,2));
        control.setSize(50,200);
        System.out.println("3.Created a ControlPanel(JPanel)");
        /////////////////////////////////////////////////////////////////////////////////
        //Reset Button CLEARS THE SCREEN
        JButton BFS = new JButton("BFS");
        BFS.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   canvas.clear();
                                          root.BFS(canvas);
                System.out.println("\n\nBFS PRESSED!");
            }
        });
        control.add(BFS);
        System.out.println("  Added  NodeRESET button to ControlPanel");
        /////////////////////////////////////////////////////////////////////////////////
        //DFS CLEARS THE SCREEN
        JButton DFS = new JButton("DFS");
        DFS.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                canvas.clear();
                root.set_nodesTo_unvisited();
                root.DFS(canvas , 0 );
                System.out.println("\n\nDFS PRESSED!");
            }
        });
        control.add(DFS);
        System.out.println("  Added  DFS button to ControlPanel");
        /////////////////////////////////////////////////////////////////////////////////
        //DTree CLEARS THE SCREEN
        JButton DTree = new JButton("DTree");
        DTree.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                canvas.clear();
                root.set_nodesTo_unvisited();
                root.DTree(canvas , 0 );
                System.out.println("\n\nDTree PRESSED!");
            }
        });
        control.add(DTree);
        System.out.println("  Added  DTree button to ControlPanel");
        //RepaintNodes button
        /////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////
        //Mirror Button CLEARS THE SCREEN
        JButton MIRROR = new JButton("MIRROR");
        MIRROR.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                canvas.clear();
                root.mirror();
                root.print(canvas);
                root.DRAWEDGES_RECURSSIVELY(canvas);
                System.out.println("\n\nBFS PRESSED!");
            }
        });
        control.add(MIRROR);
        System.out.println("  Added  MIRROR button to ControlPanel");
        //RepaintNodes button


        JButton SET_TREE = new JButton("HangMan");
        SET_TREE.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                canvas.clear();

                    canvas.startBuffer();
                    root.HangMan(0,0,100,Math.toRadians(10));
                    canvas.fillOval(100,100,20,20);
                    root.print(canvas);
                    root.DRAWEDGES_RECURSSIVELY(canvas);
                    canvas.endBuffer();

                }
        });
        control.add(SET_TREE);
        System.out.println("  Added SetTree button to ControlPanel");




        ///////////////////////////////////////////////////////////////
        //Mirror Button CLEARS THE SCREEN
        JButton Set_Unvisit = new JButton("SetAllNodesUnvisited & Reset");
        Set_Unvisit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                canvas.clear();
                root.set_nodesTo_unvisited();

                System.out.println("\n\nSetting all nodes unvisited  PRESSED!");
            }
        });
        control.add(Set_Unvisit);
        System.out.println("  Added  SetAllNodesUnvisited button to ControlPanel");
        //RepaintNodes button
        /////////////////////////////////////////////////////////////////////////////////
        JButton Node_Reset = new JButton("Node_Reset");
        Node_Reset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               int j = 0;
                canvas.clear();
                System.out.println("\n\nNODERESET PRESSED! SIZE =" + root.numberofnodes);
                root.print(canvas);
                root.DRAWEDGES_RECURSSIVELY(canvas);
            }
        });
        control.add(Node_Reset);
        System.out.println("  Added  Node_RESET button to ControlPanel");
        ///////////////////////////////////////////////////////////////////////////////////
        //Draw_edge
        JButton Draw_edge = new JButton("UpdatefromRoot");
        Draw_edge.addActionListener(new ActionListener()
        {
            public  void actionPerformed(ActionEvent e)
            {
                System.out.println("\n\nUPDATEROOT PRESSED! ");
                //DRAW_EDGE_TRIGGER=1;
                root.update_hops(0);
                System.out.println("maxhop from root  = "+root.maxhop);


            }
        });
        System.out.println("Added events listening to canvas");
        events.listenTo(canvas, "Graphs");
        control.add(Draw_edge);
        System.out.println("  Added  Draw_edge button to ControlPanel");


        ////////////////////////////////////////////////////////////////////////////////////

        control.setSize(200,50);
        System.out.println("  ControlPanel sizeset(200,200)");
        ////////////////////////////////////////////////////////////////////////////////////////
        //Adding all the panels and controls to the Main frame
        System.out.println("4.Adding canvas & ControlPanel into the MainFrame..");
        MainFrame.add(canvas);
        MainFrame.add(control);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("EXIT ON CLOSE AND MainFrame is set to VISIBLE");
        MainFrame.setVisible(true);
        System.out.println("Mouse For buttons are activated !");
        while (true){
            canvas.fillOval(250,300,20,20);
            EventObject event=events.waitEvent();
             if( events.isMouseEvent (event)){

                 int x = events.getMouseX (event);
                 int y = events.getMouseY (event);

                    if( events.isMousePressed (event))
                        {x0=x;y0=y;}
                    if( events.isMouseClicked (event)) {
                        if( ((x-x0)*(x-x0)+(y-y0)*(y-y0))<(root.radius*root.radius) ){
                            new Node(i++, x0 , y0 , 0 ,root );
                            canvas.clear();
                            root.print(canvas);
                            root.DRAWEDGES_RECURSSIVELY(canvas);
                            root.update_hops(0);}
                        }
                    if( events.isMouseReleased (event))
                        {   if( ( ((x-x0)*(x-x0))+((y-y0)*(y-y0)) )>(root.radius*root.radius) )
                            root.DrawEdges(x,y,x0,y0);
                            canvas.clear();
                            root.print(canvas);
                            root.DRAWEDGES_RECURSSIVELY(canvas);
                            root.update_hops(0);
                        }
                        }
    }
}
}





class Node extends JPanel{
    public int radius1;
    public int x;
    public int y;
    public int radius;
    public Color color;
    public int value;
    public boolean visted;
    public Node root;
    public double angle;

    public int hops;
    public Node[] list = new Node[100];
    public int numberofnodes = 0;
    public int maxhop ;
    public Node LeftChild;
    public Node RightChild;


    public Node[] listofedges = new Node[100];
    public int numberofedges = 0;

    public Node(int x , int y , int value ){
        this.x = x;
        this.y = y;
        this.value = value;
        this.radius = 50;
        this.hops = 0;
        this.numberofnodes = 0;
        this.root = this;
        this.hops=0;



    }

    public void DRAWEDGES_RECURSSIVELY ( JCanvas canvas){
        int size = this.numberofedges;
        int i =0;
        for (i = 0 ; i < size ; i++){
            canvas.drawLine(this.x + (this.radius/2),this.y+ (this.radius/2),this.listofedges[i].x+ (this.radius/2),this.listofedges[i].y+ (this.radius/2));
            if(this.listofedges[i].visted == false)this.listofedges[i].DRAWEDGES_RECURSSIVELY(canvas);
        }
    }






    public Node( int  value ,int x , int y, int hops , Node root  ) {
        int i , j;
        boolean flag = true;
        this.value = value;
        this.x =x;
        this.y = y;
        this.hops = 99;
        this.numberofnodes = 0;
        this.root = root;


        System.out.println("Checking for a collision");
        if(root.check_Node(this) ){
                         ///////////////////////////////////////////////////////////////////////
                         for (i =0 ; i < root.numberofnodes ; i++){
                             System.out.println("Comparing with Node: " + root.list[i].value);
                             ///////////////////////////////////////////////////////////////////
                             if( check_Node(root.list[i])  ){
                                    //////////////////////////////////////////////////////////////
                                    //update_hops(this.hops);

                                    System.out.println("NodesPass");
                                           }
                            ////////////////////////////////////////////////////////////////////
                             else {
                                 System.out.println("Collision!");
                                 flag = false;
                                 root.list[i].color = Color.BLUE;
                                 break;
                             }


                         }

                        }
                        //////////////////////////////////////////////////////////////////////////////
        else
        {JOptionPane.showMessageDialog(null,"Collision with root node"); flag = false;}

        if (flag == true) {

            setBorder(BorderFactory.createLineBorder(Color.black));

            root.push(this);
            this.value = value;
            this.x = x;
            this.y = y;
            this.radius = 50;
            this.radius1 =(int) distance(this , this.root);
            info();

        }



    }


    public void update_hops(int hops){
        int i ;
        int size = this.numberofedges;
        if (this.hops > (hops+1))
            this.hops = hops +1 ;
        for (i =0 ;i < size; i++){
            System.out.println("Node-"+listofedges[i].value+" Number of hops = " + listofedges[i].hops);
            if(listofedges[i].hops>(hops+1))
               listofedges[i].hops = hops+1;
            if(hops + 1 > this.maxhop)
                root.maxhop = hops + 1;
            listofedges[i].update_hops(hops+1);
        }
    }


    public void BFS(JCanvas canvas){
        int size = this.numberofnodes;
        int i , j ;
        Color[] l = {Color.black,Color.BLUE,Color.green,Color.YELLOW,Color.MAGENTA,Color.ORANGE,Color.red,Color.gray};


        int maxhop = this.maxhop;
        canvas.setColor(Color.DARK_GRAY);
        canvas.drawOval(this.x,this.y,this.radius,this.radius);
        canvas.setColor(Color.green);
        for(j = 0 ; j < maxhop+1 ; j++ )
            for (i = 0 ; i < size ; i++)
                if(list[i].hops == j){
                    canvas.setColor(l[j]);

                    canvas.drawString(this.list[i].value + "",this.list[i].x,this.list[i].y);
                    canvas.drawOval(this.list[i].x,this.list[i].y,this.list[i].radius,this.list[i].radius);

                    canvas.sleep(1000);}

    }


    public void mirror(){
        int i , size = this.numberofnodes;
        for (i = 0 ; i < size ; i++){
            this.list[i].x = this.list[i].x + 2*(root.x - this.list[i].x);
            this.list[i].y = this.list[i].y + 2*(root.x - this.list[i].y);

        }
    }



    public void HangMan(int x , int y , int radius ,double angle){
        int i , size = this.numberofnodes;
        //Setting the root node as the centre of mass
        int x1 = x - this.x;
        int y1 = y - this.y;
        //double radius = (double)(Math.pow(  (x1*x1)+ (y1*y1),.5));
        System.out.println("RADIUS:"+radius);


        this.x = x + (int)(radius*Math.sin(angle + this.angle)) ;
        this.y = y + (int)(radius*Math.cos(angle + this.angle)) ;
        this.angle = this.angle + angle;
        double theta1 = 0;
        if(x1 != 0)
            theta1 = Math.atan(y1/x1);
        for (i = 0 ; i < size ; i++){

            double theta2 = Math.atan( (this.y-this.listofedges[i].y) / (this.x-this.listofedges[i].x));
            double radius1 = distance(this,this.listofedges[i]);
            System.out.println("Radius="+radius);
            System.out.println("Radius1="+radius1);
            listofedges[i].x = this.x  + (int) (this.radius1*Math.sin(Math.toRadians(theta2 - theta1)));
            listofedges[i].y = this.y  + (int) (this.radius1*Math.cos(Math.toRadians(theta2 - theta1)));


        }

    }




    public double distance(int x , int y , int x0, int y0){
        return Math.pow( ((x-x0)*(x-x0))+((y-y0)*(y-y0)),.5);
    }

    public double distance(Node a , Node b){
        int x= a.x;
        int y=a.y;
        int x0 = b.x;
        int y0 = b.y;
        return Math.pow( ((x-x0)*(x-x0))+((y-y0)*(y-y0)),.5);
    }







    public void set_nodesTo_unvisited(){
        int i , size = this.numberofnodes;
        for (i = 0 ; i < size ; i++){
            this.list[i].visted = false;
            System.out.println("Node.value=" + this.list[i].value + ",Node.visted=" + this.list[i].visted);

        }

    }


    public void DFS(JCanvas canvas , int hops){
        int size = this.numberofedges;
        int i , j ;
        Color[] l = {Color.black,Color.BLUE,Color.green,Color.YELLOW,Color.MAGENTA,Color.ORANGE,Color.red,Color.gray};
        canvas.setColor(Color.DARK_GRAY);
        canvas.drawOval(this.x,this.y,this.radius,this.radius);
        canvas.setColor(Color.green);
        for(i = 0 ; i < size ; i++){
            canvas.setColor(l[i]);
            canvas.drawOval(this.listofedges[i].x,this.listofedges[i].y,this.listofedges[i].radius,this.listofedges[i].radius);
            canvas.drawLine(this.x + (this.radius/2),this.y+ (this.radius/2),this.listofedges[i].x+ (this.radius/2),this.listofedges[i].y+ (this.radius/2));
            canvas.drawString(this.listofedges[i].value + "",this.listofedges[i].x,this.listofedges[i].y);
            canvas.sleep(1000);
            if(!this.listofedges[i].visted )
            {   this.listofedges[i].DFS(canvas,this.hops);

                if(this.listofedges[i].hops > (hops +1)){
                    if(this != this.root )this.visted = true;
                    canvas.drawLine(this.x + (this.radius/2),this.y+ (this.radius/2),this.listofedges[i].x+ (this.radius/2),this.listofedges[i].y+ (this.radius/2));
                    System.out.println("Number of hops="+this.hops);}


            }


        }



    }



    public void DTree(JCanvas canvas , int hops){
        int size = this.numberofedges;
        int i ;

        for(i = 0 ; i < size ; i++){
            if(!this.listofedges[i].visted )
            {   if(this.listofedges[i].hops == (hops +1)){
                    this.listofedges[i].DTree(canvas,this.listofedges[i].hops);
                    this.listofedges[i].visted = true;
                    canvas.drawOval(this.listofedges[i].x,this.listofedges[i].y,this.listofedges[i].radius,this.listofedges[i].radius);
                    canvas.drawString(this.listofedges[i].value + "",this.listofedges[i].x,this.listofedges[i].y);
                    canvas.sleep(500);
                    canvas.drawOval(this.x,this.y,this.radius,this.radius);
                    canvas.drawString(this.value + "",this.listofedges[i].x,this.listofedges[i].y);
                    canvas.sleep(500);
                    canvas.drawLine(this.listofedges[i].x+ (this.radius/2),this.listofedges[i].y+ (this.radius/2),this.x + (this.radius/2),this.y+ (this.radius/2));

                    System.out.println("Number of hops="+this.hops);}


            }

            if(this.listofedges[i].hops == 1) {
                canvas.drawLine(this.x+ (this.radius/2),this.y+ (this.radius/2),this.root.x + (this.radius/2),this.root.y+ (this.radius/2));
                canvas.drawOval(this.x, this.y, this.radius, this.radius);
            }




        }


    }

    public void set_tree(){
        System.out.println("The Binary tree is generated from the Adjacency list of the Graph");
        //System.out.println("The node closest"+this.get_smallest().value+" is taken as left node and furthest is right node"+this.get_largest().value);
        Node a = get_smallest();
        Node b = get_largest();
        if(a!= null ){
            this.LeftChild = a;
            a.set_tree();
                 }
        if(b!=null){
            this.RightChild = b;
            b.set_tree();
        }



    }

    public void GetTree(JCanvas canvas ){
        canvas.drawOval(this.x, this.y , this.radius, this.radius);
        if (this.LeftChild!=null)
            this.LeftChild.GetTree(canvas);
        else return;
        if (this.RightChild!=null)
            this.RightChild.GetTree(canvas);
        else return;
    }

    public Node get_smallest(){
        int smallest=1000;
        int i,size = this.numberofedges;
        Node smallest_node = null;
        for(i = 0 ; i < size ; i++) {
            int x = this.listofedges[i].x  ;
            int y = this.listofedges[i].y;
            int X = this.x , Y = this.y;
            if(((x - X)*(x-X) + (y-Y)*(y-Y))  > smallest){
                smallest = ((x - X)*(x-X) + (y-Y)*(y-Y));
                smallest_node = this.listofedges[i];
            }
        }
        return smallest_node;
    }


    public Node get_largest(){
        int largest=0;
        int i,size = this.numberofedges;
        Node largest_node = null;
        for(i = 0 ; i < size ; i++) {
            int x = this.listofedges[i].x ;
            int y = this.listofedges[i].y;
            int X = this.x , Y = this.y;
            if(((x - X)*(x-X) + (y-Y)*(y-Y))  > largest){
                largest = ((x - X)*(x-X) + (y-Y)*(y-Y));
                largest_node = this.listofedges[i];
            }
        }
        return largest_node;
    }









    public void info(){
        System.out.println("Node.Value = " + this.value);
        System.out.println("Node.x = " + this.x);
        System.out.println("Node.y = " + this.y);
        System.out.println("Node.radius = " + this.radius);
        System.out.println("Node.numberofnodes = " + this.numberofnodes);
        System.out.println("Number of hops from root node = " + this.hops);
    }





    public boolean check_Node(Node n){
        int x = n.x  ;
        int y = n.y;
        int X = this.x , Y = this.y;
        if (((x - X)*(x-X) + (y-Y)*(y-Y)) > (n.radius + this.radius)*(n.radius + this.radius))
            return true;
        else {
            System.out.println("Nodes are intersecting");
            JOptionPane.showMessageDialog(null, "The nodes are intersecting ");
            return false;}
    }


    public void push(Node n ){
        this.list[numberofnodes]=n;
        this.numberofnodes = this.numberofnodes + 1;
    }


    public void print(JCanvas canvas){
        int i ;
        canvas.setColor(Color.blue);
        canvas.drawOval(this.x,this.y,this.radius,this.radius);
        canvas.drawString(this.value + "",this.x,this.y);
        canvas.setColor(Color.BLACK);
        for (i=0 ; i <this.numberofnodes ; i++){
            canvas.drawOval(this.list[i].x,this.list[i].y,this.list[i].radius,this.list[i].radius);
            canvas.drawString(this.list[i].value + "",this.list[i].x,this.list[i].y);
            this.list[i].visted = false;
        }
        for (i=0 ; i <this.numberofedges ; i++){
            canvas.drawLine(this.x + (this.radius/2),this.y+ (this.radius/2),this.listofedges[i].x+ (this.radius/2),this.listofedges[i].y+ (this.radius/2));
        }

    }

    public void DrawEdges(int x, int y ,int x0 , int y0){
                    System.out.println("x = " +x+ " y = "+y+" x0 = "+x0+"y0="+y0);
                    Node a = this.root.getNode(x0,y0);
                    Node b = this.root.getNode(x,y);

                    if(a!=null && b!=null){
                        System.out.println(a.value +" draw edge "+ b.value);
                        a.draw_edges(b);}
                    else
                        System.out.println("WRONG NODE!");
                }

    public void draw_edges(Node n ){
        this.listofedges[this.numberofedges]=n;
        this.numberofedges = this.numberofedges + 1;
    }




    public Node getNode(int x , int y){
        int i ;
        int X = this.x - x;
        int Y = this.y - y;
        int radius = this.radius;

        if((((X)*(X))+(Y)*(Y))<(radius*radius))
            return this;

        for (i=0 ; i <this.numberofnodes ; i++){
            X = this.list[i].x - x;
            Y = this.list[i].y - y;
            radius = this.list[i].radius;

            if (((X*X)+(Y*Y))<(radius*radius))
                return this.list[i];
        }


        return null;



    }










}