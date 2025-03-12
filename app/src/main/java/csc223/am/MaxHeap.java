package csc223.am;

public class MaxHeap implements Heap {
    char root = this.data[0];
    char[] data = new char[10];
    int size;
    
    public void insert(char value){
        this.size += 1;
        this.data[size] = value;
        int curr = size;
        boolean check = false;
        while (check == false){
            int parent = curr - 1;
            parent /= 2;
            if (this.data[curr] > this.data[parent]){
                char swap = this.data[parent];
                this.data[parent] = this.data[curr];
                this.data[curr] = swap;
            } else {
                check = true;
            }
            curr = parent;
        }
    }

    public void delete(){
        this.data[0] = this.data[size];
        this.root = this.data[0];
        char[] newdata = new char[10];
        for (int i = 0; i < this.size-1; i++) {
            newdata[i] = this.data[i];
        }
        this.data = newdata;
        int curr = 0;
        boolean check = false;
        while (check == false){
            int parent = curr * 2;
            parent += 1;
            if (this.data[curr] < this.data[parent]){
                char swap = this.data[parent];
                this.data[parent] = this.data[curr];
                this.data[curr] = swap;
            } else {
                check = true;
            }
            curr = parent;
        }
        this.size -= 1;
    }

    public char peek(){
        return data[0];
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size >= 1;
    }

    public void clear(){
        char[] emptyArray = new char[10];
        this.data = emptyArray;
    }

    @Override
    public String toString(){
        String out = new String();
        for (int i = 0; i < this.size; i++) {
            out += this.data[i];
        }
        return out;
    }
}
