# Readme








JavaFX FXML controller - constructor vs initialize method
https://stackoverflow.com/questions/34785417/javafx-fxml-controller-constructor-vs-initialize-method
CustomControl Class as Both the Root and Controller of the FXML Document
https://docs.oracle.com/javase/8/javafx/fxml-tutorial/custom_control.htm

https://docs.oracle.com/javase/8/javafx/get-started-tutorial/fxml_tutorial.htm
https://stackoverflow.com/questions/32464698/java-how-do-i-start-a-standalone-application-from-the-current-one-when-both-are
https://stackoverflow.com/questions/23627340/login-application-with-1-stage-and-multiple-scene-in-javafx?rq=1
https://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm


# MyLinkedList

I have created a class, *MyLinkedList*,  whose function is to replace the *LinkedList* java class.
It implements various methods, including:

insert(D data)
: This method inserts a new node with the given data at the end of the linked list.

show()
: This method prints the data of all nodes in the linked list.

getHead()
: This method returns the head node of the linked list.

setHead(MyNode<T> head)
: This method sets the head node of the linked list.

getTail()
: This method returns the tail node of the linked list.

setTail(MyNode<T> tail)
: This method sets the tail node of the linked list.

The *MyLinkedList* class uses a private static nested class *Node* to represent each node in the linked list.

# MyNode
The MyNode class has two fields:

data
: *data* stores the data of the node

next
: *next* stores a reference to the next node in the list.

My Node can be an outer or inner  class.

Have a look at *MyLinkedList.java* for more functions.


# ...
