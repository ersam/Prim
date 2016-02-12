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
        graph[item.getFrom()].insert(item);
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
    
    public GraphTree minimumSpanningTree() {
        return null;
    }
    
    public void readFile( String path ) {
        
    }
}
