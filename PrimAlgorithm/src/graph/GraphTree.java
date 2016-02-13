package graph;

import Tree.Tree;

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

    public void insert(GraphItem item) throws SuchElementAlreadyExistException {
        if (item == null) {
            return;
        }

        if(this.getItem() == null) {
            this.setItem(item);
            return;
        }
        if (item.getTo() > this.getItem().getTo()) {
            this.setRight(goToNode((GraphTree) this.getRight(), item));
        } else if (item.getTo() < this.getItem().getTo()) {
            this.setLeft(goToNode((GraphTree) this.getLeft(), item));
        } else throw new SuchElementAlreadyExistException("The edge between nodes "
                + item.getFrom() + " and " + item.getTo() + " already exist in graph!" );
    }

    private GraphTree goToNode(GraphTree node, GraphItem item) throws SuchElementAlreadyExistException {
        if (node == null) {
            node = new GraphTree(item, this.getDepth() + 1);
        } else {
            node.insert(item);
        }

        return node;
    }

    public String print() {
        String tree = "";

        if(this.getItem() == null) {
            return tree;
        }
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
    
    public GraphItem get(int index) throws NoSuchElementException {
        if( this.getItem().getTo() < index ) {
            return searchFurther((GraphTree) this.getRight(), index);
        } else if ( this.getItem().getTo() > index ) {
            return searchFurther((GraphTree) this.getLeft(), index);
        } else return this.getItem();
        
        
    }
    
    private GraphItem searchFurther( GraphTree node, int index) throws NoSuchElementException {
        if (node == null) {
            throw new NoSuchElementException("There is no such element!");
        } else {
            return node.get(index);
        }
    }
}
