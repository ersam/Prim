/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primalgorithm;

import graph.BadGraphParametersException;
import graph.Graph;
import graph.NegativeNodeValueException;
import graph.NotEmptyFileException;
import graph.OutOfSizeException;
import graph.SuchElementAlreadyExistException;
import graph.TheSameNodeValueException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Eryk
 */
public class PrimAlgorithm {

    private Graph graph;

    public PrimAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public Graph findMinimumSpanningTree(Graph graph) throws NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException, OutOfSizeException, SuchElementAlreadyExistException {
        Graph MST = new Graph(graph.getNumberOfNodes());
        

        return MST;
    }

    public static void main(String[] args) {
        Graph g = null;
        try {
            g = new Graph("C:\\Users\\Eryk\\Desktop\\graph1.txt");
        } catch (FileNotFoundException | SuchElementAlreadyExistException | NotEmptyFileException | NegativeNodeValueException | TheSameNodeValueException | BadGraphParametersException | OutOfSizeException ex) {
            System.err.println(ex.getMessage());
        }

        PrimAlgorithm p = new PrimAlgorithm(g);
        Graph g1 = null;
        try {
            g1 = p.findMinimumSpanningTree(g);
        } catch (NegativeNodeValueException | TheSameNodeValueException | BadGraphParametersException | OutOfSizeException | SuchElementAlreadyExistException ex) {
            System.err.println(ex.getMessage());
        }
        if (g1 != null) {
            System.out.println(g1.print());
        }

    }

}
