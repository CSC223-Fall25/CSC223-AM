
package csc223.am;

public class ArrayQueue implements Queue {

    int[] data;
    int curr;
    int capacity;

    public void enqueue(int item){
        if (this.data[0] == Integer.MAX_VALUE){
            this.data[0] = item;
        }
        this.data[curr] = item;
        this.curr += 1;

        if(this.curr >= this.capacity){
            this.capacity += 8;
        }
    }

    public int dequeue(){
        int out = this.data[0];
        if (this.curr == 0){
            this.data[0] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        } else {

            for (int i = 0; i < this.curr - 1; i++){
                this.data[i] = this.data[i + 1];
            }
            this.curr -= 1;
            return out;
        }

    }

    public int peek(){
        return this.data[curr];
    }

    public boolean isEmpty(){
        return this.data[0] == Integer.MAX_VALUE;
    }

    public int size(){
        int count = 0;
        for (int i = 0; i < this.curr; i++){
            count += 1;
        }
        return count;
    }
}