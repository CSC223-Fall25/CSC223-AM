package main.java.csc223.am;

public class MinHeap implements Heap{
    
    char[] heap;
    int maxSize;
    int curr;

    public MinHeap(){
        this.maxSize = 10;
        this.heap = new char[this.maxSize];
        this.curr = 0;
    }

    public void insert(char value){
        if (this.curr == this.maxSize){
            this.maxSize = this.maxSize * 2;
            char[] newData = new char[this.maxSize];
            for (int i = 0; i < this.maxSize/2; i++){
                newData[i] = this.heap[i];
            }
            this.heap = newData;
        }
        this.heap[this.curr] = value;
        bubbleUp();
        this.curr++;
    }

    private void bubbleUp(){
        int parentIndex = Math.floorDiv(this.curr-1, 2);
        while (parentIndex >= 0){
            if (this.heap[this.curr] < this.heap[parentIndex]){
                char temp = this.heap[this.curr];
                this.heap[this.curr] = this.heap[parentIndex];
                this.heap[parentIndex] = temp;
            }
            else{
                return;
            }
            parentIndex = Math.floorDiv(parentIndex-1, 2);
        }

    }
    
    public void delete(){
        if (this.curr == 0){
            return;
        }
        this.curr--;
        this.heap[0] = this.heap[curr];
        bubbleDown();
    }

    private void bubbleDown(){
        int i = 0;
        while (i < this.curr){
            char leftChild = this.heap[(2*i) + 1];
            char rightChild = this.heap[(2*i) + 2];
            if (leftChild < rightChild){
                if (leftChild < this.heap[i]){
                    char temp = this.heap[i];
                    this.heap[i] = leftChild;
                    this.heap[(2*i) + 1] = temp;
                }
                else{
                    return;
                }
            }
            else{
                if (rightChild < this.heap[i]){
                    char temp = this.heap[i];
                    this.heap[i] = rightChild;
                    this.heap[(2*i) + 2] = temp;
                }
                else{
                    return;
                }
            }

        }
    }
    
    public char peek(){
        return this.heap[0];
    }
    
    public int size(){
        return this.curr;
    }
    
    public boolean isEmpty(){
        if (this.curr == 0){
            return true;
        }
        return false;
    }
    
    public void clear(){
        this.curr = 0;
    }
    
    public String toString(){
        String result = "";
        for (int i = 0; i < this.curr; i++){
            result = result + this.heap[i];
        }
        return result;
    }

    public static void main(String[] args){
        MinHeap h = new MinHeap();
        System.out.println(h.isEmpty());
        h.insert('3');
        h.insert('9');
        h.insert('1');
        h.insert('2');
        h.insert('7');
        System.out.println(h.isEmpty());
        System.out.println(h.toString());
        System.out.println(h.size());
        System.out.println(h.peek());
        h.delete();
        System.out.println(h.toString());
        System.out.println(h.size());
        System.out.println(h.peek());
    }

}
