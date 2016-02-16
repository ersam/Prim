/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author Eryk
 */
public class GraphTest {

    private static GraphItem[] graphItemTab;
    private final int NUMBER_OF_SAMPLE_ITEMS = 7;
    private final int MAX_VALUE_IN_GRAPH = 15;
    private static Graph graph;

    private void initialize() throws NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException {
        graph = new Graph(NUMBER_OF_SAMPLE_ITEMS);
        graphItemTab = new GraphItem[NUMBER_OF_SAMPLE_ITEMS];

        graphItemTab[0] = new GraphItem(1, 3, 2);
        graphItemTab[1] = new GraphItem(3, 2, 4);
        graphItemTab[2] = new GraphItem(5, 4, 3);
        graphItemTab[3] = new GraphItem(2, 5, 8);
        graphItemTab[4] = new GraphItem(3, 5, 7);
        graphItemTab[5] = new GraphItem(5, 1, 4);
        graphItemTab[6] = new GraphItem(4, 3, 5);

    }

    //@Test
    public void testAddToGraph() {
        System.out.println("addToGraph test:\n");
        try {
            initialize();
        } catch (NegativeNodeValueException | BadGraphParametersException ex) {
            System.err.println(ex.getMessage());
            return;
        } catch (TheSameNodeValueException ex) {
            System.err.println(ex.getMessage());
        }

//        for (int i = 0; i < NUMBER_OF_SAMPLE_ITEMS; i++) {
//            System.out.print(graphItemTab[i].printItem());
//        }
        for (int i = 0; i < graph.getNumberOfNodes(); i++) {
            try {
                graph.addToGraph(graphItemTab[i]);
            } catch (OutOfSizeException | SuchElementAlreadyExistException ex) {
                System.err.println(ex.getMessage());
            }
        }

        System.out.println(graph.print());
        System.out.println(graph.getNumberOfEdges());
    }

    @Test
    public void readFileTest() {
        System.out.println("readFile() test:\n");
        try {
            graph = new Graph("C:\\Users\\Eryk\\Desktop\\graph1.txt");
        } catch (FileNotFoundException | SuchElementAlreadyExistException | NotEmptyFileException | NegativeNodeValueException | TheSameNodeValueException | BadGraphParametersException | OutOfSizeException ex) {
            System.err.println(ex.getMessage());
            return;
        }
        System.out.print("Graph from file:\n" + graph.print());
        
        try {
            Graph graph1 = new Graph(8);
            graph1.addToGraph(new GraphItem(3, 2, 1));
            System.out.println("\nGraph1:\n" + graph1.print());
        } catch (OutOfSizeException | SuchElementAlreadyExistException | NegativeNodeValueException | TheSameNodeValueException | BadGraphParametersException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
}
