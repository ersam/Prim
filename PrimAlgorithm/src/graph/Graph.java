/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Eryk
 */
public abstract class Graph {

    private GraphTree[] graph;
    private final int numberOfNodes;
    private final int numberOfEdges;

    public Graph(int numberOfNodes, int numberOfEdges) throws NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException {
        checkCorrectnessOfParameters(numberOfNodes, numberOfEdges);
        this.numberOfNodes = numberOfNodes;
        this.numberOfEdges = numberOfEdges;
        this.graph = new GraphTree[numberOfNodes];
        initializeGraph();
    }
    
    private void checkCorrectnessOfParameters(int numberOfNodes, int numberOfEdges) throws BadGraphParametersException {
        if(numberOfEdges <= 0 || numberOfNodes <= 0) {
            throw new BadGraphParametersException("Bad parameters in graph " + this.getClass());
        }
    }
    
    private void initializeGraph() throws NegativeNodeValueException, TheSameNodeValueException {
        for(int i = 0; i < numberOfNodes; i++) {
            graph[i] = new GraphTree(null);
        }
    }

    public int getNumberOfNodes() {
        return this.numberOfNodes;
    }

    public int getNumberOfEdges() {
        return this.numberOfEdges;
    }

    public GraphItem getItem(int from, int to) {
        GraphItem item = null;
        try {
            item = graph[from].get(to);
        } catch (NoSuchElementInGraphException ex) {
            System.out.println(ex.getMessage());
        }

        return item;
    }

    public void addToGraph(GraphItem item) throws OutOfSizeException, SuchElementAlreadyExistException {
        if (item == null) {
            return;
        }
        if (item.getFrom() >= this.numberOfNodes || item.getTo() >= this.numberOfNodes) {
            throw new OutOfSizeException("One of the node is out of the size of graph and cannot be added!");
        }
        insertIntoGraph(item);
    }

    private void insertIntoGraph(GraphItem item) throws SuchElementAlreadyExistException {
        graph[item.getFrom()].insert(item);
        int tmp = item.getFrom();
        item.setFrom(item.getTo());
        item.setTo(tmp);
        graph[item.getFrom()].insert(item);
    }

    public String print() {
        String stringGraph = "";
        for (int i = 0; i < this.numberOfNodes; i++) {

            stringGraph = stringGraph.concat("tree[" + i + "]:\n" + graph[i].print());
        }

        return stringGraph;
    }

    
}
