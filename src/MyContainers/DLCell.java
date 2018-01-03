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

//container for doubly linked list
public class DLCell implements Comparable{
    
    //fields
    private Object item;
    private DLCell prev;
    private DLCell next;
    
    //constructors
    public DLCell(Object obj){
        this.item = obj;
        this.prev = null;
        this.next = null;
    }
    
    public DLCell(){
        this(null);
    }

    //getters
    public Object getItem() {
        return item;
    }
    
    public DLCell getPrev() {
        return prev;
    }
    
    public DLCell getNext() {
        return next;
    }
    
    //setters
    public void setItem(Comparable item) {
        this.item = item;
    }
    
    public void setPrev(DLCell prev) {
        this.prev = prev;
    }
    
    public void setNext(DLCell next) {
        this.next = next;
    }
    
    //for reversing dlists
    public void switchPointers(){
        DLCell temp = prev;
        prev = next;
        next = temp;
    }

    public DLCell clone(){
        return new DLCell(this.getItem());
    }
    
    @Override
    public int compareTo(Object o) {
        if (o.getClass() == this.getClass()){
            Comparable thing1 = (Comparable)this.item;
            Comparable thing2 = (Comparable)((DLCell)o).getItem();
            return thing1.compareTo(thing2);
        }
        Comparable otherObject = (Comparable)o;
        return otherObject.compareTo(this.item);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()){
            DLCell otherCell = (DLCell)obj;
            return this.getItem().equals(otherCell.getItem());
        }
        return false;
    }
    
    @Override
    public String toString() {
        return item.toString();
    }
    
}
