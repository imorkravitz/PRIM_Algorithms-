/** Or Kravitz, ID : 308248293
*/


package test;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Graph graph = new Graph(20);

        String[] nodes = {"0", "1", "2", "3", "4",
                "5","6","7","8","9","10",
                "11", "12", "13", "14",
                "15", "16","17","18","19"};
        int i = 0;

        for (String string : nodes) {
            graph.getNode()[i].setName(string);
            i++;
        }

        graph.addEdge("0", "1", 1);
        graph.addEdge("1", "2", 2);
        graph.addEdge("2", "3", 12);
        graph.addEdge("3", "4", 4);
        graph.addEdge("4", "5", 5);
        graph.addEdge("5", "6", 6);
        graph.addEdge("6", "7", 11);
        graph.addEdge("7", "8", 8);
        graph.addEdge("8", "9", 9);
        graph.addEdge("9", "10", 10);
        graph.addEdge("10", "11", 11);
        graph.addEdge("11", "12", 43);
        graph.addEdge("12", "13", 13);
        graph.addEdge("13", "14", 70);
        graph.addEdge("14", "15", 3);
        graph.addEdge("15", "16", 16);
        graph.addEdge("16", "17", 34);
        graph.addEdge("17", "18", 18);
        graph.addEdge("18", "19", 25);
        graph.addEdge("19", "0", 20);
        graph.addEdge("1", "19", 4);
        graph.addEdge("1", "15", 5);
        graph.addEdge("2", "14", 7);
        graph.addEdge("2", "10", 24);
        graph.addEdge("3", "8", 25);
        graph.addEdge("3", "19", 26);
        graph.addEdge("4", "8", 27);
        graph.addEdge("4", "9", 28);
        graph.addEdge("5", "19", 29);
        graph.addEdge("5", "10", 30);
        graph.addEdge("6", "17", 31);
        graph.addEdge("6", "11", 6);
        graph.addEdge("7", "1", 33);
        graph.addEdge("7", "14", 8);
        graph.addEdge("8", "16", 35);
        graph.addEdge("8", "11", 36);
        graph.addEdge("8", "3", 37);
        graph.addEdge("9", "18", 7);
        graph.addEdge("9", "12", 39);
        graph.addEdge("9", "10", 45);
        graph.addEdge("10", "0", 41);
        graph.addEdge("10", "16", 42);
        graph.addEdge("10", "1", 90);
        graph.addEdge("11", "6", 44);
        graph.addEdge("11", "19", 45);
        graph.addEdge("11", "13", 46);
        graph.addEdge("12", "2", 47);
        graph.addEdge("12", "4", 3);
        graph.addEdge("13", "17", 49);
        graph.addEdge("14", "1", 22);
        graph.addEdge("15", "2", 65);

        System.out.println("Graph:");
        Graph.printG(graph);

        System.out.println("\nGraph After Run Minimum Spanning Tree :");
        ArrayList<Node> mst = PRIM.PrimMST(graph);
        PRIM.PrintMST(mst);

        System.out.println();

        Edge newEdge = new Edge(mst.get(1), mst.get(2),102); // "Heaviest" weighted Edge -> not going to change the Graph
        System.out.println("\nGraph do not change ");
        PRIM.addEdgeToMst(mst,newEdge);
        PRIM.PrintMST(mst);

        System.out.println();

        Edge newEdge2 = new Edge(mst.get(2), mst.get(19),3); // Vs Not Heavy weight -> in ensure will Change the Graph
        System.out.println("\nGraph after change in 1 Edge");
        PRIM.addEdgeToMst(mst,newEdge2);
        PRIM.PrintMST(mst);
    }
}
