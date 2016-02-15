/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primalgorithm;

import graph.BadGraphParametersException;
import graph.GraphItem;
import graph.NegativeNodeValueException;
import graph.OutOfSizeException;
import graph.SuchElementAlreadyExistException;
import graph.TheSameNodeValueException;
import graph.UndirectedGraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Eryk
 */
public class PrimAlgorithm {

    private UndirectedGraph uGraph;
    
    public UndirectedGraph readFile(String file) throws FileNotFoundException, NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException, OutOfSizeException, SuchElementAlreadyExistException {
        UndirectedGraph graph;
        Scanner scanner = new Scanner(new File(file));
        
        graph = setGraphParameters(scanner.nextInt(), scanner.nextInt());
        
        for(int i = 0; i < graph.getNumberOfEdges(); i++) {
            graph.addToGraph(new GraphItem(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        
        return graph;
    }
    
    private UndirectedGraph setGraphParameters(int numberOfNodes, int numberOfEdges) throws NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException {
        return (new UndirectedGraph(numberOfNodes, numberOfEdges));
    }
    
    public static void main(String[] args) {
        
    }



    
}
