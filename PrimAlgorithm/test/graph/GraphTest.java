/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eryk
 */
public class GraphTest {
    GraphItem [] graphItemTab;
    private final int NUMBER_OF_SAMPLE_ITEMS = 5;
    Random r;
    
    public GraphTest() {
        graphItemTab = new GraphItem[NUMBER_OF_SAMPLE_ITEMS];
        r = new Random();
        
        
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
                
        
    }

    /**
     * Test of print method, of class Graph.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Graph instance = null;
        String expResult = "";
        String result = instance.print();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minimumSpanningTree method, of class Graph.
     */
    @Test
    public void testMinimumSpanningTree() {
        
    }
    
}
