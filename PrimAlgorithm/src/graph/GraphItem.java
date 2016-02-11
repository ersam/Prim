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
public class GraphItem {
    private int from;
    private int to;
    private int weight;
    
    public GraphItem(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    
    public int getFrom() {
        return from;
    }
    
    public int getTo() {
        return to;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public void setFrom(int from) {
        this.from = from;
    }
    
    public void setTo(int to) {
        this.to = to;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public String printItem() {
        String item = "";
        return item.concat("From: " + from + ", To: " + to + ", Weight: " + weight + "\n");
    }
}

