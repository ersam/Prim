/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primalgorithm;

import graph.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author Eryk
 */
public class PrimAlgorithmTest {
    
    public PrimAlgorithmTest() {
    }

    //@Test
    public void testFindMinimumSpanningTree() {
    }

    @Test
    public void testFindFirstNode() {
        Graph graph;
        try {
            graph = new Graph("C:\\Users\\Eryk\\Desktop\\graph1.txt");
        } catch (FileNotFoundException | SuchElementAlreadyExistException | NotEmptyFileException | NegativeNodeValueException | TheSameNodeValueException | BadGraphParametersException | OutOfSizeException ex) {
            System.err.println(ex.getMessage());
            return;
        }
        System.out.println(graph.print());
        PrimAlgorithm prim = new PrimAlgorithm(graph);
        System.out.println(prim.findFirstNode(graph).printItem());
    }

    @Test
    public void testMain() {
    }
    
}
