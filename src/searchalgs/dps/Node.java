package searchalgs.dps;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tomi on 10/23/16.
 */
public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private boolean visited;
    private List<Node> neighbors;
    private boolean objective;

    public Node(final String name) {
        this.name = name;
    }

    public boolean isObjective() {
        return objective;
    }

    public void setObjective(boolean objective) {
        this.objective = objective;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(final boolean visited) {
        this.visited = visited;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(final List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}
