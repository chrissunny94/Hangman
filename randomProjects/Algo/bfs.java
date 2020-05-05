import java.util.*;
import java.lang.*;
import java.io.*;
//This is the code for BFS 

public class bfs {


    public static int pos ;

	public static int[][] adj = {             //A  B  C  D  E
  								{ 0, 1, 1, 0, 0, },    //A
  								{ 0, 0, 0, 0, 0, },	   //B
  								{ 0, 0, 0, 1, 0, },    //C
  								{ 0, 0, 0, 0, 1, },    //D
  								{ 0, 0, 0, 0, 0, }     //E
							};

	public static int[][] weights = {             //A  B  C  D  E
  												{ 0, 0, 0, 0, 0, },    //A
  												{ 0, 0, 0, 0, 0, },	   //B
  												{ 0, 0, 0, 0, 0, },    //C
  												{ 0, 0, 0, 0, 0, },    //D
  												{ 0, 0, 0, 0, 0, }     //E
									};

   
   

   public static void main(String args[]){

   		
   		int size = 5 , i , j , pos =0;

        ArrayList<Node> node = new ArrayList<Node>();
   		//Creating a list of Nodes 
   		
   		//Constructing the nodes
   		node.add(new Node('A' , 5));
   		node.add(new Node('B' , 4));
   		node.add(new Node('C' , 3));
   		node.add(new Node('D' , 2));
   		node.add(new Node('E' , 1));

   	    
   	    
        

        //#################################################
   	    for (i = 0 ; i < size ; i++)
   	    	for (j = 0 ; j < size ; j++){
   	    		if ( adj[i][j] == 1 ){
   	    			node.get(i).add_edge( node.get(j) , weights[i][j] );

   	    		}
   	    	} 

   	   //###################################################

        for(i = 0 ; i < size ; i++){
        	node.get(i).info();

        }








        
    }




// public static void bfs( Node temp ,  int size  ){
//     int count = 0 ;
//     int pos = 0;
//     int current_height = 0 ;
// 	while (count < size){
// 		if ( pos == current_height){
// 			System.out.println(temp.data); }
// 		if (temp.lnode != null)
// 			{temp = temp.lnode; pos++;}
		
// 		else if (temp.rnode != null){
// 			temp = temp.rnode;  pos++;}
// 		else if (temp.root_node != null)
// 			{temp = temp.root_node; pos--;}
			

// 	}

	
}




	



     




	





class Node{
	public char data;
	public int value;
	
	public Edge root = null , lnode =null ,rnode = null;
	public Node root_node;
	public int status;
	//Constructor for the nodes	
	public Node(char c , int value){
		this.data = c;
		this.value = value;
		this.status = 0;
	}

	public  void add_edge(Node other , int weight ){
		if( other.value > this.value  && this.root == null)
			root = new Edge(this , other , weight );
		if( other.value < this.value  && this.lnode==null ){
			lnode = new Edge(this , other , weight );}
		else if( other.value < this.value  && this.rnode==null )
			rnode = new Edge(this , other , weight );
	}

	public void info(){
		//System.out.println("Node:" + this.data +" RootNode:" + root.node2 + " LeftNode:" + lnode.node2 + "RightNode:" +rnode.node2);
	    
        System.out.println("This is the graph for the given Adj.Matrix");

	    System.out.println("Node:" + this.data);
	    if (root_node != null)
	    	System.out.println("Root(Node on Top):" + root_node.data );
	    if (lnode != null)
	    	System.out.println("LeftNode:" + lnode.node2.data);
	    if (rnode != null)
	    	System.out.println("RightNode:" + rnode.node2.data);

	    System.out.println();


	}
}


class Edge{

	public Node node1 ;
	public Node node2 ;

	public int weight;


	public Edge(Node node1 , Node node2 , int weight){

		node2.root_node=node1;

		this.node1 = node1;
		node1.status = 1;
		this.node2 = node2;
		node2.status = 1;
		this.weight = weight;


	}




}