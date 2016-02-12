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
public class Graph {
    GraphTree [] graph;
    public final int numberOfNodes;
    public final int numberOfEdges;
    
    public Graph( int numberOfNodes, int numberOfEdges ) {
        this.graph = new GraphTree[numberOfNodes];
        this.numberOfNodes = numberOfNodes;
        this.numberOfEdges = numberOfEdges;
    }
    
    private void insertIntoGraph( GraphItem item ) {
        try {
            graph[item.getFrom()].insert(item);
        } catch (SuchElementAlreadyExistException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private void addToGraph( GraphItem item ) {
        insertIntoGraph(item);
        int tmp = item.getFrom();
        item.setFrom(item.getTo());
        item.setTo(tmp);
        insertIntoGraph(item);
    }
    
    public String print() {
        String stringGraph = "";
        for(int i = 0; i < this.numberOfNodes; i++) {
            
            stringGraph.concat(graph[i].print());
        }
        
        return stringGraph;
    }
}
