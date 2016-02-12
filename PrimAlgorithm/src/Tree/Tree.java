package Tree;

public abstract class Tree<T> {

    private Tree<T> left;
    private Tree<T> right;
    private T item;
    private final int depth;

    public Tree(T item) {
        this.left = null;
        this.right = null;
        this.item = item;
        this.depth = 0;
    }
    
    public Tree(T item, int depth) { // should be private in class-child
        this.left = null;
        this.right = null;
        this.item = item;
        this.depth = depth;
    }

    public T getItem() {
        return this.item;
    }

    public Tree<T> getLeft() {
        return this.left;
    }

    public Tree<T> getRight() {
        return this.right;
    }
    
    public int getDepth() {
        return this.depth;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    public void setRight(Tree<T> right) {
        this.right = right;
    }
}
