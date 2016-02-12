/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

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
public class GraphItemTest {

    public GraphItemTest() {
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
     * Test of getFrom method, of class GraphItem.
     */
    @Test
    public void GraphItemTest() {
        GraphItem[] itemsTab = new GraphItem[5];
        try {
            //itemsTab[0] = new GraphItem(-1, 1, 2);
            itemsTab[1] = new GraphItem(3, -2, 5);
            itemsTab[2] = new GraphItem(-2, -4, 3);
            itemsTab[3] = new GraphItem(1, 1, 4);
            itemsTab[4] = new GraphItem(2, 1, -4);
        } catch (NegativeNodeValueException e) {
            System.err.println(e.getMessage());
        } catch (TheSameNodeValueException e) {
            System.err.println(e.getMessage());
        }
        
        System.out.println("test!");

    }

}
