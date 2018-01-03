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
public class MyStack<E> implements MyArrayList<E>{
    private Object[] stack;
    private final int MAXCAP ;
    private int length;
    
    public MyStack(){
        this(10);
    }
    
    public MyStack(int maxCap){
        if (maxCap < 0)
            throw new NegativeArraySizeException("Capacity must be geater than 0.");
        this.MAXCAP = maxCap;
        this.stack = new Object[maxCap];
        Arrays.fill(this.stack, null);
        this.length = 0;
    }
    
    @Override
    //add to the top
    public void append(E obj){
        if (length == MAXCAP)
            throw new IllegalStateException("Not enough space to add more objects.");
        this.stack[this.length] = obj;
        this.length++;
    }

    @Override
    public int length() {
        return this.length;
    }
    
    @Override
    //read from the top
    public Object read(){
        if (length == 0)
            throw new IllegalStateException("No more objects to read");
        Object result = this.stack[this.length-1];
        
        //delete
        this.stack[this.length-1] = null;
        this.length--;
        return result;
    }

    @Override
    public String toString() {
        String result = "Bottom: ";
        for (int i = 0; i < length; i++)
            result += (stack[i] + " ");
        result += ":Top";
        return result;
    }
    
    
    
    
}
