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
public class UndirectedGraph extends Graph {
       
    public UndirectedGraph( int numberOfNodes, int numberOfEdges ) throws NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException {
        super(numberOfNodes, numberOfEdges);
    }
    
    
}
