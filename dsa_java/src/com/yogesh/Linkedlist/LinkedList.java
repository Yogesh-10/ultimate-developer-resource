package com.yogesh.Linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
    //create a node class, for each node in a linked list
    //each node in a LL consists of value and address which is pointing to next node
    //so we create two fields value and next
    private class Node {
        private int value;
        private Node next; //next is by default initialized to null

        //we set the value of newNode by creating a newNode object and passing
        //value thru constructor
        public Node(int value) {
            this.value = value;
        }
    }

    //we keep reference of first and last node
    private Node first;
    private Node last;
    private int size; //this is to keep track of size for sizeOf method

    public void addLast(int item) {
        //add a newNode to LinkedList by creating a node object
        Node newNode = new Node(item);

        //first we check if LinkedList is empty.
        //If yes, we set first and last node to newNode created
        if (first == null)
            first = last = newNode;
            //if No,
        else {
            //we link the last node with the newNode in the LinkedList
            last.next = newNode;
            //finally set the newNode as last(updating last node to newNode)
            last = newNode;
        }
        size++; //this is to keep track of size for sizeOf method
    }

    public void addFirst(int item) {
        //add a newNode to LinkedList by creating a node object
        Node newNode = new Node(item);

        //first we check if LinkedList is empty.
        //If yes, we set first and last node to newNode created
        if (first == null)
            first = last = newNode;
        else {
            //If No,
            //we want our newNode point to our first node
            //We set the next node of newNode as first, which is next to newNode(inserting a node and linking with first node)
            newNode.next = first;
            //and then update first node to point newNode
            first = newNode;
        }
        size++;
    }

    public int indexOf(int item) {
        //initialize index as 0, to return the index of item
        int index = 0;
        //set the first node as current node
        Node current = first;

        //iterate the loop till the end of the list, i.e current node is not null
        //if the current node is null, it means we have reached the end of the list
        while (current != null) {
            //check if value of current node equals to item. if yes return index
            if (current.value == item)
                return index;
            //If No,
            //move the current node to next node
            current = current.next;
            //increment the index value
            index++;
        }
        return -1; //if the item is not found return -1
    }

    public boolean contains(int item) {
        //we can use the logic in indexOf method. so
        return indexOf(item) != -1; //this means. if indexOf returns 1 then contains is true,
        //if it returns -1 then contains is false
    }
//    we can use the below method if indexOf is not implemented
//        Node current = first;
//        while (current != null){
//            //check if value of current node equals to item. if yes return true
//            if (current.value == item)
//                return true;
//            //If No,
//            //move the current node to next node
//            current = current.next;
//            //increment the index value
//        }
//        return false;
//     }

    public void removeFirst(){
        //if the list is empty throw error
        if (first == null)
            throw new NoSuchElementException();

        //if there is only one item in list. set that to null, so that item is removed
        if (first == last) {
            first = last = null;
        }
        else {
            //List - [10 -> 20 -> 30]
            //now we have first -> 10, we need to change this to first -> 20
            //we need to remove this link [10 20 -> 30]
            //But if we remove link, first is not pointing to 20, we lose track of second node
            //to solve this prob, we need two diff references first and second
            //we set second to first.next, so now second is pointing to 20, now we can remove
            //the link[10 20 -> 30], because we have second node as backup
            Node secondVal = first.next;
            //we set first.next to null which will remove the link b/w 10 and 20
            first.next = null;
            //finally we update first and set it to point to second node
            first = secondVal;
        }
        size--; //this is to keep track of size for sizeOf method
    }

    public void removeLast(){
        //if list is empty throw error
        if (first == null)
            throw new NoSuchElementException();

        //if there is only one item in the list, set it to null so the item is removed
        if (first == last){
            first = last = null;
        }
        else {
            //to remove the last node, we need to find the previous node also
            //so that we can set the previous node as last node and remove the link from last node
            //we store previous node
            Node previous = getPreviousNode(last);
            //and set last node as previous node, so that that becomes last node
            last = previous;
            //and then remove the link from last node so that it is cleared in memory
            last.next = null;
        }
        size--; //this is to keep track of size for sizeOf method
    }

    private Node getPreviousNode(Node node){
        //we set current as first node
        Node current = first;
        //iterate till the end of the list
        while (current != null){
            //if current.next is last node, we return current, so that we can
            //get the previous node.
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public void removeByValue(int item){
        //if list is empty throw error
        if (first == null)
            throw new IllegalStateException();

        //set current as first, and prev as null initially, because node before
        //first is always null
       Node current = first;
       Node prev = null;

       //if value of first node is equal to item, remove
       if (first.value == item){
           removeFirst();
           return;
       }

       //iterate till end of the list
       while (current != null){
           //if current node value is equal to the item we are searching for
           if (current.value == item){
               //we set prev.next to null to remove from memory
               //[10 -> 20 -> 30 -> 40 -> 50], item=30
               //        p     c
               //we set prev.next to null, so
               //[10 -> 20  30 -> 40 -> 50], so link between 20 and 30 is removed and also from memory
               //we can also skip this step, because garbage collector will remove unused objects,but it is good practice to
               //free the memory.
               prev.next =  null;
               //we link prev.next to current.next
               //now we set prev.next to current.next, so
               //[10 -> 20 -> 40 -> 50] is linked
               prev.next = current.next;
               return;
           }
           //update prev to current node(iterating)
           prev = current;
           //and update current to next node(iterating)
           current = current.next;
       }
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] arr = new int[size];
        Node current = first;
        int index = 0;
        while (current != null){
            arr[index++] = current.value;
            current = current.next;
        }
        return arr;
    }

    public void print(){
        Node current = first;

        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public void reverse(){
        //if list is empty we simply return, so below lines will not be executed
        if (first == null) return;

        //[10 -> 20 -> 30]
//        prev  curr  next
        //we set first node to prev, second node to current and,
        //next to current's next node(we set next because when we unlink the pointer
        //we should not lose track of next node.Eg [10 -> 20 -> 30] to [10 <- 20 30]
        //to keep track of 30, we use next variable
        Node previous = first;
        Node current = first.next;
        //we iterate till end of list
        while (current != null){
            //set next to current's next node
            Node next = current.next; //this is to keep track of node which is next to current so that when we change link, we still have backup
            //we set current.next to previous, so that the link is changed from
            //[10 -> 20 -> 30] to [10 <- 20 30] in first iteration and keep on changes in next iteration
            current.next = previous;
            //we move the previous point to current
            previous = current;
            //and current pointer to next
            current = next;
        }
        //after list is reversed, we must change first and last node
        //so we set first as last
        last = first;
        //now last is 10, and we set last.next to null
        //[30 -> 20 -> 10 -> null]
        last.next = null;
        //we have previous as 30, we set it as first node
        first = previous;
    }

    //Exercise - Get Kth node from the end in one pass(i.e in one iteration)
    //I/P - [10 20 30 40 50], k=3 | O/P - 30
    public int getKthNodeFromEnd(int k){
        if (first == null)
            throw new IllegalStateException();

        //we set both a and b to first node
        //[10 20 30 40 50]
        // a,b
        Node a = first;
        Node b = first;
        //we move b pointer away from a pointer, with k-1 distance
        for (int i=0; i<k-1; i++) {
            b = b.next;
            //if we pass the index which is not in list we throw error
            if (b == null)
                throw new IllegalArgumentException();
        }
        //then we iterate till b reaches the last node
        while (b != last){
            //we move a
            a = a.next;
            //we move b
            b = b.next;
        }
        //finally we return the value at 'a' pointer
        return a.value;
    }
}


