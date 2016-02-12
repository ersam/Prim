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
public class NoSuchElementException extends Exception {
    
    private final String message;
    
    public NoSuchElementException( String messsage ) {
        this.message = messsage;
    }
    @Override
    public String getMessage() {
        return this.message;
    }
}
