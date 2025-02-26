package csc223.am;

public class BinaryTree implements Tree{
    TreeNode root;
    int height;
    public BinaryTree(){
        height = 0;
    }
    public String levelorder(){
        String out = new String();
        BTQueue queue = new BTQueue();
        queue.enqueue(this.root);
        while (queue.isEmpty() == false){
            TreeNode curr = queue.dequeue();
            out += curr.data;
            queue.enqueue(curr.left);
            queue.enqueue(curr.right);
        }
        return out;
    }


    public String preorder(){
        String out = new String();
        return preorder(this.root, out);
    }
    public String preorder(TreeNode curr, String out){
        out += curr.data;
        preorder(curr.left, out);
        preorder(curr.right, out);
        return out;
    }


    public String inorder(){
        String out = new String();
        return inorder(this.root, out);
    }
    public String inorder(TreeNode curr, String out){
        inorder(curr.left, out);
        out += curr.data;
        inorder(curr.right, out);
        return out;
    }


    public String postorder(){
        String out = new String();
        return inorder(this.root, out);
    }
    public String postorder(TreeNode curr, String out){
        postorder(curr.left, out);
        postorder(curr.right, out);
        out += curr.data;
        return out;
    }
    public void insert(char item){
        TreeNode newnode = new TreeNode(item);
        if (this.root == null){
            this.root = newnode;
            this.height += 1;
        } else {
            BTQueue queue = new BTQueue();
            queue.enqueue(this.root);
            while (queue.isEmpty() == false){
                TreeNode curr = queue.dequeue();
                if (curr.left == null){
                    curr.left = newnode;
                    this.height += 1;
                    break;
                } else if (curr.right == null){
                    curr.right = newnode;
                    break;
                } else {
                    queue.enqueue(curr.left);
                    queue.enqueue(curr.right);
                }
            }
        }
    }
    public boolean search(char item){
        BTQueue queue = new BTQueue();
        queue.enqueue(this.root);
        while (queue.isEmpty() == false){
            TreeNode curr = queue.dequeue();
            if (curr.data == item){
                return true;
            }
            queue.enqueue(curr.left);
            queue.enqueue(curr.right);
        }
        return false;
    }
    public int size(){
        int count = 0;
        BTQueue queue = new BTQueue();
        queue.enqueue(this.root);
        while (queue.isEmpty() == false){
            TreeNode curr = queue.dequeue();
            count += 1;
            queue.enqueue(curr.left);
            queue.enqueue(curr.right);
        }
        return count;
    }
    public boolean isEmpty(){
        return this.root != null;
    }
    public int height(){
        return this.height;
    }
}
