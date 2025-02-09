package csc223.am;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
public class SortedLinkedListTest {
    public static void main(String[] args) {
        SortedLinkedList sortll = new SortedLinkedList();

        // Testing for insert(), remove(), getFirst(), and getLast()
        assertEquals('☠', sortll.getFirst());
        assertEquals('☠', sortll.getLast());
        sortll.insert('F');
        assertEquals('F', sortll.getFirst());
        assertEquals('☠', sortll.getLast());
        sortll.insert('G');
        assertEquals('F', sortll.getFirst());
        assertEquals('G', sortll.getLast());
        sortll.insert('E');
        assertEquals('E', sortll.getFirst());
        assertEquals('G', sortll.getLast());
        sortll.remove('G');
        assertEquals('F', sortll.getLast());
        assertEquals('E', sortll.getFirst());
        sortll.remove('E');
        sortll.remove('F');
        assertEquals('☠', sortll.getFirst());
        assertEquals('☠', sortll.getLast());

        // Testing for get(), size(), isEmpty(), and clear()
        sortll.insert('A');
        sortll.insert('B');
        sortll.insert('C');
        assertEquals('A', sortll.get(0));
        assertEquals('B', sortll.get(1));
        assertEquals('C', sortll.get(2));
        assertEquals('☠', sortll.get(3));
        assertEquals(3, sortll.size());
        assertEquals(false, sortll.isEmpty());
        sortll.insert('D');
        assertEquals('D', sortll.get(3));
        assertEquals('☠', sortll.get(4));
        assertEquals(4, sortll.size());
        assertEquals(false, sortll.isEmpty());
        sortll.clear();
        assertEquals('☠', sortll.get(2));
        assertEquals(0, sortll.size());
        assertEquals(true, sortll.isEmpty());

        // Testing for contains(), indexOf(), and lastIndexOf()
        sortll.insert('W');
        assertEquals(true, sortll.contains('W'));
        assertEquals(false, sortll.contains('X'));
        assertEquals(0, sortll.indexOf('W'));
        assertEquals(-1, sortll.indexOf('Z'));
        assertEquals(0, sortll.lastIndexOf('W'));
        assertEquals(-1, sortll.lastIndexOf('Z'));
        sortll.insert('Z');
        sortll.insert('W');
        assertEquals(true, sortll.contains('Z'));
        assertEquals(-1, sortll.indexOf('X'));
        assertEquals(2, sortll.indexOf('Z'));
        assertEquals(0, sortll.indexOf('W'));
        assertEquals(1, sortll.lastIndexOf('W'));
        assertEquals(2, sortll.lastIndexOf('Z'));
        assertEquals(-1, sortll.lastIndexOf('S'));

        //Testing for reverse() and toString()
        sortll.insert('X');
        sortll.insert('Y');
        assertEquals("WWXYZ", sortll.toString());
        sortll.reverse();
        assertEquals("ZYXWW", sortll.toString());
        sortll.insert('A');
        sortll.reverse();
        sortll.insert('A');
        assertEquals("AWWXYZA", sortll.toString());
    }
}
