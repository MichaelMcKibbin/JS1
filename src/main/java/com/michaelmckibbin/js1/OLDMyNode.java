package com.michaelmckibbin.js1;

public class OLDMyNode<N> { // node class for linked list
    public N data; // data stored in node
    public OLDMyNode<N> next; // reference to next node in list

    public OLDMyNode(N data) { // constructor
        this.data = data; // set data to passed in value
        this.next = null; // set next to null
    }

    public OLDMyNode() {

    }
}
