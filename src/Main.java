
import MyCollections.MyArrayLists.MyQueue;
import MyCollections.MyArrayLists.MyStack;
import MyCollections.MyLinkedLists.MyDoublyLinkedList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nathan
 */
public class Main {
    public static void main(String[] args){
        Random randomizer = new Random();
        
        System.out.println("----------------- Testing MyDoublyLinkedList -----------------------");
        MyDoublyLinkedList<Integer> dlist = new MyDoublyLinkedList<>();
        
        for (int i = 0; i < 15; i++)
            dlist.add(randomizer.nextInt(100));
        
        System.out.println("Here is our starting Doubly Linked List:\n");
        System.out.println("Size of: " + dlist.size());
        System.out.println(dlist);
        System.out.println("");
        System.out.println("Prepend with 42:");
        dlist.prepend(42);
        System.out.println("Size of: " + dlist.size());
        System.out.println(dlist);
        System.out.println("");
        System.out.println("Reversing it now:");
        dlist.reverse();
        System.out.println(dlist);
        System.out.println("");
        System.out.println("42 is not so great, removing it: ");
        dlist.remove(42);
        System.out.println("Size of: " + dlist.size());
        System.out.println(dlist);
        System.out.println("");
        System.out.println("To be sure that 42 is gone, remove the end:");
        dlist.removeAt(dlist.size()-1);
        System.out.println("Size of: " + dlist.size());
        System.out.println(dlist);
        System.out.println("");
        System.out.println("Now let's sort the remaing things: ");
        dlist.sort();
        System.out.println(dlist);
        System.out.println("");
        System.out.println("Let's pop out the middle gal!");
        System.out.println("Here she is: " + dlist.popAt(dlist.size()/2));
        System.out.println("Size of: " + dlist.size());
        System.out.println(dlist);
        System.out.println("");
        Integer insert = (Integer)dlist.get(4);
        System.out.println("Now let's insert a copy of position 4 at position 7: ");
        dlist.insert(insert, 7);
        System.out.println("Size of: " + dlist.size());
        System.out.println(dlist);
        System.out.println("");
        System.out.println("Does it contain 1337?");
        System.out.println(dlist.contains(1337));
        System.out.println("");
        Integer item = (Integer)dlist.get(5);
        System.out.println("Does it contain " + item + "?");
        System.out.println(dlist.contains(item));
        System.out.println("");
        System.out.println("Where is " + item + "?");
        System.out.println("It is at position " + dlist.find(item) + ": ");
        System.out.println(dlist);
        System.out.println("");
        System.out.println("And now for my last trick, let's slice from position 4 to 11:");
        System.out.println(dlist.slice(4, 11));
        System.out.println("");
        
        System.out.println("Just kidding, now for a grand finale!  A List of Lists!");
        MyDoublyLinkedList<MyDoublyLinkedList<Integer>> twoDList = new MyDoublyLinkedList<>();
        int count = 0;
        
        for (int i = 0; i < 10; i++){
            MyDoublyLinkedList<Integer> row = new MyDoublyLinkedList<>();
            for (int j = 0; j < 10; j++)
                row.add(count++);
            twoDList.add(row);
        }
        
        System.out.println(twoDList);
        
        System.out.println("----------------- Testing MyStack -----------------------");
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i < 6; i++){
            stack.append(i);
        }
        
        System.out.println(stack);
        System.out.println("Length: " + stack.length());
        System.out.println("");
        
        System.out.println("Read from Top to Bottom");
        for (int i = stack.length(); i > 0; i--){
            System.out.println(stack.read());
        }
        System.out.println("Length: " + stack.length());
        
        System.out.println("----------------- Testing MyQueue -----------------------");
        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 0; i < 10; i++){
            queue.append(i);
        }
        
        System.out.println(queue);
        System.out.println("Length: " + queue.length());
        System.out.println("");
        
        System.out.println("Read from Head to Tail");
        for (int i = queue.length(); i > 0; i--){
            System.out.println(queue.read());
        }
        System.out.println("Length: " + stack.length());
    }
}
