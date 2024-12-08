package com.michaelmckibbin.js1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {


    @Test
    void iterator() {
        System.out.println("Testing iterator");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        for (String s : testList) {
            System.out.println(s);
        }
        assertEquals("a", testList.get(0));
        assertEquals("z", testList.get(25));
    }

    @Test
    void addAll() {
        System.out.println("Testing addAll");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        assertEquals(26, testList.size());
    }

    @Test
    void addFirst() {
        System.out.println("Testing addFirst");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.addFirst("x");
        testList.show();
        assertEquals("x", testList.get(0));
    }

    @Test
    void addLast() {
        System.out.println("Testing addLast");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.addLast("x");
        testList.show();
        assertEquals("x", testList.get(26));
    }

    @Test
    void add() {
        System.out.println("Testing add");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.add("x");
        testList.show();
        assertEquals("x", testList.get(26));
    }

    @Test
    void getFirst() {
        System.out.println("Testing getFirst");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.getFirst();
        assertEquals("a", testList.get(0));
    }

    @Test
    void getLast() {
        System.out.println("Testing getLast");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.getLast();
        assertEquals("z", testList.get(25));
    }

    @Test
    void insertAt() {
        // insert at index
        System.out.println("Testing insertAt");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.insertAt(0, "a");
        testList.show();
        assertEquals("a", testList.get(0));
        testList.insertAt(25, "z");
    }

    @Test
    void deleteHead() {
        System.out.println("Testing deleteHead");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.deleteHead();
        testList.show();
        assertEquals("b", testList.get(0));
    }

    @Test
    void deleteList() {
        System.out.println("Testing deleteList");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.deleteList();
        testList.show();
        assertEquals(0, testList.size());
    }

    @Test
    void deleteNode() {
        System.out.println("Testing deleteNode");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.deleteNode("a");
        testList.show();
        assertEquals("b", testList.get(0));
    }

    @Test
    void show() {
        System.out.println("Testing show");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        assertEquals(26, testList.size());
    }

    @Test
    void getHead() {
        System.out.println("Testing getHead");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.getHead();
        assertEquals("a", testList.get(0));
    }

    @Test
    void getTail() {
        System.out.println("Testing getTail");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.getTail();
        assertEquals("z", testList.get(25));
    }

    @Test
    void getSize() {
        System.out.println("Testing getSize");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.getSize();
        assertEquals(26, testList.size());
    }

    @Test
    void contains() {
        System.out.println("Testing contains");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        assertTrue(testList.contains("a"));
        assertTrue(testList.contains("z"));
        assertFalse(testList.contains("7"));
    }


    @Test
    void indexOf() {
        System.out.println("Testing indexOf");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        assertEquals(0, testList.indexOf("a"));
        assertEquals(25, testList.indexOf("z"));
        assertEquals(23, testList.indexOf("x"));
    }

    @Test
    void isEmpty() {
        System.out.println("Testing isEmpty");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        assertFalse(testList.isEmpty());
        testList.clear();
        assertTrue(testList.isEmpty());
    }

    @Test
    void testAdd() {
        System.out.println("Testing add");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.add("x");
        testList.show();
        assertEquals("x", testList.get(26));
    }

    @Test
    void testRemove() {
        System.out.println("Testing remove");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        testList.remove("a");
        testList.show();
        assertEquals("b", testList.get(0));
        testList.remove("z");
        testList.show();
        assertEquals("y", testList.get(23));
    }

    @Test
    void get() {
        System.out.println("Testing get");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        assertEquals("a", testList.get(0));
        assertEquals("z", testList.get(25));
    }

    @Test
    void toArray() {
        System.out.println("Testing toArray");
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        testList.show();
        Object[] testArray = testList.toArray();
        assertEquals(26, testArray.length);
    }
}