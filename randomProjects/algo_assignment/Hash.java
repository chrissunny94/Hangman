package algo_assignment;

/**
 * Created by stuxnet-il on 8/11/15.
 */
public  class Hash extends Node {

    private int[][] hash_table = new Int[ 80 ][ 80 ];

    private int[] hash_index = new int[100];
    private Node[] node_list = new Node[100];

    private int size = 0 ;
    private int resolution;
    private int X ;
    private int Y ;


 // Parametes of the Hash Constructor
    //X , Y -> x /resolution , y / resolution
    //Node address will be mapped to
    //Resolution
    public Hash(int x , int y , Node n  ){
        this.resolution = resolution ;
        this.X = x / resolution;
        this.Y = y / resolution;

        this.node_list[this.size] = n ;
        this.size ++;




    }

    public Node get_node(int x , int y ){
        x = x / this.resolution;
        y = y / this.resolution;
        Node n = Hashing( x , y );
        return n;
    }

    public Node Hashing(int x , int y){
        int index = hash_table[x][y];
        return get_node_from_indextable( index );

    }

    public Node get_node_from_indextable( int index ){
        return node_list[index];
    }


}
