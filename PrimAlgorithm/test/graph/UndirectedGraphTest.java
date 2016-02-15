/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Eryk
 */
public class UndirectedGraphTest {
    GraphItem [] graphItemTab;
    private final int NUMBER_OF_SAMPLE_ITEMS = 6;
    private final int MAX_VALUE_IN_GRAPH = 15;
    Random r;
    UndirectedGraph graph;
    
    public UndirectedGraphTest() throws NegativeNodeValueException, TheSameNodeValueException, BadGraphParametersException {
        graphItemTab = new GraphItem[NUMBER_OF_SAMPLE_ITEMS];
        r = new Random();
        graph = new UndirectedGraph(NUMBER_OF_SAMPLE_ITEMS, 3);
        
            try {
                graphItemTab[0] = new GraphItem(3, 2, 4);
                graphItemTab[1] = new GraphItem(2, 3, 2);
                graphItemTab[2] = new GraphItem(4, 5, 3);
                graphItemTab[3] = new GraphItem(5, 2, 5);
                graphItemTab[4] = new GraphItem(4, 2, 7);
                graphItemTab[5] = new GraphItem(1, 2, 4);
            } catch (TheSameNodeValueException ex) {
                System.err.println(ex.getMessage());
            } catch (NegativeNodeValueException ex) {
                System.err.println(ex.getMessage());
            }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addToGraph method, of class Graph.
     */
    
    @Test
    public void testAddToGraph() {
        System.out.println("addToGraph test:\n");
        
        
        for( int i = 0; i < NUMBER_OF_SAMPLE_ITEMS; i++) {
            System.out.print(graphItemTab[i].printItem());
        }
        for(int i = 0; i < NUMBER_OF_SAMPLE_ITEMS; i++) {
            try {
                graph.addToGraph(graphItemTab[i]);
            } catch (OutOfSizeException ex) {
                System.err.println(ex.getMessage());
            } catch (SuchElementAlreadyExistException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        System.out.println(graph.print());
    }

    /**
     * Test of print method, of class Graph.
     */
    //@Test
    public void testPrint() {
        System.out.println("print");
        
    }

    /**
     * Test of minimumSpanningTree method, of class Graph.
     */
    
}
