/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primalgorithm;

import graph.Graph;
import graph.GraphItem;

/**
 *
 * @author Eryk
 */
public class PrimAlgorithm {

    private Graph graph;
    
    public Graph findMinimumSpanningTree(Graph graph) {
        Graph MST = new Graph();
        
        
        return MST;
    }
    
    public GraphItem findFirstNode(Graph graph) {
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
