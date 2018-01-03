/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyCollections.MyLinkedLists;

import MyContainers.SLCell;

/**
 *
 * @author nathan
 * @param <E>
 */

//generic singly linked list that can hold a collection of any kind of object, E
public class MySinglyLinkedList<E> implements MyLinkedList<E>{
    private SLCell head;
    private SLCell tail;
    private int size;
    
    public MySinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    @Override
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    @Override
    public int size(){
        return size;
    }
    
    @Override
    public void add(E obj){
        SLCell cell = new SLCell(obj);
        if (this.head == null){
            this.head = cell;
            this.tail = cell;
        } else{
            this.tail.setNext(cell);
            this.tail = cell;
        }
        size++;
    }
    
    @Override
    public void remove(E obj){
        SLCell curr = this.head;
        SLCell prev = null;
        
        while (curr != null){
            if (curr.getItem().equals(obj)){
                if ( prev == null){           //we're at the head
                    this.head = curr.getNext();
                    break;
                }
                if ( curr.getNext() == null){ //We're at the tail
                    prev.setNext(null);
                    this.tail = prev;
                    break;
                }
                prev.setNext(curr.getNext()); //We're in the body
                size--;
                break;
            }
            prev = curr;
            curr = curr.getNext();
        }
    }
    
    @Override
    public String toString(){
        SLCell curr = this.head;
        String result = "[ ";
        while (curr != null){
            result += curr.getItem();
            result += " ";
            curr = curr.getNext();
        }
        result += "]";
        return result;
    }
    
}
