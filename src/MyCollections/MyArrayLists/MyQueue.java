/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyCollections.MyArrayLists;

import java.util.Arrays;

/**
 *
 * @author nathan
 * @param <E>
 */
public class MyQueue<E> implements MyArrayList<E> {
    private Object[] queue;
    private final int MAXCAP;
    private int length;
    
    public MyQueue(){
        this(10);
    }
    
    public MyQueue(int maxCap){
        if (maxCap < 0)
            throw new NegativeArraySizeException("Capacity must be geater than 0.");
        this.MAXCAP = maxCap;
        this.queue = new Object[maxCap];
        Arrays.fill(this.queue, null);
        this.length = 0;
    }
    
    @Override
    //add to the tail
    public void append(E obj){
        if (length == MAXCAP)
            throw new IllegalStateException("Not enough space to add more objects.");
        this.queue[this.length] = obj;
        this.length++;
    }
    
    @Override
    public int length() {
        return this.length;
    }
    
    @Override
    //read from the head
    public Object read(){
        if (length == 0)
            throw new IllegalStateException("No more objects to read");
        Object result = this.queue[0];
        
        //delete
        this.queue[0] = null;
        this.length--;
        pushUp();
        return result;
    }
    
    private void pushUp(){
        for (int i = 0; i < length; i++){
            queue[i] = queue[(i+1)%MAXCAP];
        }
    }

    @Override
    public String toString() {
        String result = "Head: ";
        for (int i = 0; i < length; i++)
            result += (queue[i] + " ");
        result += ":Tail";
        return result;
    }
}
