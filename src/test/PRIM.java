/** Or Kravitz, ID : 308248293
 */
package test;
import java.util.*;

class PRIM {
    public static void removeEdge(LinkedList<Edge> edge, ArrayList<Node> mst, int index) {
        if (index == 0) {
            Node n1 = new Node(mst.get(0).getName(), 0, null);
            Node n2 = new Node(mst.get(1).getName(), mst.get(1).getKey(), n1);
            Edge e = new Edge(n1, n2, mst.get(1).getKey());
            for (int k = 0; k < edge.size(); k++) {
                edge.remove(k);
            }
            edge.add(e);
            return;
        }

        Node source = new Node(mst.get(index).getName(), 0, mst.get(index - 1));
        Node dest = new Node(mst.get(index + 1).getName(), mst.get(index + 1).getKey(), source);
        Edge e = new Edge(source, dest, mst.get(index + 1).getKey());
        for (int k = 0; k < edge.size(); k++) {
            edge.remove(k);
        }
        edge.add(e);
    }

    public static ArrayList<Node> PrimMST(Graph g) {
        Node root = g.getNode()[0];
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 0; i < g.getNode().length; i++) {
            g.getNode()[i].setKey(Integer.MAX_VALUE);
            queue.add(g.getNode()[i]);
        }

        root.setKey(0);
        root.setFather(null);
        ArrayList<Node> tree = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node recantNode = queue.poll();
            LinkedList<Edge> rEdgeList = recantNode.getEdgesList();

            for (Edge edge : rEdgeList) {
                Node v = edge.getDest();
                int weight = edge.getWeight();
                if (weight < v.getKey() && queue.contains(edge.getDest())) {
                    queue.remove(v);
                    v.setFather(recantNode);
                    v.setKey(weight);
                    queue.add(v);
                }
            }
            tree.add(recantNode);
        }
        for (int i = 0; i < tree.size() - 1; i++) {
            removeEdge(tree.get(i).getEdgesList(), tree, i);
        }
        return tree;
    }

    public static List<Edge> circlePath(Node src, Node dest, ArrayList<Node> tree) {
        List<Edge> path = new ArrayList<Edge>();
        if (src.getName().equals(dest.getName())) {
            Edge newEdge = new Edge(src, dest, 0);
            path.add(newEdge);
            return path;
        }

        for (int i = tree.indexOf(src); i < tree.size(); i++) {
            if (!tree.get(i).getName().equals(dest.getName())) {
                path.add(tree.get(i).getEdgesList().getFirst());
            } else break;
        }
        return path;
    }

    public static void addEdgeToMst(ArrayList<Node> mst, Edge newEdge) {
        List<Edge> path = circlePath(newEdge.getSource(), newEdge.getDest(), mst);
        if (path == null)
            return;
        int max = Integer.MIN_VALUE;
        Edge e = null;

        for (int i = 0; i < path.size(); i++) {
            if (path.get(i).getWeight() > max) {
                max = path.get(i).getWeight();
                e = path.get(i);
            }
        }

        if (newEdge.getWeight() < max) {
            for (int i = 0; i < mst.size(); i++) {
                if (mst.get(i).getName().equals(e.getSource().getName())) {
                    mst.get(i).getEdgesList().remove();
                    break;
                }
            }

            for (int i = 0; i < mst.size(); i++) {
                if (mst.get(i).getName().equals(newEdge.getSource().getName())) {
                    mst.get(i).getEdgesList().add(newEdge);
                    break;
                }
            }

            for (int i = 0; i < mst.size(); i++) {
                if (mst.get(i).getName().equals(e.getDest().getName())) {
                    mst.get(i).setKey(newEdge.getWeight());
                    mst.get(i).setFather(newEdge.getSource());
                    break;
                }
            }
        }
    }
    public static void PrintMST(ArrayList<Node> tree) {
        System.out.print("Edges: ");
        for(int i=1; i < tree.size() ; i++){
            System.out.print("(" + tree.get(i).getFather().getName() + "," + tree.get(i).name + "," +
                    tree.get(i).key + ")" + " -> ");
        }
    }
}



