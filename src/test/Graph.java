/** Or Kravitz, ID : 308248293*/

package test;
/** This class represent Graph
 * each Graph has vertices and array of nodes*/
public class Graph {

    private int vertices;
    private Node[] node;

    public Node[] getNode() {
        return node;
    }

    public Graph(int vertices) {
        this.vertices = vertices;
        this.node = new Node[this.vertices];
        for (int i = 0; i < vertices; i++)
            this.node[i] = new Node();
    }

    public void addEdge(String sourceName, String destName, int weight) {
        Node source = new Node();
        Node dest = new Node();

        for (int i=0; i < this.node.length; i++){
            if(this.node[i].name.equals(sourceName)) {
                source = node[i];
            }

            if(this.node[i].name.equals(destName)) {
                dest = node[i];
            }
        }
        /** Each Edge is defined between 2 Vertex and contains weight */
        Edge edge1 = new Edge(source, dest, weight);
        Edge edge2 = new Edge(dest , source, weight);
        source.getEdgesList().add(edge1);
        dest.getEdgesList().add(edge2);
    }

    public static void printG(Graph g){
        for (int i=0; i < g.vertices; i++){
            System.out.print("\nVertax: " + g.getNode()[i].getName() + " Edges: ");
            for (int j=0; j < g.getNode()[i].getEdgesList().size(); j++){
                g.getNode()[i].getEdgesList().get(j).printEdge();
            }
        }
    }
}
