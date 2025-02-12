package csc223.am;

public class BTQueue {
    TreeNode[] data;
    int curr;
    int capacity;

    public BTQueue(){
        capacity = 10;
    }
    public void enqueue(TreeNode item){
        if (this.data[0].data == Integer.MAX_VALUE){
            this.data[0] = item;
        }
        this.data[curr] = item;
        this.curr += 1;

        if (this.curr >= this.capacity){
            this.capacity += 8;
        }
    }
    public TreeNode dequeue(){
        TreeNode out = this.data[0];
        if (this.curr == 0){
            this.data[0] = new TreeNode('☠');
            return this.data[0];
        } else {
            for (int i = 0; i < this.curr - 1; i++){
                this.data[i] = this.data[i + 1];
            }
            this.curr -= 1;
            return out;
        }
    }

    public TreeNode peek(){
        return this.data[curr];
    }

    public boolean isEmpty(){
        return this.data[0].data == '☠';
    }

    public int size(){
        return this.curr;
    }
}
