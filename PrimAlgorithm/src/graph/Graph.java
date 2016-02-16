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

    public Graph(int numberOfNodes) throws NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException {
        checkCorrectnessOfParameters(numberOfNodes);
        this.numberOfNodes = numberOfNodes;
        this.numberOfEdges = 0;
        initializeGraph(numberOfNodes);
    }

    public Graph(String file) throws FileNotFoundException, SuchElementAlreadyExistException, NotEmptyFileException, NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException, OutOfSizeException {
        readFile(file);
    }
    
    private void checkCorrectnessOfParameters(int numberOfNodes) throws BadGraphParametersException {
        if( numberOfNodes <= 0) {
            throw new BadGraphParametersException("Bad parameters in graph " + this.getClass());
        }
    }
    
    private void initializeGraph(int numberOfNodes) throws NegativeNodeValueException, TheSameNodeValueException {
        this.graph = new GraphTree[numberOfNodes];
        for(int i = 0; i < numberOfNodes; i++) {
            graph[i] = new GraphTree(null);
        }
    }
    
    private void readFile(String file) throws FileNotFoundException, SuchElementAlreadyExistException, NotEmptyFileException, NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException, OutOfSizeException {
        Scanner scanner = new Scanner(new File(file));
        
        numberOfNodes = scanner.nextInt();
        initializeGraph(numberOfNodes);
        int edges = scanner.nextInt();
        
        for(int i = 0; i < edges; i++) {
            addToGraph(new GraphItem(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        
        if( scanner.hasNext() ) {
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
            throw new OutOfSizeException("One of the node is out of the size of the graph and cannot be added!");
        }
        insertIntoGraph(item);
    }

    private void insertIntoGraph(GraphItem item) throws SuchElementAlreadyExistException {
        graph[item.getFrom()].insert(item);
        int tmp = item.getFrom();
        item.setFrom(item.getTo());
        item.setTo(tmp);
        graph[item.getFrom()].insert(item);
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
