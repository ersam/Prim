/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eryk
 */
public abstract class Graph {
    private GraphTree [] graph;
    private final int numberOfNodes;
    private final int numberOfEdges;
    
    public Graph( int numberOfNodes, int numberOfEdges ) {
        this.graph = new GraphTree[numberOfNodes];
        this.numberOfNodes = numberOfNodes;
        this.numberOfEdges = numberOfEdges;
    }
    
    public int getNumberOfNodes() {
        return this.numberOfNodes;
    }
    
    public int getNumberOfEdges(){
        return this.numberOfEdges;
    }
    
    public GraphItem getItem(int from, int to) {
        GraphItem item = null;
        try {
            item = graph[from].get(to);
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
        
        return item;
    }
    
    public void addToGraph( GraphItem item ) throws OutOfSizeException {
        if( item == null ) {
            return;
        }
        if( item.getFrom() >= this.numberOfNodes || item.getTo() >= this.numberOfNodes) {
            throw new OutOfSizeException("One of the node is out of the size of graph and cannot be added!");
        }
        insertIntoGraph(item);
        int tmp = item.getFrom();
        item.setFrom(item.getTo());
        item.setTo(tmp);
        insertIntoGraph(item);
    }
    
    private void insertIntoGraph( GraphItem item ) {
        try {
            graph[item.getFrom()].insert(item);
        } catch (SuchElementAlreadyExistException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public String print() {
        String stringGraph = "";
        for(int i = 0; i < this.numberOfNodes; i++) {
            
            stringGraph.concat(graph[i].print());
        }
        
        return stringGraph;
    }
}
