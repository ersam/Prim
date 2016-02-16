/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primalgorithm;

import graph.BadGraphParametersException;
import graph.Graph;
import graph.GraphItem;
import graph.NegativeNodeValueException;
import graph.TheSameNodeValueException;

/**
 *
 * @author Eryk
 */
public class PrimAlgorithm {

    private Graph graph;

    public PrimAlgorithm(Graph graph) {
        this.graph = graph;
    }
    
    public Graph findMinimumSpanningTree(Graph graph) throws NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException {
        Graph MST = new Graph(graph.getNumberOfNodes());
        
        for(int i = 0; i < graph.getNumberOfNodes(); i++) {
            for(int j = 0; j < i; j++) {
                
            }
        }
        
        return MST;
    }
    
    public GraphItem findFirstNode(Graph graph) {
        if( graph == null) {
            return null;
        }
        GraphItem item = null;
        for( int i = 0; i < graph.getNumberOfNodes(); i++ ) {
            for( int j = 0; j < graph.getNumberOfNodes(); j++ ) {
                if( i != j && (item = graph.getItem(i, j)) != null) {
                    return item;
                }
            }
        }
        
        return item;
    }

    public static void main(String[] args) {

    }

}
