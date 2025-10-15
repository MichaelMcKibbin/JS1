# Readme

# Data Structures and Algorithms 1

## Jewellery Store Management System

The objective of this exercise is to create a “jewellery store management system” in Java that makes heavy use of
custom-built internal data structures.

### Rules

The system should allow the user to manage a jewellery store that consists of multiple display cases.

Every display case contains multiple display trays.

Every tray can contain multiple items of jewellery (e.g. rings, watches, necklaces, etc.).

Every item of jewellery consists of one or more materials/components (e.g. gold, platinum, diamonds, etc.), and these
materials/components will vary in quantity (by a suitable unit of weight e.g. grams or carats) and quality (e.g. karat
for gold, clarity for diamonds, etc.) for different items of jewellery.

Therefore, in summary, an item of jewellery is comprised of one-or-more materials/components of varying quantity and
quality;
an item of jewellery has to be stored on a display tray;
a display tray must be stored in a display case.

### Requirements

The system should allow the user to:

* **Add a new display case to the system.**
  The following information should be stored for each display case: unique display case number/identifier, type (
  wall-mounted or freestanding), and lighting (lit or unlit).


* **Add a new display tray to a display case.**
  The following information should be stored for each display tray: display tray identifier (one letter followed by a
  number e.g. A12), inlay material colour (e.g. green), and the display tray dimensions (width x depth) in centimetres.
  *Note that the **display tray identifier must be unique** in the system, so check that no other display tray in any
  other display case has the same identifier when creating a new display tray.*


* **Add an item of jewellery to a display tray.**
  Properties that should be stored: item description (free text to include style, etc.), type (ring, watch, necklace,
  etc.), target gender (male, female, unisex, etc.), image (as a URL), and retail price.


* **Add a material/component to an item of jewellery**
  (in a display tray on a display case). Material/component records should have properties: name/type (e.g. gold,
  platinum, diamond, emerald, silver, etc.), description/information (free text e.g. type of cut/shape/colour if a
  gemstone), quantity/amount/weight (in a numeric form), and quality (in a suitable numeric form).


* **View all stock in the jewellery store.**
  This would show/list all jewellery items (with suitable information, photos, etc.) on all display trays in all display
  cases.


* **Interactively “drill down”** through display cases, display trays, and jewellery items to see full details (
  material/components etc.) of a specific item of jewellery using an appropriate GUI.


* **Search for items of jewellery by text.**
  The system will systematically search for all matches for the given search term in every item of jewellery and its
  materials/components information. It will then report the search results (in list form) on where matches are stored in
  the jewellery store (i.e. which display cases and display trays). The user should then be able to choose a search
  result from the list to see a full description of the given item of jewellery (including photo, materials/components
  information, retail price, etc.).

Complete instructions for the assignment can be found in *JewelleryStoreDetailedInstructions.pdf*

## Desired elements and weighting

| Element                                                           | %  | Attempted? |
|-------------------------------------------------------------------|----|------------|
| Appropriate custom ADTs (Abstract Data Types)                     | 10 | Y          |
| Create/add facilities - case, tray, jewellery, materials          | 12 | Y          |
| View all stock (List view, maybe sortable)                        | 8  | Y          |
| Interactive view stock                                            | 7  | Y          |
| Search for and select/view items of jewellery                     | 10 | Y          |
| Smart add for items of jewellery                                  | 10 | N          |
| Remove item of jewellery                                          | 5  | Y          |
| Value stock facility                                              | 10 | Y          |
| Reset facility                                                    | 5  | Y          |
| Save/load facility                                                | 8  | Y          |
| Appropriate JavaFX user interface                                 | 5  | Y          |
| JUnit testing (minimum of 8-10 useful unit tests)                 | 5  | Y          |
| General (commenting, style, logical approach, completeness, etc.) | 5  | Y          |

# My approach:

I created a custom linked list class **MyLinkedList** to allow the creation of nested linked lists to store the required
information on cases, trays, jewellery items and materials.

A **JavaFX** GUI allows the user to manage cases, trays, items and materials in the store.

### MyLinkedList

I have created a class, *MyLinkedList.java*, whose function is to replace the *LinkedList* java class.
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

### MyNode

The MyNode class has two fields:

data
: *data* stores the data of the node

next
: *next* stores a reference to the next node in the list.

My Node can be an outer or inner class.

*Have a look at MyLinkedList.java for more detail.*

![Screenshots](src/main/resources/images/Views.jpg)

# ...

# References

JavaFX FXML controller - constructor vs initialize method
https://stackoverflow.com/questions/34785417/javafx-fxml-controller-constructor-vs-initialize-method
CustomControl Class as Both the Root and Controller of the FXML Document
https://docs.oracle.com/javase/8/javafx/fxml-tutorial/custom_control.htm

https://docs.oracle.com/javase/8/javafx/get-started-tutorial/fxml_tutorial.htm
https://stackoverflow.com/questions/32464698/java-how-do-i-start-a-standalone-application-from-the-current-one-when-both-are
https://stackoverflow.com/questions/23627340/login-application-with-1-stage-and-multiple-scene-in-javafx?rq=1
https://docs.oracle.com/javafx/2/fxml_get_started/jfxpub-fxml_get_started.htm
