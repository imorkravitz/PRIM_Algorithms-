/** Or Kravitz, ID : 308248293
 */

package test;
/** This class represent a Edge
 * each edge contains weight
 * defined Edge type between 2 Nodes*/
public class Edge {

    private Node source;
    private Node dest;
    private int weight;

    public Edge(Node source, Node dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Node getSource() {
        return source;
    }
    public Node getDest() {
        return dest;
    }
    public int getWeight() {
        return weight;
    }
    /** This function is printing Edge */
    public void printEdge () {
        System.out.print("(" + this.source.getName() + "," + this.dest.getName() + "," + this.weight + ")" + " -> ");
    }
}
