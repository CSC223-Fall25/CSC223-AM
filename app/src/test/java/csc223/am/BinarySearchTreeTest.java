package csc223.am;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
public class BinarySearchTreeTest {
    BinarySearchTree BST = new BinarySearchTree();
    /// testing for insert, delete, and search
    BST.insert(1);
    BST.insert(0);
    BST.insert(2);
    assertEquals(true, BST.search(1));
    assertEquals(true, BST.search(0));
    assertEquals(true, BST.search(2));
    assertEquals(false, BST.search(3));
    BST.delete(1);
    assertEquals(true, BST.search(0));
    assertEquals(true, BST.search(2));
    assertEquals(false, BST.search(1));

    /// testing for update and inOrder
    BST.insert(1);
    BST.insert(3);
    BST.insert(5);
    BST.insert(4);
    BST.insert(6);
    BST.insert(-3);
    assertEquals(true, BST.search(5));
    BST.update(5, 200);
    assertEquals(false, BST.search(5));
    assertEquals(true, BST.search(200));
    assertEquals("-3 0 1 2 4 200 6 3", BST.inOrder(this.root));

    /// testing for sortedArrayToBST
    assertEquals(0, sortedArrayToBST([-10,-3,0,5,9]));
    assertEquals(3, sortedArrayToBST([1,2,3,4,5,6]));
    assertEquals(7, sortedArrayToBST([0, 1, 2, 300, 4, 5, 7, 6, 200, -202, 94, -2, 74]));

    /// testing for LCA
    assertEquals(2, BST.lowestCommonAncestor(-3, 200));
    assertEquals(1, lowestCommonAncestor(-3, 1));
    assertEquals(3, BST.lowestCommonAncestor(200, 6));
}
