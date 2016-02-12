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

/**
 *
 * @author Eryk
 */
public class GraphTreeTest {

    public static final int NUMBER_OF_ITEMS = 20;
    public static final int MAX_VALUE_IN_GRAPH = 9;
    GraphItem[] graphItemTab;

    public GraphTreeTest() {
        graphItemTab = new GraphItem[NUMBER_OF_ITEMS];
        Random r = new Random();
        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            try {
                graphItemTab[i] = new GraphItem(r.nextInt(MAX_VALUE_IN_GRAPH),
                        r.nextInt(MAX_VALUE_IN_GRAPH), r.nextInt(MAX_VALUE_IN_GRAPH));
            } catch (NegativeNodeValueException ex) {
                System.err.println(ex.getMessage());
                i--;
            } catch (TheSameNodeValueException ex) {
                System.err.println(ex.getMessage());
                i--;
            }
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
     * Test of insert method, of class GraphTree.
     */
    @Test
    public void testInsert() {

        System.out.println("Items created to insert into the tree:");
        System.out.println(printGraphItemTab());

        GraphTree graphTree = new GraphTree(graphItemTab[0]);

        for (int i = 1; i < NUMBER_OF_ITEMS; i++) {
            try {
                graphTree.insert(graphItemTab[i]);
            } catch (SuchElementAlreadyExistException ex) {
                System.err.println(ex.getMessage());
            }
        }

        System.out.println("Items after inserting into the tree:");
        System.out.println(graphTree.print());

    }

    public String printGraphItemTab() {
        String toString = "";
        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            toString = toString.concat("Item 1: " + graphItemTab[i].printItem());
        }

        return toString;
    }

    public void testGet() {

        System.out.println("Items created to insert into the tree:");
        System.out.println(printGraphItemTab());

        GraphTree graphTree = new GraphTree(graphItemTab[0]);

        for (int i = 1; i < NUMBER_OF_ITEMS; i++) {
            try {
                graphTree.insert(graphItemTab[i]);
            } catch (SuchElementAlreadyExistException ex) {
                System.err.println(ex.getMessage());
            }
        }

        System.out.println("Items after inserting into the tree:");
        System.out.println(graphTree.print());

        try {
            System.out.println("Returned element: " + graphTree.get(6).printItem());
        } catch (NoSuchElementException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
