/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyCollections.MyLinkedLists;

/**
 *
 * @author nathan
 * @param <E>
 */
public interface MyLinkedList<E> {
    
    public boolean isEmpty();
    
    public int size();
    
    public void add(E obj);
    
    public void remove(E obj);
}
