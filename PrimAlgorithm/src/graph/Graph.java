/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Eryk
 */
public class Graph {

    private GraphTree[] graph;
    private int numberOfNodes;
    private int numberOfEdges;

    public Graph(int numberOfNodes) throws BadGraphParametersException {
        checkCorrectnessOfParameters(numberOfNodes);
        this.numberOfNodes = numberOfNodes;
        this.numberOfEdges = 0;
        initializeGraph(numberOfNodes);
    }
    
    private void initializeGraph(int numberOfNodes) {
        this.graph = new GraphTree[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            graph[i] = new GraphTree(null);
        }
    }

    public Graph(String file) throws FileNotFoundException, SuchElementAlreadyExistException, NotEmptyFileException, NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException, OutOfSizeException {
        readFile(file);
    }

    private void checkCorrectnessOfParameters(int numberOfNodes) throws BadGraphParametersException {
        if (numberOfNodes <= 0) {
            throw new BadGraphParametersException("Bad parameters in graph!");
        }
    }

    

    private void readFile(String file) throws FileNotFoundException, SuchElementAlreadyExistException, NotEmptyFileException, NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException, OutOfSizeException {
        Scanner scanner = new Scanner(new File(file));

        numberOfNodes = scanner.nextInt();
        initializeGraph(numberOfNodes);
        int edges = scanner.nextInt();

        for (int i = 0; i < edges; i++) {
            addToGraph(new GraphItem(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }

        if (scanner.hasNext()) {
            throw new NotEmptyFileException("File contains too much data");
        }
    }

    public int getNumberOfNodes() {
        return this.numberOfNodes;
    }

    public int getNumberOfEdges() {
        return this.numberOfEdges;
    }

    public GraphItem getItem(int from, int to) {
        try {
            return graph[from].get(to);
        } catch (NoSuchElementInGraphException ex) {
            return null;
        }
    }
    
    public GraphTree getAllEdges(int node) {
        return graph[node];
    }

    public void addToGraph(GraphItem item) throws OutOfSizeException, SuchElementAlreadyExistException {
        if (item == null) {
            return;
        }
        if (item.getFrom() >= this.numberOfNodes || item.getTo() >= this.numberOfNodes) {
            throw new OutOfSizeException("One of the node is out of the size of the graph and cannot be added!");
        }
        insertIntoGraph(item);
    }

    private void insertIntoGraph(GraphItem item) throws SuchElementAlreadyExistException {
        if (item.getFrom() > item.getTo()) {
            graph[item.getFrom()].insert(item);
        } else {
            graph[item.getTo()].insert(item);
        }
        numberOfEdges++;
    }

    public String print() {
        String stringGraph = "";
        for (int i = 0; i < this.numberOfNodes; i++) {

            stringGraph = stringGraph.concat("tree[" + i + "]:\n" + graph[i].print());
        }

        return stringGraph;
    }

}
