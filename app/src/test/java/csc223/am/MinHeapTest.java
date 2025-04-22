package csc223.am;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
// max heap = big to small
public class MinHeapTest {

    @Test
    public void insertTest(){
        MinHeap heap = new MinHeap();
        assertEquals(heap.isEmpty(), true);
        heap.insert('T');
        assertEquals(heap.data[0], 'T');
        heap.insert('E');
        assertEquals(heap.data[0], 'E');
        assertEquals(heap.data[1], 'T');
        heap.insert('S');
        assertEquals(heap.data[2], 'S');
        heap.insert('T');
        assertEquals(heap.data[3], 'T');
        assertEquals(heap.data[1], 'T');
        heap.insert('Z');
        assertEquals(heap.data[4], 'Z');
    }

    @Test
    public void deleteTest(){
        MinHeap heap = new MinHeap();
        heap.insert('A');
        assertEquals(heap.data[0], 'A');
        heap.delete();
        assertEquals(heap.isEmpty(), true);
        heap.insert('T');
        heap.insert('E');
        heap.insert('S');
        heap.insert('T');
        assertEquals(heap.data[0], 'E');
        heap.delete();
        assertEquals(heap.data[0], 'S');
        heap.delete();
        assertEquals(heap.data[0], 'T');
        heap.delete();
        assertEquals(heap.data[0], 'T');
        heap.delete();
        assertEquals(heap.isEmpty(), true);
    }

    @Test
    public void peekTest(){
        MinHeap heap = new MinHeap();
        assertEquals(heap.isEmpty(), true);
        heap.insert('T');
        assertEquals(heap.peek(), heap.data[0]);
        heap.insert('E');
        heap.insert('S');
        heap.insert('T');
        assertEquals(heap.peek(), heap.data[0]);
    }

    @Test
    public void sizeTest(){
        MinHeap heap = new MinHeap();
        assertEquals(heap.size(), 0);
        heap.insert('A');
        assertEquals(heap.size(), 1);
        heap.delete();
        assertEquals(heap.size(), 0);
        heap.insert('T');
        heap.insert('E');
        heap.insert('S');
        heap.insert('T');
        assertEquals(heap.size(), 4);
        heap.delete();
        assertEquals(heap.size(), 3);
    }

    @Test
    public void isEmptyTest(){
        MinHeap heap = new MinHeap();
        assertEquals(heap.isEmpty(), true);
        heap.insert('A');
        assertEquals(heap.isEmpty(), false);
        heap.delete();
        assertEquals(heap.isEmpty(), true);
    }

    @Test
    public void clearTest(){
        MinHeap heap = new MinHeap();
        assertEquals(heap.isEmpty(), true);
        heap.insert('A');
        assertEquals(heap.isEmpty(), false);
        heap.clear();
        assertEquals(heap.isEmpty(), true);
        heap.insert('T');
        heap.insert('E');
        heap.insert('S');
        heap.insert('T');
        assertEquals(heap.isEmpty(), false);
        heap.clear();
        assertEquals(heap.isEmpty(), true);
    }

    @Test
    public void toStringTest(){
        MinHeap heap = new MinHeap();
        heap.insert('A');
        assertEquals(heap.toString(), "A");
        heap.insert('B');
        assertEquals(heap.toString(), "AB");
        heap.clear();
        heap.insert('T');
        heap.insert('E');
        heap.insert('S');
        heap.insert('T');
        assertEquals(heap.toString(), "ETST");
    }

}
