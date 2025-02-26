
package csc223.am;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class DoublyLinkedListTest {
        public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Testing for insert(), remove(), get(), and size()
        dll.insert('P');
        assertEquals('P', dll.get(0));
        assertEquals(1, dll.size());
        dll.insert('A');
        dll.insert('R');
        dll.insert('T');
        dll.insert('H');
        assertEquals('T', dll.get(3));
        assertEquals(5, dll.size());
        dll.insert('Q');
        assertEquals(6, dll.size());
        dll.remove('Q');
        assertEquals(5, dll.size());
        assertEquals('☠', dll.get(10));

        // Testing for getFirst(), getLast(), clear(), and isEmpty()
        DoublyLinkedList dll2 = dll;
        assertEquals('P', dll2.getFirst());
        assertEquals('H', dll2.getLast());
        assertEquals(false, dll2.isEmpty());
        dll.clear();
        assertEquals('☠', dll2.getFirst());
        assertEquals('☠', dll2.getLast());
        assertEquals(true, dll2.isEmpty());

        // Testing for contains(), indexOf(), and lastIndexOf()
        assertEquals(true, dll.contains('P'));
        assertEquals(false, dll.contains('Q'));
        assertEquals(1, dll.indexOf('A'));
        assertEquals(3, dll.indexOf('T'));
        assertEquals(-1, dll.indexOf('Z'));
        assertEquals(3, dll.lastIndexOf('T'));
        dll.insert('T');
        assertEquals(5, dll.lastIndexOf('T'));
        dll.remove('T');
        assertEquals(4, dll.lastIndexOf('T'));
        dll.remove('H');
        dll.insert('H');

        //Testing for reverse() and toString()
        assertEquals("PARTH", dll.toString());
        dll.reverse();
        assertEquals("HTRAP", dll.toString());
        dll.reverse();
        dll.insert('Q');
        assertEquals("PARTHQ", dll.toString());
        dll.reverse();
        assertEquals("QHTRAP", dll.toString());
        dll.insert('Z');
        dll.reverse();
        assertEquals("ZPARTHQ", dll.toString());
    }
}
