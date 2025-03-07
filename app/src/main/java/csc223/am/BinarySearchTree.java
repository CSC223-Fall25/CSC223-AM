package csc223.am;

public class BinarySearchTree {

    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data = data;
        }
    }
    TreeNode root;
    public void insert(int value){
        TreeNode newNode = new TreeNode(value);
        if (this.root == null){
            this.root = newNode;
        } else {
            TreeNode curr = this.root;
            if (curr.data > value){
                if (curr.left == null){
                    curr.left = newNode;
                } else {
                    curr = curr.left;
                }
            } else if (curr.data < value){
                if (curr.right == null){
                    curr.right = newNode;
                } else {
                    curr = curr.right;
                }
            }         
        }
    }

    public void delete(int value){
        deleteHelper(this.root, null, value);
    }

    public void deleteHelper(TreeNode curr, TreeNode parent, int value){
        if (value < curr.data){
            deleteHelper(curr.left, curr, value);
        } else if (value > curr.data){
            deleteHelper(curr.right, curr, value);
        } else {
            if (curr.left == null && curr.right == null && parent.right == curr){
                parent.right = null;
            } else if (curr.left == null && curr.right == null && parent.left == curr){
                parent.left = null;
            } else if (curr.left == null && curr.right != null && parent.left == curr){
                parent.left = curr.left;
            } else if (curr.left != null && curr.right == null && parent.left == curr){
                parent.left = curr.right;
            } else if (curr.left == null && curr.right != null && parent.right == curr){
                parent.right = curr.right;
            } else if (curr.left != null && curr.right == null && parent.right == curr){
                parent.right = curr.left;
            } else if (curr.left != null && curr.right != null){
                TreeNode swap = curr.right;
                while (swap.left != null){
                    swap = swap.left;
                }
                int hold = swap.data;
                swap.data = curr.data;
                curr.data = hold;
                while (curr.left != swap){
                    curr = curr.left;
                }
                curr.left = null;
            }
        }
    }

    public boolean search(int value){
        TreeNode curr = this.root;
        return search(curr, value);
    }

    public boolean search(TreeNode curr, int value){
        if (curr == null){
            return false;
        } else if (curr.data == value){
            return true;
        } else if (curr.data > value){
            search(curr.left, value);
        } else if (curr.data < value){
            search(curr.right, value);
        }
        return false;
    }  

    public void update(int old, int newValue){
        this.delete(old);
        this.insert(newValue);
    }

    public String inOrder(TreeNode curr){
        return inOrder(curr.left) + " " + curr.data + " " + inOrder(curr.right);
    }



    public static TreeNode sortedArrayToBST(int[] values){
        BinarySearchTree BST = new BinarySearchTree();
        int arrayLength = values.length;
        arrayLength /= 2;
        if (arrayLength % 1 != 0){
            arrayLength += 0.5;
        }
        BST.insert(values[arrayLength]);
        for (int i = 0; i < arrayLength; i++){
            if (BST.search(values[i]) == false){
                BST.insert(values[i]);
            }
            if (BST.search(values[i + arrayLength]) == false){
                BST.insert(values[i + arrayLength]);
            }
        }
        return BST.root;
    }

    public int lowestCommonAncestor(int p, int q){
        if (this.search(p) == false || this.search(q) == false){
            return -1;
        } else {
            return LCAHelper(p, q, this.root);
        }
    }

    public int LCAHelper(int p, int q, TreeNode curr){
        if (p >= curr.data && q <= curr.data){
            return curr.data;
        } else if (p <= curr.data && q >= curr.data){
            return curr.data;
        } else if (p > curr.data){
            return LCAHelper(p, q, curr.right);
        } else {
            return LCAHelper(p, q, curr.left);
        }
    }
}