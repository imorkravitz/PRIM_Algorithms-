
/** Or Kravitz, ID : 308248293
 *  Nadav Voikovitch, ID : 308526508*/
package test;
import java.util.Collection;
import java.util.LinkedList;
/** This class represent a Node
 * we will use Comparable in order to compere between Nodes type*/
public class Node implements Comparable <Node> {
    //members:
    String name;
    int key;
    private Node nFather;
    private LinkedList<Edge> edgesList;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }
    public Node getFather() { return nFather; }
    public void setFather(Node nFather) { this.nFather = nFather; }
    public LinkedList<Edge> getEdgesList() { return edgesList; }
    public Node() { this.edgesList = new LinkedList<Edge>(); }

    /**Node C'tor */
    public Node(String name,int key, Node nFather) {
        this.name = name;
        this.key = key;
        this.nFather = nFather;
    }

    @Override
    public int compareTo(Node node) {
        if (this.getKey() < node.getKey()) {
            return -1;
        } else if (this.getKey() > node.getKey()) {
            return 1;
        }
        return 0;
    }
}
