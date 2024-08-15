package com.michaelmckibbin.js1;

public class MyNode<N> { // node class for linked list
    public N data; // data stored in node
    public MyNode<N> next; // reference to next node in list

    public MyNode(N data) { // constructor
        this.data = data; // set data to passed in value
        this.next = null; // set next to null
    }

    public MyNode() {

    }
}
