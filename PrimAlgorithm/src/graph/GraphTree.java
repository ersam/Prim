package graph;

/**
 *
 * @author Eryk
 */
public class GraphTree extends Tree<GraphItem> {

    public GraphTree(GraphItem item) {
        super(item);
    }

    private GraphTree(GraphItem item, int depth) {
        super(item, depth);
    }

    public void insert(GraphItem item) {
        if (item == null) {
            return;
        }

        if (item.getWeight() > this.getItem().getWeight()) {
            this.setRight(goToNode((GraphTree) this.getRight(), item));
        } else if (item.getWeight() <= this.getItem().getWeight()) {
            this.setLeft(goToNode((GraphTree) this.getLeft(), item));
        }
    }

    private GraphTree goToNode(GraphTree node, GraphItem item) {
        if (node == null) {
            node = new GraphTree(item, this.getDepth() + 1);
        } else {
            node.insert(item);
        }

        return node;
    }

    public String print() {
        String tree = "";

        if ( this.getLeft() != null ) {
            GraphTree tmp = (GraphTree) this.getLeft();
            tree = tree.concat(tmp.print());
        }
        
        tree = tree.concat(this.getItem().printItem());
        
        if ( this.getRight() != null ) {
            GraphTree tmp = (GraphTree) this.getRight();
            tree = tree.concat(tmp.print());
        }

        return tree;
    }
}