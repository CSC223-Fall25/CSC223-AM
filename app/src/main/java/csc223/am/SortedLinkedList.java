package csc223.am;

public class SortedLinkedList extends DoublyLinkedList{
    
    @Override
    public void insert(char item){
        Node new_item = new Node();
        new_item.data = item;
        if (this.head == null){
            this.head = new_item;
            this.tail = new_item;
        } else {
            Node curr = this.head;
            while (curr != null){
                if (curr.data >= item){
                    Node prev = curr.previous;
                    prev.next = new_item;
                    curr.previous = new_item;
                    new_item.previous = prev;
                    new_item.next = curr;
                    break;
                } else {
                    curr = curr.next;
                }
            }
            if (curr == this.head){
                this.head = new_item;
            } else if (curr == this.tail){
                curr.next = new_item;
                new_item.previous = curr;
                this.tail = new_item;
            }
        }
    }

    @Override
    public void remove(char item){
        super.remove(item);
    }

    @Override 
    public char getFirst(){
        return super.getFirst();
    }

    @Override
    public char getLast(){
        return super.getLast();
    }

    @Override
    public char get(int index){
        return super.get(index);
    }

    @Override
    public int size(){
        return super.size();
    }

    @Override
    public boolean isEmpty(){
        return super.isEmpty();
    }

    @Override
    public void clear(){
        super.clear();
    }

    @Override
    public boolean contains(char item){
        return super.contains(item);
    }

    @Override
    public int indexOf(char item){
        return super.indexOf(item);
    }

    @Override
    public int lastIndexOf(char item){
        return super.lastIndexOf(item);
    }

    @Override
    public void reverse(){
        super.reverse();
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
