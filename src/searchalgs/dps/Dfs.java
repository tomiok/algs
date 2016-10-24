package searchalgs.dps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by tomi on 10/23/16.
 */
public class Dfs {

    final Stack<Node> nodeStack = new Stack<>();

    public Dfs() {

    }

    public void doDfs(final List<Node> nodes) {

        nodes.forEach(n -> {
            if (!n.isVisited()) {
                n.setVisited(true);
                dfsWithStack(n);
            }
        });

        for (final Node n : nodes) {


        }
    }

    private void dfsWithStack(final Node rootNode) {
        nodeStack.add(rootNode);
        rootNode.setVisited(true);
        while (!this.nodeStack.isEmpty()) {
            final Node currentNode = this.nodeStack.pop();
            System.out.println("Removed: " + currentNode);
            if (currentNode.isObjective()) {
                currentNode.setVisited(true);
                System.out.println("Objective aquired: " + currentNode);
                return;
            }
            for (final Node n : rootNode.getNeighbors()) {
                if (!n.isVisited()) {
                    n.setVisited(true);
                    this.nodeStack.push(n);
                }
            }
        }
    }
}

class Main {

    public static void main(final String[] args) {
        final Dfs dfs = new Dfs();
        final Node n1 = new Node("node 1");
        final Node n2 = new Node("node 2");
        final Node n3 = new Node("node 3");

        n1.setNeighbors(Arrays.asList(n2, n3));
        n2.setNeighbors(Arrays.asList(n3));
        n3.setNeighbors(null);

        n1.setObjective(false);
        n2.setObjective(true);
        n3.setObjective(false);

        final List<Node> nodes = new ArrayList<>();
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);

        dfs.doDfs(nodes);
    }
}

