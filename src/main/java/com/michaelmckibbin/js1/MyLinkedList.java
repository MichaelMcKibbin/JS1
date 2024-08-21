package com.michaelmckibbin.js1;

// my version of a linked list
// After struggling with an overly bulky implementation of multiple types of linked lists all at once,
// I took a more sensible option of separating the linked list into its own class
// which I can now use easily for any type of object. It also makes it easier to
// search,  delete, and add nodes to the lists.

import java.util.Iterator;

public class MyLinkedList<N> implements Iterable<N>{

    private Node<N> head;
    private Node<N> tail;

    public void clear() {
        head = null;
        tail = null;
        System.out.println("List has been cleared");
    }

    // inner class
    private static class Node<N> {
        N data;
        Node<N> next;

        Node(N data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }


    @Override
    public Iterator<N> iterator() {
        return new MyLinkedListIterator<>(this);
    }

    private static class MyLinkedListIterator<N> implements Iterator<N> {
        private Node<N> current;

        public MyLinkedListIterator(MyLinkedList<N> list) {
            this.current = list.head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public N next() {
            N data = current.data;
            current = current.next;
            return data;
        }
    }

    /*
    add all items to list
     */
    public void addAll(N... items) {
        for (N item : items) {
            insert(item);
        }
        System.out.println("Items added to list");
    }



    /*
     ************ INSERT ITEM INTO LIST ************
     */

    // add item to end of list
    public void insert(N data) {
        Node<N> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }


    /*
     ************ SEARCH LIST ************
     */



    /*
     *********** DELETE METHODS ***********
     */

    public void deleteHead() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Head deleted");
        }
    }

    // Set head and tail to null, effectively deleting the list.
    public void deleteList(){
        head = null;
        tail = null;
        System.out.println("List has been deleted");
    }

    // delete a node with a given value and close the gap
    public void deleteNode(N value) {
        Node<N> current = head;
        Node<N> previous = null;
        while (current != null) {
            if (current.data == value) { // if the needed value is found, delete the node
                if (previous == null) { // if the node to be deleted is the head, set the head to the next node
                    head = current.next;
                } else { // otherwise, set the previous node's next to the current node's next
                    previous.next = current.next;
                }
                break; // exit the loop after removing the node
            }
            previous = current; // set the previous node to the current node
            current = current.next; // move on to the next node
        }
    }

    /*
     ************ PRINT LIST ************
     */
    public void printList() {
        Node<N> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }



/*
***** SHOW LIST CONTENTS *****
 */
    public void show() {
        Node<N> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }

    /*
     ************ MANIPULATING THE LIST ************
     */

    /*
    GET & SET HEAD & TAIL
     */
    public void getHead() {
        System.out.println("Head: " + head.data);
    }
    public void getTail() {
        System.out.println("Tail: " + tail.data);
    }
    public void setHead(Node<N> head) {
        this.head = head;
    }
    public void setTail(Node<N> tail) {
        this.tail = tail;
    }

    /*
    Get size of list
     */

    public void getSize() {
        System.out.println("Size: " + size());
    }

    public int size() {
        int count = 0;
        Node<N> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // remove item
    public void remove(N item) {
        Node<N> current = head;
        Node<N> previous = null;
    }

    // set node by index
    public void set(int index, N item) {
        Node<N> current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.data = item;
                return;
            }
            count++;
            current = current.next;
        }
    }

    // check if item exists in list
    public boolean contains(N item) {
        Node<N> current = head;
        while (current != null) {
            if (current.data == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // get index of item in list
    public int indexOf(N item) {
        Node<N> current = head;
        int index = 0;
        while (current != null) {
            if (current.data == item) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // check if list is empty
    public boolean isEmpty() {
        return head == null;
    }
    // add at index
    public void add(int index, N item) {
        Node<N> newNode = new Node<>(item);
        Node<N> current = head;
        int count = 0;
        while (current != null) {
            if (count == index - 1) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            count++;
            current = current.next;
        }
    }
    // remove at index
    public void remove(int index) {
        Node<N> current = head;
        int count = 0;
        while (current != null) {
            if (count == index - 1) {
                current.next = current.next.next;
                return;
            }
            count++;
            current = current.next;
        }
    }

    // get at index
    public N get(int index) {
        Node<N> current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    // send list to array
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node<N> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

//    // return list of all items
//    public Iterator<N> iterator() {
//        return new Iterator<N>() {
//            Node<N> current = head;
//
//            @Override
//            public boolean hasNext() {
//                return current != null;
//            }
//
//            @Override
//            public N next() {
//                N data = current.data;
//                current = current.next;
//                return data;
//            }
//        };
//    }

    // add a displaycase to the list
    public void add(DisplayCase displayCase) {
        insert((N) displayCase);
    }
    // add a displaytray to the list
    public void add(DisplayTray displayTray) {
        insert((N) displayTray);
    }
    // add a jewelleryitem to the list
    public void add(JewelleryItem jewelleryItem) {
        insert((N) jewelleryItem);
    }
    // add a jewellerymaterial to the list
    public void add(JewelleryMaterial jewelleryMaterial) {
        insert((N) jewelleryMaterial);
    }




}

