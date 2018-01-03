/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyContainers;

/**
 *
 * @author nathan
 */

// Container for singly linked list 
public class SLCell{
    
    //fields
    private Object item;
    private SLCell next;
    
    //constructors
    public SLCell(Object obj){
        this.item = obj;
        this.next = null;
    }
    
    public SLCell(){
        this(null);
    }

    //getters
    public Object getItem() {
        return item;
    }
    
    public SLCell getNext() {
        return next;
    }

    //setters
    public void setItem(Object item) {
        this.item = item;
    }
    
    public void setNext(SLCell next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return item.toString();
    }
}
