package com.michaelmckibbin.js1;

// my version of a linked list
// It took a lot of reading and experimentation to get this to work.
// With thanks to stack overflow, geeks for geeks, Oracle, the internet, and w3schools.
// After struggling with an overly bulky implementation of multiple types of linked lists all at once,
// I took a more sensible option of separating the linked list into its own class
// which I can now use easily for any type of object. It also makes it easier to
// search,  delete, and add nodes to the lists.

public class MyLinkedList<N> {

    public MyNode<N> head = null, last = null;

//    public MyLinkedList() {
//        this.head = null; // initialize head of list to null
//    }

    /*
     ************ ADD TO LIST ************
     */
    // add a new node to the end of the list
    public void add(N data) {
        MyNode<N> temp = new MyNode<>();
        if (head == null) { // check if list is empty and if  so, set head to temp
            head = temp;
        } else { // otherwise, traverse the list and add temp to the end
            MyNode<N> current = head; // start at the head of the list
            while (current.next != null) { // traverse the list until the end is reached
                current = current.next;
            }
            current.next = temp; // add new MyNode to the end of the list
        }
    }

    /*
     ************ SEARCH LIST ************
     */
    // Need to fix the search returning node address...
    //

    // search for and return a node with a given value
    public MyNode<N> search(N value) {
        MyNode<N> current = head;
        while (current != null) {
            if (current.data == value) { // if the needed value is found, return the node
                return current;
            }
            current = current.next; // move on to the next node
        }
        return null; // if the value is not found, return null
    }
    /*
    public String search2(String value) {
        MyNode current = head; // assuming head is the first node in the list
        while (current != null) {
            if (current.value.equals(value)) {
                return current.value; // return the value of the found node
            }
            current = current.next;
        }
        return null; // return null if the value is not found
    }


    public void search3(N data) {
        MyNode<N> current = head;
        while (current != null && !current.data.equals(data)) {
            current = current.next;
        }
        if (current != null) {
            System.out.println("Element found: " + current.data);
        } else {
            System.out.println("Element not found");
        }
    }

    */

    /*
     ************ DELETE ITEM FROM LIST ************
     */
    // delete a node with a given value and close the gap
    public void delete(N value) {
        MyNode<N> current = head;
        MyNode<N> previous = null;
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
    public void delete(N data) {
        MyNode<N> current = head;
        MyNode<N> previous = null;
        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
        }
        if (current != null) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
        }
    }
    */

    /*
     *********** DELETE ALL ITEMS FROM LIST ***********
     */

    // delete list
    // Set head to null, effectively deleting the list
    public void deleteAll() {
        head = null;
    }

    // reset list
    // same as deleteAll, just in case I type reset instead of deleteAll
    public void reset() {
        head = null;
        last = null; // to be sure to be sure :)
        System.out.println("List has been reset");
    }


    /*
     ************ PRINT LIST ************
     */
    public void printList() {
        MyNode<N> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


    /*
     ************ MANIPULATING THE LIST ************
     */

    public void addFirst(N data) {
        MyNode<N> temp = new MyNode<>(data);
        temp.next = head;
        head = temp;
    }


    public void remove(N item) {
        MyNode<N> current = head;
        MyNode<N> previous = null;
    }

    public void clear() {
        head = null;
    }

    public int size() {
        int count = 0;
        MyNode<N> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public N get(int index) {
        MyNode<N> current = head;
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

    public void set(int index, N item) {
        MyNode<N> current = head;
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

    public boolean contains(N item) {
        MyNode<N> current = head;
        while (current != null) {
            if (current.data == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(N item) {
        MyNode<N> current = head;
        int index = 0;
        while (current != null) {
            if (current.data == item) {
                return index;
            }
            index++;
            current = current.next;
        }
        return index;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

