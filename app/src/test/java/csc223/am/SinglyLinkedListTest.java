
package csc223.am;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        // Failing tests for getFirst() and getLast()
        assertEquals('☠', sll.getFirst());
        assertEquals('☠', sll.getLast());

        // Shows that the first insert() sets the input to both this.head and this.tail
        sll.insert('A');
        assertEquals('A', sll.getFirst());
        assertEquals('A', sll.getFirst());

        // Testing for getFirst() and getLast() with more nodes
        sll.insert('N');
        sll.insert('D');
        sll.insert('R');
        sll.insert('E');
        sll.insert('W');
        assertEquals('A', sll.getFirst());
        assertEquals('W', sll.getLast());

        // Testing for get()
        assertEquals('D', sll.get(2));
        assertEquals('E', sll.get(4));
        assertEquals('W', sll.get(5));
        assertEquals('☠', sll.get(200));

        // Testing for size(), isEmpty(), clear(), and contains()
        SinglyLinkedList sll2 = sll;
        assertEquals(6, sll2.size());
        assertEquals(false, sll2.isEmpty());
        assertEquals(true, sll2.contains('W'));
        assertEquals(false, sll2.contains('Z'));
        sll2.remove('A');
        assertEquals(5, sll2.size());
        assertEquals(true, sll2.contains('W'));
        assertEquals(false, sll2.contains('A'));
        sll2.remove('D');
        assertEquals(4, sll2.size());
        assertEquals(true, sll2.contains('W'));
        assertEquals(false, sll2.contains('D'));
        sll2.clear();
        assertEquals(true, sll2.isEmpty());
        assertEquals(0, sll2.size());
        assertEquals(false, sll2.contains('W'));
        assertEquals(false, sll2.contains('A'));

        // Testing for toString(), lastIndexOf(), and reverse()
        assertEquals("ANDREW", sll.toString());
        assertEquals(5, sll.lastIndexOf('W'));
        sll.reverse();
        assertEquals("WERDNA", sll.toString());
        sll.reverse();
        sll.insert('W');
        assertEquals("ANDREWW", sll.toString());
        assertEquals(6, sll.lastIndexOf('W'));
        sll.reverse();
        assertEquals("WWERDNA", sll.toString());
        assertEquals(1, sll.lastIndexOf('W'));
        sll.reverse();
        sll.remove('A');
        assertEquals("NDREWW", sll.toString());
        assertEquals(-1, sll.lastIndexOf('A'));
        System.out.println("All test cases passed");
    }
}
