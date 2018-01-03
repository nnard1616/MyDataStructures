/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyCollections.MyLinkedLists;

import MyContainers.DLCell;

/**
 *
 * @author nathan
 * @param <E>
 */

//generic doubly linked list that can hold a collection of any kind of object, E
public class MyDoublyLinkedList<E> implements MyLinkedList<E>{
    private DLCell head;
    private DLCell tail;
    private int size;
    
    public MyDoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private DLCell getHead() {
        return head;
    }
    
    @Override
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    @Override
    public int size(){
        return size;
    }
    
    // user side add
    @Override
    public void add(E obj){
        DLCell dlcell = new DLCell(obj);
        add(dlcell);
    }
    
    // class side add
    private void add(DLCell dlcell){
        if (this.head == null){
            this.head = dlcell;
            this.tail = dlcell;
        } else{
            this.tail.setNext(dlcell);
            dlcell.setPrev(this.tail);
            this.tail = dlcell;
        }
        size++;
    }
    
    // user side prepend
    public void prepend(E obj){
        DLCell dlcell = new DLCell(obj);
        prepend(dlcell);
    }
    
    // class side prepend
    private void prepend(DLCell dlcell){
        if (this.head == null){
            this.head = dlcell;
            this.tail = dlcell;
        } else{
            dlcell.setNext(head);
            this.head.setPrev(dlcell);
            this.head = dlcell;
        }
        size++;
    }
    
    public void reverse(){
        //swap body pointers;
        DLCell curr = this.head;
        while (curr != null){
            curr.switchPointers();
            curr = curr.getPrev();
        } 
        
        //swap list field pointers to head and tail
        DLCell temp = this.head;
        this.head = this.tail;
        this.tail = temp;
    }
    
    // class side remove
    private void remove(DLCell dlcell){
        DLCell curr = this.head;
        
        while (curr != null){
            if (curr.equals(dlcell)){
                if ( curr.getPrev() == null){ //we're at the head
                    this.head = curr.getNext();
                    this.head.setPrev(null);
                    size--;
                    break;
                }
                if ( curr.getNext() == null){ //We're at the tail
                    this.tail = curr.getPrev();
                    this.tail.setNext(null);
                    size--;
                    break;
                }
                //We're in the body
                linkNeighbors(curr);
                size--;
                break;
            }
            curr = curr.getNext();
        }
    }
    
    // user side remove
    @Override
    public void remove(E obj){
        DLCell dlcell = new DLCell(obj);
        remove(dlcell);
    }
    
    public void removeAt(int index){
        remove(getDLCell(index));
    }
    
    //selection sort
    public void sort(){
        MyDoublyLinkedList<E> sorted = new MyDoublyLinkedList<>();
        DLCell min;
        DLCell curr;
        while(this.size > 0){
            min = this.head;
            curr = this.head;

            while (curr != null){
                if ( curr.compareTo(min) < 0)
                    min = curr;
                curr = curr.getNext();
            }
            
            sorted.add(this.popDLCell(min) ); 
            
        }
        this.head = sorted.getHead();
        this.size = sorted.size();
    }
    
    // class side pop
    private DLCell popDLCell(DLCell dlcell){
        DLCell curr = this.head;
        DLCell result;
        while (curr != null){
            if (curr.equals(dlcell)){
                
                  //we're at the head
                if ( curr.getPrev() == null){ 
                    //store cell for later return
                    result = this.head;
                    
                    //set list field head pointer to the second item in list
                    this.head = curr.getNext();
                    //point new head's previous to null
                    try{
                        this.head.setPrev(null);
                    } catch(NullPointerException e1){
                        ;//head was the only element, so no reason to set its previous pointer
                    }
                    
                    //ensure result's pointers are all null
                    result.setNext(null);
                    size--;
                    return result;
                }
                  //We're at the tail
                if ( curr.getNext() == null){ 
                    //store cell for later return
                    result = this.tail;
                    
                    //set list field tail pointer to the penultimate item in list
                    this.tail = curr.getPrev();
                    //point new tail's next to null
                    this.tail.setNext(null);
                    
                    //ensure result's pointers are all null
                    result.setPrev(null);
                    size--;
                    return result;
                }
                
                  //We're in the body
                linkNeighbors(curr);
                size--;
                return curr;
            }
            curr = curr.getNext();
        }
        return null; //didn't find it!
    }
    
    //user side pop
    public Object pop(E obj){
        DLCell dlcell = new DLCell(obj);
        return popDLCell(dlcell);
    }
    
    public Object popAt(int index){
        return popDLCell(getDLCell(index));
    }
    
    //for removing an item from the list
    private void linkNeighbors(DLCell dlcell){
        dlcell.getPrev().setNext(dlcell.getNext()); 
        dlcell.getNext().setPrev(dlcell.getPrev());
        dlcell.setNext(null);
        dlcell.setPrev(null);
    }
    
    // user side get
    public Object get(int index){
        DLCell dlcell = getDLCell(index);
        return dlcell.getItem();
    }
    
    //class side get
    private DLCell getDLCell(int index){
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if(index < size/2.0)
            return getFromHead(index);
        else
            return getFromTail(index);
    }
    
    private DLCell getFromHead(int index){
        DLCell curr = this.head;
        for (int i = 0; i < size; i++){
            if ( i == index)
               return curr;
            curr = curr.getNext();
        }
        throw new IndexOutOfBoundsException();
    }
    
    private DLCell getFromTail(int index){
        DLCell curr = this.tail;
        
        for (int i = size-1; i > 0; i--){
            if ( i == index)
                return curr;
            curr = curr.getPrev();
        }
        throw new IndexOutOfBoundsException();
    }
    
    // user side insert
    public void insert(E obj, int index){
        DLCell dlcell = new DLCell(obj);
        insert(dlcell, index);
    }
    
    // class side insert
    private void insert(DLCell insertion, int index){
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            prepend(insertion);
        else if (index == size-1)
            add(insertion);
        else{
            DLCell location = getDLCell(index);

            insertion.setPrev(location.getPrev());
            insertion.setNext(location);

            location.getPrev().setNext(insertion);
            location.setPrev(insertion);
            size++;
        }
    }
    
    //user side contains
    public boolean contains(E obj){
        DLCell dlcell = new DLCell(obj);
        return contains(dlcell);
    }
    
    // class side contains
    private boolean contains(DLCell dlcell){
        DLCell curr = this.head;
        while (curr != null){
            if (curr.equals(dlcell))
                return true;
            curr  = curr.getNext();
        }
        return false;
    }
    
    //user side find
    public Integer find(E obj){
        DLCell dlcell = new DLCell(obj);
        return find(dlcell);
    }
    
    // class side find
    private Integer find(DLCell dlcell){
        DLCell curr = this.head;
        int indexCounter = 0;
        while (curr != null){
            if (curr.equals(dlcell))
                return indexCounter;
            indexCounter++;
            curr = curr.getNext();
        }
        return null;//not found
    }
    
    public MyDoublyLinkedList<E> slice(int start, int end){
        if(start >= size || start >= end || end > size || start < 0 || end < 0)
            throw new IndexOutOfBoundsException();
        
        MyDoublyLinkedList<E> result = new MyDoublyLinkedList<>();
        
        DLCell curr = getDLCell(start);
        while (start < end){
            result.add(curr.clone());
            curr = curr.getNext();
            start++;
        }
        
        return result;
    }
    
    @Override
    public String toString(){
        DLCell curr = this.head;
        String result = "[ ";
        while (curr != null){
            result += curr.getItem();
            result += " ";
            curr = curr.getNext();
        }
        result += "]\n";
        return result;
    }
    
    
}
