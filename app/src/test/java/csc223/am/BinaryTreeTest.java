package csc223.am;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class BinaryTreeTest {
    BinaryTree bt = new BinaryTree();
    bt.insert('A');
    bt.insert('P');
    bt.insert('P');
    bt.insert('L');
    bt.insert('E');
    assertEquals("APPLE", bt.levelorder());
    assertEquals("APLEP", bt.preorder());
    assertEquals("LPEAP", bt.inorder());
    assertEquals("LEPPA", bt.postorder());
    assertEquals(false, bt.search('Z'));
    assertEquals(true, bt.search('A'));
    assertEquals(true, bt.search('E'));
    assertEquals(true, bt.search('P'));
    assertEquals(5, bt.size());
    assertEquals(false, bt.isEmpty());
    assertEquals(3, bt.height());
    BinaryTree bt2 = new BinaryTree();
    assertEquals(0, bt2.size());
    assertEquals(true, bt2.isEmpty());
    assertEquals(0, bt2.height());
}
